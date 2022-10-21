
package com.portfolio.mi.Controller;

import com.portfolio.mi.Dto.dtoHabilidad;
import com.portfolio.mi.Entity.Habilidad;
import com.portfolio.mi.Security.Controller.Mensaje;
import com.portfolio.mi.Service.HabilidadesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://mgbfrontend.web.app", "http://localhost:4200"})
@RequestMapping("/habilidades")
public class HabilidadesController {
    @Autowired
    HabilidadesService habilidadesService;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = habilidadesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id) {
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilidad = habilidadesService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        habilidadesService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtohabilidad) {
        if (StringUtils.isBlank(dtohabilidad.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (habilidadesService.existsByNombre(dtohabilidad.getTitulo())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = new Habilidad(dtohabilidad.getTitulo(), dtohabilidad.getPorcentaje(), dtohabilidad.getImgHabilidad());
        habilidadesService.save(habilidad);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidad dtohabilidad) {
        //Validamos si existe el ID
        if (!habilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (habilidadesService.existsByNombre(dtohabilidad.getTitulo()) && habilidadesService.getByTitulo(dtohabilidad.getTitulo()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohabilidad.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = habilidadesService.getOne(id).get();
        habilidad.setTitulo(dtohabilidad.getTitulo());
        habilidad.setPorcentaje(dtohabilidad.getPorcentaje());
        habilidad.setImgProyecto(dtohabilidad.getImgHabilidad());

        habilidadesService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

    }
}

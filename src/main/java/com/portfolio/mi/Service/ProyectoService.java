package com.portfolio.mi.Service;

import com.portfolio.mi.Entity.Proyecto;
import com.portfolio.mi.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    IProyectoRepository iproyectoRepository;

    public List<Proyecto> list() {
        return iproyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return iproyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByTitulo(String titulo) {
        return iproyectoRepository.findByTitulo(titulo);
    }

    public void save(Proyecto proyecto) {
        iproyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        iproyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iproyectoRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return iproyectoRepository.existsByTitulo(titulo);
    }

}

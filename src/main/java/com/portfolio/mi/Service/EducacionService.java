package com.portfolio.mi.Service;

import com.portfolio.mi.Entity.Educacion;
import com.portfolio.mi.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository ieducacionRepository;

    public List<Educacion> list() {
        return ieducacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return ieducacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombreE(String nombreE) {
        return ieducacionRepository.findByNombreE(nombreE);
    }

    public void save(Educacion educacion) {
        ieducacionRepository.save(educacion);
    }

    public void delete(int id) {
        ieducacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return ieducacionRepository.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {
        return ieducacionRepository.existsByNombreE(nombreE);
    }
}

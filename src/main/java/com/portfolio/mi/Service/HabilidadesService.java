/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mi.Service;

import com.portfolio.mi.Entity.Habilidad;
import com.portfolio.mi.Repository.IHabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Transactional
@Service
public class HabilidadesService {
    @Autowired
    IHabilidadesRepository ihabilidadesRepository;
    
    public List<Habilidad> list(){
        return ihabilidadesRepository.findAll();
    }
    
    public Optional<Habilidad> getOne(int id){
        return ihabilidadesRepository.findById(id);
    }
    
    public Optional<Habilidad> getByTitulo(String titulo){
        return ihabilidadesRepository.findByTitulo(titulo);
    }
    
    public void save(Habilidad skill){
        ihabilidadesRepository.save(skill);
    }
    
    public void delete(int id){
        ihabilidadesRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ihabilidadesRepository.existsById(id);
    }
    
    public boolean existsByNombre(String titulo){
        return ihabilidadesRepository.existsByTitulo(titulo);
    }
}

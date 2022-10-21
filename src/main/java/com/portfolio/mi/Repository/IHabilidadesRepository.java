
package com.portfolio.mi.Repository;

import com.portfolio.mi.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHabilidadesRepository extends JpaRepository<Habilidad, Integer>{
    Optional<Habilidad> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
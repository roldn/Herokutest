
package com.portfolio.mi.Repository;

import com.portfolio.mi.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}

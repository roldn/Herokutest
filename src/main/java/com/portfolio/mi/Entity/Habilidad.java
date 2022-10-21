
package com.portfolio.mi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private int porcentaje;
    private String imgHabilidad;

    public Habilidad() {
    }

    public Habilidad(String titulo, int porcentaje, String imgHabilidad) {
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.imgHabilidad = imgHabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }    
     
    public String getImgHabilidad() {
        return imgHabilidad;
    }

    public void setImgProyecto(String imgHabilidad) {
        this.imgHabilidad = imgHabilidad;
    }
}

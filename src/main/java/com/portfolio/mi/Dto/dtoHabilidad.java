
package com.portfolio.mi.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidad {
    @NotBlank
    private String titulo;
    @NotBlank
    private int porcentaje;
    
    private String imgHabilidad;
    
    public dtoHabilidad() {
    }

    public dtoHabilidad(String titulo, int porcentaje, String imgHabilidad) {
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.imgHabilidad = imgHabilidad;
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

    public void setImgHabilidad(String imgHabilidad) {
        this.imgHabilidad = imgHabilidad;
    }
}

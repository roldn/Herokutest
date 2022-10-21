/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mi.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Francisco
 */
public class dtoProyecto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String urlProyecto;
    private String imgProyecto;

    //Constructores
    public dtoProyecto() {
    }

    public dtoProyecto(String titulo, String descripcionP, String urlProyecto, String imgProyecto) {
        this.titulo = titulo;
        this.descripcionP = descripcionP;
        this.urlProyecto = urlProyecto;
        this.imgProyecto = imgProyecto;
    }

    //Getters & Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
    
    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }
    
    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

}

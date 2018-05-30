package com.example.personal.myappgym;

public class Articulo {
    private int id;
    private String referencia;
    private String descripcion;

    public Articulo() {
    }

    public Articulo(int id, String referencia, String descripcion) {
        this.id = id;
        this.referencia = referencia;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

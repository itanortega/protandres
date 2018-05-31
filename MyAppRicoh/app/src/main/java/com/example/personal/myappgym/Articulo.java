package com.example.personal.myappgym;

public class Articulo {
    private int id;
    private String referencia;
    private String descripcion_es;
    private String descripcion_en;

    public Articulo() {
    }

    public Articulo(int id, String referencia, String descripcion_es, String descripcion_een) {
        this.setId(id);
        this.setReferencia(referencia);
        this.setDescripcion_es(descripcion_es);
        this.setDescripcion_en(descripcion_een);
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

    public String getDescripcion_es() {
        return descripcion_es;
    }

    public void setDescripcion_es(String descripcion_es) {
        this.descripcion_es = descripcion_es;
    }

    public String getDescripcion_en() {
        return descripcion_en;
    }

    public void setDescripcion_en(String descripcion_en) {
        this.descripcion_en = descripcion_en;
    }
}

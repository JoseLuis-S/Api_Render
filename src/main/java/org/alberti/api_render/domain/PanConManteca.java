package org.alberti.api_render.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "panes_con_manteca")
public class PanConManteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private Integer stock;


    @ManyToOne
    @JoinColumn(name = "pan_id")
    private Pan pan;

    @ManyToOne
    @JoinColumn(name = "manteca_id")
    private Manteca manteca;

    public PanConManteca() {
    }

    public PanConManteca(String nombre, String descripcion, Integer stock, Pan pan, Manteca manteca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.pan = pan;
        this.manteca = manteca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Transient
    public BigDecimal getPrecio() {
        if (pan != null && pan.getPrecio() != null && manteca != null && manteca.getPrecio() != null) {
            return pan.getPrecio().add(manteca.getPrecio());
        }
        return BigDecimal.ZERO;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public Manteca getManteca() {
        return manteca;
    }

    public void setManteca(Manteca manteca) {
        this.manteca = manteca;
    }
}

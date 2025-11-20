package org.alberti.api_render.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mantecas")
public class Manteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoManteca;

    private String descripcion;

    private BigDecimal precio;

    @OneToMany(mappedBy = "manteca", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PanConManteca> panesConManteca = new ArrayList<>();

    public Manteca() {
    }

    public Manteca(String tipoManteca, String descripcion, BigDecimal precio) {
        this.tipoManteca = tipoManteca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoManteca() {
        return tipoManteca;
    }

    public void setTipoManteca(String tipoManteca) {
        this.tipoManteca = tipoManteca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<PanConManteca> getPanesConManteca() {
        return panesConManteca;
    }

    public void setPanesConManteca(List<PanConManteca> panesConManteca) {
        this.panesConManteca = panesConManteca;
    }
}

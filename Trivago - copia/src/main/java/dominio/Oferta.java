/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class Oferta {
    private int IDoferta;
    private Double precio;
    private Date fechaInicio;
    private Date fechaFin;
    private int ALOJAMIENTO_IDalojamiento;//clave ajena de alojamiento

    //getter and setter
    public Integer getIDoferta() {
        return IDoferta;
    }

    public void setIDoferta(Integer IDoferta) {
        this.IDoferta = IDoferta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getALOJAMIENTO_IDalojamiento() {
        return ALOJAMIENTO_IDalojamiento;
    }

    public void setALOJAMIENTO_IDalojamiento(Integer ALOJAMIENTO_IDalojamiento) {
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
    }


    //constructores
    //vacio
    public Oferta() {
    }

    //sin id
    public Oferta(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Oferta(Double precio, Date fechaInicio, Date fechaFin, Integer ALOJAMIENTO_IDalojamiento) {
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
    }

    
    
    public Oferta(Integer IDoferta, Double precio, Date fechaInicio, Date fechaFin, Integer ALOJAMIENTO_IDalojamiento) {
        this.IDoferta = IDoferta;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
    }

    public Oferta(int IDoferta) {
        this.IDoferta = IDoferta;
    }
    
    
    
    
    
    
    //equals ahd hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.IDoferta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oferta other = (Oferta) obj;
        if (!Objects.equals(this.IDoferta, other.IDoferta)) {
            return false;
        }
        return true;
    }

    
    //tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IDoferta=").append(IDoferta);
        sb.append(", precio=").append(precio);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", ALOJAMIENTO_IDalojamiento=").append(ALOJAMIENTO_IDalojamiento);
        return sb.toString();
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class Reserva {
    private Integer idRESERVA;
    private int OFERTA_IDoferta;
    private int PERSONA_ID;
    private String nombre;
    private Date fechaReserva;
    
    
    //getter and setter
    public Integer getIdRESERVA() {
        return idRESERVA;
    }

    public void setIdRESERVA(Integer idRESERVA) {
        this.idRESERVA = idRESERVA;
    }

    public int getOFERTA_IDoferta() {
        return OFERTA_IDoferta;
    }

    public void setOFERTA_IDoferta(int OFERTA_IDoferta) {
        this.OFERTA_IDoferta = OFERTA_IDoferta;
    }

    public int getPERSONA_ID() {
        return PERSONA_ID;
    }

    public void setPERSONA_ID(int PERSONA_ID) {
        this.PERSONA_ID = PERSONA_ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
    //constructores
    //vacio
    public Reserva() {
    }
    
    //sin id
    public Reserva(int OFERTA_IDoferta, int PERSONA_ID, String nombre, Date fechaReserva) {
        this.OFERTA_IDoferta = OFERTA_IDoferta;
        this.PERSONA_ID = PERSONA_ID;
        this.nombre = nombre;
        this.fechaReserva = fechaReserva;
    }
    
    //con id
    public Reserva(Integer idRESERVA, int OFERTA_IDoferta, int PERSONA_ID, String nombre, Date fechaReserva) {
        this.idRESERVA = idRESERVA;
        this.OFERTA_IDoferta = OFERTA_IDoferta;
        this.PERSONA_ID = PERSONA_ID;
        this.nombre = nombre;
        this.fechaReserva = fechaReserva;
    }
    
    
    
    //eaquals ahd hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idRESERVA);
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
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idRESERVA, other.idRESERVA)) {
            return false;
        }
        return true;
    }
    
    
    //tostring

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva{idRESERVA=").append(idRESERVA);
        sb.append(", OFERTA_IDoferta=").append(OFERTA_IDoferta);
        sb.append(", PERSONA_ID=").append(PERSONA_ID);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaReserva=").append(fechaReserva);
        sb.append('}');
        return sb.toString();
    }
    
    
}

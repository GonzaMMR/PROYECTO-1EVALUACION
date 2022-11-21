/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Alumno Mañana
 */
public class Valoracion {
    private Integer IDvaloracion;
    private String descripcion;
    private int nota;
    private int ALOJAMIENTO_IDalojamiento;
    private int PERSONA_ID;
    
    //geter and setter
    public Integer getIDvaloracion() {
        return IDvaloracion;
    }

    public void setIDvaloracion(Integer IDvaloracion) {
        this.IDvaloracion = IDvaloracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getALOJAMIENTO_IDalojamiento() {
        return ALOJAMIENTO_IDalojamiento;
    }

    public void setALOJAMIENTO_IDalojamiento(int ALOJAMIENTO_IDalojamiento) {
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
    }

    public int getPERSONA_ID() {
        return PERSONA_ID;
    }

    public void setPERSONA_ID(int PERSONA_ID) {
        this.PERSONA_ID = PERSONA_ID;
    }
    
    
    //constructores
    //vacio
    public Valoracion() {
    }
    
    //sin id
    public Valoracion(String descripcion, int nota, int ALOJAMIENTO_IDalojamiento, int PERSONA_ID) {
        this.descripcion = descripcion;
        this.nota = nota;
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
        this.PERSONA_ID = PERSONA_ID;
    }
    
    //con id
    public Valoracion(Integer IDvaloracion, String descripcion, int nota, int ALOJAMIENTO_IDalojamiento, int PERSONA_ID) {
        this.IDvaloracion = IDvaloracion;
        this.descripcion = descripcion;
        this.nota = nota;
        this.ALOJAMIENTO_IDalojamiento = ALOJAMIENTO_IDalojamiento;
        this.PERSONA_ID = PERSONA_ID;
    }
    
    //tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valoracion{IDvaloracion=").append(IDvaloracion);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", nota=").append(nota);
        sb.append(", ALOJAMIENTO_IDalojamiento=").append(ALOJAMIENTO_IDalojamiento);
        sb.append(", PERSONA_ID=").append(PERSONA_ID);
        sb.append('}');
        return sb.toString();
    }
    
    
}

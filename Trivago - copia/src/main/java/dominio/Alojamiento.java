/*
*   CLASE ALOJAMIENTO
 */
package dominio;

import java.sql.Blob;

/**
 *
 * @author Alumno Mañana
 */
public class Alojamiento {
    private int IDalojamiento;
    private String tipo; //puede ser entre apartamento, hotel o chalet
    private String nombre;
    private String descripcion;
    private int espacio;
    private int IDdireccion;//clave ajena de direccion
    private String foto;
    
    //getter and setter
    public int getIDalojamiento() {
        return IDalojamiento;
    }

    public void setIDalojamiento(int IDalojamiento) {
        this.IDalojamiento = IDalojamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public int getIDdireccion() {
        return IDdireccion;
    }

    public void setIDdireccion(int IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

    public String getFoto() {
        return foto;
    }
    
    
    //constructores
    //vacio
    public Alojamiento() {
    }
    
    //sin id
        public Alojamiento(String tipo, String nombre, String descripcion, int espacio, int IDdireccion, String foto) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.espacio = espacio;
        this.IDdireccion = IDdireccion;
        this.foto = foto;
    }
    
    //con id
    public Alojamiento(int IDalojamiento, String tipo, String nombre, String descripcion, int espacio, int IDdireccion, String foto) {
        this.IDalojamiento = IDalojamiento;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.espacio = espacio;
        this.IDdireccion = IDdireccion;
        this.foto = foto;
    }
    
    //solo foto
    public Alojamiento(String foto) {
        this.foto = foto;
    }
    

    
    
    
    //equals and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.IDalojamiento;
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
        final Alojamiento other = (Alojamiento) obj;
        if (this.IDalojamiento != other.IDalojamiento) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alojamiento{IDalojamiento=").append(IDalojamiento);
        sb.append(", tipo=").append(tipo);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", espacio=").append(espacio);
        sb.append(", IDdireccion=").append(IDdireccion);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}

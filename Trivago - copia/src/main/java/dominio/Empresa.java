/*
*       EMPRESA
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Alumno Mañana
 */
public class Empresa {
    
    private int IDempresa;
    private String nombre;
    private String telefono;
    
    
    //getter and seter
    public int getIDempresa() {
        return IDempresa;
    }

    public void setIDempresa(int IDempresa) {
        this.IDempresa = IDempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    //construcotres
    //vacio
    public Empresa() {
    }
    
    //sin id
    public Empresa(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    //con id
    public Empresa(int IDempresa, String nombre, String telefono) {
        this.IDempresa = IDempresa;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    
    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.IDempresa;
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
        final Empresa other = (Empresa) obj;
        if (this.IDempresa != other.IDempresa) {
            return false;
        }
        return true;
    }
    
   //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{IDempresa=").append(IDempresa);
        sb.append(", nombre=").append(nombre);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}

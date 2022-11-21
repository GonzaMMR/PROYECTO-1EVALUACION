/*
*       DIRECCION
 */
package dominio;

import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class Direccion {
    
    private int IDdireccion;
    private String pais;
    private String calle;
    private String portal;
    private String piso;
    
    //getter and setter
    public int getIDdireccion() {
        return IDdireccion;
    }

    public void setIDdireccion(int IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    //constructores
    //vacio
    public Direccion() {
    }
    
    //sin id
    public Direccion(String pais, String calle, String portal, String piso) {
        this.pais = pais;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
    }
    
    
    //con id
    public Direccion(int IDdireccion, String pais, String calle, String portal, String piso) {
        this.IDdireccion = IDdireccion;
        this.pais = pais;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
    }

    public Direccion(int IDdireccion) {
        this.IDdireccion = IDdireccion;
    }
    
    
    
    //equals and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.IDdireccion;
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
        final Direccion other = (Direccion) obj;
        if (this.IDdireccion != other.IDdireccion) {
            return false;
        }
        return true;
    }
    
    
    //ToString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IDdireccion=").append(IDdireccion);
        sb.append(", pais=").append(pais);
        sb.append(", calle=").append(calle);
        sb.append(", portal=").append(portal);
        sb.append(", piso=").append(piso);
        return sb.toString();
    }
    
    
    
}

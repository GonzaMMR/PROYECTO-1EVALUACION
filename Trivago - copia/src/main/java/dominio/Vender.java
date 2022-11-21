/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author gonza
 */
public class Vender {
    private int IDventa;
    private int OFERTA_IDoferta;
    private int EMPRESA_IDempresa;
    
    //getter and setter
    public int getIDventa() {
        return IDventa;
    }

    public int getOFERTA_IDoferta() {
        return OFERTA_IDoferta;
    }

    public int getEMPRESA_IDempresa() {
        return EMPRESA_IDempresa;
    }
    
    
    //constructores
    public Vender() {    
    }

    //sin id
    public Vender(int OFERTA_IDoferta, int EMPRESA_IDempresa) {
        this.OFERTA_IDoferta = OFERTA_IDoferta;
        this.EMPRESA_IDempresa = EMPRESA_IDempresa;
    }
    
    //con id
    public Vender(int IDventa, int OFERTA_IDoferta, int EMPRESA_IDempresa) {
        this.IDventa = IDventa;
        this.OFERTA_IDoferta = OFERTA_IDoferta;
        this.EMPRESA_IDempresa = EMPRESA_IDempresa;
    }
    
    
    //tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vender{IDventa=").append(IDventa);
        sb.append(", OFERTA_IDoferta=").append(OFERTA_IDoferta);
        sb.append(", EMPRESA_IDempresa=").append(EMPRESA_IDempresa);
        sb.append('}');
        return sb.toString();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonza
 */
public class VenderDao {
    private static final String SQL_SELECT = "SELECT * FROM vender";
    private static final String SQL_INSERT = "INSERT INTO vender (OFERTA_IDoferta, EMPRESA_IDempresa) VALUES(?, ?)";
    private static final String SQL_UPDATE="UPDATE vender SET OFERTA_IDoferta=?,  EMPRESA_IDempresa=? WHERE IDventa=?";
    private static final String SQL_DELETE= "DELETE from vender WHERE IDventa=?";
    
    public List<Vender> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vender venta = null;
        List<Vender> ventas = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDventa = rs.getInt("IDventa");
            int OFERTA_IDoferta = rs.getInt("OFERTA_IDoferta");
            int EMPRESA_IDempresa = rs.getInt("EMPRESA_IDempresa");
            
            
            //instancio un nuevo objeto
            ventas.add(new Vender(IDventa,OFERTA_IDoferta, EMPRESA_IDempresa));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return ventas;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Vender venta){
        //delcaro e inicializao mis variables 
        Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            //1: establecer la conexion
            conn = getConnection();
            
            //2. preparo mi instrucccion para ejecutar contra la base de datos
            stm = conn.prepareStatement(SQL_INSERT);
            //asignar los valores a los ? de la consulta

            stm.setInt(1, venta.getOFERTA_IDoferta());
            stm.setInt(2, venta.getEMPRESA_IDempresa());
            
            //3. ejecuto el array
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Vender venta){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setInt(1, venta.getOFERTA_IDoferta());
            stm.setInt(2, venta.getEMPRESA_IDempresa());
            stm.setInt(3, venta.getIDventa());
            
            
            registros = stm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Vender venta){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, venta.getIDventa());
            
            registros = stm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}

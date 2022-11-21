/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Alumno Mañana
 */
public class OfertaDao {
    private static final String SQL_SELECT = "SELECT * FROM oferta";
    private static final String SQL_INSERT = "INSERT INTO oferta (precio, fechaInicio, fechaFin, ALOJAMIENTO_IDalojamiento) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE="UPDATE oferta SET precio=?,  fechaInicio=?,  fechaFin=?,  ALOJAMIENTO_IDalojamiento=?  WHERE IDoferta=?";
    private static final String SQL_DELETE= "DELETE from oferta WHERE IDoferta=?";
     
    
    public List<Oferta> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Oferta oferta = null;
        List<Oferta> ofertas = new ArrayList<>();
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDoferta = rs.getInt("IDoferta");
            Double precio = rs.getDouble("precio"); 
            Date fechaInicio = rs.getDate("fechaInicio");
            Date fechaFin = rs.getDate("fechaFin");
            int ALOJAMIENTO_IDalojamiento = rs.getInt("ALOJAMIENTO_IDalojamiento");
            
            
            
            //instancio un nuevo objeto
            ofertas.add(new Oferta(IDoferta, precio, fechaInicio, fechaFin, ALOJAMIENTO_IDalojamiento));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return ofertas;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Oferta oferta){
        //delcaro e inicializao mis variables 
        Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            //1: establecer la conexion
            conn = getConnection();
            
            //2. preparo mi instrucccion para ejecutar contra la base de datos
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setDouble(1, oferta.getPrecio());
            stm.setDate(2, oferta.getFechaInicio());
            stm.setDate(3, oferta.getFechaFin());
            stm.setInt(4, oferta.getALOJAMIENTO_IDalojamiento());
            
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
    
    
    public int actualizar(Oferta oferta){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setDouble(1, oferta.getPrecio());
            stm.setDate(2, oferta.getFechaInicio());
            stm.setDate(3, oferta.getFechaFin());
            stm.setInt(4, oferta.getALOJAMIENTO_IDalojamiento());
            stm.setInt(5, oferta.getIDoferta());
            
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
    
    public int eliminar(Oferta oferta){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, oferta.getIDoferta());
            
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

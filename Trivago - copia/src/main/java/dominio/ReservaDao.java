/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class ReservaDao {
    private static final String SQL_SELECT = "SELECT * FROM reserva";
    private static final String SQL_INSERT = "INSERT INTO reserva (OFERTA_IDoferta, PERSONA_ID, nombre, fechaReserva) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE="UPDATE reserva SET OFERTA_IDoferta=?, PERSONA_ID=?, nombre=?, fechaReserva=? WHERE idRESERVA=?";
    private static final String SQL_DELETE= "DELETE from reserva WHERE idRESERVA=?";
    
    public List<Reserva> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Reserva reserva = null;
        List<Reserva> reservas = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int idRESERVA = rs.getInt("idRESERVA");
            int OFERTA_IDoferta = rs.getInt("OFERTA_IDoferta");
            int PERSONA_ID = rs.getInt("PERSONA_ID");
            String nombre = rs.getString("nombre");
            Date fechaReserva = rs.getDate("fechaReserva");
            
            
            //instancio un nuevo objeto
            reservas.add(new Reserva(idRESERVA, OFERTA_IDoferta, PERSONA_ID, nombre, fechaReserva));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return reservas;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Reserva reserva){
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
            stm.setInt(1, reserva.getOFERTA_IDoferta());
            stm.setInt(2, reserva.getPERSONA_ID());
            stm.setString(3, reserva.getNombre());
            stm.setDate(4, reserva.getFechaReserva());

            
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
    
    public int eliminar(Reserva reserva){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, reserva.getIdRESERVA());
            
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

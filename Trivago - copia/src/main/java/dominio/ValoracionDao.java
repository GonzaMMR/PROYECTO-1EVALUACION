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
 * @author Alumno Mañana
 */
public class ValoracionDao {
    private static final String SQL_SELECT = "SELECT * FROM valoración";
    private static final String SQL_INSERT = "INSERT INTO valoración (descripcion, nota, ALOJAMIENTO_IDalojamiento, PERSONA_ID) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE="UPDATE valoración SET descripcion=?, nota=? WHERE IDvaloracion=?";
    private static final String SQL_DELETE= "DELETE from valoración WHERE IDvaloracion=?";
    
    public List<Valoracion> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Valoracion valoracion = null;
        List<Valoracion> valoraciones = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDvaloracion = rs.getInt("IDvaloracion");
            String descripcion = rs.getString("descripcion");
            int nota = rs.getInt("nota");
            int ALOJAMIENTO_IDalojamiento = rs.getInt("ALOJAMIENTO_IDalojamiento");
            int PERSONA_ID = rs.getInt("PERSONA_ID");
            
            
            //instancio un nuevo objeto
            valoraciones.add(new Valoracion(IDvaloracion, descripcion, nota, ALOJAMIENTO_IDalojamiento, PERSONA_ID));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return valoraciones;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Valoracion valoracion){
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
            stm.setString(1, valoracion.getDescripcion());
            stm.setInt(2, valoracion.getNota());
            stm.setInt(3, valoracion.getALOJAMIENTO_IDalojamiento());
            stm.setInt(4, valoracion.getPERSONA_ID());

            
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
    
    public int actualizar(Valoracion valoracion){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, valoracion.getDescripcion());
            stm.setInt(2, valoracion.getNota());
            stm.setInt(3, valoracion.getALOJAMIENTO_IDalojamiento());
            stm.setInt(4, valoracion.getPERSONA_ID());
            stm.setInt(5, valoracion.getIDvaloracion());
            
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
    
    public int eliminar(Valoracion valoracion){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, valoracion.getIDvaloracion());
            
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

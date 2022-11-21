/*
*       DIRECCIONDAO (aqui solo va ir INSERTAR), ya que no puedes cambiar el nombre de un pais o calle o eliminarla
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
public class DireccionDao {
    private static final String SQL_SELECT = "SELECT * FROM dirección";
    private static final String SQL_INSERT = "INSERT INTO dirección (pais, calle, portal, piso) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE="UPDATE dirección SET pais=?,  calle=?,  portal=?,  piso=?  WHERE IDdireccion=?";
    private static final String SQL_DELETE= "DELETE from dirección WHERE IDdireccion=?";
    
    public List<Direccion> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Direccion direccion = null;
        List<Direccion> direcciones = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDdireccion = rs.getInt("IDdireccion");
            String pais = rs.getString("pais");
            String calle = rs.getString("calle");
            String portal = rs.getString("portal");
            String piso = rs.getString("piso");
            
            //instancio un nuevo objeto
            direcciones.add(new Direccion(IDdireccion, pais,calle, portal, piso));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return direcciones;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Direccion direccion){
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
            stm.setString(1, direccion.getPais());
            stm.setString(2, direccion.getCalle());
            stm.setString(3, direccion.getPortal());
            stm.setString(4, direccion.getPiso());
            
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
    
    public int actualizar(Direccion direccion){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, direccion.getPais());
            stm.setString(2, direccion.getCalle());
            stm.setString(3, direccion.getPortal());
            stm.setString(4, direccion.getPiso());
            stm.setInt(5, direccion.getIDdireccion());
            
            
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
    
    public int eliminar(Direccion direccion){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, direccion.getIDdireccion());
            
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

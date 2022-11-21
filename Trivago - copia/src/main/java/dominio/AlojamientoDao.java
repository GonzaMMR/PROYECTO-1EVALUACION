/*
*       ALOJAMIENTODAO
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
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
public class AlojamientoDao {
    
    
    
    private static final String SQL_SELECT = "SELECT * FROM alojamiento";
    private static final String SQL_INSERT = "INSERT INTO alojamiento (tipo, nombre, descripcion, espacio, DIRECCIÓN_IDdireccion, foto) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE="UPDATE alojamiento SET tipo=?, nombre=?, descripcion=?, espacio=?,DIRECCIÓN_IDdireccion=?, foto=?  WHERE IDalojamiento=?";
    private static final String SQL_DELETE= "DELETE from alojamiento WHERE IDalojamiento=?";
    
    public List<Alojamiento> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Alojamiento alojamiento = null;
        List<Alojamiento> alojamientos = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDalojamiento = rs.getInt("IDalojamiento");
            String tipo = rs.getString("tipo");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int espacio = rs.getInt("espacio");
            int IDdireccion = rs.getInt("DIRECCIÓN_IDdireccion");
            String foto = rs.getString("foto");
            
            
            //instancio un nuevo objeto
            alojamientos.add(new Alojamiento(IDalojamiento, tipo, nombre, descripcion, espacio, IDdireccion, foto));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return alojamientos;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Alojamiento alojamiento) throws FileNotFoundException{
        
        File archivoFoto = new File(alojamiento.getFoto());
        Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            
            FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, alojamiento.getTipo());
            stm.setString(2, alojamiento.getNombre());
            stm.setString(3, alojamiento.getDescripcion());
            stm.setInt(4, alojamiento.getEspacio());
            stm.setInt(5, alojamiento.getIDdireccion());
            stm.setBlob(6, convertir_imagen, archivoFoto.length());
            
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
    
    
    public int actualizar(Alojamiento alojamiento) throws FileNotFoundException{
        
        File archivoFoto = new File(alojamiento.getFoto());
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, alojamiento.getTipo());
            stm.setString(2, alojamiento.getNombre());
            stm.setString(3, alojamiento.getDescripcion());
            stm.setInt(4, alojamiento.getEspacio());
            stm.setInt(5, alojamiento.getIDdireccion());
            stm.setBlob(6, convertir_imagen, archivoFoto.length());
            stm.setInt(7, alojamiento.getIDalojamiento());
            
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
    
    public int eliminar(Alojamiento alojamiento){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, alojamiento.getIDalojamiento());
            
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

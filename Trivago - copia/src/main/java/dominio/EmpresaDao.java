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
public class EmpresaDao {
    private static final String SQL_SELECT = "SELECT * FROM empresa";
    private static final String SQL_INSERT = "INSERT INTO empresa (nombre, telefono) VALUES(?, ?)";
    private static final String SQL_UPDATE="UPDATE empresa SET nombre=?, telefono=? WHERE IDempresa=?";
    private static final String SQL_DELETE= "DELETE from empresa WHERE IDempresa=?";
    
    public List<Empresa> seleccionar() throws SQLException{
        
        //inicializamos las varialbes
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Empresa persona = null;
        List<Empresa> empresas = new ArrayList<>();
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDempresa = rs.getInt("IDempresa");
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            
            //instancio un nuevo objeto
            empresas.add(new Empresa(IDempresa, nombre, telefono));
        }
        close(rs);
        close(stm);
        close(conn);
        
        return empresas;
    }
    
    //metodo que inserta una persona en mi sistmea
    public int insertar(Empresa empresa){
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
            stm.setString(1, empresa.getNombre());
            stm.setString(2, empresa.getTelefono());
            
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
    
    public int actualizar(Empresa empresa){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, empresa.getNombre());
            stm.setString(2, empresa.getTelefono());
            stm.setInt(3, empresa.getIDempresa());
            
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
    
    public int eliminar(Empresa empresa){
        //inicializo mis componentes
        Connection conn = null;
        PreparedStatement stm = null;
        int registros =0;
        
        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, empresa.getIDempresa());
            
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

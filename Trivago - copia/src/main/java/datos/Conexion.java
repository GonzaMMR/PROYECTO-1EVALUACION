/*
*       CONEXION CON LA BBDD: TRIVAGO 
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno Mañana
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/trivago?useSSL=false"+
            "&useTimezone=true&serverTimezone=UTC"+
            "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="1234";
    
    
    //DECLARO UN  METODO QUE ESTABLECE LA CONEXION
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //metodos de cierre
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stm) throws SQLException{
        stm.close();
    }
    
    
    public static void close(PreparedStatement stm) throws SQLException{
        stm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
}

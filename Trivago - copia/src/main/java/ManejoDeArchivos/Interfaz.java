/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDeArchivos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Alojamiento;
import dominio.Direccion;
import dominio.Empresa;
import dominio.Oferta;
import dominio.Persona;
import dominio.Reserva;
import dominio.Valoracion;
import dominio.Vender;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonza
 */
public class Interfaz {
    
    
    
    public static void crearArchivo(String nombree){
        File archivo = new File(nombree);
        try{
            PrintWriter salida = new PrintWriter(archivo); 
            salida.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void escribirArchivo(String nombree, ArrayList contenido) throws SQLException{        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {//se que el fichero esxiste
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            System.out.println("Se ha creado el archivo!!");
        } catch (FileNotFoundException ex) {//el fichero no existe -> excp
            ex.printStackTrace(System.out);
        } finally {//Este bloque siempre se ejecuta
            salida.close();
        }
    }
    
    public static void agregarArchivoEmpresa(String nombree, ArrayList empresas) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM empresa";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Empresa persona = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: empresas) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void agregarArchivoPersona(String nombree, ArrayList personas) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM persona";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = null;
        
        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int ID = rs.getInt("ID");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String contrasenia = rs.getString("contrasenia");
            String tarjeta = rs.getString("tarjeta");
            
            //instancio un nuevo objeto
            personas.add(new Persona(ID, nombre,apellidos, email, telefono, contrasenia, tarjeta));
        }
        close(rs);
        close(stm);
        close(conn);
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: personas) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void agregarArchivoDireccion(String nombree, ArrayList direcciones) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM dirección";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Direccion direccion = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: direcciones) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void agregarArchivoAlojamiento(String nombree, ArrayList alojamientos) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM alojamiento";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Alojamiento alojamiento = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: alojamientos) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    
    public static void agregarArchivoValoracion(String nombree, ArrayList valoraciones) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM valoración";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Valoracion valoracion = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: valoraciones) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void agregarArchivoOferta(String nombree, ArrayList ofertas) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM oferta";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Oferta oferta = null;

        conn = getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();
        
        while(rs.next()){
            int IDoferta = rs.getInt("IDoferta");
            Double precio = rs.getDouble("precio"); 
            Date fechaInicio = rs.getDate("fechaInicio");
            Date fechaFin = rs.getDate("fechaFin");
            int ALOJAMIENTO_IDalojamiento = rs.getInt("ALOJAMIENTO_IDalojamiento");
            //Blob foto = rs.getBlob("foto");
            
            
            //instancio un nuevo objeto
            ofertas.add(new Oferta(IDoferta, precio, fechaInicio, fechaFin, ALOJAMIENTO_IDalojamiento));
        }
        close(rs);
        close(stm);
        close(conn);
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: ofertas) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    
    public static void agregarArchivoReserva(String nombree, ArrayList reservas) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM reserva";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Reserva reserva = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: reservas) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void agregarArchivoVenta(String nombree, ArrayList ventas) throws SQLException{//Este metodo agrega texto en el archivo
        
        String SQL_SELECT = "SELECT * FROM vender";
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vender venta = null;
        
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
        
        PrintWriter salida = null;
        File archivo = new File(nombree);
        try {
             salida = new PrintWriter(new FileWriter(nombree, true));
             for (Object i: ventas) {
                salida.println(i);
            }
        } catch (IOException ex) {
            
        }finally{
            salida.close();
        }
    }
    
    public static void leerarchivo(String nombre, ArrayList contenido){
        //1.se declara el file
         BufferedReader entrada;
         File archivo = new File(nombre);
        try {
            //2.creamos el descriptor de lectura del fichero
             entrada = new BufferedReader(new FileReader(archivo));
              String lectura = entrada.readLine();
            //3. ahora recorremos lectura hasta fin de archivo
            while (lectura!= null){
                System.out.println("lectura :" +lectura);
                lectura= entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace(System.out);
        }catch (IOException ex){
             ex.printStackTrace(System.out);
        } 
    }
}

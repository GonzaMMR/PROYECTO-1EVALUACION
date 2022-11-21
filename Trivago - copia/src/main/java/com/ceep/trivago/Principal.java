/*
*       CLASE MAIN
 */
package com.ceep.trivago;


import ManejoDeArchivos.Interfaz;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Alojamiento;
import dominio.AlojamientoDao;
import dominio.Direccion;
import dominio.DireccionDao;
import dominio.Empresa;
import dominio.EmpresaDao;
import dominio.Oferta;
import dominio.OfertaDao;
import dominio.Persona;
import dominio.PersonaDao;
import dominio.Reserva;
import dominio.ReservaDao;
import dominio.Valoracion;
import dominio.ValoracionDao;
import dominio.Vender;
import dominio.VenderDao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Principal {
    
    //D:\\SEGUNDO AÑO\\ACCESO A DATOS\\PROYECTO PRIMERA EVALUACION\\img\\habitacionAustralia.jpg
    //en la base de datos por defecto, tiene que estar metido: empresas, direccion, oferta, alojamiento
    static Scanner ent = new Scanner(System.in);

    //ARCHIVO PARA CADA TABLA
    static String empresas = "empresas.txt";
    static String personas = "personas.txt";
    static String ofertas = "ofertas.txt";
    static String alojamientos = "alojamientos.txt";
    static String direcciones = "direcciones.txt";
    static String valoraciones = "valoraciones.txt";
    static String reservas = "reservas.txt";
    static String ventas = "ventas.txt";
    
    //ARRAYLIST PARA CADA TABLA
    static ArrayList<Empresa> empresa = new ArrayList<>();
    static Oferta o =new Oferta();
    static Alojamiento ol =new Alojamiento();
    static ArrayList<Persona> persona = new ArrayList<>();
    static ArrayList<Oferta> oferta = new ArrayList<>();
    static ArrayList<Alojamiento> alojamiento = new ArrayList<>();
    static ArrayList<Direccion> direccion = new ArrayList<>();
    static ArrayList<Valoracion> valoracion = new ArrayList<>();
    static ArrayList<Reserva> reserva = new ArrayList<>();
    static ArrayList<Vender> venta = new ArrayList<>();
    
    static Persona perso = new Persona();   
    static Valoracion valora = new Valoracion();
    static Reserva reser = new Reserva();
    static Alojamiento aloja = new Alojamiento();
    static Alojamiento a = new Alojamiento();
    static Oferta ofert = new Oferta();
    static Empresa empre =new Empresa();
    static Direccion d =new Direccion();
    static Vender v = new Vender();
    
    public static void main(String[] args) throws FileNotFoundException, SQLException {
      administrador();  
    }
    
    public static void administrador2() throws SQLException, FileNotFoundException{
        int opcion=-1;
        boolean sw1 = false;
        boolean sw2 = false;
        boolean sw3 = false;
        boolean sw5=false;

        while(opcion!=0){
        System.out.println("MENU\n");
        System.out.println("(1) Insertar Direccion");
        System.out.println("(2) Insertar Alojamiento");
        System.out.println("(3) Insertar Oferta");
        System.out.println("(4) Insertar Empresa");
        System.out.println("(5) Cambiar Direccion");
        System.out.println("(6) Mostrar todos los datos que se han registrado");
        System.out.println("(7) Insertar Venta");
        System.out.println("\t\t\t\t\t\t\t(0) [SALIR]");
        System.out.print("Seleccione la opcion a elegir: ");
        opcion=ent.nextInt();
        switch(opcion){
            case 1:
                sw1 = true;
                DireccionDao direccionDao = new DireccionDao();
                System.out.println("\nIntroduzca el pais al que pertenece: ");
                String pais = ent.nextLine();
                pais = ent.nextLine();
                System.out.println("Introduzca la calle: ");
                String calle = ent.nextLine();
                System.out.println("Introduzca el portal: ");
                String portal = ent.nextLine();
                System.out.println("Introduzca el piso: ");
                String piso = ent.nextLine();
                System.out.println("Pulsa una tecla para continuar");
                ent.nextLine();
                Direccion direcc = new Direccion(pais, calle, portal, piso);
                d = direcc;
                direccionDao.insertar(direcc);
                direccion.add(direcc);
                Interfaz.crearArchivo(direcciones);
                Interfaz.agregarArchivoDireccion(direcciones, direccion);
                break;
            case 2:
                if(sw1==true){
                    sw2 = true;
                    AlojamientoDao alojamientoDao = new AlojamientoDao();
                    System.out.println("\nIntroduzca su Tipo (Hotel, Apartamento o Chalet): ");
                    String tipo = ent.nextLine();
                    tipo = ent.nextLine();
                    System.out.println("Introduzca el nombre del apartamento: ");
                    String nombre = ent.nextLine();
                    System.out.println("Introduzca su descripcion: ");
                    String descripcion = ent.nextLine();
                    System.out.println("Introduzca la cantidad de personas que ocupan el alojamiento: ");
                    int espacio = ent.nextInt();
                    System.out.println("Introduzca su contraseña: ");
                    String contrasenia = ent.nextLine();
                    DireccionDao direccionDao2 = new DireccionDao();
                    try {
                    List<Direccion> direccion = direccionDao2.seleccionar();
                    direccion.forEach(o -> {
                        System.out.println("\t\t"+ o);
                    }
                    );
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    System.out.println("Introduzca el ID de la direccion a la que corresponde: ");
                    int IDdireccion = ent.nextInt();
                    System.out.println("Inserte una foto: ");
                    String foto = ent.nextLine();
                    foto = ent.nextLine();
                    System.out.println("Pulsa una tecla para continuar");
                    ent.nextLine();
                    Alojamiento aloj = new Alojamiento(tipo, nombre, descripcion, espacio, IDdireccion, foto);
                    aloja = aloj;
                    alojamientoDao.insertar(aloj);
                    alojamiento.add(aloj);
                    Interfaz.crearArchivo(alojamientos);
                    Interfaz.agregarArchivoAlojamiento(alojamientos, alojamiento);
                }else{
                    System.out.println("Primero tienes que insertar una Direccion");
                }
                
                break;
            case 3:
                sw3=true;
                if(sw2==true){
                    OfertaDao ofertaDao = new OfertaDao();
                    System.out.println("\nIntroduzca su precio(no mayor de 100): ");
                    Double precio = ent.nextDouble();

                    System.out.println("Introduzca el dia de inicio de la oferta: ");
                    int dia = ent.nextInt();
                    System.out.println("Introduzca el mes de inicio de la oferta: ");
                    int mes = ent.nextInt()- 1;
                    System.out.println("Introduzca el año de inicio de la oferta: ");
                    int anio = ent.nextInt() - 1900;
                    System.out.println("La fecha de reserva es: ");
                    Date fechaInicio = new Date(anio, mes, dia);

                    System.out.println("Introduzca el dia de fin de la oferta: ");
                     dia = ent.nextInt();
                    System.out.println("Introduzca el mes de fin de la oferta: ");
                     mes = ent.nextInt()- 1;
                    System.out.println("Introduzca el año de fin de la oferta: ");
                     anio = ent.nextInt() - 1900;
                    System.out.println("La fecha de reserva es: ");
                    Date fechaFin = new Date(anio, mes, dia);

                    AlojamientoDao aloDao = new AlojamientoDao();
                    try {
                    List<Alojamiento> direccion = aloDao.seleccionar();
                    direccion.forEach(o -> {
                        System.out.println("\t\t"+ o);
                    }
                    );
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    System.out.println("Introduzca el ID del alojamineto que quiere en la oferta ");
                    int ALOJAMIENTO_IDalojamiento = ent.nextInt();
                    System.out.println("Pulsa una tecla para continuar");
                    ent.nextLine();
                    Oferta ofer = new Oferta(precio, fechaInicio, fechaFin, ALOJAMIENTO_IDalojamiento);
                    ofert = ofer;
                    ofertaDao.insertar(ofer);
                    oferta.add(ofer);
                    Interfaz.crearArchivo(ofertas);
                    Interfaz.agregarArchivoOferta(ofertas, oferta);
                }else{
                    System.out.println("Tienes que insertar un Alojamiento");
                }
                
                break;
            case 4:
                sw5=true;
                EmpresaDao empresaDao = new EmpresaDao();
                System.out.println("\nIntroduzca el nombre de la Empresa: ");
                String nombre = ent.nextLine();
                nombre = ent.nextLine();
                System.out.println("Introduzca el telefono de la empresa: ");
                String telefono = ent.nextLine();
                System.out.println("Pulsa una tecla para continuar");
                ent.nextLine();
                Empresa empr = new Empresa(nombre, telefono);
                empre = empr;
                empresaDao.insertar(empr);
                empresa.add(empr);
                Interfaz.crearArchivo(empresas);
                Interfaz.agregarArchivoEmpresa(empresas, empresa);
                break;
            case 5:
                DireccionDao dDao = new DireccionDao();
                Direccion di = new Direccion();
                System.out.println("\nIntroduzca el Id de la direccion a actualizar:");
                int Iddireccion = ent.nextInt();
                List<Direccion> direccioness = dDao.seleccionar();
                    for(Direccion d: direccioness){
                        if(Iddireccion==d.getIDdireccion()){
                            di = d;
                        }
                    }System.out.println("\n\tHas seleccionado la direccion: "+di);
                    System.out.println("Introduzca un nuevo pais: ");
                    pais = ent.nextLine();
                    pais = ent.nextLine();
                    di.setPais(pais);
                    dDao.actualizar(di);
                    
                    Interfaz.crearArchivo(direcciones);
                    Interfaz.agregarArchivoDireccion(direcciones, direccion);
                    
                break;
            case 6:
                System.out.println("");
                System.out.println("");
                System.out.println("\n\t\t\t\t\tEMPRESAS");
                System.out.println("\t\t\t\t\t==========");
                EmpresaDao empresaDao2 = new EmpresaDao();
                try {
                    List<Empresa> empresas = empresaDao2.seleccionar();
                    empresas.forEach(a -> {
                        System.out.println("\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                
                System.out.println("");
                System.out.println("");
                System.out.println("\n\t\t\t\t\tOFERTAS");
                System.out.println("\t\t\t\t\t=========");
                OfertaDao ofertadao = new OfertaDao();
                try {
                    List<Oferta> ofertas = ofertadao.seleccionar();
                    ofertas.forEach(a -> {
                        System.out.println("\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                System.out.println("");
                System.out.println("");
                System.out.println("\n\t\t\t\t\tPERSONAS (USUARIOS)");
                System.out.println("\t\t\t\t\t=====================");
                PersonaDao personadao = new PersonaDao();
                try {
                    List<Persona> personas = personadao.seleccionar();
                    personas.forEach(a -> {
                        System.out.println("\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                
                System.out.println("");
                System.out.println("");
                System.out.println("\n\t\t\t\t\tRESERVAS");
                System.out.println("\t\t\t\t\t==========");
                ReservaDao reservadao = new ReservaDao();
                try {
                    List<Reserva> reservas = reservadao.seleccionar();
                    reservas.forEach(a -> {
                        System.out.println("\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                System.out.println("");
                System.out.println("");
                System.out.println("\n\t\t\t\t\tVALORACIONES");
                System.out.println("\t\t\t\t\t==============");
                ValoracionDao valoraciondao = new ValoracionDao();
                try {
                    List<Valoracion> valoraciones = valoraciondao.seleccionar();
                    valoraciones.forEach(a -> {
                        System.out.println("\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                
                Interfaz.crearArchivo(alojamientos);
                Interfaz.agregarArchivoAlojamiento(alojamientos, alojamiento);
                break;
            case 7:
                if(sw5==true){
                    VenderDao venderDao = new VenderDao();
                OfertaDao ofertaDao2 = new OfertaDao();
                try {
                    List<Oferta> oferta = ofertaDao2.seleccionar();
                    oferta.forEach(o -> {
                        System.out.println("\n\t\t\t\t"+ o+"\n");
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                System.out.println("\nIntroduzca el ID de la oferta que quiera vender: ");
                int IDoferta = ent.nextInt();
                
                EmpresaDao empresadao = new EmpresaDao();
                try {
                    List<Empresa> empresa = empresadao.seleccionar();
                    empresa.forEach(o -> {
                        System.out.println("\n\t\t\t\t"+ o+"\n");
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                System.out.println("Introduzca el ID de la empresa que lo vende: ");
                int IDempresa = ent.nextInt();
                System.out.println("Pulsa una tecla para continuar");
                ent.nextLine();
                Vender vendr = new Vender(IDoferta, IDempresa);
                v = vendr;
                venderDao.insertar(vendr);
                venta.add(vendr);
                Interfaz.crearArchivo(ventas);
                Interfaz.agregarArchivoVenta(ventas, venta);
                }else{
                    System.out.println("Primero tienes que crear una empresa y oferta");
                }
                
                break;
            case 0:
                break;
            default:
                System.out.println("Elija entre las opcines 1 y 8");
                break;
        }
        for(int i=0;i<2;i++){
            System.out.println("");
        }
        }
    }
    
    public static void administrador() throws SQLException, FileNotFoundException{
        int opcion=-1;
        while(opcion!=0){
        System.out.println("MENU\n");
        System.out.println("(1) Aministrador");
        System.out.println("(2) Ver app ");
        System.out.println("\t\t\t\t\t\t\t(0) [SALIR]");
        System.out.print("Seleccione la opcion a elegir: ");
        opcion=ent.nextInt();
        switch(opcion){
            case 1:
                administrador2();
                break;
            case 2:
                menu();
                break;
            case 0:
                break;
            default:
                System.out.println("Elija entre las opcines 1 y 2");
                break;
        }
        for(int i=0;i<2;i++){
            System.out.println("");
        }
        }
    }
    
    public static void menu() throws SQLException, FileNotFoundException{
        Persona p = new Persona();
        int opcion=-1;
        while(opcion!=0){
        if(perso.equals(p)){
            System.out.println("\t¿MENÚ\n");
            System.out.println("(1) OFERTAS");
            System.out.println("(2) CREAR USUARIO ");
            System.out.println("(3) INICIAR SESION ");
        }else{
           System.out.println("\t¿MENÚ\n");
            System.out.println("(1) OFERTAS");
            System.out.println("(2) CREAR USUARIO ");
            System.out.println("(3) ENTRAR AL PERFIL "); 
        }
        System.out.println("(4) HACER RESERVA ");
        System.out.println("(5) ESCRIBIR VALORACIÓN");
        System.out.println("\t(0)   SALIR");
        System.out.print("Seleccione la opcion a elegir: ");
        opcion=ent.nextInt();
        switch(opcion){ 
            case 1:
                System.out.println("\n\t\t\t\t\tOFERTAS");
                System.out.println("\t\t\t\t\t=======");
                oferta.add(ofert);
                OfertaDao ofertaDao = new OfertaDao();
                try {
                    List<Oferta> oferta = ofertaDao.seleccionar();
                    oferta.forEach(o -> {
                        System.out.println("\t\t\t\t\t"+ o);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                String pasar;
                System.out.println("\n\t\t\t\t\t¿QUIERES VER LOS ALOJAMIENTOS DISPONIBLES QUE HAY EN LAS OFERTAS?");
                pasar=ent.nextLine();
                pasar=ent.nextLine();
                System.out.println("\n\t\t\t\t\tALOJAMIENTOS");
                System.out.println("\t\t\t\t\t============");
                alojamiento.add(aloja);
                AlojamientoDao alojamientoDao = new AlojamientoDao();
                try {
                    List<Alojamiento> alojamiento = alojamientoDao.seleccionar();
                    alojamiento.forEach(a -> {
                        System.out.println("\t\t\t\t\t"+ a);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                System.out.println("\n\t\t\t\t\t¿QUIERES DONDE SE ENCUENTRAN ESOS ALOJAMIENTOS?");
                pasar=ent.nextLine();
                System.out.println("\t\t\t\t\tDIRECCIONES");
                System.out.println("\t\t\t\t\t============");
                DireccionDao direccionDao = new DireccionDao();
                try {
                    List<Direccion> direccion = direccionDao.seleccionar();
                    direccion.forEach(d -> {
                        System.out.println("\t\t\t\t\t"+ d);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }                       
                break;
            case 2:
                System.out.println("\n\nIntroduzca su NOMBRE: ");
                String nombre = ent.nextLine();
                nombre = ent.nextLine();
                System.out.println("Introduzca sus APELLIDOS: ");
                String apellidos = ent.nextLine();
                System.out.println("Introduzca su Correo Electronico: ");
                String email = ent.nextLine();
                System.out.println("Introduzca su teléfono: ");
                String telefono = ent.nextLine();
                System.out.println("Introduzca su contraseña: ");
                String contrasenia = ent.nextLine();
                System.out.println("Introduzca su tarjeta de pago(16 digitos en total, sin dejar espacios vacios): ");
                String tarjeta = ent.nextLine();
                System.out.println("Pulsa una tecla para continuar");
                ent.nextLine();
                Persona per = new Persona(nombre, apellidos, email, telefono, contrasenia, tarjeta);
                perso = per;
                
                PersonaDao personaDao = new PersonaDao();
                try {
                    List<Persona> persona = personaDao.seleccionar();
                    persona.forEach(pe -> {
                        System.out.println(""+ pe);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                personaDao.insertar(per);
                persona.add(per);
                Interfaz.crearArchivo(personas);
                Interfaz.agregarArchivoPersona(personas, persona);
                break;
            case 3:
                if(perso.equals(p)){
                    ent.nextLine();
                    iniciarSesion();
                }else{
                    ent.nextLine();
                    menuPerfil();
                }
                break;
            case 4:
                System.out.println("\t\t\t\t\tREALIZAR RESERVA");
                System.out.println("\t\t\t\t\t================");
                System.out.println("\tAqui tienes todas las ofertas disponibles para comprar\n");
                OfertaDao ofertaDao2 = new OfertaDao();
                try {
                    List<Oferta> oferta = ofertaDao2.seleccionar();
                    oferta.forEach(o -> {
                        System.out.println("\n\t\t\t\t"+ o+"\n");
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                int OFERTA_IDoferta;
                int PERSONA_ID;
                String nombree;
                int dia;
                int mes;
                int anio;

                System.out.println("\tA continuacion, vas a realizar una reserva de cualquier oferta");
                System.out.println("\tHola,  "+"ID: " +perso.getID()+" "+perso.getNombre()+", "+perso.getApellidos()+", Contraseña: "+perso.getContrasenia());
                System.out.println("\tSu ID es: "+perso.getID());
                PERSONA_ID = perso.getID();
                System.out.println("Introduzca el ID de la Oferta que quiera reservar: ");
                OfertaDao ofertaDao3 = new OfertaDao();
                try {
                    List<Oferta> oferta = ofertaDao3.seleccionar();
                    oferta.forEach(o -> {
                        System.out.println("\t\t"+ o);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                OFERTA_IDoferta = ent.nextInt();
                System.out.println("");
                
                
                System.out.println("Introduzca el nombre con el que quiere guardar esta Reserva: ");
                nombre = ent.nextLine();
                nombre = ent.nextLine();
                System.out.println("Eliga la fecha de la Reserva, se tiene que aproximar a la fecha de inicio de la oferta: ");
                System.out.println("Introduzca el dia: ");
                dia = ent.nextInt();
                System.out.println("Introduzca el mes: ");
                mes = ent.nextInt()- 1;
                System.out.println("Introduzca el año: ");
                anio = ent.nextInt() - 1900;
                System.out.println("La fecha de reserva es: ");
                Date fechaReserva = new Date(anio, mes, dia);
                System.out.println(fechaReserva);
                System.out.println("");
                Reserva res = new Reserva(OFERTA_IDoferta, PERSONA_ID, nombre, fechaReserva);
                reser = res;

                ReservaDao reservaDao = new ReservaDao();
                try {
                    List<Reserva> reserva = reservaDao.seleccionar();
                    persona.forEach(pee -> {
                        System.out.println(""+ pee);
                    }
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                reservaDao.insertar(res);
                reserva.add(res);
                Interfaz.crearArchivo(reservas);
                Interfaz.agregarArchivoReserva(reservas, reserva);
                break;
            case 5:
                ValoracionDao valoracionDao = new ValoracionDao();
                System.out.println("¿Quieres realizar una valoracion sobre tu estancia? True or False");
                    boolean SiNo;
                    
                    SiNo=ent.nextBoolean();
                    if(SiNo) {
                      String descripcion;
                        int nota;
                        int ALOJAMIENTO_IDalojamiento;
                        System.out.println("A continuacion, vas a realizar una valoracion de cualquier alojamiento");
                        System.out.println("\tHola,  "+"ID: " +perso.getID()+" "+perso.getNombre()+", "+perso.getApellidos()+", Contraseña: "+perso.getContrasenia());
                        System.out.println("\tSu ID es: "+perso.getID());
                        PERSONA_ID = perso.getID();
                        System.out.println("Escribe un breve comentario sobre que le ha parecido: ");
                        descripcion=ent.nextLine();
                        descripcion=ent.nextLine();
                        System.out.println("Que nota nos darias? ");
                        nota=ent.nextInt();
                        System.out.println("En que alojamiento estuviste? ");
                        AlojamientoDao alodao = new AlojamientoDao();
                        try {
                            List<Alojamiento> alo = alodao.seleccionar();
                            alo.forEach(o -> {
                                System.out.println("\t\t"+ o);
                            }
                            );
                        } catch (SQLException ex) {
                            ex.printStackTrace(System.out);
                        }
                        ALOJAMIENTO_IDalojamiento=ent.nextInt();
                        Valoracion valor = new Valoracion(descripcion, nota, ALOJAMIENTO_IDalojamiento, PERSONA_ID);
                        valora = valor;
                        valoracionDao.insertar(valor);
                        valoracion.add(valor);
                        Interfaz.crearArchivo(valoraciones);
                        Interfaz.agregarArchivoValoracion(valoraciones, valoracion);
                    } else {
                        System.out.println("Gracias por tu colaboracion, esperamos que vuelvas :)");
                    }
                break;
            case 0:
 
                break;
            default:
                System.out.println("Elija entre las opcines 1 y 6");
                break;
        }
        for(int i=0;i<2;i++){
            System.out.println("");
        }
        }
    }
    
    public static void menuPerfil() throws SQLException, FileNotFoundException{
        PersonaDao personaDao = new PersonaDao();  
        boolean sw1=false;
        int opcion=-1;
        while(opcion!=0){
        System.out.println("MENU\n");
        System.out.println("(1) Editar perfil ");
        System.out.println("(2) Eliminar reserva ");
        System.out.println("(3) Eliminar valoracion ");
        System.out.println("(4) Eliminar perfil ");
        System.out.println("\t\t\t\t\t\t\t(0) [SALIR]");
        System.out.print("Seleccione la opcion a elegir: ");
        opcion=ent.nextInt();
        switch(opcion){
            case 1:
               editarPerfil();
                break;
            case 2:
                sw1=true;
                boolean SiNo;
                ReservaDao rDao = new ReservaDao();
                Reserva re = new Reserva();
                    try {
                    List<Reserva> reserva = rDao.seleccionar();
                    reserva.forEach(o -> {
                        System.out.println("\n\t\t"+ o);
                    }
                    );
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                System.out.println("Tu ID es: "+perso.getID());
                System.out.println("Quieres volver a atras? (True o False): ");
                SiNo= ent.nextBoolean();
                if(SiNo){
                    break;
                }else{
                System.out.println("\nIntroduzca el Id de la reserva que quiere eliminar:");
                int idRESERVA = ent.nextInt();
                List<Reserva> reservass = rDao.seleccionar();
                    for(Reserva d: reservass){
                        if(idRESERVA==d.getIdRESERVA()){
                            re = d;
                        }
                    }
                    System.out.println("\n\tHas eliminado la reserva: "+re);
                    re.getIdRESERVA();
                    rDao.eliminar(re);
                    reserva.remove(re);
                    Interfaz.crearArchivo(reservas);
                    Interfaz.agregarArchivoReserva(reservas, reserva);
                }
                   
                break;
            case 3:
                sw1=true;
                ValoracionDao vDao = new ValoracionDao();
                Valoracion var = new Valoracion();
                    try {
                    List<Valoracion> valoracion = vDao.seleccionar();
                    valoracion.forEach(o -> {
                        System.out.println("\n\t\t"+ o);
                    }
                    );
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                System.out.println("Tu ID es: "+perso.getID());
                System.out.println("Quieres volver a atras? (True o False): ");
                SiNo= ent.nextBoolean();
                if(SiNo){
                    break;
                }else{
                System.out.println("\nIntroduzca el Id de la valoracion que quiere eliminar:");
                int IDvaloracion = ent.nextInt();
                List<Valoracion> valoracionn = vDao.seleccionar();
                    for(Valoracion d: valoracionn){
                        if(IDvaloracion==d.getIDvaloracion()){
                            var = d;
                        }
                    }
                    System.out.println("\n\tHas eliminado la valoracion: "+var);
                    var.getIDvaloracion();
                    vDao.eliminar(var);
                    valoracion.remove(var);
                    Interfaz.crearArchivo(valoraciones);
                    Interfaz.agregarArchivoReserva(valoraciones, valoracion);
                }
                break;
            case 4:
                if(sw1==true){
                System.out.println("¿SEGURO QUE DESEA ELIMINAR ESTE PERFIL? True o False");
                boolean SiNo3;
                SiNo3=ent.nextBoolean();
                if(SiNo3){
                    perso.getID();
                    personaDao.eliminar(perso);
                    persona.remove(perso);
                    System.out.println("Has eliminado tu perfil");
                    opcion=0;
                    Interfaz.crearArchivo(personas);
                    Interfaz.agregarArchivoPersona(personas, persona);
                    System.exit(0);
                    break;
                }else{
                    System.out.println("Cancelada la accion.........");
                }
                Interfaz.crearArchivo(personas);
                Interfaz.agregarArchivoPersona(personas, persona);
                boolean SiNo2;
                System.out.println("");
                }else{
                    System.out.println("Primero tienes que eliminar tus reservas correspondientes");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Elija entre las opcines 1 y 2");
                break;
        }
        for(int i=0;i<2;i++){
            System.out.println("");
        }
        }
    }
    
    public static void editarPerfil() throws SQLException{
        PersonaDao personaDao = new PersonaDao();        
        int opcion=-1;
        while(opcion!=0){
        System.out.println("MENU\n");
        System.out.println("(1) Editar nombre ");
        System.out.println("(2) Editar apellidos ");
        System.out.println("(3) Editar email ");
        System.out.println("(4) Editar contraseña ");
        System.out.println("\t\t\t\t\t\t\t(0) GUARDAR DATOS");
        System.out.print("Seleccione la opcion a elegir: ");
        opcion=ent.nextInt();
        switch(opcion){
            case 1:
                System.out.println("\nIntroduzca el nuevo nombre: ");
                String nombre = ent.nextLine();
                nombre = ent.nextLine();
                perso.setNombre(nombre);
                break;
            case 2:
                System.out.println("\nIntroduzca el nuevo apellido: ");
                String apellidos = ent.nextLine();
                apellidos = ent.nextLine();
                perso.setApellidos(apellidos);
                break;
            case 3:
                System.out.println("\nIntroduzca el nuevo email: ");
                String email = ent.nextLine();
                email = ent.nextLine();
                perso.setEmail(email);
                break;
            case 4:
                System.out.println("\nIntroduzca la nueva contraseña: ");
                String contrasenia = ent.nextLine();
                contrasenia = ent.nextLine();
                perso.setContrasenia(contrasenia);
                break;
            case 0:
                personaDao.actualizar(perso);
                Interfaz.crearArchivo(personas);
                Interfaz.agregarArchivoPersona(personas, persona);
                break;
            default:
                System.out.println("Elija entre las opcines 1 y 4");
                break;
        }
        for(int i=0;i<2;i++){
            System.out.println("");
        }
        }
    }
        
    
    public static void iniciarSesion(){
        PersonaDao perDao = new PersonaDao();
        System.out.println("\nIntroduzca su nombre: ");
        String nombre = ent.nextLine();
        nombre = ent.nextLine();
        System.out.println("Introduzca su contraseña: ");
        String contrasenia = ent.nextLine();
        Persona p = new Persona(nombre, contrasenia);
        Persona pvacia = new Persona();
        try {
                List<Persona> personas = perDao.seleccionar();
                personas.forEach(pp -> {
                   if(pp.getNombre().equalsIgnoreCase(p.getNombre())&pp.getContrasenia().equals(p.getContrasenia())){
                       perso=pp;
                   }
                }
                );
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        if(perso.equals(pvacia)){
            System.out.println("\tUsuario o contraseña incorrecto");
        }else{
            System.out.println("\tUsuario Y contraseña correcto");
        }
    }
    
    
}

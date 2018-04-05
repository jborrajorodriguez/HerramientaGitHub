package com.juan.pruebaclonadocommitpush;

import javax.swing.JOptionPane;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {
    private static String user,pass,nombreR,desc;

    public static String getDesc() {
        return desc;
    }

    public Funciones() {
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Funciones.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Funciones.pass = pass;
    }

    public static String getNombreR() {
        return nombreR;
    }

    public static void setNombreR(String nombreR) {
        Funciones.nombreR = nombreR;
    }

   
    /**
     * Metodo estático que se encarga de introducir las credenciales.
     */
    public static void credentials(){
        user=JOptionPane.showInputDialog("Introduce el nombre de usuario(mail)");
        pass=JOptionPane.showInputDialog("Introduce la contraseña e usuario");
    }
    /**
     * Metodo estatico que devuelve un String con el nombre del repositorio.
     * @return nombre del repositorio String.
     */
    public static String nombreRepo(){
        nombreR=JOptionPane.showInputDialog("Nombre del repositorio");
         return nombreR;       
        
    }
    /**
     * Metodo estatico que devuelve un String con la descripcion del repositorio.
     * @return descripcion del repositorio String
     */
    public static String desc(){
        desc=JOptionPane.showInputDialog("Descripcion del repositorio");
         return desc;       
        
    }
}

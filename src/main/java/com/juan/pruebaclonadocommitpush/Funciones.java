package com.juan.pruebaclonadocommitpush;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;



/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {

    private static String user, pass, nombreR, desc;

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
    public static void credentials() {
        user = JOptionPane.showInputDialog("Introduce el nombre de usuario(mail)");
        pass = JOptionPane.showInputDialog(null, "Introduce la contraseña e usuario");
    }

    /**
     * Metodo estatico que devuelve un String con el nombre del repositorio.
     *
     * @return nombre del repositorio String.
     */
    public static String nombreRepo() {
        nombreR = JOptionPane.showInputDialog("Nombre del repositorio");
        return nombreR;

    }

    /**
     * Metodo estatico que devuelve un String con la descripcion del
     * repositorio.
     *
     * @return descripcion del repositorio String
     */
    public static String desc() {
        desc = JOptionPane.showInputDialog("Descripcion del repositorio");
        return desc;

    }

    public static void crear(String nombre, String desc, String ruta) {
        try {
            GitHub github;

            github = GitHub.connectUsingPassword(Funciones.getUser(), Funciones.getPass());
            GHRepository builder = github.createRepository(nombre, desc, " ", true);
            JOptionPane.showMessageDialog(null, builder.getGitTransportUrl());

        } catch (IOException ex) {
            System.out.println("Error");
        }

    }

    public static void inicializar(String ruta) {
        
        InitCommand repositorio=new InitCommand();
        try{
            repositorio.setDirectory(new File(ruta)).call();
        }catch(GitAPIException ex){
            System.out.println("Error al inicializar");
        }
    }
    public static void clonar(String url,String nombre){
        try {
            Git.cloneRepository().setURI(url).setDirectory(new File(nombre)).call();
        } catch (GitAPIException ex) {
            System.out.println("Error al clonar");
        }
        
    }
    public static void push() throws URISyntaxException{
        String url=JOptionPane.showInputDialog("Introduce la url del repositorio");
        String ruta=JOptionPane.showInputDialog("Introduce la ruta local del repositorio");
        try{
            FileRepositoryBuilder repositoryBuilder=new FileRepositoryBuilder();
            Repository repository=repositoryBuilder.setGitDir(new File(ruta))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();
            
            Git git=new Git(repository);

            RemoteAddCommand remoteAddCommand=git.remoteAdd();
            remoteAddCommand.setName("origin");
            remoteAddCommand.setUri(new URIish(url));
            remoteAddCommand.call();
            
            PushCommand pushCommand=git.push();
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(Funciones.getUser(),Funciones.getPass()));
            pushCommand.call();
            
        }catch(IOException ex){
            System.out.println("Error: Repositorio ");
        }catch(URISyntaxException ex){
            System.out.println("Error: URL ");
        }catch(GitAPIException ex){
            System.out.println("Error: "+ex);
        }
    }
    
   
    }
    
    




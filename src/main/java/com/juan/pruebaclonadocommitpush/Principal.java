package com.juan.pruebaclonadocommitpush;

import GUI.Entorno;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHCommitBuilder;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

/**
 * @author Juan Borrajo Rodriguez
 */
public class Principal {

    public static void main(String[] args) {
        Entorno en=new Entorno();
        en.setVisible(true);
        
    }
//        int x;
//        do {
//            Funciones.credentials();
//            x = Integer.parseInt(JOptionPane.showInputDialog("--------Menú--------"
//                    +"\nPulsa 1 Para crear repositorio"
//                    +"\nPulsa 2 Para borrar un repositorio"
//                    +"\nPulsa 3 Para hacer un commit"
//                    +"\nPulsa 4 Para clonar un repositorio"
//                    ));
//            switch (x) {
//                
//                case 1: {
//                    try {
//                        Funciones.nombreRepo();
//                        Funciones.desc();
//                        GitHub github = GitHub.connectUsingPassword(Funciones.getUser(),Funciones.getPass());
//                        GHRepository builder = github.createRepository(Funciones.getNombreR(),Funciones.getDesc()," ", true);
//                    } catch (IOException ex) {
//                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                break;
//                case 2:{
//                    
//                    
//                    break;
//                   
//                    
//                }
//                case 3:{
//                    break;
//                }
//                
//                    
//                case 4:{
//                try {
//                    Git.cloneRepository().setURI(JOptionPane.showInputDialog("Introduce la URL del repositorio a Clonar")).setDirectory(new File(JOptionPane.showInputDialog("Introduce la ruta donde quieres clonar el Repositorio"))).call();
//                    
//                    break;
//                } catch (GitAPIException ex) {
//                    System.out.println("Error"+ex);
//                }
//                }
//                default:
//                    throw new AssertionError();
//            }
//
//        } while (x == 0);
//
//    }

}

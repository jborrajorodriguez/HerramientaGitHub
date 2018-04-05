package com.juan.pruebaclonadocommitpush;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

/**
 * @author Juan Borrajo Rodriguez
 */
public class Principal {

    public static void main(String[] args) {
        int x;
        do {
            Funciones.credentials();
            x = Integer.parseInt(JOptionPane.showInputDialog("Pulsa 1 Para crear repositorio"));
            switch (x) {
                
                case 1: {
                    try {
                        Funciones.nombreRepo();
                        Funciones.desc();
                        GitHub github = GitHub.connectUsingPassword(Funciones.getUser(),Funciones.getPass());
                        GHRepository builder = github.createRepository(Funciones.getNombreR(),Funciones.getDesc()," ", true);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
                case 2:{
                    
                    
                 break;   
                }
                default:
                    throw new AssertionError();
            }

        } while (x == 0);

    }

}

package com.juan.pruebaclonadocommitpush;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

/**
 * @author Juan Borrajo Rodriguez
 */
public class Principal {

    public static void main(String[] args) {
        try {
            GitHub github = GitHub.connect();
            GHRepository repo = github.createRepository(
                    "Repo creado desde netbeans", "Repositorio de prueba de la API de GitHub",
                    " ", true/*public*/);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

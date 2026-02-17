package com.musicstore.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária para gerenciar a conexão com o banco de dados via JPA.
 * Ela lê as configurações do persistence.xml e fornece o EntityManager.
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "MusicStore-PU";
    private static EntityManagerFactory fabrica;

    /**
     * Retorna um EntityManager pronto para realizar operações no banco de dados.
     */
    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return fabrica.createEntityManager();
    }

 
    public static void fecharFabrica() {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}

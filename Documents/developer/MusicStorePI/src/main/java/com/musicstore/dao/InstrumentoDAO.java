package com.musicstore.dao;

import com.musicstore.model.Instrumento;
import com.musicstore.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Classe DAO para gerenciar as operações de banco de dados do Instrumento.
 */
public class InstrumentoDAO {

    /**
     * Salva ou atualiza um instrumento no banco de dados.
     */
    public void cadastrar(Instrumento instrumento) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(instrumento); // Persiste o objeto no banco
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // Cancela se houver erro
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Lista todos os instrumentos cadastrados no MySQL.
     */
    public List<Instrumento> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Consulta JPQL (referencia a classe, não a tabela)
            return em.createQuery("SELECT i FROM Instrumento i", Instrumento.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void excluir(int id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        Instrumento i = em.find(Instrumento.class, id); // Localiza o item pelo ID
        if (i != null) {
            em.remove(i); // Remove do banco
        }
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw e;
    } finally {
        em.close();
    }
}
}

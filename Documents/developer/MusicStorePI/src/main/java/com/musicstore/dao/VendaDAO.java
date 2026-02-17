package com.musicstore.dao;

import com.musicstore.model.Venda;
import com.musicstore.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class VendaDAO {
    public void cadastrar(Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}

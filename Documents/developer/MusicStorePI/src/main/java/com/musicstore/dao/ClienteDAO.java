package com.musicstore.dao;

import com.musicstore.model.Cliente;
import com.musicstore.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteDAO {

    /**
     * Busca um cliente no banco de dados através do CPF.
     * Necessário para vincular a venda ao cliente correto.
     */
    public Cliente buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Consulta JPQL para encontrar o cliente pelo CPF único
            String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("cpf", cpf);
            
            // Retorna o cliente encontrado ou null se não existir
            return query.getSingleResult();
        } catch (Exception e) {
            return null; 
        } finally {
            em.close();
        }
    }
}
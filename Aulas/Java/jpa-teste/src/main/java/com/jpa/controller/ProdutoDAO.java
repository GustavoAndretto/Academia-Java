package com.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jpa.model.Produto;

public class ProdutoDAO {
    private static final EntityManagerFactory emf;
    private EntityManager em;
    
    static {
        try {
            emf = Persistence.createEntityManagerFactory("default");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProdutoDAO() {
        em = emf.createEntityManager();
    }

    public void inserir(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public List<Produto> listarTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> rootEntry = cq.from(Produto.class);
        CriteriaQuery<Produto> all = cq.select(rootEntry);
        TypedQuery<Produto> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public void atualizar(Produto produto) {
        em.getTransaction().begin();

        Produto prod = em.find(Produto.class, produto.getId());
        if(prod != null) {
            prod.setCod(produto.getCodigo());
            prod.setQuantidade(produto.getQuantidade());
            prod.setNome(produto.getNome());
            prod.setValor(produto.getValor());
        }

        em.getTransaction().commit();
    }

    public void remover(Produto produto) {
        em.getTransaction().begin();

        Produto prod = em.find(Produto.class, produto.getId());
        if(prod != null) {
            em.remove(prod);
        }

        em.getTransaction().commit();
    }
}

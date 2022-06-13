package com.coco.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    public List<Produto> listarTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> rootEntry = cq.from(Produto.class);
        CriteriaQuery<Produto> all = cq.select(rootEntry);
        TypedQuery<Produto> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Long inserir(Produto produto) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }

        return produto.getCodigo();
    }

    public void atualizar(Produto produto) throws Exception {
        try {
            em.getTransaction().begin();

            Produto prod = em.find(Produto.class, produto.getCodigo());

            prod.setCategoria(produto.getCategoria());
            prod.setNome(produto.getNome());
            prod.setValor(produto.getValor());
            prod.setQuantidade(produto.getQuantidade());

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void remover(Produto produto) throws Exception {
        try {
            em.getTransaction().begin();

            Produto prod = em.find(Produto.class, produto.getCodigo());
            em.remove(prod);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
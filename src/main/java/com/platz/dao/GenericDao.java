/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.dao;

import com.platz.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Anderson
 * @param <T> Entidade
 */
public abstract class GenericDao<T> implements GenericDaoInterface<T> {

    @Override
    public void cadastrar(T t) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void alterar(T t) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> listarTodos(Class<T> entity) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        List<T> lista = entityManager.createQuery("from " + entity.getSimpleName()).getResultList();
        entityManager.close();

        return lista;
    }

    @Override
    public T buscarPorId(Class<T> entity, Integer id) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        T resultado = entityManager.find(entity, id);
        entityManager.close();

        return resultado;

    }

    @Override
    public void excluir(T t) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        t = entityManager.merge(t);
        entityManager.remove(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

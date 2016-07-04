package com.platz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.platz.entity.CategoriaEntity;
import com.platz.util.JpaUtil;

/**
 *
 * @author Anderson
 */

public class CategoriaDao extends GenericDao<CategoriaEntity> implements GenericDaoInterface<CategoriaEntity> {

	@SuppressWarnings("unchecked")
	public List<CategoriaEntity> buscarPeloNome(String nome) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		List<CategoriaEntity> lista = entityManager.createQuery("from CategoriaEntity where nome like :nome")
				.setParameter("nome", nome + "%").getResultList();
		entityManager.close();
		return lista;
	}

}

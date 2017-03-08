package br.com.caelum.empresa.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DAO<T> {

	
	public DAO(Class <T> classe) {
		super();
		this.classe = classe;
	}

	private final EntityManager entityManager = new JPAUtil().getEntityManager();
	private Class<Gasto> classe = Gasto.class;


	public void adiciona(Gasto entity) {
	    entityManager.persist(entity);
	}

	public Gasto atualiza(Gasto entity) {
	    return entityManager.merge(entity);
	}

	public void remove(Gasto entity) {
	    entityManager.remove(entity);
	}

	public Gasto buscaPorId(Long id) {
	    return entityManager.find(classe, id);
	}

	public List<Gasto> buscaTodos() {
	    Query query = entityManager
	            .createQuery("from " + classe.getName());
	    return query.getResultList();
	}

}
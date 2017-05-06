package br.app.servico.infra.fncmdo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.servico.infra.fncmdo.model.Funcionalidade;

@Stateless
public class FuncionalidadeFacade extends AbstractFacade<Funcionalidade> {

	public FuncionalidadeFacade() {
		super(Funcionalidade.class);
	}

	public FuncionalidadeFacade(Class<Funcionalidade> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "app-servico-infra-contexto-fnc-mdo")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<Funcionalidade> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Funcionalidade> criteria = cb.createQuery(Funcionalidade.class);
		Root<Funcionalidade> root = criteria.from(Funcionalidade.class);
		CriteriaQuery<Funcionalidade> todos = criteria.select(root);
		TypedQuery<Funcionalidade> allQuery = em.createQuery(todos);
		
		List<Funcionalidade> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}
	
	
}

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
import br.app.servico.infra.fncmdo.model.Identificador;

@Stateless
public class IdentificadorFacede extends AbstractFacade<Identificador> {

	public IdentificadorFacede() {
		super(Identificador.class);
	}

	public IdentificadorFacede(Class<Identificador> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-servico-infra-contexto-fnc-mdo")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Identificador> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Identificador> criteria = cb.createQuery(Identificador.class);
		Root<Identificador> parametro = criteria.from(Identificador.class);
		CriteriaQuery<Identificador> todos = criteria.select(parametro);
		TypedQuery<Identificador> allQuery = em.createQuery(todos);

		List<Identificador> resultado = allQuery.getResultList();

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}
}

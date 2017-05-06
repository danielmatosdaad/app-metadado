package br.app.servico.infra.apl.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.servico.infra.apl.model.Aplicativo;

@Stateless
public class AplicativoFacade extends AbstractFacade<Aplicativo> {

	public AplicativoFacade() {
		super(Aplicativo.class);
	}

	public AplicativoFacade(Class<Aplicativo> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-servico-infra-contexto-apl")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Aplicativo> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Aplicativo> criteria = cb.createQuery(Aplicativo.class);
		Root<Aplicativo> parametro = criteria.from(Aplicativo.class);
		CriteriaQuery<Aplicativo> todos = criteria.select(parametro);
		TypedQuery<Aplicativo> allQuery = em.createQuery(todos);

		List<Aplicativo> resultado = allQuery.getResultList();

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

	public Aplicativo buscarPorLogin(String login) {

		TypedQuery<Aplicativo> query = em.createQuery("SELECT app FROM aplicativo app WHERE app.login = ?", Aplicativo.class);
		return query.setParameter(1, login).getSingleResult();
	}
}

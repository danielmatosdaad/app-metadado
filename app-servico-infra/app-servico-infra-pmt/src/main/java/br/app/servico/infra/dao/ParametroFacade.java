package br.app.servico.infra.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.servico.infra.model.Parametro;
import br.app.servico.infra.model.TipoParametro; 

@Stateless
public class ParametroFacade extends AbstractFacade<Parametro> {

	public ParametroFacade() {
		super(Parametro.class);
	}

	public ParametroFacade(Class<Parametro> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-servico-infra-contexto-pmt")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public Parametro buscarPorTipoParametro(TipoParametro tipoParametro) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Parametro> criteria = cb.createQuery(Parametro.class);
		Root<Parametro> parametro = criteria.from(Parametro.class);
		criteria.select(parametro).where(cb.equal(parametro.get("tipoParametro"), tipoParametro));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Parametro> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Parametro> criteria = cb.createQuery(Parametro.class);
		Root<Parametro> parametro = criteria.from(Parametro.class);
		CriteriaQuery<Parametro> todos = criteria.select(parametro);
		TypedQuery<Parametro> allQuery = em.createQuery(todos);
		
		List<Parametro> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}
}

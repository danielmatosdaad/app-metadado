package br.app.servico.infra.fncmdo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.servico.infra.fncmdo.model.MetaDado;

@Stateless
public class MetaDadoFacade extends AbstractFacade<MetaDado> {

	public MetaDadoFacade() {
		super(MetaDado.class);
	}

	public MetaDadoFacade(Class<MetaDado> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-servico-infra-contexto-fnc-mdo")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<MetaDado> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MetaDado> criteria = cb.createQuery(MetaDado.class);
		Root<MetaDado> parametro = criteria.from(MetaDado.class);
		CriteriaQuery<MetaDado> todos = criteria.select(parametro);
		TypedQuery<MetaDado> allQuery = em.createQuery(todos);

		List<MetaDado> resultado = allQuery.getResultList();

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

	public MetaDado buscarPorNumeroTelaFuncionalidade(long numeroTela,long idFuncionalidade) {

		try {
			
			Query query =em.createNamedQuery(MetaDado.BUSCAR_POR_NUMEROTELA_FUNCIONALIDADE);
			
			query.setParameter("numTela", Integer.valueOf(""+numeroTela));
			query.setParameter("idFun", idFuncionalidade);
			MetaDado mdo = (MetaDado)query.getSingleResult();
			return mdo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();;
		}
		return null;
	}
}

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
import br.app.servico.infra.fncmdo.model.Perfil;

@Stateless
public class PerfilFacade extends AbstractFacade<Perfil> {

	public PerfilFacade() {
		super(Perfil.class);
	}

	public PerfilFacade(Class<Perfil> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-servico-infra-contexto-fnc-mdo")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Perfil> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Perfil> criteria = cb.createQuery(Perfil.class);
		Root<Perfil> root = criteria.from(Perfil.class);
		CriteriaQuery<Perfil> todos = criteria.select(root);
		TypedQuery<Perfil> allQuery = em.createQuery(todos);

		List<Perfil> resultado = (List<Perfil>) allQuery.getResultList();

		for (Perfil perfil : resultado) {

			System.out.println("id: " + perfil.getId());
			if (perfil.getPerfilPai() == null) {

				System.out.println("idPai: null");
			} else {

				System.out.println("idPai: " + perfil.getPerfilPai().getId());
			}

			System.out.println("qtdFilhos: " + perfil.getPerfilFilhos().size());
		}

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}

package br.app.servico.infra.fncmdo.service;

import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.fncmdo.dao.PerfilFacade;
import br.app.servico.infra.fncmdo.model.Perfil;
import br.app.servico.infra.integracao.dto.FuncionalidadeDTO;
import br.app.servico.infra.integracao.dto.PerfilDTO;
import br.app.servico.infra.integracao.interfaces.IServicoPerfilLocal;
import br.app.servico.infra.integracao.interfaces.IServicoPerfilRemote;

@Stateless(mappedName = "PerfilServiceImp")
@Remote(value = { IServicoPerfilRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoPerfilLocal.class,IServicoLocalDAO.class })
public class PerfilServiceImp implements IServicoPerfilRemote, IServicoPerfilLocal {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "FuncionalidadeServiceImp", beanInterface = IServicoLocalDAO.class)
	private IServicoLocalDAO<FuncionalidadeDTO> funcionalidadeServiceImp;

	@EJB
	private PerfilFacade perfilFacade;

	@Override
	public PerfilDTO adiconar(PerfilDTO dto) throws InfraEstruturaException, NegocioException {

		try {

			ServiceDAO.adiconar(perfilFacade, Perfil.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<PerfilDTO> adiconar(List<PerfilDTO> lista) throws InfraEstruturaException, NegocioException {

		try {

			for (PerfilDTO PerfilDTO : lista) {

				adiconar(PerfilDTO);
			}

			return lista;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public PerfilDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.perfilFacade, PerfilDTO.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);
		}
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		try {
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public void remover(PerfilDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.perfilFacade, Perfil.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public PerfilDTO alterar(PerfilDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.alterar(this.perfilFacade, Perfil.class, dto);
			return dto;
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<PerfilDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarTodos(this.perfilFacade, PerfilDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<PerfilDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.perfilFacade, PerfilDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}


}

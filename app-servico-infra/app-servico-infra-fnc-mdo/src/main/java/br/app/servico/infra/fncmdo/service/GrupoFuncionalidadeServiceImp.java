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
import br.app.servico.infra.fncmdo.dao.GrupoFuncionalidadeFacade;
import br.app.servico.infra.fncmdo.model.GrupoFuncionalidade;
import br.app.servico.infra.integracao.dto.GrupoFuncionalidadeDTO;
import br.app.servico.infra.integracao.interfaces.IServicoGrupoFuncionalidadeLocal;
import br.app.servico.infra.integracao.interfaces.IServicoGrupoFuncionalidadeRemote;

@Stateless(mappedName = "GrupoFuncionalidadeServiceImp")
@Remote(value = { IServicoGrupoFuncionalidadeRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoGrupoFuncionalidadeLocal.class,IServicoLocalDAO.class })
public class GrupoFuncionalidadeServiceImp
		implements IServicoGrupoFuncionalidadeRemote, IServicoGrupoFuncionalidadeLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	GrupoFuncionalidadeFacade grupoFuncionalidadeFacede;

	@Override
	public GrupoFuncionalidadeDTO adiconar(GrupoFuncionalidadeDTO dto)
			throws InfraEstruturaException, NegocioException {

		try {

			ServiceDAO.adiconar(grupoFuncionalidadeFacede, GrupoFuncionalidade.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<GrupoFuncionalidadeDTO> adiconar(List<GrupoFuncionalidadeDTO> lista)
			throws InfraEstruturaException, NegocioException {

		try {

			for (GrupoFuncionalidadeDTO GrupoFuncionalidadeDTO : lista) {

				adiconar(GrupoFuncionalidadeDTO);
			}

			return lista;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public GrupoFuncionalidadeDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.grupoFuncionalidadeFacede, GrupoFuncionalidadeDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		try {
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public void remover(GrupoFuncionalidadeDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.grupoFuncionalidadeFacede, GrupoFuncionalidade.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public GrupoFuncionalidadeDTO alterar(GrupoFuncionalidadeDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(this.grupoFuncionalidadeFacede, GrupoFuncionalidade.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<GrupoFuncionalidadeDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarTodos(this.grupoFuncionalidadeFacede, GrupoFuncionalidadeDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<GrupoFuncionalidadeDTO> bustarPorIntervaloID(int[] range)
			throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.grupoFuncionalidadeFacede, GrupoFuncionalidadeDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

}

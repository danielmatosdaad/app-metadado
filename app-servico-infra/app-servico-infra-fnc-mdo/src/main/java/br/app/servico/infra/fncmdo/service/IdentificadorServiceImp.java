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
import br.app.servico.infra.fncmdo.dao.IdentificadorFacede;
import br.app.servico.infra.fncmdo.model.Identificador;
import br.app.servico.infra.integracao.dto.IdentificadorDTO;
import br.app.servico.infra.integracao.interfaces.IServicoIdentificadorLocal;
import br.app.servico.infra.integracao.interfaces.IServicoIdentificadorRemote;

@Stateless
@Remote(value = { IServicoIdentificadorRemote.class,IServicoRemoteDAO.class})
@Local(value = { IServicoIdentificadorLocal.class,IServicoLocalDAO.class})
public class IdentificadorServiceImp implements IServicoIdentificadorRemote, IServicoIdentificadorLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IdentificadorFacede identificadorFacade;

	@Override
	public IdentificadorDTO adiconar(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {

		try {
			if (dto != null && dto.getId() == null) {
				return ServiceDAO.adiconar(this.identificadorFacade, Identificador.class, dto);
			}
		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

		return dto;
	}

	@Override
	public List<IdentificadorDTO> adiconar(List<IdentificadorDTO> listaDto) throws InfraEstruturaException, NegocioException {

		for (IdentificadorDTO IdentificadorDTO : listaDto) {
			adiconar(IdentificadorDTO);
		}
		return listaDto;
	}

	@Override
	public IdentificadorDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.identificadorFacade, IdentificadorDTO.class, id);

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

	public void remover(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.remover(identificadorFacade, Identificador.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public IdentificadorDTO alterar(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.alterar(identificadorFacade, Identificador.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<IdentificadorDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.identificadorFacade, IdentificadorDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<IdentificadorDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.identificadorFacade, IdentificadorDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

}

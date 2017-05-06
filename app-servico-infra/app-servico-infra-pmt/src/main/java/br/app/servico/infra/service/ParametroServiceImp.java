package br.app.servico.infra.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.dao.ParametroFacade;
import br.app.servico.infra.integracao.dto.ParametroDTO;
import br.app.servico.infra.integracao.interfaces.IServicoParametroLocal;
import br.app.servico.infra.integracao.interfaces.IServicoParametroRemote;
import br.app.servico.infra.model.Parametro;

@Stateless
@Remote(value = { IServicoParametroRemote.class,IServicoRemoteDAO.class})
@Local(value = { IServicoParametroLocal.class,IServicoLocalDAO.class })
public class ParametroServiceImp
		implements IServicoParametroRemote, IServicoParametroLocal<ParametroDTO>,IServicoRemoteDAO<ParametroDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ParametroFacade parametroFacede;

	public ParametroDTO adiconar(ParametroDTO dto) throws InfraEstruturaException, NegocioException {

		try {
			System.out.println("cheguei aqui");
			return ServiceDAO.adiconar(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	public List<ParametroDTO> adiconar(List<ParametroDTO> listaDto) throws InfraEstruturaException, NegocioException {

		for (ParametroDTO parametroDTO : listaDto) {
			adiconar(parametroDTO);
		}
		return listaDto;
	}

	public ParametroDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.parametroFacede, ParametroDTO.class, id);
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

	public void remover(ParametroDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public ParametroDTO alterar(ParametroDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.alterar(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<ParametroDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarTodos(this.parametroFacede, ParametroDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public List<ParametroDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.parametroFacede, ParametroDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

}

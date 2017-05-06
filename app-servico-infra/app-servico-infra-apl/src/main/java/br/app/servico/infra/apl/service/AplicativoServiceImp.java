package br.app.servico.infra.apl.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.conversores.Conversor;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.apl.dao.AplicativoFacade;
import br.app.servico.infra.apl.model.Aplicativo;
import br.app.servico.infra.integracao.dto.AplicativoDTO;
import br.app.servico.infra.integracao.dto.StatusAplicacaoDTO;
import br.app.servico.infra.integracao.interfaces.IServicoAplicativoLocal;
import br.app.servico.infra.integracao.interfaces.IServicoAplicativoRemote;

@Stateless
@Remote(value = { IServicoAplicativoRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoAplicativoLocal.class, IServicoLocalDAO.class })
public class AplicativoServiceImp implements IServicoAplicativoRemote, IServicoAplicativoLocal,
		IServicoRemoteDAO<AplicativoDTO>, IServicoLocalDAO<AplicativoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AplicativoFacade aplicativoFacade;

	@Override
	public AplicativoDTO adiconar(AplicativoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			if (dto == null) {
				throw new NegocioException("Dados invalidos", new RuntimeException());
			}
			return ServiceDAO.adiconar(this.aplicativoFacade, Aplicativo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<AplicativoDTO> adiconar(List<AplicativoDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.aplicativoFacade, Aplicativo.class, listaDto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public AplicativoDTO alterar(AplicativoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.alterar(this.aplicativoFacade, Aplicativo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(AplicativoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.aplicativoFacade, Aplicativo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AplicativoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.aplicativoFacade, AplicativoDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public AplicativoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.aplicativoFacade, AplicativoDTO.class, id);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<AplicativoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorIntervaloID(this.aplicativoFacade, AplicativoDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	public AplicativoDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException {

		try {

			Aplicativo aplicativo = this.aplicativoFacade.buscarPorLogin(login);
			if (aplicativo == null) {
				throw new NegocioException(1, "login nao encontrado");
			}
			AplicativoDTO dto = Conversor.converter(aplicativo, AplicativoDTO.class);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	public AplicativoDTO validaAplicativo(String login, String senha) throws InfraEstruturaException, NegocioException {

		AplicativoDTO dto = buscarPorLogin(login);

		if (!dto.getStatusAplicacao().equals(StatusAplicacaoDTO.ATIVO)) {

			throw new NegocioException("Login " + dto.getStatusAplicacao().name(), new RuntimeException());
		}

		if (dto.getSenha() != null) {
			if (dto.getSenha().equals(senha)) {
				System.out.println("senha:" + dto.getSenha());
				return dto;
			}
		}
		throw new NegocioException("Login ou senha invalidos do aplicativo", new RuntimeException());

	}

}

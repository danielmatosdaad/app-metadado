package br.app.servico.infra.fncmdo.service;

import java.util.List;
import java.util.Properties;

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
import br.app.servico.infra.fncmdo.dao.MetaDadoFacade;
import br.app.servico.infra.fncmdo.model.MetaDado;
import br.app.servico.infra.integracao.dto.IdentificadorDTO;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.integracao.dto.ObterMetaDadoDTO;
import br.app.servico.infra.integracao.interfaces.IMetaDadoUtilDAO;
import br.app.servico.infra.integracao.interfaces.IServicoMetaDadoLocal;
import br.app.servico.infra.integracao.interfaces.IServicoMetaDadoRemote;

@Stateless
@Remote(value = { IServicoMetaDadoRemote.class, IMetaDadoUtilDAO.class, IServicoRemoteDAO.class })
@Local(value = { IServicoMetaDadoLocal.class, IServicoLocalDAO.class })
public class MetaDadoServiceImp implements IServicoMetaDadoRemote, IServicoMetaDadoLocal, IMetaDadoUtilDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private MetaDadoFacade metaDadoFacade;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/IdentificadorServiceImp!br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO", beanName = "IdentificadorServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<IdentificadorDTO> identificadorService;

	@Override
	public MetaDadoDTO adiconar(MetaDadoDTO dto) throws InfraEstruturaException, NegocioException {

		try {

			return ServiceDAO.adiconar(this.metaDadoFacade, MetaDado.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<MetaDadoDTO> adiconar(List<MetaDadoDTO> listaDto) throws InfraEstruturaException, NegocioException {

		for (MetaDadoDTO MetaDadoDTO : listaDto) {
			adiconar(MetaDadoDTO);
		}
		return listaDto;
	}

	@Override
	public MetaDadoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.metaDadoFacade, MetaDadoDTO.class, id);

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

	public void remover(MetaDadoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.remover(metaDadoFacade, MetaDado.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public MetaDadoDTO alterar(MetaDadoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.alterar(metaDadoFacade, MetaDado.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<MetaDadoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.metaDadoFacade, MetaDadoDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<MetaDadoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.metaDadoFacade, MetaDadoDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public MetaDadoDTO buscarMetaDadoFuncionalidade(ObterMetaDadoDTO requisicao) throws InfraEstruturaException {

		if (requisicao == null) {
			throw new InfraEstruturaException("Requisicao invalidade", new RuntimeException());
		}
		try {

			MetaDado mdo = this.metaDadoFacade.buscarPorNumeroTelaFuncionalidade(requisicao.getNumeroFuncionalidade(),
					requisicao.getNumeroTela());

			if (mdo == null) {
				return null;
			}
			MetaDadoDTO metaDadoDTO = Conversor.converter(mdo, MetaDadoDTO.class);
			return metaDadoDTO;
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}


}

package br.app.servico.infra.fncmdo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.FuncionalidadeDTO;
import br.app.servico.infra.integracao.dto.GrupoFuncionalidadeDTO;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.integracao.dto.ProcessoConfiguracaoDTO;
import br.app.servico.infra.integracao.interfaces.IServicoProcessoConfiguracaoRemote;

@Stateless(mappedName = "ProcessoConfiguracaoImp")
@Remote(value = { IServicoProcessoConfiguracaoRemote.class })
public class ProcessoConfiguracaoImp implements IServicoProcessoConfiguracaoRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "GrupoFuncionalidadeServiceImp", beanInterface = IServicoLocalDAO.class)
	private IServicoLocalDAO<GrupoFuncionalidadeDTO> grupoFuncionalidadeService;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/MetaDadoServiceImp!br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO", beanName = "MetaDadoServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<MetaDadoDTO> metaDadoService;

	@EJB(beanName = "FuncionalidadeServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<FuncionalidadeDTO> funcionalidadeServiceImp;

	@Override
	public ProcessoConfiguracaoDTO configurarNevegacaoSistema(ProcessoConfiguracaoDTO dto)
			throws InfraEstruturaException, NegocioException {

		if (dto == null) {
			throw new NegocioException(-1, "dados vazios");
		}

		if (dto.getFuncionalidadeDTO() == null || dto.getGrupoFuncionalidadeDTO() == null
				|| dto.getIdentificadoresDTO() == null || dto.getMetadadoDTO() == null || dto.getPerfilDTO() == null) {
			throw new NegocioException(-1, "Dados Obrigatorios invalidos");
		}

		if (isExisteId(dto.getMetadadoDTO().getId()) == false) {

			if (dto.getMetadadoDTO().getIdentificadores() == null) {
				dto.getMetadadoDTO().setIdentificadores(dto.getIdentificadoresDTO());
			}

			dto.setMetadadoDTO(incluiMetadado(dto.getMetadadoDTO()));
			System.out.println("MetaDado incluido:" + dto.getMetadadoDTO().getId());
		}

		registrarFuncionalidadeMetaDado(dto);

		if (dto.getFuncionalidadeDTO() != null && dto.getFuncionalidadeDTO().getId() != null) {
			dto.getMetadadoDTO().setFuncionalidade(dto.getFuncionalidadeDTO());
			metaDadoService.alterar(dto.getMetadadoDTO());
		}

		return dto;
	}

	private void registrarFuncionalidadeMetaDado(ProcessoConfiguracaoDTO dto)
			throws InfraEstruturaException, NegocioException {

		if (isExisteId(dto.getFuncionalidadeDTO().getId()) && isExisteId(dto.getGrupoFuncionalidadeDTO().getId())
				&& isExisteId(dto.getPerfilDTO().getId())) {

			FuncionalidadeDTO funcionalidadeDTO = dto.getFuncionalidadeDTO();
			funcionalidadeDTO.setGrupoFuncionalidade(dto.getGrupoFuncionalidadeDTO());
			funcionalidadeDTO.setPerfil(dto.getPerfilDTO());
			dto.getMetadadoDTO().setFuncionalidade(funcionalidadeDTO);
			List<MetaDadoDTO> metadados = new ArrayList<MetaDadoDTO>();
			metadados.add(dto.getMetadadoDTO());
			funcionalidadeDTO.setMetadados(metadados);

			dto.setFuncionalidadeDTO(this.funcionalidadeServiceImp.alterar(funcionalidadeDTO));
		}

	}

	private MetaDadoDTO incluiMetadado(MetaDadoDTO metadadoDTO) throws InfraEstruturaException, NegocioException {
		return this.metaDadoService.adiconar(metadadoDTO);
	}

	private boolean isExisteId(Long id) {
		if (id == null || id.longValue() <= 0) {
			return false;
		}

		return true;
	}

}

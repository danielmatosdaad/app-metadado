package br.app.servico.infra.integracao.dto;

import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class ProcessoConfiguracaoDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FuncionalidadeDTO funcionalidadeDTO;
	private GrupoFuncionalidadeDTO grupoFuncionalidadeDTO;
	private PerfilDTO perfilDTO;
	private MetaDadoDTO metadadoDTO;
	private List<IdentificadorDTO> identificadoresDTO;
	
	public ProcessoConfiguracaoDTO() {
	}

	public FuncionalidadeDTO getFuncionalidadeDTO() {
		return funcionalidadeDTO;
	}

	public void setFuncionalidadeDTO(FuncionalidadeDTO funcionalidadeDTO) {
		this.funcionalidadeDTO = funcionalidadeDTO;
	}

	public GrupoFuncionalidadeDTO getGrupoFuncionalidadeDTO() {
		return grupoFuncionalidadeDTO;
	}

	public void setGrupoFuncionalidadeDTO(GrupoFuncionalidadeDTO grupoFuncionalidadeDTO) {
		this.grupoFuncionalidadeDTO = grupoFuncionalidadeDTO;
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	public MetaDadoDTO getMetadadoDTO() {
		return metadadoDTO;
	}

	public void setMetadadoDTO(MetaDadoDTO metadadoDTO) {
		this.metadadoDTO = metadadoDTO;
	}

	public List<IdentificadorDTO> getIdentificadoresDTO() {
		return identificadoresDTO;
	}

	public void setIdentificadoresDTO(List<IdentificadorDTO> identificadoresDTO) {
		this.identificadoresDTO = identificadoresDTO;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

}

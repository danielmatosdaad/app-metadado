package br.app.servico.infra.integracao.dto;

import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class ObterConversaoCompositeDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CompositeInterfaceDTO> composites;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public List<CompositeInterfaceDTO> getComposites() {
		return composites;
	}

	public void setComposites(List<CompositeInterfaceDTO> composites) {
		this.composites = composites;
	}

}

package br.app.servico.infra.integracao.dto;

import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class ObterConversaoComponenteUIDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ComponenteTelaDTO> componentes;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public List<ComponenteTelaDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteTelaDTO> componentes) {
		this.componentes = componentes;
	}

}

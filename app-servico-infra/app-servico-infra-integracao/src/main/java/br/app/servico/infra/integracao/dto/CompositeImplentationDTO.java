package br.app.servico.infra.integracao.dto;

import java.io.Serializable;

public class CompositeImplentationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponenteDTO componente;

	public ComponenteDTO getComponente() {
		return componente;
	}

	public void setComponente(ComponenteDTO componente) {
		this.componente = componente;
	}

}

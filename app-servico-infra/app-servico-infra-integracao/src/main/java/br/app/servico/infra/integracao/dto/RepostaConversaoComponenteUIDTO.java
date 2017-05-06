package br.app.servico.infra.integracao.dto;

import java.io.Serializable;

import br.app.barramento.integracao.dto.DTO;

public class RepostaConversaoComponenteUIDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultadoConvercaoComponenteUI resultado;

	public ResultadoConvercaoComponenteUI getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoConvercaoComponenteUI resultado) {
		this.resultado = resultado;
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

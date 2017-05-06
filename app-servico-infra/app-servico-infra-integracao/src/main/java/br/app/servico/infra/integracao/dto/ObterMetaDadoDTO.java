package br.app.servico.infra.integracao.dto;

import java.io.Serializable;

import br.app.barramento.integracao.dto.DTO;

public class ObterMetaDadoDTO implements DTO, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroFuncionalidade ;
	private int numeroTela;

	public int getNumeroFuncionalidade() {
		return numeroFuncionalidade;
	}

	public void setNumeroFuncionalidade(int numeroFuncionalidade) {
		this.numeroFuncionalidade = numeroFuncionalidade;
	}

	public int getNumeroTela() {
		return numeroTela;
	}

	public void setNumeroTela(int numeroTela) {
		this.numeroTela = numeroTela;
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

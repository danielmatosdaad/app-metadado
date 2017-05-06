package br.app.servico.infra.apl.model;

import java.io.Serializable;

public enum StatusAplicativo implements Serializable{

	ATIVO(1), DESABILITADO(2),EXCLUIDO(3);

	private Integer value;

	private StatusAplicativo(Integer valor) {

		this.value = valor;
	}

	public Integer getValue() {
		return value;
	}
}

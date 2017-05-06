package br.app.servico.infra.integracao.dto;

public enum StatusAplicacaoDTO {

	ATIVO(1), DESABILITADO(2), EXCLUIDO(3);

	private Integer value;

	private StatusAplicacaoDTO(Integer valor) {

		this.value = valor;
	}

	public Integer getValue() {
		return value;
	}
}

package br.app.servico.infra.integracao.dto;

import java.util.EnumSet;
import java.util.Set;

public enum TipoIdentificadorDTO {

	NEGOCIAL(1, "Negocial"), 
	BEAN(2, "Bean"), 
	COMPONENTE_TELA(3, "ComponenteTela"), 
	VARIAVEL_UI(4,"VarUI"),
	INDEFINIDO(-1,"Indefinido");

	private int value;
	private String texto;

	private TipoIdentificadorDTO(int valor, String texto) {

		this.value = valor;
		this.texto = texto;

	}

	public int getValue() {

		return value;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static TipoIdentificadorDTO get(int value) {

		Set<TipoIdentificadorDTO> tipos = EnumSet.allOf(TipoIdentificadorDTO.class);
		for (TipoIdentificadorDTO tipoParametroDTO : tipos) {
			if (tipoParametroDTO.value == value) {
				return tipoParametroDTO;
			}
		}
		return INDEFINIDO;
	}
	
	

}
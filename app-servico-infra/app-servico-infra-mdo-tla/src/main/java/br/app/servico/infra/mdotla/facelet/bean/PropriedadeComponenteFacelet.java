package br.app.servico.infra.mdotla.facelet.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PropriedadeComponenteFacelet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String valor;

	public PropriedadeComponenteFacelet() {
		// TODO Auto-generated constructor stub
	}

	public PropriedadeComponenteFacelet(String nome, String valor) {

		this.nome = nome;
		this.valor = valor;
	}

	@XmlAttribute(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement(name="valor")
	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}

}

package br.app.servico.infra.apl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.app.barramento.integracao.dao.interfaces.Entidade;

@Entity(name = "aplicativo")
@XmlRootElement
@Table(name = "aplicativo",uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class Aplicativo implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 25, message = "Tamanho maximo de caracteres sao 25")
	private String login;

	@NotNull
	@Size(min = 1, max = 16, message = "Tamanho maximo de caracteres sao 16")
	private String chave;

	@NotNull
	@Size(min = 1, max = 16, message = "Tamanho maximo de caracteres sao 16")
	private String initChave;

	private String senha;
	private String hash;
	
	@Enumerated(value = EnumType.STRING)
	private StatusAplicativo statusAplicacao;

	private RegistroAuditoria registroAuditoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getInitChave() {
		return initChave;
	}

	public void setInitChave(String initChave) {
		this.initChave = initChave;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public StatusAplicativo getStatusAplicacao() {
		return statusAplicacao;
	}

	public void setStatusAplicacao(StatusAplicativo statusAplicacao) {
		this.statusAplicacao = statusAplicacao;
	}

	public RegistroAuditoria getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}
	
	
}

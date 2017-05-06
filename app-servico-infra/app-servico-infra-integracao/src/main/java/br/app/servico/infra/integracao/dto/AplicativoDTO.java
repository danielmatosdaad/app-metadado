package br.app.servico.infra.integracao.dto;

import java.io.Serializable;

import br.app.barramento.integracao.dto.DTO;

public class AplicativoDTO implements DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String chave;
	private String initChave;
	private String senha;
	private String hash;
	private StatusAplicacaoDTO statusAplicacao;
	private RegistroAuditoriaDTO registroAuditoria;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistroAuditoriaDTO getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
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

	public StatusAplicacaoDTO getStatusAplicacao() {
		return statusAplicacao;
	}

	public void setStatusAplicacao(StatusAplicacaoDTO statusAplicacao) {
		this.statusAplicacao = statusAplicacao;
	}

}

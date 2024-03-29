package br.app.servico.infra.integracao.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class IdentificadorDTO implements DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String valor;
	private String descricao;
	private Date dataInclusao;
	private Date dataAlteracao;
	private TipoIdentificadorDTO tipoIdentificador;

	private List<MetaDadoDTO> metadados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public TipoIdentificadorDTO getTipoIdentificador() {
		return tipoIdentificador;
	}

	public void setTipoIdentificador(TipoIdentificadorDTO tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}

	public List<MetaDadoDTO> getMetadados() {
		return metadados;
	}

	public void setMetadados(List<MetaDadoDTO> metadados) {
		this.metadados = metadados;
	}

}

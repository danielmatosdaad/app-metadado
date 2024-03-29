package br.app.servico.infra.fncmdo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import br.app.barramento.integracao.dao.interfaces.Entidade;

@Entity(name = "metadado")
@Table(name = "metadado",uniqueConstraints = @UniqueConstraint(columnNames = {"numeroTela","nomeTela"}))
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = MetaDado.BUSCAR_POR_NUMEROTELA_FUNCIONALIDADE,
                query = "select m from metadado m WHERE m.numeroTela = :numTela and m.funcionalidade.id= :idFun")
})
public class MetaDado implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String BUSCAR_POR_NUMEROTELA_FUNCIONALIDADE = "buscarPorNumeroTelaFuncionalidade";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int numeroTela;

	@Column(nullable = false)
	private String nomeTela;

	@Column(nullable = false)
	private String tituloTela;

	@Column(nullable = false)
	private String descricaoTela;

	@Column(nullable = false)
	private String urlTela;

	private Long versao;

	@Column(length = 3000, nullable = false)
	private String xml;

	@Column(length = 3000)
	private String xhtml;

	private RegistroAuditoria registroAuditoria;

	@ManyToOne
	private Funcionalidade funcionalidade;

	@ManyToMany
	private List<Identificador> identificadores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getXhtml() {
		return xhtml;
	}

	public void setXhtml(String xhtml) {
		this.xhtml = xhtml;
	}

	public RegistroAuditoria getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

	public int getNumeroTela() {
		return numeroTela;
	}

	public void setNumeroTela(int numeroTela) {
		this.numeroTela = numeroTela;
	}

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public String getTituloTela() {
		return tituloTela;
	}

	public void setTituloTela(String tituloTela) {
		this.tituloTela = tituloTela;
	}

	public String getDescricaoTela() {
		return descricaoTela;
	}

	public void setDescricaoTela(String descricaoTela) {
		this.descricaoTela = descricaoTela;
	}

	public String getUrlTela() {
		return urlTela;
	}

	public void setUrlTela(String urlTela) {
		this.urlTela = urlTela;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public List<Identificador> getIdentificadores() {
		return identificadores;
	}

	public void setIdentificadores(List<Identificador> identificadores) {
		this.identificadores = identificadores;
	}

}

package br.app.servico.infra.telametadadoxml.api;

import br.app.barramento.integracao.dto.IService;
import br.app.servico.infra.integracao.interfaces.IServicoComponenteTela;
import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoComponenteTela extends AbstractLocalizadorServico<IService> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.componente.tela.metadado";
	private static final String REGISTRO_NOME_REMOTO = "remote.componente.tela.metadado";
	private static final String REGISTRO_LOCAL_DAO = "local.componente.tela.metadado.dao";
	private static final String REGISTRO_REMOTO_DAO = "remote.componente.tela.metadado.dao";

	public LocalizarServicoComponenteTela(String tipoLocalizacao, String registroNomeLocal, String registroNomeRemoto) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoComponenteTela(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoComponenteTela() {
		super(TipoLocalizador.LOCAL,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

}

package br.app.servico.infra.parametro.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoParametro<IService> extends AbstractLocalizadorServico<IService> {

	public static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	public static final String REGISTRO_NOME_LOCAL = "local.parametro";
	public static final String REGISTRO_NOME_REMOTO = "remoto.parametro";
	public static final String REGISTRO_LOCAL_DAO = "local.parametro.dao";
	public static final String REGISTRO_REMOTO_DAO = "remoto.parametro.dao";

	public LocalizarServicoParametro(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoParametro() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoParametro(String tipoLocalizacao, String registroNomeLocal, String registroNomeRemoto) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

}

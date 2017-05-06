package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoPerfil<IServicoPerfil> extends AbstractLocalizadorServico<IServicoPerfil> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.perfil";
	private static final String REGISTRO_NOME_REMOTO = "remote.perfil";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.perfil.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.perfil.dao";
	public LocalizarServicoPerfil(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoPerfil() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoPerfil(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}

}

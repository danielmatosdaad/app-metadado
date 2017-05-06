package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoMetaDado<IService> extends AbstractLocalizadorServico<IService> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.metadado";
	private static final String REGISTRO_NOME_REMOTO = "remote.metadado";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.metadado.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.metadado.dao";
	
	public LocalizarServicoMetaDado(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoMetaDado() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoMetaDado(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}

}

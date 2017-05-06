package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoFuncionalidade<IServicoFuncionalidade>
		extends AbstractLocalizadorServico<IServicoFuncionalidade> {

	public static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	public static final String REGISTRO_NOME_LOCAL = "local.funcionalidade";
	public static final String REGISTRO_NOME_REMOTO = "remote.funcionalidade";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.funcionalidade.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.funcionalidade.dao";
	
	public LocalizarServicoFuncionalidade(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoFuncionalidade() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoFuncionalidade(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}

}

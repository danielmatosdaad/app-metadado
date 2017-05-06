package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoGrupoFuncionalidade<IService> extends AbstractLocalizadorServico<IService> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.grupofuncionalidade";
	private static final String REGISTRO_NOME_REMOTO = "remote.grupofuncionalidade";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.grupofuncionalidade.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.grupofuncionalidade.dao";

	public LocalizarServicoGrupoFuncionalidade(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoGrupoFuncionalidade(String tipoLocalizacao, String registroNomeLocal,
			String registroNomeRemoto) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoGrupoFuncionalidade() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

}

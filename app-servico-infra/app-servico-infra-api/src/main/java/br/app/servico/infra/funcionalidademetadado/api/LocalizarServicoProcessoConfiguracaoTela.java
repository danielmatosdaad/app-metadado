package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoProcessoConfiguracaoTela<IServicoProcessoConfiguracao>
		extends AbstractLocalizadorServico<IServicoProcessoConfiguracao> {

	public static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	public static final String REGISTRO_NOME_LOCAL = "local.funcionalidade.processoconfiguracaotela";
	public static final String REGISTRO_NOME_REMOTO = "remote.funcionalidade.processoconfiguracaotela";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.funcionalidade.processoconfiguracaotela.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.funcionalidade.processoconfiguracaotela.dao";
	
	public LocalizarServicoProcessoConfiguracaoTela(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoProcessoConfiguracaoTela() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoProcessoConfiguracaoTela(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}

}

package br.app.servico.infra.funcionalidademetadado.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoIdentificador<IService> extends AbstractLocalizadorServico<IService> {

	public static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	public static final String REGISTRO_NOME_LOCAL = "local.identificador";
	public static final String REGISTRO_NOME_REMOTO = "remote.identificador";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.identificador.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.identificador.dao";
	
	public LocalizarServicoIdentificador(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoIdentificador() {
		super(TipoLocalizador.LOCAL,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoIdentificador(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}
	
	

}

package br.app.servico.infra.apl.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoAplicativo<IServicoUsuario> extends AbstractLocalizadorServico<IServicoUsuario> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "remoto.aplicativo";
	private static final String REGISTRO_NOME_REMOTO = "local.aplicativo";

	public LocalizarServicoAplicativo(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoAplicativo() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

}

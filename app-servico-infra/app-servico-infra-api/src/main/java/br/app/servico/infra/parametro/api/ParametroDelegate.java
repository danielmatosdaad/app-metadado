package br.app.servico.infra.parametro.api;

import java.util.List;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("rawtypes")
public class ParametroDelegate extends AbstractDelegate<IService> {

	public ParametroDelegate() {

	}

	private ParametroDelegate(LocalizadorServico<IService> localizaServico) {
		super(localizaServico);
	}

	@Override
	public LocalizadorServico<IService> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IService> localizaServico = new LocalizarServicoParametro<IService>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoParametro.REGISTRO_LOCAL_DAO,
					LocalizarServicoParametro.REGISTRO_REMOTO_DAO);
			return localizaServico;
		}

		LocalizadorServico<IService> localizaServico = new LocalizarServicoParametro<IService>(TipoLocalizador.REMOTO);
		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IService servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}

	public static ParametroDelegate getInstancia() {

		LocalizadorServico<IService> localizaServico = new LocalizarServicoParametro<IService>(TipoLocalizador.REMOTO);

		ParametroDelegate delegate = new ParametroDelegate(localizaServico);
		return delegate;
	}

}

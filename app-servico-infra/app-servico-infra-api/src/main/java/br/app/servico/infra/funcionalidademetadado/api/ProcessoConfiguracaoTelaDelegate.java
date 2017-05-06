package br.app.servico.infra.funcionalidademetadado.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.ProcessoConfiguracaoDTO;
import br.app.servico.infra.integracao.interfaces.IServicoProcessoConfiguracao;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ProcessoConfiguracaoTelaDelegate extends AbstractDelegate<IServicoProcessoConfiguracao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcessoConfiguracaoTelaDelegate(LocalizadorServico<IServicoProcessoConfiguracao> localizaServico) {
		super(localizaServico);
	}

	public ProcessoConfiguracaoTelaDelegate() {
	}

	public static ProcessoConfiguracaoTelaDelegate getInstancia() {

		LocalizadorServico<IServicoProcessoConfiguracao> localizaServico = new LocalizarServicoProcessoConfiguracaoTela<IServicoProcessoConfiguracao>(
				TipoLocalizador.LOCAL);

		ProcessoConfiguracaoTelaDelegate delegate = new ProcessoConfiguracaoTelaDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IServicoProcessoConfiguracao> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IServicoProcessoConfiguracao> localizaServico = new LocalizarServicoProcessoConfiguracaoTela<IServicoProcessoConfiguracao>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoProcessoConfiguracaoTela.REGISTRO_NOME_LOCAL_DAO,
					LocalizarServicoProcessoConfiguracaoTela.REGISTRO_NOME_REMOTO_DAO);
			return localizaServico;
		}

		LocalizadorServico<IServicoProcessoConfiguracao> localizaServico = new LocalizarServicoFuncionalidade<IServicoProcessoConfiguracao>(
				TipoLocalizador.REMOTO);
		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoProcessoConfiguracao servico)
			throws NegocioException, InfraEstruturaException {

		switch (acao) {
		case SALVAR_TELA_UI:
			ProcessoConfiguracaoDTO funcionalidadeDTO = servico
					.configurarNevegacaoSistema((ProcessoConfiguracaoDTO) envio.getRequisicao());
			resposta.setResultado(funcionalidadeDTO);
			Mensagem m = Mensagem.SUCESSO;
			m.setCodigo(1);
			resposta.setMensagem(m);
			return;

		default:
			break;
		}

		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}

}

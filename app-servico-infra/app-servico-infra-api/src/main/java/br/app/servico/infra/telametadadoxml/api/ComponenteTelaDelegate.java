package br.app.servico.infra.telametadadoxml.api;

import java.util.List;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.ObterConversaoComponenteTelaDTO;
import br.app.servico.infra.integracao.dto.ObterConversaoComponenteUIDTO;
import br.app.servico.infra.integracao.dto.ObterConversaoCompositeDTO;
import br.app.servico.infra.integracao.dto.RepostaConversaoComponenteUIDTO;
import br.app.servico.infra.integracao.dto.ResultadoConvercaoComponenteUI;
import br.app.servico.infra.integracao.interfaces.IServicoComponenteTela;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ComponenteTelaDelegate extends AbstractDelegate<IService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComponenteTelaDelegate(LocalizadorServico<IService> localizarServico) {
		super(localizarServico);
	}

	public ComponenteTelaDelegate() {
		LocalizarServicoComponenteTela localizaServico = new LocalizarServicoComponenteTela(TipoLocalizador.REMOTO);
		super.localizarServico = localizaServico;
	}

	public static ComponenteTelaDelegate getInstancia() {

		LocalizarServicoComponenteTela localizaServico = new LocalizarServicoComponenteTela(TipoLocalizador.REMOTO);

		ComponenteTelaDelegate delegate = new ComponenteTelaDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IService> getLocalizadorServico(TipoAcao acao) {

		LocalizarServicoComponenteTela localizaServico = new LocalizarServicoComponenteTela(TipoLocalizador.REMOTO);
		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IService servico)
			throws NegocioException, InfraEstruturaException {

		switch (acao) {
		case CONVERTER_ARQUIVO_COMPONENTE_TELA:

			if (envio.getRequisicao() instanceof ObterConversaoComponenteTelaDTO) {

				ObterConversaoComponenteTelaDTO requisicao = (ObterConversaoComponenteTelaDTO) envio.getRequisicao();
				List resultado = ((IServicoComponenteTela) servico).converterArquivo(requisicao.getFiles());
				resposta.setListaResultado(resultado);
				resposta.setMensagem(Mensagem.SUCESSO);
				return;
			}
			break;
		case CONVERTER_COMPOSITE_COMPONENTE_TELA:
			if (envio.getRequisicao() instanceof ObterConversaoCompositeDTO) {

				ObterConversaoCompositeDTO requisicao = (ObterConversaoCompositeDTO) envio.getRequisicao();
				List resultado = ((IServicoComponenteTela) servico)
						.converterCompositeInterfaces(requisicao.getComposites());
				resposta.setListaResultado(resultado);
				resposta.setMensagem(Mensagem.SUCESSO);
				return;
			}
			break;
		case CONVERTER_COMPONENTE_TELA_UI:
			if (envio.getRequisicao() instanceof ObterConversaoComponenteUIDTO) {

				ObterConversaoComponenteUIDTO requisicao = (ObterConversaoComponenteUIDTO) envio.getRequisicao();
				ResultadoConvercaoComponenteUI resultado = ((IServicoComponenteTela) servico)
						.converterComponenteUI(requisicao.getComponentes());
				RepostaConversaoComponenteUIDTO resultadoDTO = new RepostaConversaoComponenteUIDTO();
				resultadoDTO.setResultado(resultado);
				resposta.setResultado(resultadoDTO);
				resposta.setMensagem(Mensagem.SUCESSO);
				return;
			}
			break;
		}

		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Acao nao identificada");

	}

}

package br.app.servico.infra.apl.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.AplicativoDTO;
import br.app.servico.infra.integracao.interfaces.IServicoAplicativo;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class AplicativoDelegate extends AbstractDelegate<IServicoAplicativo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AplicativoDelegate(LocalizadorServico<IServicoAplicativo> localizaServico) {
		super(localizaServico);
	}

	@SuppressWarnings("unchecked")
	public IServicoAplicativo<AplicativoDTO> getServico() {
		return this.getLocalizadorServico().getServico();
	}

	public static AplicativoDelegate getInstancia() {

		LocalizadorServico<IServicoAplicativo> localizaServico = new LocalizarServicoAplicativo<IServicoAplicativo>(
				TipoLocalizador.REMOTO);

		AplicativoDelegate delegate = new AplicativoDelegate(localizaServico);

		return delegate;
	}


	public AplicativoDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException {
		return getServico().buscarPorLogin(login);
	}

	public AplicativoDTO validaAplicativo(String login, String senha) throws InfraEstruturaException, NegocioException {
		return getServico().validaAplicativo(login, senha);
	}

	@Override
	public LocalizadorServico<IServicoAplicativo> getLocalizadorServico(TipoAcao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, IServicoAplicativo servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}

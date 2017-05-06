package br.app.servico.infra.funcionalidademetadado.api;



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

public class IdentificadorDelegate extends AbstractDelegate<IService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentificadorDelegate(LocalizadorServico<IService> localizaServico) {
		super(localizaServico);
	}
	
	public IdentificadorDelegate() {
	}


	public static IdentificadorDelegate getInstancia() {

		LocalizadorServico<IService> localizaServico = new LocalizarServicoIdentificador<IService>(
				TipoLocalizador.LOCAL);

		IdentificadorDelegate delegate = new IdentificadorDelegate(localizaServico);

		return delegate;
	}


	@Override
	public LocalizadorServico<IService> getLocalizadorServico(TipoAcao acao) {
		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IService> localizaServico = new LocalizarServicoIdentificador<IService>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoIdentificador.REGISTRO_NOME_LOCAL_DAO,
					LocalizarServicoIdentificador.REGISTRO_NOME_REMOTO_DAO);

			return localizaServico;
		}

		LocalizadorServico<IService> localizaServico = new LocalizarServicoIdentificador<IService>(TipoLocalizador.REMOTO);
		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IService servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}

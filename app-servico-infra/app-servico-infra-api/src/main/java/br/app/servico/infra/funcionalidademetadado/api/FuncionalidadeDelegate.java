package br.app.servico.infra.funcionalidademetadado.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.FuncionalidadeDTO;
import br.app.servico.infra.integracao.interfaces.IServicoFuncionalidadeRemote;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class FuncionalidadeDelegate extends AbstractDelegate<IService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionalidadeDelegate(LocalizadorServico<IService> localizaServico) {
		super(localizaServico);
	}

	public FuncionalidadeDelegate() {
	}

	public static FuncionalidadeDelegate getInstancia() {

		LocalizadorServico<IService> localizaServico = new LocalizarServicoFuncionalidade<IService>(
				TipoLocalizador.LOCAL);

		FuncionalidadeDelegate delegate = new FuncionalidadeDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IService> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IService> localizaServico = new LocalizarServicoFuncionalidade<IService>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoFuncionalidade.REGISTRO_NOME_LOCAL_DAO,
					LocalizarServicoFuncionalidade.REGISTRO_NOME_REMOTO_DAO);
			return localizaServico;
		}

		LocalizadorServico<IService> localizaServico = new LocalizarServicoFuncionalidade<IService>(TipoLocalizador.REMOTO);
		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IService servico)
			throws NegocioException, InfraEstruturaException {

		switch (acao) {
		case SALVAR_SEM_RELACIONAMENTO:
			IServicoFuncionalidadeRemote servicoFuncionalidade = (IServicoFuncionalidadeRemote) servico;
			FuncionalidadeDTO funcionalidadeDTO = servicoFuncionalidade
					.adicionarFuncionalidadeSemRelacionamento((FuncionalidadeDTO) envio.getRequisicao());
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

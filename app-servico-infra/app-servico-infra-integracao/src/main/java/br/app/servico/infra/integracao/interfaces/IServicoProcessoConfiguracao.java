package br.app.servico.infra.integracao.interfaces;

import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.ProcessoConfiguracaoDTO;

public interface IServicoProcessoConfiguracao extends IService{

	public ProcessoConfiguracaoDTO configurarNevegacaoSistema(ProcessoConfiguracaoDTO dto) throws InfraEstruturaException, NegocioException;
}

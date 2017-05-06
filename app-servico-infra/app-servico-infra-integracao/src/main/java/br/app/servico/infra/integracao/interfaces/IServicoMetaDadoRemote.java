package br.app.servico.infra.integracao.interfaces;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.integracao.dto.ObterMetaDadoDTO;

public interface IServicoMetaDadoRemote extends IServicoMetaDado<MetaDadoDTO> {

	MetaDadoDTO buscarMetaDadoFuncionalidade(ObterMetaDadoDTO requisicao)
			throws InfraEstruturaException, NegocioException;
	
}

package br.app.servico.infra.mdotla.infra.interfaces;

import java.io.Serializable;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.mdotla.infra.comum.dto.ObterMetaDadoDTO;

public interface IComponenteMetadado extends Serializable {

	public MetaDadoDTO gerar(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException;
	
}

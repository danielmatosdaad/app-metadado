package br.app.servico.infra.mdotla.componente;

import javax.inject.Inject;
import javax.inject.Named;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.mdotla.infra.comum.dto.ObterMetaDadoDTO;
import br.app.servico.infra.mdotla.infra.interfaces.IComponenteMetadado;
import br.app.servico.infra.mdotla.infra.interfaces.IRegrasNavegacao;

@Named
public class ComponenteMetadado implements IComponenteMetadado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IRegrasNavegacao regrasNavegacao;

	@Override
	public MetaDadoDTO gerar(ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {
		MetaDadoDTO metadoUI = this.regrasNavegacao.funcionalidadeMetadado(obterMetaDadoDTO);

		return metadoUI;
	}


}

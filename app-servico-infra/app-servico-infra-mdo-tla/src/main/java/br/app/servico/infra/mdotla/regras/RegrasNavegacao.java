package br.app.servico.infra.mdotla.regras;

import javax.inject.Inject;
import javax.inject.Named;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.mdotla.bean.MetaDado;
import br.app.servico.infra.mdotla.infra.comum.dto.ObterMetaDadoDTO;
import br.app.servico.infra.mdotla.infra.interfaces.IRegrasNavegacao;
import br.app.servico.infra.mdotla.regras.IRegrasMetaDado;

@Named
public class RegrasNavegacao implements IRegrasNavegacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRegrasMetaDado regrasMetadados;

	public MetaDadoDTO funcionalidadeMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {
		MetaDadoDTO metaDadoDTO = this.regrasMetadados.buscarMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade());
		return metaDadoDTO;
	}

	private MetaDado buscarMetadado(
			ObterMetaDadoDTO obterMetaDadoDTO) throws InfraEstruturaException, NegocioException {

		MetaDadoDTO metaDadoDTO = this.regrasMetadados.buscarMetadado(
				obterMetaDadoDTO.getNumeroTela(),
				obterMetaDadoDTO.getNumeroFuncionalidade());
		
		return this.regrasMetadados.converterMetaDado(metaDadoDTO);
	}


}

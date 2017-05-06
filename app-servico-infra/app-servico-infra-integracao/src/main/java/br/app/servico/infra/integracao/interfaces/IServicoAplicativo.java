package br.app.servico.infra.integracao.interfaces;

import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.AplicativoDTO;

public interface IServicoAplicativo<T extends AplicativoDTO> extends IService {

	public AplicativoDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException;

	public AplicativoDTO validaAplicativo(String login, String senha) throws InfraEstruturaException, NegocioException;
}

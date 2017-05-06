package br.app.servico.infra.integracao.interfaces;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.FuncionalidadeDTO;

public interface IServicoFuncionalidadeLocal extends IServicoFuncionalidade<FuncionalidadeDTO>{

	public FuncionalidadeDTO adicionarFuncionalidadeSemRelacionamento(FuncionalidadeDTO funcionalidadeDTO) throws InfraEstruturaException,NegocioException;
}

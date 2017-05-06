package br.app.servico.infra.integracao.interfaces;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.servico.infra.integracao.dto.GrupoFuncionalidadeDTO;

public interface IServicoGrupoFuncionalidade<T extends GrupoFuncionalidadeDTO> extends IServicoDAO<T>{

}

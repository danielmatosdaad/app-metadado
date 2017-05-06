package br.app.servico.infra.integracao.interfaces;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.servico.infra.integracao.dto.IdentificadorDTO;

public interface IServicoIdentificador<T extends IdentificadorDTO> extends IServicoDAO<T>{

}

package br.app.servico.infra.integracao.interfaces;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.servico.infra.integracao.dto.ParametroDTO;

public interface IServicoParametro<T extends ParametroDTO> extends IServicoDAO<T> {

}

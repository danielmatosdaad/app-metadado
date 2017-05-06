package br.app.servico.infra.integracao.interfaces;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;

public interface IServicoMetaDado<T extends MetaDadoDTO> extends IServicoDAO<T> {

}

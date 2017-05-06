package br.app.servico.infra.integracao.interfaces;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.servico.infra.integracao.dto.PerfilDTO;

public interface IServicoPerfil<T extends PerfilDTO> extends IServicoDAO<T>{

}

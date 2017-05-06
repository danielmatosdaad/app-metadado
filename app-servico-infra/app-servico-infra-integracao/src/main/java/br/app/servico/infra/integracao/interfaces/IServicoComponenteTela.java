package br.app.servico.infra.integracao.interfaces;

import java.io.File;
import java.util.List;

import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.servico.infra.integracao.dto.ComponenteTelaDTO;
import br.app.servico.infra.integracao.dto.CompositeDTO;
import br.app.servico.infra.integracao.dto.CompositeInterfaceDTO;
import br.app.servico.infra.integracao.dto.ResultadoConvercaoComponenteUI;

public interface IServicoComponenteTela extends IService{

	public List<CompositeDTO> converterArquivo(List<File> files);

	public List<ComponenteTelaDTO> converterComposite(List<CompositeDTO> composites);

	public ResultadoConvercaoComponenteUI converterComponenteUI(List<ComponenteTelaDTO> metadados);

	public List<ComponenteTelaDTO> converterCompositeInterfaces(List<CompositeInterfaceDTO> compositeInterfaceDTOs)
			throws InfraEstruturaException;
}

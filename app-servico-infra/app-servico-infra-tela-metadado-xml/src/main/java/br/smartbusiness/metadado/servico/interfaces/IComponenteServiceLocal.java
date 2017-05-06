package br.smartbusiness.metadado.servico.interfaces;

import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;

import java.io.File;
import java.util.List;

public interface IComponenteServiceLocal {

	/**
	 * @param files
	 *            Recebe uma lista de arquivos de componentes xhtml no formato
	 *            composite
	 * @return List<IComposite>
	 */
	public List<IComposite> converterArquivo(List<File> files);

	public List<MetaDado> converterComposite(List<IComposite> composites);

	public List<StringBuffer> converterComponenteUI(List<MetaDado> metadados);

	public List<MetaDado> converterCompositeInterfaces(List<ICompositeInterfaces> compositesInterfaces);

	public List<StringBuffer> converterEmXml(List<MetaDado> metadados);
}

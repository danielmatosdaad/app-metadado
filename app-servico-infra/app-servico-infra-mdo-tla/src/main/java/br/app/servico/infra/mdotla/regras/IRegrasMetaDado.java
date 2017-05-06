package br.app.servico.infra.mdotla.regras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.servico.infra.integracao.dto.MetaDadoDTO;
import br.app.servico.infra.mdotla.bean.MetaDado;
import br.app.servico.infra.mdotla.facelet.bean.Facelet;
import br.app.servico.infra.mdotla.infra.comum.StringBufferOutputStream;

public interface IRegrasMetaDado extends Serializable {

	public String converterMetadado(MetaDado metadado);

	public MetaDadoDTO buscarMetadado(int numeroTela, int funcionalidade)
			throws InfraEstruturaException, NegocioException;

	public MetaDadoDTO atualizarTela(long idMetaDado) throws InfraEstruturaException, NegocioException;

	public StringBuffer transformaParaXml(MetaDado metaDado);

	public StringBuffer transformaMetaDadoParaFacelet(MetaDado metaDado);

	public List<String> converterFaceletMetadadoUI(List<Facelet> lista)
			throws TransformerConfigurationException, TransformerException;

	public List<Facelet> transformarEmFacelets(List<File> lista);

	public StringBufferOutputStream transformarMetadado(MetaDado metadado)
			throws TransformerException, JAXBException, FileNotFoundException;

	public MetaDado converterFaceletMetaDado(List<Facelet> faceletes);

	public MetaDado converterMetaDado(MetaDadoDTO metaDadoDTO);
}

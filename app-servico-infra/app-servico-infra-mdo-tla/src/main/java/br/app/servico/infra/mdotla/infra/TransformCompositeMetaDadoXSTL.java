package br.app.servico.infra.mdotla.infra;

import java.io.File;
import java.net.URL;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.app.servico.infra.mdotla.infra.comum.StringBufferOutputStream;

public class TransformCompositeMetaDadoXSTL {

	private static final String TEMPLATE_XSL = "uicomposite_componente.xslt";

	public static StringBuffer transform(File inXML) throws TransformerConfigurationException, TransformerException {
		StringBuffer sb = new StringBuffer();
		try {

			URL urlXsl = TransformCompositeMetaDadoXSTL.class.getResource(TEMPLATE_XSL);
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(urlXsl.getPath());
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new MyErrorListener());
			StreamSource in = new StreamSource(inXML);

			StringBufferOutputStream streamBuffer = new StringBufferOutputStream(sb);

			StreamResult out = new StreamResult(streamBuffer);
			transformer.transform(in, out);
			return streamBuffer.getBuffer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return sb;
	}

}

package br.app.servico.infra.mdotla.conversor;

import java.util.ArrayList;
import java.util.List;

import br.app.servico.infra.mdotla.bean.Componente;
import br.app.servico.infra.mdotla.bean.Conteudo;
import br.app.servico.infra.mdotla.bean.MetaDado;
import br.app.servico.infra.mdotla.bean.Propriedade;
import br.app.servico.infra.mdotla.facelet.bean.ComponenteFacelet;
import br.app.servico.infra.mdotla.facelet.bean.Facelet;
import br.app.servico.infra.mdotla.facelet.bean.PropriedadeComponenteFacelet;

public class ConversorMetadadoFacelet {

	private static final String NS_PROJETO_COMPONENTES = "http://url.projeto/componentes";

	public static MetaDado converter(Facelet facelet) {

		String nomeMetadado = facelet.getNomeMetadado().replace(".xhtml", "");

		List<Propriedade> propriedades = new ArrayList<Propriedade>();
		for (ComponenteFacelet componenteFacelet : facelet.getConteudo().getComponentes()) {
			for (PropriedadeComponenteFacelet propriedadeComponenteFacelet : componenteFacelet.getPropriedades()) {
				Propriedade prop = new Propriedade();

				if (UiComponentUtil.isVariavelUiComponent(propriedadeComponenteFacelet.getValor())) {

					String id = UiComponentUtil.retirarExpressaoEL(propriedadeComponenteFacelet.getValor());
					prop.setNome(id);
					prop.setValor(id);
					propriedades.add(prop);
				} else {
					prop.setNome(propriedadeComponenteFacelet.getNome());
					prop.setValor(propriedadeComponenteFacelet.getValor());
					propriedades.add(prop);
				}

			}
		}
		Componente componente = new Componente(nomeMetadado, NS_PROJETO_COMPONENTES, propriedades);
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes.add(componente);
		Conteudo conteudo = new Conteudo(componentes);
		conteudo.setNomeConteudo("html");
		MetaDado metadado = new MetaDado(conteudo);
		return metadado;

	}


	public static Facelet converter(MetaDado metadado) {

		return null;
	}
}

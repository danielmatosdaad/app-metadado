package br.com.app.smart.business.databuilder;

import java.util.Date;

import br.app.servico.infra.integracao.dto.RegistroAuditoriaDTO;

public class RegistroAuditoriaBuilder {

	public static RegistroAuditoriaDTO getInstanceDTO(TipoRegistroAuditoriaBuilder tipoRegistroAuditoria) {

		switch (tipoRegistroAuditoria) {

		case DEFAULT:
			return criarRegistroAuditoriaDefault();

		default:
			break;
		}
		return new RegistroAuditoriaDTO();
	}

	private static RegistroAuditoriaDTO criarRegistroAuditoriaDefault() {
		RegistroAuditoriaDTO r = new RegistroAuditoriaDTO();
		r.setDataCadastro(new Date());

		return r;

	}

	public static enum TipoRegistroAuditoriaBuilder {

		DEFAULT;
	}
}

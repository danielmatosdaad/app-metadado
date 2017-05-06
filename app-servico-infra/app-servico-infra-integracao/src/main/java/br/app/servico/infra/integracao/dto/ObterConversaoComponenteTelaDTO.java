package br.app.servico.infra.integracao.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class ObterConversaoComponenteTelaDTO implements Serializable, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<File> files;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}

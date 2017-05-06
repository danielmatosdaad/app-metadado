package br.app.servico.infra.fncmdo.model;

public abstract class EntidadeUtil {

	public static String getNomeSequence(final Class clazz){
		
		return "SEQ_"+clazz.getSimpleName().toUpperCase();
	}
}

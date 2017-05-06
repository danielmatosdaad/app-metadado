package br.com.app.smart.business.util;

import br.app.barramento.infra.persistencia.conversores.Conversor;
import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.barramento.infra.persistencia.dao.IFacedeDAO;
import br.app.barramento.infra.persistencia.service.ServiceDAO;

public class ClassUtil {

	public static Class[] getClassInfraDAO() {

		Class[] classeInfraDAO = { AbstractFacade.class, IFacedeDAO.class, Conversor.class, ServiceDAO.class };
		return classeInfraDAO;
	}
}

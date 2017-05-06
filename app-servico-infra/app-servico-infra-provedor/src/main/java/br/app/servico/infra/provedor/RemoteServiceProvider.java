package br.app.servico.infra.provedor;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.app.servico.infra.integracao.interfaces.IFuncionalidadeDAO;
import br.app.servico.infra.integracao.interfaces.IMetaDadoUtilDAO;
import br.app.servico.infra.integracao.interfaces.IServicoComponenteTelaRemote;
import br.app.servico.infra.integracao.interfaces.IServicoFuncionalidadeRemote;
import br.app.servico.infra.integracao.interfaces.IServicoGrupoFuncionalidadeRemote;
import br.app.servico.infra.integracao.interfaces.IServicoIdentificadorRemote;
import br.app.servico.infra.integracao.interfaces.IServicoMetaDadoRemote;
import br.app.servico.infra.integracao.interfaces.IServicoParametroRemote;
import br.app.servico.infra.integracao.interfaces.IServicoPerfilRemote;
import br.app.servico.infra.integracao.interfaces.IServicoProcessoConfiguracaoRemote;

@ApplicationScoped
@Named
public class RemoteServiceProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-pmt/ParametroServiceImp!br.app.servico.infra.integracao.interfaces.IServicoParametroRemote", beanName = "ParametroServiceImp", beanInterface = IServicoParametroRemote.class)
	private IServicoParametroRemote parametroService;


	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/FuncionalidadeServiceImp!br.app.servico.infra.integracao.interfaces.IServicoFuncionalidadeRemote", beanName = "FuncionalidadeServiceImp", beanInterface = IServicoFuncionalidadeRemote.class)
	private IServicoFuncionalidadeRemote funcionalidadeService;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/MetaDadoServiceImp!br.app.servico.infra.integracao.interfaces.IServicoMetaDadoRemote", beanName = "MetaDadoServiceImp", beanInterface = IServicoMetaDadoRemote.class)
	private IServicoMetaDadoRemote metaDadoService;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/GrupoFuncionalidadeServiceImp!br.app.servico.infra.integracao.interfaces.IServicoGrupoFuncionalidadeRemote", beanName = "GrupoFuncionalidadeServiceImp", beanInterface = IServicoGrupoFuncionalidadeRemote.class)
	private IServicoGrupoFuncionalidadeRemote grupoFuncionalidadeService;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/PerfilServiceImp!br.app.servico.infra.integracao.interfaces.IServicoPerfilRemote", beanName = "PerfilServiceImp", beanInterface = IServicoPerfilRemote.class)
	private IServicoPerfilRemote perfilService;

	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/IdentificadorServiceImp!br.app.servico.infra.integracao.interfaces.IServicoIdentificadorRemote", beanName = "IdentificadorServiceImp", beanInterface = IServicoIdentificadorRemote.class)
	private IServicoIdentificadorRemote identificadorService;
	
	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-tela-metadado-xml/ComponenteTelaServiceImp!br.app.servico.infra.integracao.interfaces.IServicoComponenteTelaRemote", beanName = "ComponenteTelaServiceImp", beanInterface = IServicoComponenteTelaRemote.class)
	private IServicoComponenteTelaRemote componenteTelaService;
	
	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/MetaDadoServiceImp!br.app.servico.infra.integracao.interfaces.IMetaDadoUtilDAO", beanName = "MetaDadoServiceImp", beanInterface = IMetaDadoUtilDAO.class)
	private IMetaDadoUtilDAO metaDadoUtilDAO;
	
	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/ProcessoConfiguracaoImp!br.app.servico.infra.integracao.interfaces.IProcessoConfiguracaoRemote", beanName = "ProcessoConfiguracaoImp", beanInterface = IServicoProcessoConfiguracaoRemote.class)
	private IServicoProcessoConfiguracaoRemote processoConfiguracaoRemote;
	
	@EJB(lookup = "java:global/app-servico-infra/app-servico-infra-fnc-mdo/FuncionalidadeServiceImp!br.app.servico.infra.integracao.interfaces.IFuncionalidadeDAO", beanName = "FuncionalidadeServiceImp", beanInterface = IFuncionalidadeDAO.class)
	private IFuncionalidadeDAO funcionalidadeDAO;
	
	
	@Default
	@Produces
	public 	IMetaDadoUtilDAO getMetaDadoUtilDAO() {
		System.out.println("Injetando Servico metaDadoUtilDAO");
		return metaDadoUtilDAO;
	}
	
	@Default
	@Produces
	public IServicoParametroRemote getParametroService() {
		System.out.println("Injetando Servico parametroService");
		return parametroService;
	}


	@Default
	@Produces
	public IServicoFuncionalidadeRemote getFuncionalidadeService() {
		return funcionalidadeService;
	}

	@Default
	@Produces
	public IServicoMetaDadoRemote getMetaDadoService() {
		return metaDadoService;
	}

	@Default
	@Produces
	public IServicoGrupoFuncionalidadeRemote getGrupoFuncionalidadeService() {
		return grupoFuncionalidadeService;
	}

	@Default
	@Produces
	public IServicoPerfilRemote getPerfilService() {
		return perfilService;
	}


	@Default
	@Produces
	public IServicoIdentificadorRemote getIdentificadorService() {
		return identificadorService;
	}
	
	
	@Default
	@Produces
	public IServicoComponenteTelaRemote getComponenteTelaService() {
		System.out.println("Injetando Servico componenteTelaService" + componenteTelaService );
		return componenteTelaService;
	}
	
	
	@Default
	@Produces
	public IServicoProcessoConfiguracaoRemote getProcessoConfiguracaoRemote() {
		return processoConfiguracaoRemote;
	}
	
	@Default
	@Produces
	public IFuncionalidadeDAO getFuncionalidadeDAO() {
		return funcionalidadeDAO;
	}

	/**
	 * Carrega instância da service passada como parâmetro do contexto
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Object carregaService(Class<?> clazz) {
		Object service = null;
		BeanManager beanManager = getBeanManager();
		try {
			for (Bean<?> bean : beanManager.getBeans(clazz)) {
				try {
					CreationalContext contexto = beanManager.createCreationalContext(bean);
					service = bean.create(contexto);
					break;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
		}

		return service;
	}

	/**
	 * @return
	 */
	public static final BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			return null;
		}
	}
}

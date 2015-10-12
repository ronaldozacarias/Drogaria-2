package br.com.drogaria.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	
	//Quando Finaliza o TomCat
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().close();
	}
	
	//Quando Inicia o TomCat
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Vai Perceber que o Hibernate n�o Foi inicializado e criar� uma Sess�o.
		HibernateUtil.getSessionFactory().openSession();
	}
	
}

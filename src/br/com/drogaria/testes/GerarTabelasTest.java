package br.com.drogaria.testes;

import org.junit.Test;

import br.com.drogaria.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}

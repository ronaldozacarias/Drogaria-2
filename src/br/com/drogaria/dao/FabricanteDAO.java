package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {
	
	public void salvar(Fabricante fabricante) {
		//Aqui estou abrindo a sess�o
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) transacao.rollback();
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		
		return fabricantes;
	}
	
	public Fabricante buscar(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorID");
			consulta.setLong("id", id);
			
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		
		return fabricante;
	}
	
	public void excluir(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(buscar(id));
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) transacao.rollback();
			throw ex;
		} finally {
			sessao.close();
		}
	}
}

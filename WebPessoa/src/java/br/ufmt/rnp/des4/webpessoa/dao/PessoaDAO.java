/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.webpessoa.dao;

import br.ufmt.rnp.des4.webpessoa.entidades.Pessoa;
import br.ufmt.rnp.des4.webpessoa.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author aluno
 */
public class PessoaDAO {
    
    public void inserir(Pessoa pessoa){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pessoa);
        session.getTransaction().commit();
        session.close();
    }
    
    public void editar(Pessoa pessoa){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(pessoa);
        session.getTransaction().commit();
        session.close();
    }
    
    public void excluir(Pessoa pessoa){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(pessoa);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Pessoa> consultar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Pessoa");
        return query.list();
    }
}

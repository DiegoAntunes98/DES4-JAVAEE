
package mb;

import beans.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.Util;

@Named
@RequestScoped
public class ExemploMB {
    
    private Aluno aluno = new Aluno();
    private String texto = "";
    private List<Aluno> lista = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("select a from Aluno a");
        lista = q.list();
    }
    
    public void salvarAluno(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(aluno);
        session.getTransaction().commit();
        session.close();
        Util.addMessagem("Aluno salvo com Sucesso!");
        
    }
    
    public String pesquisarAluno(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("select a from Aluno a where a.nome like :criterio");
        q.setParameter("criterio", "%"+texto+"%");
        lista = q.list();
        return "list";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Aluno> getLista() {
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
    
}

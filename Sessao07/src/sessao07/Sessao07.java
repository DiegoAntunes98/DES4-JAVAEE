
package sessao07;


import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Sessao07 {

    
    public static void main(String[] args) {
        
        Endereco endereco = new Endereco();
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        int insert = 10000;
        long start = new Date().getTime();
        s.beginTransaction();

        for(int i=0;i <insert; i++){
            Pessoa p = new Pessoa();
            p.setNome("dsadsad");
            s.save(p);
        }
        
        s.getTransaction().commit();
        System.out.println((new Date().getTime() - start));
        
        start = new Date().getTime();
        
        Query consulta = s.createQuery("select e from Endereco e");
        List<Endereco> enderecos = consulta.list();
        
        for (Endereco end : enderecos) {
            System.out.println(end.getId() + " " + end.getRua() + "" +end.getPessoa().getNome());
        }
       
        s.close();
        
        System.exit(0);
    }
    
}

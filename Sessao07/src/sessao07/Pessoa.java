
package sessao07;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
@SequenceGenerator(name = "seq",allocationSize = 1,sequenceName = "tb_pessoa_id_seq")
public class Pessoa {
    @Id
    @GeneratedValue(generator="seq",strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    
}

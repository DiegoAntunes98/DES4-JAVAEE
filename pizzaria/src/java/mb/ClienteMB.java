/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value ="clienteMB")
@RequestScoped
public class ClienteMB {
    
    private String nome;
    private String endereco;
    private String telefone;
    
    public void salvar(){
        System.out.println(nome);
        System.out.println(endereco);
        System.out.println(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
    
    
}

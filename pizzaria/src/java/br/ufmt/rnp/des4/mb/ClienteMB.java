/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.mb;

import br.ufmt.rnp.des4.entidades.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value="clienteMB")
@SessionScoped

public class ClienteMB implements Serializable {
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    public String salvar(){
        System.out.println("salvar");
        //Inserção no Banco
        System.out.println(cliente.getNome());
        System.out.println(cliente.getEndereco());
        System.out.println(cliente.getTelefone());
        System.out.println(cliente.getUf().getSigla());
        clientes.add(cliente);
        cliente = new Cliente();
        FacesMessage msg = new FacesMessage("Salvo","Cliente salvo com sucesso!");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "index";
    }
    
    public void excluir(int id){
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if(c.getId() == id){
                clientes.remove(i);
                FacesMessage msg = new FacesMessage("Removido","Cliente removido com sucesso!");
                msg.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                break;
            }
        }
        
    }
    
    public String editar(int id){
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if(c.getId() == id){
                cliente = c;
                break;
            }
        }
        return "cliente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.mb;

import br.ufmt.rnp.des4.entidades.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named(value="produtoMB")
@ApplicationScoped
public class ProdutoMB implements Serializable {
    
    private Produto produto = new Produto();
    private List<Produto> produtos ;
    
    public ProdutoMB(){
        produtos = new ArrayList<Produto>();
    }
    
    public void salvar(){
        produtos.add(produto);
        
        produto = new Produto();
        FacesMessage msg = new FacesMessage("Produto salvo com sucesso!");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
       
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}

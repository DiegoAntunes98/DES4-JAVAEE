/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.webpessoa.mb;

import br.ufmt.rnp.des4.webpessoa.entidades.Pessoa;
import br.ufmt.rnp.des4.webpessoa.dao.PessoaDAO;
import br.ufmt.rnp.des4.webpessoa.entidades.Endereco;
import br.ufmt.rnp.des4.webpessoa.utils.Util;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

/**
 *
 * @author aluno
 */



@Named
@RequestScoped
public class PessoaMB {
    
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private PessoaDAO dao;
    private Endereco novoendereco;
    
    @PostConstruct
    public void init(){
        pessoa = new Pessoa();
        dao = new PessoaDAO();
        pessoas = dao.consultar();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
   
    
    
    public void salvar(){
        
        if(pessoa.getId()==0){
            dao.inserir(pessoa);
        } else{
            dao.editar(pessoa);
        }
        
        pessoa = new Pessoa();
        pessoas = dao.consultar();
        Util.addMessagem("registro salvo com sucesso!");
    }
    
    public void excluir(Pessoa pessoa){
        try{
            dao.excluir(pessoa);
            pessoas = dao.consultar();
        
            Util.addMessagem("Registro removido com Sucesso!");
        }catch(Exception erro){
            erro.printStackTrace();
            Util.addMessagem(erro.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        
    }
    
    public void editar(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getNovoendereco() {
        return novoendereco;
    }

    public void setNovoendereco(Endereco novoendereco) {
        this.novoendereco = novoendereco;
    }
    
    
    
}

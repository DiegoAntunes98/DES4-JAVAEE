/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class ExemploBean {
    private String texto;
    
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto= texto;
    }
    
    public void caixaAlta(){
        texto = texto.toUpperCase();
    }
    
    
    
}

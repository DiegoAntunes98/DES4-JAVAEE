/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.webpessoa.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author aluno
 */
public class Util {
    
    public static void addMessagem(String mensagem){
        addMessagem(mensagem,FacesMessage.SEVERITY_INFO);
    }
    
    public static void addMessagem(String mensagem,Severity severity){
        FacesMessage msg = new FacesMessage(mensagem);
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
}

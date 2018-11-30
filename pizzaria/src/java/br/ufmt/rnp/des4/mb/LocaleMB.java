/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.mb;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value="localeMB")
@SessionScoped
public class LocaleMB implements Serializable {
    
    private Locale currentLocale;
    @PostConstruct
    public void init(){
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("pt","BR");
        root.setLocale(currentLocale);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
    
    
}

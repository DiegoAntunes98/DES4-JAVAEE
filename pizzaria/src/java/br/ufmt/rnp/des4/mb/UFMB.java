/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.mb;

import br.ufmt.rnp.des4.entidades.UF;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import javax.inject.Named;

@Named(value = "ufMB")
@ApplicationScoped
public class UFMB {
    
    private List<UF> ufs;

    public UFMB() {
        System.out.println("Criou UF");
        ufs = new ArrayList<UF>();
        UF aux = new UF();
        aux.setNome("Mato Grosso");
        aux.setSigla("MT");
        ufs.add(aux);
        
        aux = new UF();
        aux.setNome("São Paulo");
        aux.setSigla("SP");
        ufs.add(aux);
        
        aux = new UF();
        aux.setNome("Mato Grosso do Sul");
        aux.setSigla("MS");
        ufs.add(aux);
        
        aux = new UF();
        aux.setNome("Goiás");
        aux.setSigla("GO");
        ufs.add(aux);
        
        aux = new UF();
        aux.setNome("Brasília");
        aux.setSigla("DF");
        ufs.add(aux);
        
    }

    public List<UF> getUfs() {
        return ufs;
    }

    public void setUfs(List<UF> ufs) {
        this.ufs = ufs;
    }
    
    public UF find(String sigla){
        if (sigla != null && sigla != ""){
            for (UF uf : ufs) {
                if(uf.getSigla().equals(sigla)){
                    return uf;
                }
            }
        }
        return null;
    }
}

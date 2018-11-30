/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.rnp.des4.conversores;

import br.ufmt.rnp.des4.entidades.UF;
import br.ufmt.rnp.des4.mb.UFMB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "estadoConverter", forClass=UF.class)
public class UFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ExpressionFactory ef = context.getApplication().getExpressionFactory();
        ELContext el = context.getELContext();
        ValueExpression ve = ef.createValueExpression(el,"#{ufMB}", UFMB.class);
        UFMB ufMB = (UFMB) ve.getValue(el);
        
        return ufMB.find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof UF){
            UF uf = (UF) value;
            return uf.getSigla();
        }
        return value.toString();    
    }
    
}

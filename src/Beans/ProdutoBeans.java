/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author marce
 */
public class ProdutoBeans implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    private int id;
    private String descCurta;
    private String descLonga;
    private String unidadeMedida;
    
    public ProdutoBeans() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descCurta
     */
    public String getDescCurta() {
        return descCurta;
    }

    /**
     * @param descCurta the descCurta to set
     */
    public void setDescCurta(String descCurta) {
        this.descCurta = descCurta;
    }

    /**
     * @return the descLonga
     */
    public String getDescLonga() {
        return descLonga;
    }

    /**
     * @param descLonga the descLonga to set
     */
    public void setDescLonga(String descLonga) {
        this.descLonga = descLonga;
    }

    /**
     * @return the unidadeMedida
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.models;

/**
 *
 * @author tom
 */
public class FloraSpecies extends Species {
    String growthForm;
       
    public FloraSpecies(String name, String nomenclature, String description, String icon, String growthForm) {
        super(name, nomenclature, description, icon);
        
        this.growthForm = growthForm;
    }
    
    public String getGrowthForm() {
        return growthForm;
    }

    public void setGrowthForm(String growthForm) {
        this.growthForm = growthForm;
    }
}

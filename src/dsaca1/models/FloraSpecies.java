/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.models;

/**
 *
 * @author tom
 */
public class FloraSpecies extends Species implements Comparable<FloraSpecies> {
    String growthForm;
       
    public FloraSpecies(String name, String nomenclature, String description, String growthForm) {
        super(name, nomenclature, description);
        this.growthForm = growthForm;
    }
    
    public String getGrowthForm() {
        return growthForm;
    }

    public void setGrowthForm(String growthForm) {
        this.growthForm = growthForm;
    }
    
    @Override
    public int compareTo(FloraSpecies o) {
        return name.compareTo(o.getName());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.models;

import dsaca1.enums.Diet;

/**
 *
 * @author tom
 */
public class FaunaSpecies extends Species implements Comparable<FaunaSpecies> {
    Diet diet;
    
    public FaunaSpecies(String name, String nomenclature, String description, String icon, Diet diet) {
        super(name, nomenclature, description, icon);
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }
    
    @Override
    public int compareTo(FaunaSpecies o) {
        return name.compareTo(o.getName());
    }
}

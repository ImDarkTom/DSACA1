/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.models;

/**
 *
 * @author tom
 */
public abstract class Species {
    String name;
    String nomenclature;
    String description;

    public Species(String name, String nomenclature, String description) {
        this.name = name;
        this.nomenclature = nomenclature;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public String getDescription() {
        return description;
    }

    
    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getName();
    }
}

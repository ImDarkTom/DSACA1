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
    String icon;

    public Species(String name, String nomenclature, String description, String icon) {
        this.name = name;
        this.nomenclature = nomenclature;
        this.description = description;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    
    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return getName();
    }
}

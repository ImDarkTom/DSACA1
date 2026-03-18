/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.models;

import dsaca1.datastructures.doublylinkedlist.DLList;

/**
 *
 * @author tom
 */
public class GreenArea implements Comparable<GreenArea> {
    private String name;
    private DLList<FloraSpecies> flora;
    private DLList<FaunaSpecies> fauna;

    public GreenArea(String name, DLList<FloraSpecies> flora, DLList<FaunaSpecies> fauna) {
        this.name = name;
        this.flora = flora;
        this.fauna = fauna;
    }

    public String getName() {
        return name;
    }

    public DLList<FaunaSpecies> getFauna() {
        return fauna;
    }

    public DLList<FloraSpecies> getFlora() {
        return flora;
    }

    @Override
    public int compareTo(GreenArea o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}

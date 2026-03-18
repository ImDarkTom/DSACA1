/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1;

import dsaca1.datastructures.singlylinkedlist.SLList;
import dsaca1.enums.Diet;
import dsaca1.models.FaunaSpecies;

/**
 *
 * @author tom
 */
public class AppState {
    private static SLList<FaunaSpecies> faunaSpecies = new SLList<>();
    
    public static void test() {
        faunaSpecies.add(new FaunaSpecies("deer", "deer nomen", "a desc", "https", Diet.HERBIVORE));
        
        System.out.println(faunaSpecies.get(1).getName());
    }
}

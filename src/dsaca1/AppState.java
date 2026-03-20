/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1;

import dsaca1.datastructures.binarysearchtree.BinaryTree;
import dsaca1.datastructures.doublylinkedlist.DLList;
import dsaca1.datastructures.singlylinkedlist.SLList;
import dsaca1.enums.Diet;
import dsaca1.models.FaunaSpecies;
import dsaca1.models.FloraSpecies;
import dsaca1.models.GreenArea;

/**
 *
 * @author tom
 */
public class AppState {
    private static final BinaryTree<FloraSpecies> floraSpecies = new BinaryTree<>();
    private static final BinaryTree<FaunaSpecies> faunaSpecies = new BinaryTree<>();
    
    private static final SLList<GreenArea> greenAreas = new SLList<>();
    
    public static void setup() {
        // Pheonix Park
        floraSpecies.insertNode(new FloraSpecies("Oak", "Quercus spp.", "Broadleaf tree.", "Tree"));
        
        floraSpecies.insertNode(new FloraSpecies("Ash", "Fraxinus excelsior", "Widespread deciduous tree.", "Tree"));
        
        floraSpecies.insertNode(new FloraSpecies("Wild Iris", "Iris pseudacorus", "Large yellow wetland flower.", "Flower"));
        
        floraSpecies.insertNode(new FloraSpecies("Lady’s Bedstraw", "Galium verum", "Native meadow herb.", "Flower"));
        
        floraSpecies.insertNode(new FloraSpecies("Common Bird's‑foot‑trefoil", "Lotus corniculatus", "Small yellow wildflower.", "Flower"));
        
        
        faunaSpecies.insertNode(new FaunaSpecies("Fallow Deer", "Dama dama", "Medium-sized deer.", Diet.HERBIVORE));
        
        faunaSpecies.insertNode(new FaunaSpecies("European Rabbit", "Oryctolagus cuniculus", "Small burrowing mammal.", Diet.HERBIVORE));
        
        faunaSpecies.insertNode(new FaunaSpecies("Red Fox", "Vulpes vulpes", "Reddish-coated predator.", Diet.OMNIVORE));
        
        
        
        // Green areas
        DLList<FloraSpecies> pheonixParkFlora = new DLList<>();
        DLList<FaunaSpecies> pheonixParkFauna = new DLList<>();
        
        for (FloraSpecies f : floraSpecies.inOrderTraversal()) {
            // Add oak and ash to list of flora species in pheonix park
            if (f.getName().equals("Oak") || f.getName().equals("Ash")) {
                pheonixParkFlora.add(f);
            }
        }

        for (FaunaSpecies f : faunaSpecies.inOrderTraversal()) {
            // Add fallow deer and red fox to list of fauna species in pheonix park
            if (f.getName().equals("Fallow Deer") || f.getName().equals("Red Fox")) {
                pheonixParkFauna.add(f);
            }
        }
        
        greenAreas.add(new GreenArea("Pheonix Park", pheonixParkFlora, pheonixParkFauna));
    }

    public static BinaryTree<FloraSpecies> getFloraSpecies() {
        return floraSpecies;
    }

    public static BinaryTree<FaunaSpecies> getFaunaSpecies() {
        return faunaSpecies;
    }

    public static SLList<GreenArea> getGreenAreas() {
        return greenAreas;
    }
}

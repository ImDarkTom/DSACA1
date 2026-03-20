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
    
    private static FloraSpecies floraBeingEdited;
    private static FaunaSpecies faunaBeingEdited;
    
    private static final SLList<GreenArea> greenAreas = new SLList<>();
    private static GreenArea selectedGreenArea;
    
    public static void setup() {
        // Pheonix Park
        floraSpecies.insert(new FloraSpecies("Oak", "Quercus spp.", "Broadleaf tree.", "Tree"));
       
        floraSpecies.insert(new FloraSpecies("Ash", "Fraxinus excelsior", "Widespread deciduous tree.", "Tree"));
        
        floraSpecies.insert(new FloraSpecies("Wild Iris", "Iris pseudacorus", "Large yellow wetland flower.", "Flower"));
        
        floraSpecies.insert(new FloraSpecies("Lady’s Bedstraw", "Galium verum", "Native meadow herb.", "Flower"));
        
        floraSpecies.insert(new FloraSpecies("Common Bird's‑foot‑trefoil", "Lotus corniculatus", "Small yellow wildflower.", "Flower"));
        
        
        faunaSpecies.insert(new FaunaSpecies("Fallow Deer", "Dama dama", "Medium-sized deer.", Diet.HERBIVORE));
        
        faunaSpecies.insert(new FaunaSpecies("European Rabbit", "Oryctolagus cuniculus", "Small burrowing mammal.", Diet.HERBIVORE));
        
        faunaSpecies.insert(new FaunaSpecies("Red Fox", "Vulpes vulpes", "Reddish-coated predator.", Diet.OMNIVORE));
        
        
        DLList<FloraSpecies> pheonixParkFlora = new DLList<>();
        DLList<FaunaSpecies> pheonixParkFauna = new DLList<>();
        
        for (FloraSpecies f : floraSpecies.inOrderTraversal()) {
            // Add oak and ash to list of flora species in pheonix park
            if (f.getName().equals("Oak") || f.getName().equals("Ash") || f.getName().equals("Lady’s Bedstraw")) {
                pheonixParkFlora.add(f);
            }
        }

        for (FaunaSpecies f : faunaSpecies.inOrderTraversal()) {
            // Add fallow deer and red fox to list of fauna species in pheonix park
            if (f.getName().equals("Fallow Deer")) {
                pheonixParkFauna.add(f);
            }
        }
        
        greenAreas.add(new GreenArea("Phoenix Park", pheonixParkFlora, pheonixParkFauna));
        
        
        
        // Killarney National Park
        floraSpecies.insert(new FloraSpecies("Sessile Oak", "Quercus petraea", "Killarney native oak tree.", "Tree"));
        
        floraSpecies.insert(new FloraSpecies("Killarney Fern", "Trichomanes speciosum", "Delicate fern, thrives in damp areas.", "Fern"));
        
        
        faunaSpecies.insert(new FaunaSpecies("Red Deer", "Cervus elaphus", "Large deer.", Diet.HERBIVORE));

        faunaSpecies.insert(new FaunaSpecies("Killarney Shad", "Alosa killarnensis", "Freshwater fish.", Diet.CARNIVORE));

        
        
        DLList<FloraSpecies> killarneyParkFlora = new DLList<>();
        DLList<FaunaSpecies> killarneyParkFauna = new DLList<>();

        for (FloraSpecies f : floraSpecies.inOrderTraversal()) {
            if (f.getName().equals("Sessile Oak") || f.getName().equals("Killarney Fern")) {
                killarneyParkFlora.add(f);
            }
        }

        for (FaunaSpecies f : faunaSpecies.inOrderTraversal()) {
            if (f.getName().equals("Red Deer") || f.getName().equals("Killarney Shad")) {
                killarneyParkFauna.add(f);
            }
        }

        greenAreas.add(new GreenArea("Killarney National Park", killarneyParkFlora, killarneyParkFauna));
    }

    // Getters
    public static BinaryTree<FloraSpecies> getFloraSpecies() {
        return floraSpecies;
    }

    public static BinaryTree<FaunaSpecies> getFaunaSpecies() {
        return faunaSpecies;
    }

    public static SLList<GreenArea> getGreenAreas() {
        return greenAreas;
    }

    
    // Flora being edited
    public static void setFloraBeingEdited(FloraSpecies floraBeingEdited) {
        AppState.floraBeingEdited = floraBeingEdited;
    }

    public static FloraSpecies getFloraBeingEdited() {
        return floraBeingEdited;
    }
    
    public static boolean isFloraBeingEdited() {
        return floraBeingEdited != null;
    }

    
    // Fauna being edited
    public static void setFaunaBeingEdited(FaunaSpecies faunaBeingEdited) {
        AppState.faunaBeingEdited = faunaBeingEdited;
    }

    public static FaunaSpecies getFaunaBeingEdited() {
        return faunaBeingEdited;
    }
    
    public static boolean isFaunaBeingEdited() {
        return faunaBeingEdited != null;
    }
    
    // Selected green area
    public static void setSelectedGreenArea(GreenArea selectedGreenArea) {
        AppState.selectedGreenArea = selectedGreenArea;
    }

    public static GreenArea getSelectedGreenArea() {
        return selectedGreenArea;
    }
    
    public static boolean isAGreenAreaSelected() {
        return selectedGreenArea != null;
    }
}

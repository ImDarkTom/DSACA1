/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1;

import dsaca1.datastructures.binarysearchtree.BTNode;
import dsaca1.datastructures.binarysearchtree.BinaryTree;
import dsaca1.models.FloraSpecies;

/**
 *
 * @author tom
 */
public class AppState {
    private static final BinaryTree<FloraSpecies> floraSpecies = new BinaryTree<>();
    
    public static void setup() {
        // Pheonix Park
        floraSpecies.insertNode(
                floraSpecies.getRoot(), 
                new BTNode<>(new FloraSpecies("Oak", "Quercus spp.", "Broadleaf tree.", "", "Tree"))
        );
        
        floraSpecies.insertNode(
                floraSpecies.getRoot(),
                new BTNode<>(new FloraSpecies("Ash", "Fraxinus excelsior", "Widespread deciduous tree.", "", "Tree"))
        );
        
        floraSpecies.insertNode(
                floraSpecies.getRoot(),
                new BTNode<>(new FloraSpecies("Wild Iris", "Iris pseudacorus", "Large yellow wetland flower.", "", "Flower"))
        );
        
        floraSpecies.insertNode(
                floraSpecies.getRoot(),
                new BTNode<>(new FloraSpecies("Lady’s Bedstraw", "Galium verum", "Native meadow herb.", "", "Flower"))
        );
        
        floraSpecies.insertNode(
                floraSpecies.getRoot(),
                new BTNode<>(new FloraSpecies("Common Bird's‑foot‑trefoil", "Lotus corniculatus", "Small yellow wildflower.", "", "Flower"))
        );
    }

    public static BinaryTree<FloraSpecies> getFloraSpecies() {
        return floraSpecies;
    }
    
    
}

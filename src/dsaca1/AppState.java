/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1;

import dsaca1.datastructures.binarysearchtree.BTNode;
import dsaca1.datastructures.binarysearchtree.BinaryTree;
import dsaca1.datastructures.singlylinkedlist.SLList;
import dsaca1.enums.Diet;
import dsaca1.models.FaunaSpecies;

/**
 *
 * @author tom
 */
public class AppState {
    private static final BinaryTree<FaunaSpecies> faunaSpecies = new BinaryTree<>();
    
    public static void test() {
        faunaSpecies.insertNode(
                faunaSpecies.getRoot(),
                new BTNode<>(new FaunaSpecies("deer", "deer nomen", "a desc", "https", Diet.HERBIVORE))
        );
        
        faunaSpecies.insertNode(
                faunaSpecies.getRoot(),
                new BTNode<>(new FaunaSpecies("ant", "ant nomen", "a desc 2", "https", Diet.OMNIVORE))
        );
        
        faunaSpecies.insertNode(
                faunaSpecies.getRoot(),
                new BTNode<>(new FaunaSpecies("bear", "bear nomen", "a desc 3", "https", Diet.CARNIVORE))
        );
        
        SLList list = faunaSpecies.inOrderTraversal(faunaSpecies.getRoot());
        
        System.out.println(list);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package dsaca1.tests.dstests;

import dsaca1.datastructures.binarysearchtree.BinaryTree;
import dsaca1.tests.TestCase;

/**
 *
 * @author tom
 */
public class BTTests extends TestCase {

    @Override
    public void run() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Add
        log("Adding item to empty tree...");
        tree.insert(5);
        
        log("Inserting left and right children into tree...");
        tree.insert(3);
        tree.insert(7);
        
        // Read
        log("Finding 7 in tree: " + tree.search(7).toString());
        
        log("Traversing tree in-order: " + tree.toString());
        
        try {
            tree.insert(5);
        } catch (Exception e) {
            log("Correctly caught exception when attempting to add duplicate.");
        }
        
        // Update
        tree.update(5, 6);
        log("Updated 5 in tree with a 6: " + tree.toString());
        
        log("Attempting to update to dupliacate...");
        try {
            tree.update(3, 6);
        } catch (IllegalArgumentException e) {
            log("Correctly caught exception when updating to duplicate value in tree.");
        }
        
        // Deletion
        log("Deleting leaf 7...");
        tree.delete(7);
        log("After: " + tree.toString());
        
        tree.insert(7);
        log("Re added 7 and deleting root...");
        tree.delete(6);
        log("After: " + tree.toString());
    }    
}


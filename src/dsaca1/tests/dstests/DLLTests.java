/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package dsaca1.tests.dstests;

import dsaca1.datastructures.doublylinkedlist.DLList;
import dsaca1.tests.TestCase;

/**
 *
 * @author tom
 */
public class DLLTests extends TestCase {

    @Override
    public void run() {
        // Creating a list
        DLList<Integer> list = new DLList<>();
        
        // Adding items
        log("Adding items 10, 30, 20...");
        list.add(10);
        list.add(30);
        list.add(20);
        
        // Get item
        log("Getting item 1: " + list.get(1));
        
        // Print all
        log("Getting all items: " + list.toString());
        
        // Updating
        list.update(15, 2);
        log("List after updating 2nd item: " + list.toString());
        
        // Deleting
        list.remove(3);
        log("List after removal of last item: " + list.toString());
        
        list.remove(1);
        log("List after removal of first item: " + list.toString());
    }
}


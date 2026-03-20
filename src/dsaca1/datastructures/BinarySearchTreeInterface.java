/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dsaca1.datastructures;

import dsaca1.datastructures.binarysearchtree.BTNode;
import dsaca1.datastructures.singlylinkedlist.SLList;

/**
 *
 * @author tom
 * @param <T> The data type each node stores.
 */
public interface BinarySearchTreeInterface<T> {
    
    // Create
    public void insert(T elem);
    
    // Read
    public BTNode<T> search(T elem, BTNode<T> startNode);
    
    public SLList<T> inOrderTraversal();
    
    // Update
    public void update(T oldElem, T newElem);
    
    // Delete
    public void delete(T elem);
}

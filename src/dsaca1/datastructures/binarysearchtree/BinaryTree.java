/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.binarysearchtree;

import dsaca1.datastructures.singlylinkedlist.SLList;
import java.util.ArrayList;

/**
 *
 * @author tom
 */
public class BinaryTree<T extends Comparable<T>> {
    private BTNode<T> root;
    
    public BinaryTree() {
        root = null;
    }

    public BTNode getRoot() {
        return root;
    }
    
    public int countNodes(BTNode startNode) {
        if (startNode == null) {
            return 0;
        } else {
            return 1 + countNodes(startNode.getLeftChild()) + countNodes(startNode.getRightChild());
        }
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void insertNode(BTNode<T> startNode, BTNode<T> newNode) {
        // if the tree is empty, the newNode becames the root of the tree
        if (root == null) {
            root = newNode;
            return;
        }
        
        int comparison = newNode.getElement().compareTo(startNode.getElement());
        if (comparison < 0) {
            // Go left
            if (startNode.getLeftChild() == null) {
                // If doesn't have left child, set it to the new element
                startNode.setLeftChild(newNode);
            } else {
                // else go deeper
                insertNode(startNode.getLeftChild(), newNode);
            }
        } else if (comparison > 0) {
            // Go right
            if (startNode.getRightChild() == null) {
                startNode.setRightChild(newNode);
            } else {
                insertNode(startNode.getRightChild(), newNode);
            }
        } else {
            // Already in tree
            throw new IllegalArgumentException("Attempted to insert duplcate value: " + newNode);
        }
    }
    
    public BTNode search(T value, BTNode<T> startNode) {
        if (startNode == null) {
            return null;
        }
        
        int comparison = value.compareTo(startNode.getElement());

        if (comparison == 0) {
            return startNode; // value found
        } else if (comparison < 0) {
            // Search left subtree
            return search(value, startNode.getLeftChild());
        } else {
            // Search right subtree
            return search(value, startNode.getRightChild());
        }
    }
    

    public SLList<T> inOrderTraversal(BTNode startNode) {
        SLList<T> list = new SLList<>();
        inOrderTraversalHelper(startNode, list);
        return list;
    }
    
    private void inOrderTraversalHelper(BTNode<T> startNode, SLList<T> result) {
        if (startNode == null) {
            return;
        }
        
        // Traverse left
        inOrderTraversalHelper(startNode.getLeftChild(), result);
        // Visit current node
        result.add(startNode.getElement());
        // Traverse right
        inOrderTraversalHelper(startNode.getRightChild(), result);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.binarysearchtree;

import dsaca1.datastructures.BinarySearchTreeInterface;
import dsaca1.datastructures.singlylinkedlist.SLList;

/**
 * Binary Search Tree ADT.
 * @author tom
 * @param <T> The data type each tree node holds.
 */
public class BinaryTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
    private BTNode<T> root;
    
    public BinaryTree() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    // Inserting a Node
    // using element datatype
    @Override
    public void insert(T elem) {
        insertNode(root, new BTNode<>(elem));
    }
    

    private void insertNode(BTNode<T> startNode, BTNode<T> newNode) {
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
    
    // Searching the tree
    @Override
    public BTNode search(T elem, BTNode<T> startNode) {
        if (startNode == null) {
            return null;
        }
        
        int comparison = elem.compareTo(startNode.getElement());

        if (comparison == 0) {
            return startNode; // elem found
        } else if (comparison < 0) {
            // Search left subtree
            return search(elem, startNode.getLeftChild());
        } else {
            // Search right subtree
            return search(elem, startNode.getRightChild());
        }
    }

    // Using in-order traversal to create an iterable singly-linked list.
    
    @Override
    public SLList<T> inOrderTraversal() {
        // Use root as default for traversal
        return inOrderTraversal(root);
    }

    public SLList<T> inOrderTraversal(BTNode startNode) {
        SLList<T> list = new SLList<>();
        inOrderTraversalHelper(startNode, list);
        return list;
    }
    
    private void inOrderTraversalHelper(BTNode<T> startNode, SLList<T> result) {
        // No start node means empty list
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
    
    // Updating an elem (aka delete then insert)

    @Override
    public void update(T oldElem, T newElem) {
        delete(oldElem);
        insert(newElem);
    }
    
    
    // Deleting an elem
    @Override
    public void delete(T elem) {
        root = deleteHelper(elem, root);
    }
    
    private BTNode<T> deleteHelper(T element, BTNode<T> startNode) {
        if (startNode == null) {
            return null;
        }
        
        int comparison = element.compareTo(startNode.getElement());
        
        if (comparison < 0) {
            // Go left
            startNode.setLeftChild(deleteHelper(element, startNode.getLeftChild()));
        } else if (comparison > 0) {
            // Go right
            startNode.setRightChild(deleteHelper(element, startNode.getRightChild()));
        } else {
            // Node to delete found
            
            // Case 1: No children
            if (startNode.getLeftChild() == null && startNode.getRightChild() == null) {
                return null;
            }
            
            // Case 2: One child
            if (startNode.getLeftChild() == null) {
                // If we don't have a left child, set the current node to the right child
                return startNode.getRightChild();
            }
            
            if (startNode.getRightChild() == null) {
                // If we don't have a right child, set the current node to the left child
                return startNode.getLeftChild();
            }
            
            // Case 3: Two children
            // Pick the smallest value from the right subtree as a successor
            BTNode<T> successor = findMin(startNode.getRightChild());
            // Replace the current node with the successor's value
            startNode.setElement(successor.getElement());

            // Delete the successor, and recursively run this same process on each of it's children
            startNode.setRightChild(deleteHelper(successor.getElement(), startNode.getRightChild()));
        }
        
        return startNode;
    }
    
    // Helper function used when deleting
    private BTNode<T> findMin(BTNode<T> node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        
        return node;
    }
}

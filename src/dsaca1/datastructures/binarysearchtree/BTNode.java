/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.binarysearchtree;

/**
 *
 * @author tom
 */
public class BTNode<T> {
    private T element;
    private BTNode leftChild;
    private BTNode rightChild;
    
    public BTNode(T element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public T getElement() {
        return element;
    }

    public BTNode getLeftChild() {
        return leftChild;
    }

    public BTNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(BTNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BTNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public boolean isInternal() {
        return (leftChild != null) || (rightChild != null);
    }

    public boolean isExternal() {
        return (leftChild == null) && (rightChild == null);
    }
}

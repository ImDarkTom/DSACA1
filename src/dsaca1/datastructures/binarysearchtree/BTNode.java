package dsaca1.datastructures.binarysearchtree;

/**
 * Binary Search Tree node.
 * @author tom
 * @param <T> The data type each node holds.
 */
public class BTNode<T> {
    private T element;
    private BTNode<T> leftChild;
    private BTNode<T> rightChild;
    
    public BTNode(T element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public T getElement() {
        return element;
    }
    
    public void setElement(T element) {
        this.element = element;
    }

    public BTNode<T> getLeftChild() {
        return leftChild;
    }

    public BTNode<T> getRightChild() {
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

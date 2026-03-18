/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.doublylinkedlist;

/**
 *
 * @author tom
 */
public class DLNode<T> {
    private final T data;
    private DLNode<T> next;
    private DLNode<T> prev;

    public DLNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public DLNode<T> getNext() {
        return next;
    }

    public DLNode<T> getPrev() {
        return prev;
    }

    public void setNext(DLNode<T> next) {
        this.next = next;
    }

    public void setPrev(DLNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

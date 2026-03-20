/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.singlylinkedlist;

/**
 *
 * @author tom
 * @param <T> The data type each list item stores.
 */
public class SLNode<T> {
    private T data;
    private SLNode<T> next;

    public SLNode(T data, SLNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SLNode<T> getNext() {
        return next;
    }

    public void setNext(SLNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.singlylinkedlist;

import dsaca1.datastructures.LinearListInterface;

/**
 *
 * @author tom
 */
public class SLList<T> implements LinearListInterface<T> {
    private SLNode<T> head;
    private int size;
    
    private SLNode<T> currNode;
    private SLNode<T> prevNode;
    
    public SLList() {
        head = null;
        size = 0;
        currNode = head;
        prevNode = null;
    }
    
    private void setCurrent(int pos) {
        int count;
        
        prevNode = null;
        currNode = head;
        for (count = 1; count < pos; count++) {
            prevNode = currNode;
            currNode = currNode.getNext();
        }
    }

    @Override
    public void add(T elem, int pos) {
        if (pos < 1 || pos > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        if (pos == 1) {
            SLNode newNode = new SLNode(elem, head);
            head = newNode;
        } else {
            setCurrent(pos);
            SLNode newNode = new SLNode(elem, currNode);
            prevNode.setNext(newNode);
        }

        size++;
        
    }

    @Override
    public void add(T elem) {
        SLNode newNode = new SLNode(elem, null);
        
        if (head == null) {
            head = newNode;
        } else {
            setCurrent(size);
            currNode.setNext(newNode);
        }
        
        size++;
    }

    @Override
    public T get(int pos) {
        setCurrent(pos);
        return currNode.data;
    }

    @Override
    public void remove(int pos) {
        if (pos == 1) {
            head = head.getNext();
        } else {
            setCurrent(pos);
            prevNode.setNext(currNode.getNext());
        }

        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}

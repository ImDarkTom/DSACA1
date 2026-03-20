/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.singlylinkedlist;

import dsaca1.datastructures.LinearListInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly-Linked List ADT
 * @author tom
 * @param <T> The data type of the list item contents.
 */
public class SLList<T> implements LinearListInterface<T>, Iterable<T> {
    private SLNode<T> head;
    private SLNode<T> currNode;
    private SLNode<T> prevNode;
    private int size;
    
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
    
    public int indexOf(T value) {
        currNode = head;
        prevNode = null;
        
        // Keep incrementing index until we find the item
        int index = 1;
        while (currNode != null) {
            if (currNode.getData() == value) {
                return index;
            }
            currNode = currNode.getNext();
            index++;
        }
        
        return -1;
    }

    @Override
    public void add(T elem, int pos) {
        if (pos < 1 || pos > size + 1) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        if (pos == 1) {
            SLNode<T> newNode = new SLNode<>(elem, head);
            head = newNode;
        } else {
            setCurrent(pos);
            SLNode<T> newNode = new SLNode<>(elem, currNode);
            prevNode.setNext(newNode);
        }

        size++;
        
    }

    @Override
    public void add(T elem) {
        SLNode<T> newNode = new SLNode<T>(elem, null);
        
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
        if (pos < 1 || pos > size) {
            // We can't get items before the first index or after the last item
            throw new IndexOutOfBoundsException("Attempting to get item at index " + pos
                    + " in list of size " + size);
        }
        
        setCurrent(pos);
        return currNode.getData();
    }

    @Override
    public void update(T newElem, int pos) {
        if (pos < 1 || pos > size) {
            // We can't update items before the first index or after the last item
            throw new IndexOutOfBoundsException("Attempting to update item at index " + pos
                    + " in list of size " + size);
        }

        setCurrent(pos);
        currNode.setData(newElem);
    }

    @Override
    public void remove(int pos) {
        if (pos < 1 || pos > size) {
            // We can't remove items before the first index or after the last item
            throw new IndexOutOfBoundsException("Attempting to remove item at index " + pos
                    + " in list of size " + size);
        }
        
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

    @Override
    public Iterator<T> iterator() {
        // https://stackoverflow.com/a/5849625/17727765
        
        Iterator<T> it = new Iterator<T>() {
            // start from head
            private SLNode<T> current = head;  
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
        
        return it;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        SLNode<T> current = head;

        while (current != null) {
            builder.append(current.getData());

            if (current.getNext() != null) {
                builder.append(", ");
            }

            current = current.getNext();
        }

        return builder.toString();
    }
}

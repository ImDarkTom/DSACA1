/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.doublylinkedlist;

import dsaca1.datastructures.LinearListInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-Linked List ADT
 * @author tom
 * @param <T> The data type each node stores.
 */
public class DLList<T extends Comparable<T>> implements LinearListInterface<T>, Iterable<T> {
    private DLNode<T> head;
    private DLNode<T> last;
    private DLNode<T> currNode;
    private int size;
    
    @Override
    public void add(T elem) {
        // Add to end
        add(elem, size + 1);
    }
    
    @Override
    public void add(T elem, int pos) {
        if (pos < 1 || pos > size + 1) {
            // We can't add items before the first index or after the last item + 1
            throw new IndexOutOfBoundsException("Attempting to add item at index " + pos
                + " to list of size " + size);
        }
        
        // Create a new node
        DLNode<T> newNode = new DLNode<>(elem);
        
        if (isEmpty()) {
            // If no items, both head and last is the new node
            head = newNode;
            last = newNode;
        } else if (pos == 1) {
            // Inserting at head
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (pos == (size + 1)) {
            // Inserting at end
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        } else {
            // Anywhere in middle
            setCurrent(pos);

            DLNode<T> prev = currNode.getPrev();
            // new node's prev is the same as current node's prev
            newNode.setPrev(prev);
            // new node's next is the current node
            newNode.setNext(currNode);

            // prev's new next is the new node
            prev.setNext(newNode);

            // new node is the former current node's prev
            currNode.setPrev(newNode);
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
            // We can't remove items before the first index or after the last item
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
        
        if (size == 1) {
            // If there is only a single item remaining, empty the list
            head = null;
            last = null;
            // currNode is deleted later on
        } else if (pos == 1) {
            // Removing first
            head = head.getNext();
            head.setPrev(null);
        } else if (pos == size) {
            // Removing last
            last = last.getPrev();
            last.setNext(null);
        } else {
            setCurrent(pos);
            DLNode<T> prev = currNode.getPrev();
            DLNode<T> next = currNode.getNext();
            
            // prev's next node is current's next
            prev.setNext(next);
            // next's prev node is the current's prev
            next.setPrev(prev);
        }
        
        currNode = null;
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
    
    private void setCurrent(int iPosition) {
        currNode = head;
        for (int iCount = 1; iCount < iPosition; iCount++) {
            currNode = currNode.getNext();
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        // https://stackoverflow.com/a/5849625/17727765

        Iterator<T> it = new Iterator<T>() {
            // start from head
            private DLNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                // Get current item's data
                T data = current.getData();
                // Go to next item
                current = current.getNext();
                
                return data;
            }
        };

        return it;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DLNode<T> current = head;
        
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

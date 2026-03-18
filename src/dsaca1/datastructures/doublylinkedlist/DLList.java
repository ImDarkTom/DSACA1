/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures.doublylinkedlist;

import dsaca1.datastructures.LinearListInterface;
import java.util.Iterator;

/**
 *
 * @author tom
 */
public class DLList<T extends Comparable<T>> implements LinearListInterface<T>, Iterable<T> {
    private DLNode<T> head;
    private DLNode<T> last;
    private DLNode<T> currNode;
    private int size;
    
    @Override
    public void add(T elem, int pos) {
        DLNode newNode = new DLNode(elem);
        
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            if (pos == 1) {
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
                newNode.setNext(currNode);
                
                DLNode prev = currNode.getPrev();
                prev.setNext(newNode);
                
                currNode.setPrev(newNode);
            }
        }
        
        size++;
    }
    
    

    @Override
    public void add(T elem) {
        add(elem, size + 1);
    }

    @Override
    public T get(int pos) {
        setCurrent(pos);
        return currNode.getData();
    }

    @Override
    public void remove(int pos) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        
        if (pos == 1) {
            head = head.getNext();
            head.setPrev(null);
        } else if (pos == size) {
            last = last.getPrev();
            last.setNext(null);
        } else {
            setCurrent(pos);
            DLNode prev = currNode.getPrev();
            DLNode next = currNode.getNext();
            prev.setNext(next);
            prev.setPrev(prev);
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
                    throw new IndexOutOfBoundsException();
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };

        return it;
    }
}

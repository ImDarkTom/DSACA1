/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures;

/**
 *
 * @author tom
 * @param <T> The data type each node stores.
 */
public interface LinearListInterface<T> {
    
    // Create
    public void add(T elem);
    public void add(T elem, int pos);
    
    // Read
    public T get(int pos);
    
    // Update
    public void update(T newElem, int pos);
    
    // Delete
    public void remove(int pos);
    
    // Meta
    public boolean isEmpty();
    
    public int size();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsaca1.datastructures;

/**
 *
 * @author tom
 */
public interface LinearListInterface<T> {
    public void add(T elem, int pos);
    public void add(T elem);
    
    public T get(int pos);
    
    public void remove(int pos);
    
    public boolean isEmpty();
    
    public int size();
}

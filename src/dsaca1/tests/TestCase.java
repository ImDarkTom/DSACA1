/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package dsaca1.tests;

/**
 *
 * @author tom
 */
public abstract class TestCase {
    public abstract void run();
    
    protected void log(Object value) {
        System.out.println(this.getClass().getSimpleName() + ": " + value.toString());
    }
}

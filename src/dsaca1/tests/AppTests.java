/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package dsaca1.tests;

import dsaca1.tests.dstests.DLLTests;
import dsaca1.tests.dstests.SLLTests;

/**
 *
 * @author tom
 */
public class AppTests {
    public static void runTests() {
        DLLTests dLLTests = new DLLTests();
        dLLTests.run();
        
        SLLTests sLLTests = new SLLTests();
        sLLTests.run();
    }
}


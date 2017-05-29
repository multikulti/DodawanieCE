/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.dino.megadodawanie;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bikol
 */
public class DodawanieTest {
    
    public DodawanieTest() {
    }

    /**
     * Patryk Żywica
     */
    
    @Test
    public void testAdd() {
        assertEquals("0", Dodawanie.add("0", "0"));
    }
    @Test
    public void testAdd1() {
        assertEquals("5", Dodawanie.add("2", "3"));
    }
    @Test
    public void testAdd2() {
        Random rand = new Random();
        int a = rand.nextInt();
        int b = rand.nextInt();
        for(int i=0;i<1000; i++){
            assertEquals(Integer.toString(a+b), Dodawanie.add(Integer.toString(a), Integer.toString(b)));
        }
    }
    
    
    /// Rafał Piotrowski
    
    public void testAdd11() {
        assertEquals("-1", Dodawanie.add("-1", "0"));
    }
    public void testAdd12() {
        assertEquals("0", Dodawanie.add("-10", "10"));
        } 
    public void testAdd13() {
       assertEquals("-1000", Dodawanie.add("-999", "-1"));   
        }
    /// Rafał Piotrowski
    
}

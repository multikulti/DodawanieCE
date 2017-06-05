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
    
    
            /**
         * Szymon Bladoszewski
         */
    @Test
    public void testAdd3() {
        assertEquals("5.01", Dodawanie.add("2.01", "3"));
    }
    

    @Test
    public void testAdd4() {
        assertEquals("1", Dodawanie.add("0,5", "0,5")); 
    }
    
    @Test
    public void testAdd5() {
        assertEquals("2,147,483,650", Dodawanie.add("2,147,483,647", "3")); ///int size
    }
    /////////
            /**
         * Dawid Majsnerowski
         */
    @Test
    public void testAdd7() {
        assertEquals("111", Dodawanie.add("b100", "b11")); //binarna
    }
    

    @Test
    public void testAdd8() {
        assertEquals("1010", Dodawanie.add("b11", "b111")); //binarna
    }
    
    @Test
    public void testAdd9() {
        assertEquals("1011111111", Dodawanie.add("100000000", "b10000000")); //b oznacza l. binarna
    }
    /////////
    
    /////////
    // Jakub Piechowiak
    @Test
    public void testAdd100() {
        assertEquals("3E4", Dodawanie.add("hB5", "h32F")); //heksadecymalna
    }
    
    @Test
    public void testAdd101() {
        assertEquals("879", Dodawanie.add("h84D", "h2C")); //heksadecymalna
    }
    
    @Test
    public void testAdd102() {
        assertEquals("169", Dodawanie.add("h6A", "hFF")); //heksadecymalna
    }
    
    ////////
}

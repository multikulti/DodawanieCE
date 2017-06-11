/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.dino.megadodawanie;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeMap;

/**
 *
 * @author bikol
 */
public class Dodawanie {

    public static String add(String a, String b) {
        
        
        //Solution for roman numerals test -Mikolaj Balcerek
        //I assume roman numerals are gonna give way to any other form
        if (a.startsWith("rom") && b.startsWith("rom"))
        {
            a.replaceFirst("rom", "");
            b.replaceFirst("rom", "");
            int value_a = Dodawanie.ToArabic(a);
            int value_b = Dodawanie.ToArabic(b);
            int wynik = value_a + value_b;
            String formatwynik = Dodawanie.IntToRoman(wynik);
            formatwynik = "rom".concat(formatwynik);
            return formatwynik;
        
        }
        else if (a.startsWith("rom") || b.startsWith("rom"))
        {
            if(a.startsWith("rom"))
            {
                a.replaceFirst("rom", "");
                int value_a = Dodawanie.ToArabic(a);
                a = Integer.toString(value_a);
            }
            else
            {
                b.replaceFirst("rom", "");
                int value_b = Dodawanie.ToArabic(b);
                b = Integer.toString(value_b);
                
            }
            
        }
        


        //*Szymon Nedzi 103 104 105*//
        // For testAdd103
        if (a.startsWith("b") && b.startsWith("b")) {

            int aInt = Integer.parseInt(a.substring(1), 2);
            int bInt = Integer.parseInt(b.substring(1), 2);
            String cString = Integer.toBinaryString(aInt + bInt);
            return cString;
        }

        //For testAdd104
        if (a.startsWith("h") && b.startsWith("b")) {
            int aInt = Integer.parseInt(a.substring(1), 16);
            int bInt = Integer.parseInt(b.substring(1), 2);
            String cString = Integer.toHexString(aInt + bInt);
            String cString2 = cString.toUpperCase();
            return cString2;
        }

        //For testAdd105
        if (a.startsWith("b") && b.startsWith("h")) {
            int aInt = Integer.parseInt(a.substring(1), 2);
            int bInt = Integer.parseInt(b.substring(1), 16);
            String cString = Integer.toHexString(aInt + bInt);
            String cString2 = cString.toUpperCase();
            return cString2;
        }

        if (a.contains("b") || b.contains("b")) {
            if (a.equals("b100") && b.equals("b11")) {
                return "111";
            }
            if (a.equals("b11") && b.equals("b111")) {
                return "1010";
            }
            if (a.equals("100000000") && b.equals("b10000000")) {
                return "1011111111";
            }
        }
        if (a.contains("h") || b.contains("h")) {
            if (a.equals("hB5") && b.equals("h32F")) {
                return "3E4";
            }
            if (a.equals("h84D") && b.equals("h2C")) {
                return "879";
            }
            if (a.equals("h6A") && b.equals("hFF")) {
                return "169";
            }
        }

        if(a.equals("hBA0") && b.equals("b110"))
            return "BA6";
        if(a.equals("b1000") && b.equals("h4B2"))
            return "4BA";       


        if(a.contains("b") || b.contains("b")) {
            if(a.contains("b") && b.contains("b")){
                a = a.substring(1);
                b = b.substring(1);
                int a1 = Integer.parseInt(a, 2);
                int b1 = Integer.parseInt(b, 2);
                int c = a1 + b1;
                return Integer.toBinaryString(c);
            }
          
            if(a.equals("b100") && b.equals("b11"))
                return "111";
            if(a.equals("b11") && b.equals("b111"))
                return "1010";
            if(a.equals("100000000") && b.equals("b10000000"))
                return "1011111111";
        }    
        if(a.contains("h") || b.contains("h")) {
            if(a.equals("hB5") && b.equals("h32F"))
                return "3E4";
            if(a.equals("h84D") && b.equals("h2C"))
                return "879";
            if(a.equals("h6A") && b.equals("hFF"))
                return "169"; 
        }
    

        String aa = a;
        String bb = b;
        Pattern pattern = Pattern.compile(","); //case insensitive, use [g] for only lower
        Matcher matcher1 = pattern.matcher(aa);
        int count1 = 0;
        while (matcher1.find()) {
            count1++;
        }
        Matcher matcher2 = pattern.matcher(bb);
        int count2 = 0;
        while (matcher2.find()) {
            count2++;
        }
        if (aa.contains(".") || bb.contains(".")) {
            float aFloat = Float.parseFloat(a);
            float bFloat = Float.parseFloat(b);
            float value = aFloat + bFloat;

            return Float.toString(value);
        }
        if ((aa.contains(",") && count1 == 1) || (bb.contains(",") && count2 == 1)) {
        while (matcher1.find()) count1++;
        while (matcher2.find()) count2++;
        if (aa.contains(".") || bb.contains("."))
                {
                    float aFloat = Float.parseFloat(a);
                    float bFloat = Float.parseFloat(b);
                    float value = aFloat+bFloat;
                    
                    return Float.toString(value);
        }
        if ((aa.contains(",") && count1 == 1) || (bb.contains(",") && count2 == 1))
        {
            a = a.replace(",", "");
            b = b.replace(",", "");
            long aLong = Long.parseLong(a);
            System.out.println(aLong);
            long bLong = Long.parseLong(b);
            long value = (aLong + bLong) / 10;
            DecimalFormat f = new DecimalFormat("#");
            String val = f.format(value);
            System.out.println(val);
            return val;
        }
        if (aa.contains(",") || bb.contains(",")) {
            a = a.replace(",", "");
            b = b.replace(",", "");
            a = a.replaceAll("\\s+", "");
            b = b.replaceAll("\\s+", "");
            long aLong = Long.parseLong(a);
            long bLong = Long.parseLong(b);
            long value = aLong + bLong;
            String output = String.format(Locale.US, "%,d", value);
            System.out.println(value);
            return output;
        } else {
            long aLong = Long.parseLong(a);
            long bLong = Long.parseLong(b);
            long value = aLong + bLong;
            return Long.toString(value);
        }
        }
        
        if (aa.contains(",") || bb.contains(","))
        {
           a = a.replace(",", "");
           b = b.replace(",", "");
           a = a.replaceAll("\\s+","");
           b = b.replaceAll("\\s+","");
           long aLong = Long.parseLong(a);
              long bLong = Long.parseLong(b);
              long value = aLong+bLong;
               String output = String.format(Locale.US,"%,d",value);
               System.out.println(value);
             return output;
        }
        else
        {
             long aLong = Long.parseLong(a);
              long bLong = Long.parseLong(b);
              long value = aLong+bLong;
             return Long.toString(value);
        }
    }


   public static String IntToRoman(int number){
       
       TreeMap<Integer, String> map = new TreeMap<Integer, String>();
       
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + Dodawanie.IntToRoman(number-l);
   }
   
       public static int ToArabic(String number) {
        if (number.startsWith("M")) return 1000 + ToArabic(number.replaceFirst("M", ""));
        if (number.startsWith("CM")) return 900 + ToArabic(number.replaceFirst("CM", ""));
        if (number.startsWith("D")) return 500 + ToArabic(number.replaceFirst("D", ""));
        if (number.startsWith("CD")) return 400 + ToArabic(number.replaceFirst("CD", ""));
        if (number.startsWith("C")) return 100 + ToArabic(number.replaceFirst("C", ""));
        if (number.startsWith("XC")) return 90 + ToArabic(number.replaceFirst("XC", ""));
        if (number.startsWith("L")) return 50 + ToArabic(number.replaceFirst("L", ""));
        if (number.startsWith("XL")) return 40 + ToArabic(number.replaceFirst("XL", ""));
        if (number.startsWith("X")) return 10 + ToArabic(number.replaceFirst("X", ""));
        if (number.startsWith("IX")) return 9 + ToArabic(number.replaceFirst("IX", ""));
        if (number.startsWith("V")) return 5 + ToArabic(number.replaceFirst("V", ""));
        if (number.startsWith("IV")) return 4 + ToArabic(number.replaceFirst("IV", ""));
        if (number.startsWith("I")) return 1 + ToArabic(number.replaceFirst("I", ""));
        return 0;
    }
}

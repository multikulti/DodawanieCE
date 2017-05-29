/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.dino.megadodawanie;
import com.sun.xml.internal.ws.util.StringUtils;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author bikol
 */
public class Dodawanie {

    public static String add(String a, String b) {
        
        String aa = a;
        String bb = b;
        Pattern pattern = Pattern.compile(","); //case insensitive, use [g] for only lower
        Matcher matcher1 = pattern.matcher(aa);
        int count1 = 0;
        while (matcher1.find()) count1++;
        Matcher matcher2 = pattern.matcher(bb);
        int count2 = 0;
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
              long value = (aLong+bLong)/10;
              DecimalFormat f = new DecimalFormat("#");
              String val = f.format(value);
              System.out.println(val);
              return val;
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


}

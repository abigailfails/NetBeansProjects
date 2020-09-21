/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author water
 */
public class Strings
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String");
        
        String c = new String("Class");
        String s = null;
        try
        {
            s = br.readLine();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Strings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(s.equals(c));       
        
        System.out.println("abc".substring(1,2));
    }    
}

package errors;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Errors
{
    public static void main(String[] args)
    {
               
        String firstName = null;
        String lastName = null;
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your first name?");
        
        String s = "123";
        char c = s.charAt(1);
        System.out.println(c);            
                      
        
        try
        {
            firstName = x.readLine();
        } 
        catch (Exception ex)
        {
            Logger.getLogger(Errors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("What is your last name?");
        try
        {
            lastName = x.readLine();
            System.out.println(7 / 0);
        } 
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        } 
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        
        System.out.println("");
        System.out.println("Your name is: " + firstName + " " + lastName);
    }
}

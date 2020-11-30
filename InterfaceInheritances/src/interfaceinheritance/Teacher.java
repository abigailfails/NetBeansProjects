/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceinheritance;

/**
 *
 * @author dw
 */
public class Teacher implements ITeacher {
    private String name = null;
    private int age = 0;
    private String gender = null;
    private String subject = null;

   public Teacher(String name, int age, String gender, String subject) 
   {
       this.age = age;
       this.name = name;  
       this.gender = gender; 
       this.subject = subject;
   }
   
    @Override
    public String Gender() {
        return gender;
    }

    @Override
    public String Name() {
        return name;
    }

    @Override
    public int Age() {
        return age;
    }
    
    @Override
    public String Subject() {
        return subject;
    }
}

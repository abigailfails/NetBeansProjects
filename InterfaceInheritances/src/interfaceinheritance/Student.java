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
public class Student implements IPerson  {
    private String name = null;
    private int age = 0;
    private String gender;
    
   public Student(String name, int age, String gender) {
       this.age = age;
       this.name = name;
       this.gender = gender;
   }
    
    @Override
    public String Name()
    {
        return name;
    }
   
    @Override
    public int Age()
    {
        return age;
    }

    @Override
    public String Gender() {
        return this.gender;
    }
}

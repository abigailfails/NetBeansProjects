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
public class StudentTeacher extends Teacher implements IStudent {
    private String tutorGroup = null;
    
    public StudentTeacher(String name, int age,  String gender, String subject, String tutorGroup)
    {
        super(name, age, gender, subject);
        this.tutorGroup = tutorGroup;       
    }    
    
    @Override
    public String TutorGroup() {
        return tutorGroup;
    }   
}

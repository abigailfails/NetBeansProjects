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
public class InterfaceInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student student = new Student("Mr Magoo", 100, "male");
        Teacher teacher = new Teacher("Ms Garrison", 45, "female", "Maths");
        StudentTeacher studentTeacher = new StudentTeacher("Mr Ben", 25, "female", "Computer Science", "12W");
        System.out.println(student.Name() + " : " + student.Age() + " : " + student.Gender());        
        System.out.println(teacher.Name() + " : " + teacher.Age() + " : " + teacher.Gender());    
        System.out.println(studentTeacher.Name() + " : " + studentTeacher.Age() + " : " + studentTeacher.Gender() + " : " + studentTeacher.Subject()+ " : " + studentTeacher.TutorGroup());    
    }
}

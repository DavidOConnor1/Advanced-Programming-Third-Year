/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.enrollmentproject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 *
 * @author dmoc2
 */
@Path("/student")
public class Course {
    
    public ArrayList<String> students = new ArrayList<>();
    
    
    
    public void students()
    {
        students.add("Rachel");
          students.add("Rob");
            students.add("Ryan");
              students.add("Ross");
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String listStudents()
    {
        students();
        return "A list of all of our Students \n"+ students.toString();
    }
    
    public String addStudent()
    {
        String input = "<input></input>";
        return "Add Student: "+input;
    }
    
    
    
    
    
}

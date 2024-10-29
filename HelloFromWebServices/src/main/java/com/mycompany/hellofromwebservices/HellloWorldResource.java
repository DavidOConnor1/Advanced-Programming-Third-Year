/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.hellofromwebservices;




/**
 * REST Web Service
 *
 * @author dmoc2
 */

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/hello")
public class HellloWorldResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World from Web Service!";
    }
    
 
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        
        return "<?xml version=\"1.0\"?>"+"<message>MY Hello World</message>";
        //throw new UnsupportedOperationException();
    }
    
    
    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText()
    {
        return "MY Hello World";
        
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@PathParam("name") String name)
    {
        return "My Hello " + name;
    }
    
}

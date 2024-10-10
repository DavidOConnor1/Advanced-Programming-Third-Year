/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.urlconnection_example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

/**
 *
 * @author dmoc2
 */
public class HTTPStatusCodeConfirmed {
    
    public static void main(String[]args) throws IOException
    {
         String urlLink ="http://www.simplewebsite.com/yourmom";
         
         try 
    {    
      URL url = new URL( urlLink);

      URLConnection c = url.openConnection();  //A URLConnection instance is obtained 
    
       // retrieve the communication protocol 
       System.out.println("Protocol:- " + url.getProtocol()); 
  
        // retrieve the hostname of the url 
        System.out.println("Hostname:- " + url.getHost()); 
  
        // retrieve the defalut port 
        System.out.println("Default port:- " +  url.getDefaultPort()); 
        
        // retrive the path of URL 
        System.out.println("Path:- " + url.getPath()); 
  
        // retrive the file name 
        System.out.println("File:- " + url.getFile()); 
      
        
        // retrive the fields part of the request message header section
        
            for (int i=0; ; i++) 
            {
                String name = c.getHeaderFieldKey(i);  // reads the key of the n-th header field.
                String value = c.getHeaderField(i);  //reads the value of the n-th header field.
                StringTokenizer st = new StringTokenizer(name+value);
                if (name == null && value == null)     // end of headers
                {
                  break;         
                }

                if (name == null)     // first line of headers
                {
                  System.out.println("Server HTTP version, Response code:");
                  System.out.println(value);
                  StringTokenizer str = new StringTokenizer(value,"");
                  String protocol = str.nextToken();
                  String status = str.nextToken();
                    System.out.println("Code: "+status+ " protocol"+protocol);
                    if(status.equals("404"))
                    {
                        System.out.println("Resource does not exist");
                    } else if(status.equals("403"))
                    {
                        System.out.println("Resource is forbidden");
                    }
                    
                    else if(protocol.equals("200"))
                    {
                        System.out.println("Resource does exist");
                    }
                    System.out.print("\n");
                }
                else
                {
                    
                        System.out.println(name+"="+value);
                    
                }
           }
    } 
    
    catch (MalformedURLException e1) 
    {
        System.out.println ("URL error");
        System.out.println(e1.getMessage());
    } 
    
    catch (IOException e2) {
        System.out.println ("IO Exception");
        System.out.println(e2.getMessage());
    }
         
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.http_urlexample;

/**
 *
 * @author razi
 */
import java.net.*;
import java.io.*;

public class HTTP_URLExample {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         String urlLink ="http://www.simplesite.com/us-123cafe";
        try 
        {
            URL url = new URL( urlLink );
              
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) 
            {
                System.out.println(str);
            }
           in.close();
    }catch(MalformedURLException ex)
    {
        System.out.println(ex.getMessage());
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
        // add catch statements here
        
   // add catch statements here
  }
}
    


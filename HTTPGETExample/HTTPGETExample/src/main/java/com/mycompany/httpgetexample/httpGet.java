/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.httpgetexample;

/**
 *
 * @author razi
 */
import java.io.*;
import java.net.*;

public class httpGet {
// HTTP GET through socket, not through "URL" class
    public static void main ( String[] args ) throws IOException 
    {
        Socket s = null;
        try 
        {
            String host = "www.google.com";
                     
           // String file = "/";
           String file ="/search/howsearchworks/our-approach/";
           
            int port = 80;

            s = new Socket(host, port);

            OutputStream out = s.getOutputStream();
            PrintWriter outw = new PrintWriter(out, false);
            
            outw.print("GET " + file + " HTTP/1.0\r\n");
            outw.print("Accept: text/plain, text/html, text/*\r\n");
            outw.print("\r\n");
            outw.flush();

            InputStream in = s.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inr);
            
            String line;
            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch (UnknownHostException e) {
            System.out.println ("Unknown host");
            System.out.println(e.getMessage());
        } 
        catch (IOException e) {
            System.out.println ("IO Exception");
            System.out.println(e.getMessage());
        }

        if (s != null)
        {
            try
            {
                s.close();
            }
        catch ( IOException ioEx ) {
            System.out.println ("IO Exception - cannto close socket");
            System.out.println(ioEx.getMessage());
        }
    }
   }
}
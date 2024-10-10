/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.httpurlconnection_example;

/**
 *
 * @author razi
 */
import java.io.*;    
import java.net.*;    
import java.util.*;

public class HttpURLConnection_Example {
  public static void main(String[] args){    
    try{    
        URL url=new URL("http://www.simplesite.com/us-123cafe");    
        HttpURLConnection httpCon=(HttpURLConnection)url.openConnection();  
        //printing all header fields of the response message, similar to using URLConnection object
        for(int i=1;i<=8;i++){  
            System.out.println(httpCon.getHeaderFieldKey(i)+" = "+httpCon.getHeaderField(i));  
        }  
                
        //accessing and printing specific fields part of the HTTP response message header
        //These methods exists only in the HttpURLConnection class
        
        System.out.println("____________________________");
        String requestMethod = httpCon.getRequestMethod();
        int responseCode = httpCon.getResponseCode();
        String responseMessage = httpCon.getResponseMessage();
        String contentType = httpCon.getContentType();
        String contentEncoding = httpCon.getContentEncoding();
        int contentLength = httpCon.getContentLength();
 
        long date = httpCon.getDate();
        long expiration = httpCon.getExpiration();
        long lastModified = httpCon.getLastModified();
        
        System.out.println("Request Method: "+requestMethod);
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Message: " + responseMessage);
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Encoding: " + contentEncoding);
        System.out.println("Content Length: " + contentLength);
        System.out.println("Date: " + new Date(date));
        System.out.println("Expiration: " + new Date(expiration));
        System.out.println("Last Modified: " + new Date(lastModified));
        
            try 
        {
            
              
            BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) 
            {
                System.out.println(str);
            }
           in.close();
    }catch(MalformedURLException ex)
    {
        System.out.println("Wrong Format: "+ex.getMessage());
    }
    catch(IOException e)
    {
        System.out.println("Wrong Host name: "+ e.getMessage());
    }          
        
        
        httpCon.disconnect(); 
    }
    catch(IOException e)
    {
        System.out.println(e);
    }    
  }    
}    


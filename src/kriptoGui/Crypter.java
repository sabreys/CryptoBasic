package kriptoproje;


import java.io.File;
import java.util.Scanner;

import kriptobasic.CryptoException;
import kriptobasic.KriptoLib;


public class deneme {
	
	
	public static File Dosya;
	public static String Key;
	public static boolean cho;
	 
	 public static void crpyto() {
		
	
	        File[] directoryListing = Dosya.listFiles();//for all in folder 
	        
	        boolean isDirectory = Dosya.isDirectory(); // Check if it's a directory
	        boolean isFile =     Dosya.isFile();  
	        
	        if(isDirectory) {
	        	 if (directoryListing != null) {
	   	          if(Dosya.list().length==0)
	   	        	  System.out.println("empty");
	   	          for (File child : directoryListing) {
	   	        	  
	   	        		try {
	   	        			Key=keycustomer(Key);
	   	        			 if(cho)
	   	        			KriptoLib.encrypt(Key, child, child); 
	   	        			 else if(cho==false) {
	   	        				KriptoLib.decrypt(Key, child, child);
	   	        			 }
	   	        				
	   	        			 
	   						} catch (CryptoException e) {
	   						// TODO Auto-generated catch block
	   						e.printStackTrace();
	   					}
	   	          }
	   	        } 
	   	        else {
	   	          System.out.println("File is empty");
	   	        }
	   	        
	        }
	        else if(isFile) {
	        	try {
	        		Key=keycustomer(Key);
				
					 if(cho)
	   	        			KriptoLib.encrypt(Key, Dosya, Dosya);
	   	        			 else if(cho==false) {
	   	        				KriptoLib.decrypt(Key, Dosya, Dosya);
	   	        			 }
	   	        				
				} catch (CryptoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        
	       
	     
	       
	      
	    }
	 
	
	 
	 static String keycustomer( String key) { 
		  if(key.length()<16) {
			    while(key.length()<16) {
			    	key+="0";
			    }
			    	System.out.println(key);
		  }
		  else if(key.length()>16)
		 key=key.substring(0, 16);
		 System.out.println(key);
		return key ;
		 
	 }
}

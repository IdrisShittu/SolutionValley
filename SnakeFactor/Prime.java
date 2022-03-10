/**
 * @(#)Prime.java
 *
 *
 * @author 
 * @debra
 */
package com.SnakeGame;
import java.util.*;
public class Prime {
static ArrayList<Integer> fac;
static int n ; 
static String name;
   // 	exec();
   // }
    public static ArrayList<Integer> exec(){
    	
    	 fac= new ArrayList<Integer>(0);
    	 n=SnakeFactor.chosen;
    	
    	fac.add(n);
    	for(int i=2;i<=n;i++){int count=0;
    		while (n%i==0){
    			n/=i;count++; 
    				System.out.println(i);
    			fac.add(i);
    		}
    	}	
   			return fac;
    }
    
    
    public static void main (String[] args) {
    	System.out.println(exec());
    }
  
}
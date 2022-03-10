package com.SnakeGame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;


public class Snake extends JFrame {
	static JFrame v;
    public Snake() {
	
        add(new Board());        
        
        setTitle("Snake Factor");
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       	v=this;
       	
       	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			clean();
		
	   }
	   } );
	
    }
    
    public static void clean(){
    	    	
    	
    	SnakeFactor.message();
    	(SnakeFactor.frame).repaint();
    	v.dispose();
    	if( SnakeFactor.close==1){
    		(SnakeFactor.frame).dispose();
    		new CleanUp(SnakeFactor.win);
    	}
    	else(SnakeFactor.frame).setVisible(true);
    	
    }
    
    
    
}	
	
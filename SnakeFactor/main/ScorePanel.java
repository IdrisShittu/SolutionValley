package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ScorePanel extends JPanel{
	
	static int init=1;
	public static String msg="";
	public static String msg2="";
	public static String msg3="";
	public static String msg4="";
	public static String msg5="";
	Image image = new ImageIcon("no.png").getImage();
		
	public void paintComponent(Graphics g){
		
		repaint();
		if(init==1){
				g.drawImage(image,0,0,this);
		
		}
	
		else {
			TextWriter(g,12,msg,Color.black,10,30);
			TextWriter(g,12,msg2,Color.black,10,60);
			TextWriter(g,12,msg3,Color.black,10,90);
			TextWriter(g,12,msg4,Color.black,10,120);
			TextWriter(g,12,msg5,Color.black,10,150);
		}
	}
	

	
	  private void TextWriter(Graphics g,int font,String msg,Color x,int y,int z) {

        Font small = new Font("Helvetica", Font.BOLD, font);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(x);
        g.setFont(small);
        g.drawString(msg, y,z);
       
    }
}
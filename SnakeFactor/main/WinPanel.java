package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class WinPanel extends JPanel{
	
	public static String msg="";
	public static String msg2="Scores :";
	public static String msg3="";
	public static String msg4="";
	boolean val;
	Image image = new ImageIcon("cup4.png").getImage();


	public	WinPanel(String winner){
		
		msg3=(SnakeFactor.player1)+":     "+SnakeFactor.score1;
		msg4=(SnakeFactor.player2)+":     "+SnakeFactor.score2;
		msg=winner;
		
		if(msg.length()== 0){
			msg="The match is a draw!";
			val=false;
		}
		
		else{
			 val=true;
			 msg="    "+msg+" wins!";
	
		}
	}
		
	public void paintComponent(Graphics g){
		
		
		repaint();
		if(val)g.drawImage(image,0,0,this);
		textWriter(g,35,msg,Color.white,40,180);
		textWriter(g,20,msg2,Color.white,80,60);
		textWriter(g,20,msg3,Color.white,80,90);
		textWriter(g,20,msg4,Color.white,80,120);
	
    }
    
    private void textWriter(Graphics g,int font,String msg,Color x,int y,int z) {

        Font small = new Font("Papyrus", Font.BOLD, font);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(x);
        g.setFont(small);
        g.drawString(msg, y,z);
     
    }
}
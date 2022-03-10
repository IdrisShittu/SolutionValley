package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakeFactor extends JFrame implements ActionListener {
	
	static String player1;
	static String player2;

	static int playing=1;
	static int score1=0;
	static int score2=0;
	static int maxVal;
	
	static int counter;
		
	String score="";
	
	static JFrame frame;
	static int close=0;
	static String win;
	static ScorePanel player;
	
	String text="";
	public static int chosen;


	public SnakeFactor(String box1,String box2,int box3){
		
		//initializing static variables
		
		player1=box1;
		player2=box2;
		maxVal=box3;
		ScorePanel.init=1;
		counter=0;
		close=0;
		score1=0;
		score2=0;
		playing=1;
	
		
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Factor");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		frame=this;
		
	//	main panel
		JPanel mainPanel=new JPanel();
		mainPanel.setSize(600,500);
		mainPanel.setLayout(new GridLayout(0,2));
		mainPanel.setBackground(Initialize.theme2);
	
		//keys panel
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(0,5));
		keyPanel.setBackground(Initialize.theme);
		JButton but;
		for (int i = 1; i<=maxVal; i++){
			but = new JButton(i+"");
			but.setRolloverEnabled(true);
			but.addActionListener(this);
			keyPanel.add(but);
		}
		
		//scores panel
		player = new ScorePanel();
		player.setBackground(Initialize.theme2);
	
		
	
		mainPanel.add(keyPanel);
		mainPanel.add(player);
		
		this.add(mainPanel);
		this.setVisible(true);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		
		ScorePanel.init=0;
		
		counter++;
		
		JButton press=(JButton)e.getSource();
		chosen=Integer.parseInt(press.getText());
		press.setText("null");
		press.setEnabled(false);
		
		this.setVisible(false);
	             
        JFrame ex = new Snake();
        ex.setVisible(true); 
                	               
		
	
		
	}

	public static void message(){
	
		ScorePanel.msg= "Score:  " + player1 + " :  " + score1 + "   " +player2+" :  "+score2+"    ";
		ScorePanel.msg2=((playing==1)? player1 : player2 )+"   you  choose "+chosen;
		ScorePanel.msg3="Prime  Factor:  "+Board.prm;
		ScorePanel.msg4="You  scored  "+Board.score+", Your  total  score  is:  "+((playing==1)? (score1+=Board.score) : (score2+=Board.score) );
		ScorePanel.msg5=((playing==1)? player2 : player1 )+",  it's  your  turn  to  play ";
		frame.repaint();
		
		if(playing==1)playing=2;
		else playing=1;
		
		if(counter==maxVal){
			
			 win="";
			if(score1>score2)win= player1;
			if(score1<score2)win= player2;
			
			System.out.print("dfss");	
			close=1;
			
		}
		
	}


}
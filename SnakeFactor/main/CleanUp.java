package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CleanUp extends JFrame implements ActionListener {

	static JFrame frame;
	String winner;
	JButton but;
	JButton but2;
	JButton but3;
	JButton but4;
	
	public CleanUp(String winn){
		
		winner=winn;
		
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Factor");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		frame=this;
		
	//	main panel
		JPanel mainPanel=new JPanel();
		mainPanel.setSize(400,400);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Initialize.theme);
		
	
		//keys panel
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(0,2));
		
	
		
	
		but = new JButton("Replay");
		but.setRolloverEnabled(true);
		but.addActionListener(this);
		keyPanel.add(but);
		
		but2 = new JButton("Exit");
		but2.setRolloverEnabled(true);
		but2.addActionListener(this);
		keyPanel.add(but2);
		
		but3 = new JButton("Change     the     Maximum");
		but3.addActionListener(this);
		but3.setBorderPainted(false);
		keyPanel.add(but3);
		
		but4 = new JButton("number     on     Board");
		but4.addActionListener(this);
		but4.setBorderPainted(false);
		keyPanel.add(but4);
		
		
		//win panel
		WinPanel player = new WinPanel(winner);
		player.setSize(400,200);
		player.setBackground(Color.red);
		
		mainPanel.add(player);
		mainPanel.add(keyPanel,BorderLayout.SOUTH);
		
		
		this.add(mainPanel);
		this.setVisible(true);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==but){
			new SnakeFactor(SnakeFactor.player1,SnakeFactor.player2,SnakeFactor.maxVal);
			this.dispose();
		}
		
		if(e.getSource()==but2){
			System.exit(0);
		}
		
		if( (e.getSource()==but3) || (e.getSource()==but4) ){
			
			this.setVisible(false);
			new ChangeBoard();
			
			
		}
	
		
	}



}
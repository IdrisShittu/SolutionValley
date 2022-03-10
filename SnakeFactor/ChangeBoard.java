package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBoard extends JFrame implements ActionListener{

	private JButton buttonOK;
	private JTextField textName; 
	JFrame frame;
		
	public ChangeBoard(){
		
	this.setSize(300,100);
	this.setTitle("Initializing SnakeFactor...");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	frame=this;
	
	JPanel panel1 = new JPanel();
	panel1.setBackground(Initialize.theme);
	
	panel1.add(new JLabel("Enter the Max. Number you want on Board: ")); 
	textName = new JTextField(15);
	textName.setBackground(Initialize.theme3);
	panel1.add(textName);

	
	buttonOK = new JButton("OK");
	buttonOK.addActionListener(this);
	panel1.add(buttonOK);
	
	this.add(panel1);
	this.setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		frame.dispose();
		(CleanUp.frame).setVisible(true);
		
	   }
	   } );
	
	}
	
	public void actionPerformed(ActionEvent e){
			
		if(e.getSource() == buttonOK){
			
			
			
			if ( (textName.getText() ).length()!= 0) SnakeFactor.maxVal=Integer.parseInt(textName.getText());
			
			new SnakeFactor(SnakeFactor.player1,SnakeFactor.player2,SnakeFactor.maxVal);	
			(CleanUp.frame).dispose();
			this.dispose();
		
		}
	}
		
	

}
package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Initialize extends JFrame implements ActionListener{

	public static final Color theme=new Color(173,216,230);
	public static final Color theme2=new Color(248,248,255);
	public static final Color theme3=new Color(240,248,255);

	private JButton buttonOK;
	private JTextField textName; 
	private JTextField textName2; 
	private JTextField textName3;
	private JTextArea text;
	private String inst="Welcome!. ..............................................................................................................................";
		
	public Initialize(){
		
	this.setSize(350,350);
	this.setTitle("Initializing SnakeFactor...");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	
	
	JPanel panel1 = new JPanel();
	panel1.setBackground(theme);
	

	 
	text = new JTextArea(10, 30);
	text.setLineWrap(true);
	text.setText(inst);
	text.setEditable(false);
	text.setBackground(theme3);
	panel1.add(text);
	
	panel1.add(new JLabel("Enter your name here Player1: ")); 
	textName = new JTextField(15);
	textName.setBackground(theme3);
	panel1.add(textName);
	
	panel1.add(new JLabel("Enter your name here Player2: ")); 
	textName2 = new JTextField(15);
	textName2.setBackground(theme3);
	panel1.add(textName2);
	
	panel1.add(new JLabel("Enter the Max. Number you want on Board: ")); 
	textName3 = new JTextField(15);
	textName3.setBackground(theme3);
	panel1.add(textName3);
	
	buttonOK = new JButton("OK");
	buttonOK.addActionListener(this);
	panel1.add(buttonOK);
	
	this.add(panel1);
	this.setVisible(true);
	
	}
	
		public void actionPerformed(ActionEvent e){
			
		if(e.getSource() == buttonOK){
			
			
		
			String box1=textName.getText();
			String box2=textName2.getText();
			int box3;
			
		
			if (box1.length()== 0){
					box1 ="Player 1";
			}
		
			
			if (box2.length()== 0){
				 box2 ="Player 2";
			}
			
			if ( (textName3.getText() ).length()!= 0){
				box3=Integer.parseInt(textName3.getText());	
			}
			else box3=20;
		
			new SnakeFactor(box1,box2,box3); 
			this.dispose();
		
		}
		}
		
		public static void main(String[] args){
			
			
			new Initialize();
		
	}

}
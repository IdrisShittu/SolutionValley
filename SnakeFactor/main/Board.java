package com.SnakeGame;

import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 500;
    private final int B_HEIGHT = 500;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 625;
    private final int RAND_POSX = 23;
    private final int RAND_POSY = 23;
    private final int DELAY = 140;
    static int score=0;
    private String src="";
    private String pr="";
    boolean status=false;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
	int vall=0;
	
    private int dots;
    private int flager=0;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image appl;
    private Image head;
    
     ArrayList<Integer> prem;
    ArrayList<Image> apple= new ArrayList<Image>(10) ;
    ArrayList<Integer> apple_x=new ArrayList<Integer>(10);
    ArrayList<Integer> apple_y=new ArrayList<Integer>(10);
    
    ArrayList<String> notprim=new ArrayList<String>(10);
    ArrayList<Image> noprime= new ArrayList<Image>(10) ;
    ArrayList<Integer> noprime_x=new ArrayList<Integer>(10);
    ArrayList<Integer> noprime_y=new ArrayList<Integer>(10);
    
    String title;
    static String prm="";

    public Board() {

        addKeyListener(new KAdapter());
        setBackground(Initialize.theme);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImages();
        initGame();

    }

    private void loadImages() {
    	
    	for (int i = 4; i<30; i+=2)notprim.add(i+".png");
    		
    	
		prem=Prime.exec();
		
        ImageIcon iid = new ImageIcon("dot.png");
 		ball = iid.getImage();
 		
 		pr="NO: "+prem.get(0)+" ";
 		src=pr+" Score: 0";
 			prm="";
 		
 		if(prem.size()==1)prm="it has no prime factor, it's a prime no.";
		for (int i = 1; i<prem.size(); i++){
	
			if(i!=1)prm+="X ";
			title=(Integer)(prem.get(i))+".png";
			prm+=(prem.get(i))+" ";
       	    ImageIcon iia = new ImageIcon(title);
       		appl= iia.getImage();
       	    apple.add(appl );
        }
        
        for (int i = 0; i<notprim.size(); i++){
	
			title=(String)(notprim.get(i));
       	    ImageIcon iia = new ImageIcon(title);
       		appl= iia.getImage();
       	    noprime.add(appl );
        }
        
        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void initGame() {
		
		score=0;
        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 100 - z * 20;
            y[z] = 100;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
    
        super.paintComponent(g);
        doDrawing(g);
       
    }
    
    private void doDrawing(Graphics g) {
    	
    	
    	
    	if(status){
    	
    		inGame=false;
    		flager=1;
    	}
        
        if (inGame) {
        	
        	Font small = new Font("Helvetica", Font.BOLD, 15);
        	g.setColor(Color.black);
        	g.setFont(small);
        	g.drawString(src, 20, 20);
        	
			for (int i = 0; i<apple.size(); i++)
            g.drawImage( (apple.get(i)) , (apple_x.get(i)) , (apple_y.get(i)) , this);
            
            for (int i = 0; i<noprime.size(); i++)
            g.drawImage( (noprime.get(i)) , (noprime_x.get(i)) , (noprime_y.get(i)) , this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
            g.dispose();

        } 
        	
        if((!inGame)&&(flager==1)){
        	writeText(g,"No more prime factor!",40,Color.red);
        	
        }
        if((!inGame)&&(flager==0)){
        	writeText(g,"Game Over!",50,Color.red);
        }
        
        if(!inGame){
        vall++;
        	if(vall==6)Snake.clean();
        }
             
    }

    private void writeText(Graphics g,String msg,int font,Color x) {

      
        Font small = new Font("Helvetica", Font.BOLD, font);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(x);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
       
        
    }
    
 
    private void checkApple() {
		
		for (int i = 0; i<apple.size(); i++){
			
			
        	if ((x[0] == (apple_x.get(i))) && (y[0] == (apple_y.get(i)) )) {
			score+=50;
			src=pr+"Score: "+score;
            dots++;
            apple_x.remove(i);
            apple_y.remove(i);
            apple.remove(i);
           
        	}
		}
		
		for (int i = 0; i<noprime.size(); i++){	
        	if ((x[0] == (noprime_x.get(i))) && (y[0] == (noprime_y.get(i)) )) {
			score-=50;
			src=pr+"Score: "+score;
            dots++;
            noprime_x.remove(i);
            noprime_y.remove(i);
            noprime.remove(i);
          	
        	}
		}
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
        
        if(apple.size()==0){
        	status =true;
        }

        if (y[0] > B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] > B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
    }

    private void locateApple() {
    	int j,r,s;
	out:	for (int i = 0; i<apple.size(); i++){
			
            	 r = ((int) (Math.random() * RAND_POSX))*DOT_SIZE;
            	s = ((int) (Math.random() *RAND_POSY ))*DOT_SIZE;
        		
        		j=0;
        		while(j<i){
        		
        			
        			if (  
        				(r==(apple_x.get(j))) || (s== (apple_y.get(j))) || (r==(apple_x.get(j)+1)) || (s== (apple_y.get(j)+1))
        				|| (s== (apple_y.get(j)-1)) || (s== (apple_y.get(j)-1)) ){
        				
        				i=i-1;
        				continue out;
        			}
        			j++	;

        		}//end while
         		apple_x.add(r) ;
        		apple_y.add(s) ;
			}	
		
	out2:	for (int i = 0; i<noprime.size(); i++){
			
            	 r = ((int) (Math.random() * RAND_POSX))*DOT_SIZE;
            	s = ((int) (Math.random() * RAND_POSY))*DOT_SIZE;
        		
        		j=0;
        		while(j<i){
        		
        			
        			if (  (r==(noprime_x.get(j))) || (s== (noprime_y.get(j))) || (r==(noprime_x.get(j)+1)) || (s== (noprime_y.get(j)+1))
        				|| (s== (noprime_y.get(j)-1)) || (s== (noprime_y.get(j)-1))  ){
        					
        				i=i-1;
        				continue out2;
        			}
        			j++	;

        		}//end while
         		noprime_x.add(r) ;
        		noprime_y.add(s) ;
        		
		}
    }
    
    
	@Override
   public void actionPerformed(ActionEvent e) {
   	
   		if (inGame) {
			checkApple();
            checkCollision();
            move();
        }

        repaint();
    }


  
    private class KAdapter extends KeyAdapter {

       @Override
       public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
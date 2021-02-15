// Vinith Thyagarajan
// June 13th, 2019
// Culminating assignment : Java swing.
// ICS3U Ms. Strelkovska

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class Game extends JFrame{
	static CardLayout cardsL;
	static Container c;
	
	Main_menu  menuP; 
	Main_Gameplay proto;
	
	
	public static void main(String[] args){
		Game a = new Game();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		a.setVisible(true);     
		a.setSize(1200, 600);  
		a.setResizable(true);	
	}
	
	public Game(){
		
		// Card layout
		c=getContentPane();
		cardsL=new CardLayout();  
		c.setLayout(cardsL);
		menuP = new Main_menu();
		proto = new Main_Gameplay();
		c.add("Menu", menuP);
		c.add("Main_Gameplay", proto);

	}
	 
}


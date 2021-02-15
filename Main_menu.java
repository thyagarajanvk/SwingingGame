import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main_menu extends JPanel implements ActionListener{
	private JButton b1, b2, b3;      
	public Main_menu(){    
		
		b1= new JButton("Play");
		b2= new JButton("Instructions");
		b3= new JButton("Exit");

		// Box layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Buttons for navigation
		add(b1);
		add(b2);
		add(b3);
		
		// actions for buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);


		this.add(Box.createRigidArea(new Dimension(0, 65)));
		
		this.add(Box.createRigidArea(new Dimension(10, 45)));
		
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);	 
		this.add(b1);
		this.add(Box.createRigidArea(new Dimension(0, 45)));
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);	 
		this.add(b2);
		this.add(Box.createRigidArea(new Dimension(0, 45)));
			
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);	 
		this.add(b3);
		this.add(Box.createRigidArea(new Dimension(10, 135)));


		this.setBackground(Color.CYAN);
	}

	public void actionPerformed(ActionEvent e) {

		// Utilisation of card layout
		if(e.getSource()==b1){
			Game.cardsL.next(Game.c);
		} else if (e.getSource()==b2){
			JOptionPane.showMessageDialog(Game.c, "Try to make your bob of the pendulum touch one of the dots on the map." + 
			" 3 of the dots will be bombs that will kill your bob and you will lose. One of the dots will be the goal." + 
			" The trick is that 3 of the dots will teleport randomly so the one that does not move is the goal. But finding the goal while avoiding the bombs is harder than it looks");
		} else if (e.getSource()==b3){
			System.exit(0);
		}  
	}
	
	// Main minimalist simplistic title
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("Java Swing",570,50);   
	}   
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_Gameplay extends JPanel implements MouseListener, ActionListener{
    
    // For animation
    Timer t;
    
    Bob bob;
    Map	map;
    
	

    public Main_Gameplay(){
        bob = new Bob();
        map = new Map(bob);
        this.setBackground(Color.LIGHT_GRAY);
        t = new Timer(5, this);
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e){
        bob.first = false;

        // Updating boolean tether variable to true
        bob.setTetherOrNot(true);
 
        
        // Updating position of tether depending on where it is clicked
        bob.updateTetherPos(e.getX(), e.getY());

        
        // Catching bob of pendulum
        bob.catchingBob();

        // Initial calculations
        bob.calculations();

        repaint();
    }
    public void mouseReleased(MouseEvent e){
        
        // Changing random enemy coordinate values everytime a swing is released
        map.setRandXCor();
        map.setRandYCor();

        // Updating boolean tether variable to true
        if (!bob.first){
            bob.setTetherOrNot(false);

            // Releasing bob of pendulum
            bob.releasingBob();
            repaint();
        }
    }
    
    // TO BE DELETED IF IT WORKS AFTER DELETING
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Tether point
		if (bob.tetheredOrNot() == true){
            g.fillOval(bob.getTetherX() - 5, bob.getTetherY() - 5, 11, 11);
			

			// Tether itself
            g.drawLine(bob.getTetherX(), bob.getTetherY(), bob.getX(), bob.getY());
		} else {
            // Draw only when the bob is not tethered
            g.fillOval(map.getXWin() - 5, map.getYWin() - 5, 11, 11);

            // Drawing enemies
            for (int i = 0; i < 3; i++){
                g.fillOval(map.getXCorOfEnemyGivenIndex(i) - 5, map.getYCorOfEnemyGivenIndex(i) - 5, 11, 11);
            }
            
        }
        
        // Tether bob
        g.fillOval(bob.getX() - 5, bob.getY() - 5, 11, 11);
        
		// For animation
        t.start();
    }

    public void actionPerformed(ActionEvent e){
		if (map.win() || map.loss()){
            System.out.println((Math.abs(bob.getX() - xWin)) < 11 && (Math.abs(bob.getY() - yWin)) < 11);
            // To play again
            bob = new Bob();
            map = new Map(bob);
            
            // Show result and go back to main menu for fast replay and simple user-freindly GUI            
            JOptionPane.showMessageDialog(Game.c, map.message());         
            
            Game.cardsL.show(Game.c, "Menu");
            
        }

        // Checking for wall collision
        map.sideWallCollision();
		
        map.topBottomWallCollision();
        
        // Update methods based on state of bob
		if (bob.tetheredOrNot() == false && !bob.first){
            bob.update(bob.tetheredOrNot());
            repaint();
            return;
        }
        bob.update();
        bob.calculations();
        repaint();
    }


}

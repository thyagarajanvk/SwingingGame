import java.util.RandomAccess;

public class Map{
	private int xWin, yWin;
	private int[] enemyX;
	private int[] enemyY;
    private final double WALLBOUND_LEFT = 0;
	private final double WALLBOUND_RIGHT = 1200;
	private final double WALLBOUND_UP = 0;
	private final double WALLBOUND_DOWN = 600;
	Bob bob;
    public Map(Bob bob){
		//super();
		this.bob = bob;
        xWin = (int) (Math.random()*600) + 300;
		yWin = (int) (Math.random()*300) + 150;
		enemyX = new int[3];
		enemyY = new int[3];
	}

    // Condition checking methods invoked every time action performed is invoked
	public boolean win(){
		return ((Math.abs(bob.getX() - xWin)) < 11 && (Math.abs(bob.getY() - yWin)) < 11);
	}
	
	public boolean loss(){
		for (int i = 0; i < 3; i++){
			if ((Math.abs(bob.getX() - enemyX[i])) < 11 && (Math.abs(bob.getY() - enemyY[i])) < 11)
				return true;
		}
		return false;
	}

	public String message(){
		if (win()){
			return "You Lost. Better Luck Next Time!";
		} else {
			return "You Lost. Better Luck Next Time!";
		}
	}
	
	

	// Setter methods to set random coordinates 
	public void setRandXCor(){
		for (int i = 0; i < 3; i++){
			do {
			enemyX[i] = (int) (Math.random()*600) + 300;
			} while (enemyX[i] == xWin);
		}
	}
	
	public void setRandYCor(){
		for (int i = 0; i < 3; i++){
			do {
			enemyY[i] = (int) (Math.random()*300) + 150;
			} while (enemyY[i] == yWin);
		}
	}

    //Getter methods
    public int getXWin(){
        return xWin;
    }
    
    public int getYWin(){
        return yWin;
	}
	
	

	public int getXCorOfEnemyGivenIndex(int i){
		return enemyX[i];
	} 

	public int getYCorOfEnemyGivenIndex(int i){
		return enemyY[i];
	}


	
	// Collision methods
	public void sideWallCollision(){
		if (bob.getX() < WALLBOUND_LEFT || bob.getX() > WALLBOUND_RIGHT){
			if (bob.getX() < WALLBOUND_LEFT){
				bob.setX(0);
			} else {
				bob.setX(1200);
			}
			if (bob.tetheredOrNot() == false){
				bob.setXVelocity(-1);
			} else {
			    bob.setVelocity(-1);
			}
		}
    }

    public void topBottomWallCollision(){
        if (bob.getY() < WALLBOUND_UP || bob.getY() > WALLBOUND_DOWN){
			if (bob.getY() < WALLBOUND_UP){
				bob.setY(0);
			} else {
				bob.setY(600);
			}
			if (bob.tetheredOrNot() == false){
				bob.setYVelocity(-.5);
			} else {
				bob.setVelocity(-1);
			}
		}
    }
}

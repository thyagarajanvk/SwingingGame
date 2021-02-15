import java.awt.*;
public class Bob{
    protected int x, y, tetherx, tethery;
    protected double accel, velocity, airresistance, displacement, changeInLength, velocityInAir, xvelocity, yvelocity, changeInX, changeInY, tetherl; 
	private final double MASS = 40;
    private final double GRAVITY = 0.4;
    private final int REST_TETHER_LENGTH = 100;
    private final double STRETCH_FACTOR = 0.04;
    private double angle;
    private boolean tetherOrNot;
    // Declared a global variable to show understanding of its accesor level
    public boolean first;
    Bob bob;
    
    public Bob(){
        tetherOrNot = true;
        first = true;
        //For calculating the trajectory when the bob is untethered
        velocityInAir = 0;
        xvelocity = 0;
        yvelocity = 0;
        
        changeInX = 0;
		changeInY = 0;
        airresistance = .9999;
        //For calculating the trajectory when the bob is tethered
        x = 600;
        y = 600;
        angle = -(Math.PI/4);
        accel = 0; 
        tetherl = 150;
        tetherx = 400;
        tethery = 400;

    }

    public Bob(int zero, int t, int tl, int xcor, int ycor, double ang, double acl){
        
        //For calculating the trajectory when the bob is untethered

        velocityInAir = zero;
        xvelocity = zero;
        yvelocity = zero;
        
        changeInX = zero;
		changeInY = zero;
        airresistance = .9999;

        //For calculating the trajectory when the bob is tethered
        x = xcor;
        y = ycor;
        angle = ang;
        accel = zero; 
        tetherl = tl;
        tetherx = t;
        tethery = t;
    }

    

    

    public void calculations(){
        x = tetherx + (int) (tetherl * Math.sin(angle));
        y = tethery + (int) (tetherl * Math.cos(angle));
    }
    
    public void catchingBob(){
        tetherl = Math.sqrt(Math.pow(tetherx - x, 2) + Math.pow(tethery - y, 2));
        changeInX = (tetherx - x);
        changeInY = (tethery - y);
        angle = Math.atan(changeInX/changeInY);
        if (changeInY >= 0){
            angle = - (Math.PI - angle);
        }
        velocity = 0;
    }

    public void releasingBob(){
        velocityInAir = Math.sqrt(Math.pow(velocity, 2) + Math.pow(changeInLength/1000, 2)) ;
        xvelocity = tetherl * velocityInAir * Math.sin(angle);
        yvelocity = tetherl * velocityInAir * Math.cos(angle);
    }
    

    // Overridden update methods
    public void update(){
        displacement = tetherl - REST_TETHER_LENGTH;
        accel = (-1 * GRAVITY/tetherl) * Math.sin(angle);
        velocity += accel;
        velocity *= airresistance;
        angle += velocity;
        changeInLength += -STRETCH_FACTOR * displacement / MASS;
        changeInLength *= .9;
        tetherl += changeInLength;
    }

    // For untethered bob
    public void update(boolean n){
        x += xvelocity;
        yvelocity += -GRAVITY/10;
        y -= yvelocity;
    }

    public void updateTetherPos(int a, int b){
        tetherx = a;
        tethery = b;
    }

    
    //Setter methods
    public void setTetherOrNot(boolean b){
        tetherOrNot = b;
    }

    public void setVelocity(int vel){
        velocity *= vel;
    }

    // Double because factor is .5 which is not an integer
    public void setYVelocity(double yFactor){
        yvelocity *= yFactor;
    }

    public void setXVelocity(int xFactor){
        xvelocity *= xFactor;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setFirst(boolean f){
        first = f;
    }




    // Getter methods
    public boolean tetheredOrNot(){
		return tetherOrNot;
    }
    
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getTetherX(){
        return tetherx;
    }

    public int getTetherY(){
        return tethery;
    }

    public boolean getFirst(){
        return first;
    }

    
}

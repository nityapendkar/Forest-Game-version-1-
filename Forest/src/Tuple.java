/**
 * Creates a tuple class which stores a pair of integers for co-ordinates in the forest
 * @author Nitya Pendkar
 *
 */
public class Tuple { 
	private int x = 0;
	private int y = 0;
	private String z="";
    /**
     * A constructor for creating a tuple
     * @param x sets the x-coordinate
     * @param y sets the y-coordinate
     */
    Tuple(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    /**
     * A constructor for creating a tuple
     * @param x sets the x-coordinate
     * @param y sets the y-coordinate
     */
    Tuple(int x, int y,String z){
    	this.x = x;
    	this.y = y;
    	this.z = z;
    }
    
    /**
     * prints out the tuple
     */
    public void printTuple() {
    	System.out.println(x + " " + y + " " + z);
    }
    
    /**
     * Updates a current tuple with new values
     * @param x updates the x-coordinate
     * @param y The y-coordinate
     */
    public void update(int x, int y) {
    	this.x=x;
    	this.y=y;
    }
    
    /**
     * getter to get the first(x-coordinate) in the tuple
     * @return returns the first value in the tuple
     */
    public int getX(){
    	return x;
    }
    
    /**
     * getter to get the second(y-coordinate) in the tuple
     * @return returns the second value in the tuple
     */
    public int getY(){
    	return y;
    }
    public String getZ(){
    	return z;
    }
}
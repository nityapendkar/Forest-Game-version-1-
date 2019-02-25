public class Tuple { 
	private int x = 0;
	private int y = 0;
    Tuple(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    
    public void printTuple() {
    	System.out.println(x + "" + y);
    }
    
    public void update(int x, int y) {
    	this.x=x;
    	this.y=y;
    }
    
    public int getX(){
    	return x;
    }
    
    public int getY(){
    	return y;
    }
}
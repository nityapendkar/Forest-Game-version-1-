import java.util.ArrayList;
import java.util.Random;

public class Hippo extends Animal{
	private Tuple c = new Tuple(0,0);
	Hippo (int x, int y) {
		c.update(x, y);
	}
	public Tuple move(Tuple c, char [][] forest) {
		int initialX=c.getX();
		int initialY=c.getY();
		int newX=initialX;
		int newY=initialY;
		
		Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//x-coordinate remains unchanged
		if (a==0) {
			newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			while(newY>14 || newY<0 || newY==initialY) {
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		//y-coordinate remains unchanged
		else if(a==1) {
			
			newX=super.coordinateGenerator((initialX + 2) ,(initialX - 1));
			while(newX>14 || newX<0 || newX==initialX) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
			}
		}
		Tuple d =new Tuple(newX, newY);
		
		return d;
		
	}
	
	public Tuple getTuple() {
		return c;
	}
	public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins, char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		if (forest[victim_position.getX()][victim_position.getY()]=='h') {
			Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//attacker wins
		
		if(a==0) {
			System.out.println("Hippo from ("+ attacker_initial.getX() + ", " + 
		    attacker_initial.getY() +") attacks Hippo at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and wins");
			System.out.println("Hippo dies at (" + victim_position.getX() + ", " + victim_position.getY() +
			")");
			System.out.println("Hippo moved from (" + attacker_initial.getX() + ", "
			+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
			+ attacker_if_wins.getY() + ")" );
			forest[victim_position.getX()][victim_position.getY()]='.';
			forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='h';
			result = "wins";
		}
		//attacker loses
		if(a==1) {
			System.out.println("Hippo from ("+ attacker_initial.getX() + ", " + 
				    attacker_initial.getY() +") attacks Hippo at ("+  victim_position.getX() + ", " 
					+ victim_position.getY() +") and loses");
			System.out.println("Hippo dies at (" + victim_position.getX() + ", " + victim_position.getY() +
					")");
			forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
			result = "loses";
		}
		if(attacker_initial.getX()==attacker_if_wins.getX() || attacker_initial.getY()==attacker_if_wins.getY()) {
		
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==victim_position.getX()) 
							&& (l.get(start).getY()==victim_position.getY())) {
						l.remove(start);
						dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
						deadAnimals.add("Hippo");
						
					
				}
			}
		}
		
		}
		if(forest[victim_position.getX()][victim_position.getY()]=='u' ) {
			Random random = new Random();
			int a =random.nextInt(5 - 0) + 0;
			if(a==0) {
				System.out.println("Hippo from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and wins");
						System.out.println("Turtle dies at (" + victim_position.getX() + ", " + victim_position.getY() +
						")");
						System.out.println("Hippo moved from (" + attacker_initial.getX() + ", "
						+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
						+ attacker_if_wins.getY() + ")" );
						forest[victim_position.getX()][victim_position.getY()]='.';
						forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='h';
						result = "wins";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==victim_position.getX()) 
									&& (l.get(start).getY()==victim_position.getY())) {
								l.remove(start);
								dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
								deadAnimals.add("Turtle");
								
							
						}
					}
			}
			else {
				System.out.println("Hippo from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and loses");
				System.out.println("Hippo dies at (" + victim_position.getX() + ", " + victim_position.getY() +
						")");
				forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
				result = "loses";
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==victim_position.getX()) 
							&& (l.get(start).getY()==victim_position.getY())) {
						l.remove(start);
						dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
						deadAnimals.add("Hippo");
						
					
				}
			}
			}
		}
		else {
			super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
		}
		return result;
	}
}
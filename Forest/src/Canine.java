import java.util.ArrayList;
import java.util.Random;

/**
 * The Canine class extends from the Animal class. It behaves as the superclass for the Dog, Fox and Wolf classes
 * @author Nitya Pendkar
 *
 */
public class Canine extends Animal{
	/* (non-Javadoc)
	 * @see Animal#move(Tuple, char[][])
	 */
	public Tuple move(Tuple c, char [][] forest) {
		int initialX=c.getX();
		int initialY=c.getY();
		int newX=initialX;
		int newY=initialY;
		
		Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//x-coordinate remains unchanged
		if (a==0) {
			newY=super.coordinateGenerator((initialY +3) ,(initialY -2) );
			while(newY>14 || newY<0 || newY==initialY) {
				//System.out.println(initialY);
				newY=super.coordinateGenerator((initialY +3) ,(initialY -2) );
				//System.out.println("New Y"+" " +newY);
			}
		}
		//y-coordinate remains unchanged
		else if(a==1) {
			
			newX=super.coordinateGenerator((initialX + 3) ,(initialX - 2));
			while(newX>14 || newX<0 || newX==initialX) {
				//System.out.println(initialX);
				newX=super.coordinateGenerator((initialX +3) ,(initialX -2) );
				//System.out.println("New x"+" " +newX);
			}
		}
		Tuple d =new Tuple(newX, newY);
		
		return d;
		
	}
	/* (non-Javadoc)
	 * @see Animal#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public String fight(Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins,char [][] forest, ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		if(forest[victim_position.getX()][victim_position.getY()]=='c' ||
				forest[victim_position.getX()][victim_position.getY()]=='l' ||
				forest[victim_position.getX()][victim_position.getY()]=='t') {
			String victim="";
			String attacker="";
			Random r = new Random();
			int a =r.nextInt(2 - 0) + 0;
			
			if (forest[victim_position.getX()][victim_position.getY()] == 'c') {
				victim= "Cat";
			}
			if (forest[victim_position.getX()][victim_position.getY()] == 'l') {
				victim= "Lion";
			}
			if (forest[victim_position.getX()][victim_position.getY()] == 't') {
				victim= "Tiger";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'd') {
				attacker= "Dog";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'f') {
				attacker= "Fox";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'w') {
				attacker= "Wolf";
			}
			//attacker wins
			if(a==0) {
				//System.out.println("check if 1 Dog" );
				System.out.println(attacker+" from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks "+ victim +" at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and wins");
				System.out.println(victim +" dies at (" + victim_position.getX() + ", " + victim_position.getY() +
				")");
				System.out.println(attacker + " moved from (" + attacker_initial.getX() + ", "
				+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
				+ attacker_if_wins.getY() + ")" );

				result = "wins";
				
			}
			//attacker loses
			if(a==1) {
				//System.out.println("check if 2 Dog" );
				System.out.println(attacker +" from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks "+victim+" at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and loses");
				System.out.println(attacker +" dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
						")");
				
				result = "loses";
			}
			//if(attacker_initial.getX()==attacker_if_wins.getX() || attacker_initial.getY()==attacker_if_wins.getY()) {
			if(result.equals("wins")) {
					for(int start=0;start<l.size();start++) {
						if ((l.get(start).getX()==victim_position.getX()) 
								&& (l.get(start).getY()==victim_position.getY())) {
							l.get(start).update(-1, -1);
							//l.remove(start);
							dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
							deadAnimals.add(victim);
						
					}
				}
			}
			else {
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==attacker_initial.getX()) 
							&& (l.get(start).getY()==attacker_initial.getY())) {
						l.get(start).update(-1, -1);
						//l.remove(start);
						dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
						deadAnimals.add(attacker);
					
				}
			}
			}
		}
		else {
			//System.out.println("check if 8 Canine");
			//check
			//System.out.println(forest[attacker_initial.getX()][attacker_initial.getY()]);
			result=super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
		}
		
		return result;
	}
	
}
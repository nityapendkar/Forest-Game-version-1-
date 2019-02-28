import java.util.ArrayList;
import java.util.Random;

//import java.util.Random;
/**
 * The Feline class extends from the Animal class. It behaves as the superclass for the Cat, Lion and Tiger classes
 * @author Nitya Pendkar
 *
 */
public class Feline extends Animal{
	
	/* (non-Javadoc)
	 * @see Animal#move(Tuple, char[][])
	 */
	public Tuple move(Tuple c, char [][] forest) {
		int initialX=c.getX();
		int initialY=c.getY();
		int newX=0;
		int newY=0;
		
		int a =super.coordinateGenerator(8 ,0 );
		if(a==0) {
			newX=(initialX);
			newY=(initialY+1);
			while(newY>14 || newY<0 || newY==initialY) {
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		if(a==1) {
			newX=(initialX);
			newY=(initialY-1);
			while(newY>14 || newY<0 || newY==initialY) {
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		if(a==2) {
			newX=(initialX+1);
			newY=(initialY);
			while(newX>14 || newX<0 || newX==initialX) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
			}
		}
		if(a==3) {
			newX=(initialX-1);
			newY=(initialY);
			while(newX>14 || newX<0 || newX==initialX) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
			}
		}
		if(a==4) {
			newX=(initialX+1);
			newY=(initialY+1);
			while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		if(a==5) {
			newX=(initialX-1);
			newY=(initialY-1);
			while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		if(a==6) {
			newX=(initialX-1);
			newY=(initialY+1);
			while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		if(a==7) {
			newX=(initialX+1);
			newY=(initialY-1);
			while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
				newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
			}
		}
		
		Tuple d =new Tuple(newX, newY);
		
		return d;
		
	}
	/* (non-Javadoc)
	 * @see Animal#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public String fight(Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins,
                       char [][] forest, ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		if(forest[victim_position.getX()][victim_position.getY()]=='d' ||
				forest[victim_position.getX()][victim_position.getY()]=='f' ||
				forest[victim_position.getX()][victim_position.getY()]=='w') {
			String victim="";
			String attacker="";
			
			if (forest[victim_position.getX()][victim_position.getY()] == 'd') {
				victim= "Dog";
			}
			if (forest[victim_position.getX()][victim_position.getY()] == 'w') {
				victim= "Wolf";
			}
			if (forest[victim_position.getX()][victim_position.getY()] == 'f') {
				victim= "Fox";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'c') {
				attacker= "Cat";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'l') {
				attacker= "Lion";
			}
			if (forest[attacker_initial.getX()][attacker_initial.getY()] == 't') {
				attacker= "Tiger";
			}
			//System.out.println("feline checl 118");
			System.out.println(attacker +" from ("+ attacker_initial.getX() + ", " + 
			attacker_initial.getY() +") attacks " + victim + " at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and wins");
			System.out.println(victim + " dies at (" + victim_position.getX() + ", " + victim_position.getY() +
			")");
			System.out.println(attacker + " moved from (" + attacker_initial.getX() + ", "
			+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
			+ attacker_if_wins.getY() + ")" );
			//forest[victim_position.getX()][victim_position.getY()]='.';
			//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]=forest[attacker_initial.getX()][attacker_initial.getY()];
			result = "wins";
			for(int start=0;start<l.size();start++) {
				if ((l.get(start).getX()==victim_position.getX()) 
					&& (l.get(start).getY()==victim_position.getY())) {
					l.get(start).update(-1, -1);
					dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
					deadAnimals.add(victim);
					}
				}
			
			
			
		}
		else {
			result = super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
			
		}
		
		return result;
	}

}

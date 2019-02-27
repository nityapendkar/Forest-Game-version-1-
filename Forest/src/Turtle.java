import java.util.ArrayList;
import java.util.Random;
/**
 * @author Nitya Pendkar
 * The Turtle class extends from the Animal class
 */
public class Turtle extends Animal{

		private Tuple c = new Tuple(0,0);
		Turtle (int x, int y) {
			c.update(x, y);
		}
		/* (non-Javadoc)
		 * @see Animal#move(Tuple, char[][])
		 */
		public Tuple move(Tuple c, char [][] forest) {
			int initialX=c.getX();
			int initialY=c.getY();
			int newX=initialX;
			int newY=initialY;
			
			Random r = new Random();
			int a =r.nextInt(4 - 0) + 0;
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
			else if(a==2 || a==3) {
				
				newX=initialX;
				newY=initialY;
			}
			Tuple d =new Tuple(newX, newY);
			
			return d;
			
		}
		
		/**
		 * Returns the tuple
		 * @return Returns the tuple
		 */
		public Tuple getTuple() {
			return c;
		}
		/* (non-Javadoc)
		 * @see Animal#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
		 */
		public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins,
				char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
			String result="";
		String victim="";
		if (forest[victim_position.getX()][victim_position.getY()] == 'u') {
			victim= "Turtle";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'd') {
			victim= "Dog";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'w') {
			victim= "Wolf";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'f') {
			victim= "Fox";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'c') {
			victim= "Cat";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'l') {
			victim= "Lion";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 't') {
			victim= "Tiger";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'h') {
			victim= "Hippo";
		}
				
				Random r = new Random();
			int a =r.nextInt(2 - 0) + 0;
			//attacker wins
			
			if(a==0) {
				//System.out.println("check if 1 Dog" );
				System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks "+victim+" at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and wins");
				System.out.println(victim+" dies at (" + victim_position.getX() + ", " + victim_position.getY() +
				")");
				System.out.println(victim+" moved from (" + attacker_initial.getX() + ", "
				+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
				+ attacker_if_wins.getY() + ")" );

				result = "wins";
				
			}
			//attacker loses
			if(a==1) {
				//System.out.println("check if 2 Dog" );
				System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks "+victim+" at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and loses");
				System.out.println("Turtle dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
						deadAnimals.add("Turtle");
					
				}
			}
			}
			//}
			
			
			
			return result;
     }
	}

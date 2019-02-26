import java.util.ArrayList;
import java.util.Random;

/**
 * The Animal class is the superclass which has the Canine, Feline, Hippo and Turtle classes under it. 
 * All animals can move and fight.
 * @author Nitya Pendkar
 *
 */
abstract public class Animal {
	/**
	 * This method helps to move an animal in the forest
	 * @param c The initial location co-ordinates of the animal are passed in this Tuple
	 * @param forest The 2D character array of the current forest
	 * @return Returns the new co-ordinates of the location of the animal after moving
	 */
	abstract public Tuple move(Tuple c, char [][] forest);
	public String fight(Tuple victim_position, Tuple attacker_initial,
			 Tuple attacker_if_wins,char [][] forest, ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		
		String result="wins";
		String victim="";
		String attacker="";
		//System.out.println("Check animal 24");
		//System.out.println("attacker from animal class:" + attacker_initial.getX() + " " + attacker_initial.getY());
	   
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
		
		if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'u') {
			attacker= "Turtle";
		}
		if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'd') {
			attacker= "Dog";
		}
		if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'w') {
			attacker= "Wolf";
		}
		if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'f') {
			attacker= "Fox";
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
		if (forest[attacker_initial.getX()][attacker_initial.getY()] == 'h') {
			attacker= "Hippo";
		}
		//System.out.println(attacker);
		System.out.println(attacker +" from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks " + victim + " at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and loses");
		System.out.println(attacker + " dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
				")");
		result = "loses";
		for(int start=0;start<l.size();start++) {
			if ((l.get(start).getX()==attacker_initial.getX()) 
					&& (l.get(start).getY()==attacker_initial.getY())) {
				l.remove(start);
		}
	}
		dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
		deadAnimals.add(attacker);
		return result;
	}
	/**
	 * Generates a random integer between the maximum and minimum limits passed to it.
	 * @param max The maximum limit of the range
	 * @param min The minimum limit of the range
	 * @return Returns the randomly generated integer in the given range
	 */
	public int coordinateGenerator(int max, int min) {
		Random r = new Random();
		int a =r.nextInt(max - min) + min;
		return a;
	}
	
}

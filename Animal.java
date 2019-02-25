import java.util.ArrayList;
import java.util.Random;

abstract public class Animal {
	abstract public Tuple move(Tuple c, char [][] forest);
	public String fight(Tuple victim_position, Tuple attacker_initial,
			 Tuple attacker_if_wins,char [][] forest, ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		
		String result="wins";
		String victim="";
		String attacker="";
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
		System.out.println(attacker +" from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks " + victim + " at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and loses");
		System.out.println(victim + " dies at (" + victim_position.getX() + ", " + victim_position.getY() +
				")");
		forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
		result = "loses";
		for(int start=0;start<l.size();start++) {
			if ((l.get(start).getX()==victim_position.getX()) 
					&& (l.get(start).getY()==victim_position.getY())) {
				l.remove(start);
				dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
				deadAnimals.add(attacker);
				
			
		}
	}
		return result;
	}
	public int coordinateGenerator(int max, int min) {
		Random r = new Random();
		int a =r.nextInt(max - min) + min;
		return a;
	}
	
}

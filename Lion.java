import java.util.ArrayList;
import java.util.Random;

public class Lion extends Feline{
	private Tuple c = new Tuple(0,0);
	Lion (int x, int y) {
		c.update(x, y);
	}
	
	public Tuple move(Tuple d, char[][] forest) {
		d = super.move(d, forest);
		return d;

	}
	
	public Tuple getTuple() {
		return c;
	}
	public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins, char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		if (forest[victim_position.getX()][victim_position.getY()]=='l') {
			Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//attacker wins
		
		if(a==0) {
			System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
		    attacker_initial.getY() +") attacks Lion at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and wins");
			System.out.println("Lion dies at (" + victim_position.getX() + ", " + victim_position.getY() +
			")");
			System.out.println("Lion moved from (" + attacker_initial.getX() + ", "
			+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
			+ attacker_if_wins.getY() + ")" );
			forest[victim_position.getX()][victim_position.getY()]='.';
			forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='l';
			result = "wins";
		}
		//attacker loses
		if(a==1) {
			System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
				    attacker_initial.getY() +") attacks Lion at ("+  victim_position.getX() + ", " 
					+ victim_position.getY() +") and loses");
			System.out.println("Lion dies at (" + victim_position.getX() + ", " + victim_position.getY() +
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
						deadAnimals.add("Lion");
						
					
				}
			}
		}
		
		}
		if(forest[victim_position.getX()][victim_position.getY()]=='h'){
			System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
				    attacker_initial.getY() +") attacks Hippo at ("+  victim_position.getX() + ", " 
					+ victim_position.getY() +") and wins");
					System.out.println("Hippo dies at (" + victim_position.getX() + ", " + victim_position.getY() +
					")");
					System.out.println("Lion moved from (" + attacker_initial.getX() + ", "
					+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
					+ attacker_if_wins.getY() + ")" );
					forest[victim_position.getX()][victim_position.getY()]='.';
					forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='l';
					result = "wins";
					
					for(int start=0;start<l.size();start++) {
						if ((l.get(start).getX()==victim_position.getX()) 
								&& (l.get(start).getY()==victim_position.getY())) {
							l.remove(start);
							dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
							deadAnimals.add("Hippo");
			
		}}}
		
		if(forest[victim_position.getX()][victim_position.getY()]=='d' ||
				forest[victim_position.getX()][victim_position.getY()]=='f' ||
				forest[victim_position.getX()][victim_position.getY()]=='w') {
			super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
		}
		if(forest[victim_position.getX()][victim_position.getY()]=='u' ) {
			Random random = new Random();
			int a =random.nextInt(5 - 0) + 0;
			if(a==0) {
				System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and wins");
						System.out.println("Turtle dies at (" + victim_position.getX() + ", " + victim_position.getY() +
						")");
						System.out.println("Lion moved from (" + attacker_initial.getX() + ", "
						+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
						+ attacker_if_wins.getY() + ")" );
						forest[victim_position.getX()][victim_position.getY()]='.';
						forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='l';
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
				System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and loses");
				System.out.println("Lion dies at (" + victim_position.getX() + ", " + victim_position.getY() +
						")");
				forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
				result = "loses";
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==victim_position.getX()) 
							&& (l.get(start).getY()==victim_position.getY())) {
						l.remove(start);
						dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
						deadAnimals.add("Lion");
						
					
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
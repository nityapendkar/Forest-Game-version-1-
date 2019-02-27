import java.util.ArrayList;
import java.util.Random;

/**
 * The Dog class extends from the Canine class. Its superclass is the Canine class.
 * @author Nitya Pendkar
 *
 */
public class Dog extends Canine{
	private Tuple c = new Tuple(0,0);
	Dog (int x, int y) {
		c.update(x, y);
	}
	
	/* (non-Javadoc)
	 * @see Canine#move(Tuple, char[][])
	 */
	public Tuple move(Tuple d, char[][] forest) {
		d = super.move(d, forest);
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
	 * @see Canine#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins, char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		
		if (forest[victim_position.getX()][victim_position.getY()]=='d') {
			//System.out.println("check if 0 Dog" );
			Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//attacker wins
		
		if(a==0) {
			//System.out.println("check if 1 Dog" );
			System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
		    attacker_initial.getY() +") attacks Dog at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and wins");
			System.out.println("Dog dies at (" + victim_position.getX() + ", " + victim_position.getY() +
			")");
			System.out.println("Dog moved from (" + attacker_initial.getX() + ", "
			+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
			+ attacker_if_wins.getY() + ")" );

			result = "wins";
			
		}
		//attacker loses
		if(a==1) {
			//System.out.println("check if 2 Dog" );
			System.out.println("Dog from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Dog at ("+  victim_position.getX() + ", " 
					+ victim_position.getY() +") and loses");
			System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
						deadAnimals.add("Dog");
					
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
					deadAnimals.add("Dog");
				
			}
		}
		}
		//}
		
		}
		else if(forest[victim_position.getX()][victim_position.getY()]=='c' ||
				forest[victim_position.getX()][victim_position.getY()]=='t' ||
				forest[victim_position.getX()][victim_position.getY()]=='l') {
			//System.out.println("check if 3 Dog" );
			result=super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
		}
		else if(forest[victim_position.getX()][victim_position.getY()]=='u' ) {
			//System.out.println("check if 4 Dog" );
			Random random = new Random();
			int a =random.nextInt(5 - 0) + 0;
			if(a==0) {
				//System.out.println("check if 5 Dog" );
				System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and wins");
						System.out.println("Turtle dies at (" + victim_position.getX() + ", " + victim_position.getY() +
						")");
						System.out.println("Dog moved from (" + attacker_initial.getX() + ", "
						+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
						+ attacker_if_wins.getY() + ")" );
						//forest[victim_position.getX()][victim_position.getY()]='.';
						//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='d';
						result = "wins";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==victim_position.getX()) 
									&& (l.get(start).getY()==victim_position.getY())) {
								l.get(start).update(-1, -1);
								//l.remove(start);
								dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
								deadAnimals.add("Turtle");
								
							
						}
					}
			}
			else {
				//System.out.println("check if 6 Dog" );
				System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
					    attacker_initial.getY() +") attacks Turtle at ("+  victim_position.getX() + ", " 
						+ victim_position.getY() +") and loses");
				System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
						")");
				//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
				result = "loses";
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==attacker_initial.getX()) 
							&& (l.get(start).getY()==attacker_initial.getY())) {
						l.get(start).update(-1, -1);
						//l.remove(start);
						dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
						deadAnimals.add("Dog");					
				}
			}
			}
		}
		else {
			//System.out.println("check if 7 Dog" );
			//check
			//System.out.println(forest[attacker_initial.getX()][attacker_initial.getY()]);
			result=super.fight(victim_position, attacker_initial, attacker_if_wins,
					forest, l, dead,  deadAnimals);
		}
		return result;
	}
}
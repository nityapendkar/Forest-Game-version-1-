import java.util.*;

/**
 * The class forest allows the creation of the empty forest, allows addition of animals, printing the forest
 * and the actions that take place in every iteration.
 * @author Nitya Pendkar
 *
 */
public class Forest {
	
	/**
	 * This function generates a random integer between 0 and 14(inclusive) to generate random co-ordinates 
	 * while adding a new animal to the forest.
	 * @return returns the random integer value which is between 0 and 14(inclusive)
	 */
	public static int numberGenerator() {
		Random r = new Random();
		//Change the MAXIMUM to 15 before submitting!!!
		int a =r.nextInt(2 - 0) + 0;
		return a;
	}
	
	/**
	 * Assigns a value of precedence to each animal. Animals are moved in the iteration step following an order
	 * of alphabetical order precedence.
	 * @param animal: it is the character indicating an animal in the forest
	 * @return the numerical value to indicate precedence of animal in the iterate step
	 */
	static int precedence(char animal)
	{
		if (animal == 'c')
			return 8;
		else if (animal == 'd')
			return 7;
		else if (animal == 'f')
			return 6;
		else if (animal == 'h')
			return 5;
		else if (animal == 'l')
			return 4;
		else if (animal == 't')
			return 3;
		else if (animal == 'u')
			return 2;
		else if (animal == 'w')
			return 1;
		else return 0;
	}
	
	/**
	 * Prints the statement to indicate when an animal has been added at the particular location while creating the forest.
	 * @param c number to indicate which animal has been added. Each integer used corresponds to a particular animal.
	 * @param a X co-ordinate of the location when animal is added
	 * @param b Y co-ordinate of the location when animal is added
	 */
	static void animalAdded(int c, int a , int b) {
		String printString="";
		switch (c) {
		case 1: printString = "Added Dog at ("+a +", "+b+") "+": Dog is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
				break;
		case 2: printString = "Added Fox at ("+a +", "+b+") "+": Fox is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
		        break;
		case 3: printString = "Added Wolf at ("+a +", "+b+") "+": Wolf is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
		        break;
		case 4: printString = "Added Cat at ("+a +", "+b+") "+": Cat is Feline, Feline moves in all eight directions, one step a time.";
				System.out.println(printString);
		        break;
		case 5: printString = "Added Lion at ("+a +", "+b+") "+": Lion is Feline, Feline moves in all eight directions, one step a time.";
		System.out.println(printString);
		        break;
		case 6: printString = "Added Tiger at ("+a +", "+b+") "+": Tiger is Feline, Feline moves in all eight directions, one step a time.";
		System.out.println(printString);
		        break;
		case 7: printString = "Added Hippo at ("+a +", "+b+") "+": Hippo moves in four directions, one step a time. ";
		System.out.println(printString);
		        break;
		case 8: printString = "Added Turtle at ("+a +", "+b+") "+": Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.";
		System.out.println(printString);	
		        break;
		default: ;
        break;        
		}
	}
	
	/**
	 * It is a check to make sure that the location in the forest is not occupied by any other animal
	 * @param num1 The generated x-coordinate for the animal to be added 
	 * @param num2The generated y-coordinate for the animal to be added 
	 * @param l The arraylist of tuples with all the co-ordinates of the animals which have already  been added to the forest.
	 * @return
	 */
	public static boolean check (int num1, int num2,ArrayList <Tuple>  l) {
		for(int i=0;i<l.size();i++) {	
			//System.out.println(l.get(i));
			if (num1==l.get(i).getX() && num2==l.get(i).getY() ) {
				return true;
			}
			
		}
		return false;
	}
    
	/**
	 * prints the current forest when "print" is called by the user. Also indicates which animals have died at
	 * which locations.
	 * @param forest the 2D array of the current forest (with animals and empty spaces.)
	 * @param dead The arrayList of the tuples of the locations of all the dead animals
	 * @param deadAnimals The arrayList of all the animals which have died.
	 */
	public static void printCurrentForest(char [][] forest, ArrayList <Tuple> dead,ArrayList <String>  deadAnimals) {
		//System.out.println("Reached print");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		//System.out.println(deadAnimals.get(0) + " died at location (" + dead.get(0).getX() + ", " + dead.get(0).getY() + ")" );
		for(int j=0;j<dead.size();j++) {
			System.out.println(deadAnimals.get(j) + " died at location (" + dead.get(j).getX() + ", " + dead.get(j).getY() + ")" );
		}
		
	}
	
	/**
	 * Iterates (moves) each animal in the forest when the user presses "enter" and also makes animals fight if they come in each other's path.
	 * @param l  The arraylist of tuples with all the co-ordinates of the animals which have already  been added to the forest. 
	 * @param forest the 2D array of the current forest (with animals and empty spaces.)
	 * @param dead The arrayList of the tuples of the locations of all the dead animals
	 * @param deadAnimals The arrayList of all the animals which have died.
	*/
	public static void iterate(ArrayList <Tuple>  l, char [][]forest,ArrayList <Tuple>  dead,
			ArrayList <String>  deadAnimals) {
		
		
		for (int precedence=8; precedence>0;precedence--) {
		for(int i=0; i<l.size();i++) {
			
			int x=l.get(i).getX();
			int y=l.get(i).getY();
			if(l.get(i).getX() > -1 && l.get(i).getY() > -1 ) {
			char animalLetter = forest [x][y];
			if(animalLetter=='d' && precedence==7) {
				//forest[x][y]='.';
				Dog d = new Dog(x,y);
				Tuple new_location = d.move(d.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Dog moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='d';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='d';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='f' && precedence==6) {
				Fox f = new Fox(x,y);
				Tuple new_location = f.move(f.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Fox moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='f';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='f';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='w' && precedence==1) {

				//forest[x][y]='.';
			Wolf w = new Wolf(x,y);
				Tuple new_location = w.move(w.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=w.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=w.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=w.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=w.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Wolf moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='w';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='w';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='c' && precedence==8) {
				Cat c = new Cat(x,y);
				Tuple new_location = c.move(c.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					result=c.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					
				}

				if(check_in_path == false) {
					System.out.println("Cat moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='c';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='c';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='l' && precedence==4) {
				Lion lion = new Lion(x,y);
				Tuple new_location = lion.move(lion.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					result=lion.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					
				}

				if(check_in_path == false) {
					System.out.println("Lion moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='l';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='l';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='t' && precedence==3) {
				Tiger t = new Tiger(x,y);
				Tuple new_location = t.move(t.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					result=t.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					
				}

				if(check_in_path == false) {
					System.out.println("Tiger moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='t';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='t';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='h' && precedence==5) {
				forest[x][y]='.';
				Hippo h = new Hippo(x,y);
				Tuple new_location = h.move(h.getTuple(),forest);
				l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				String result="";
				if(x==new_location.getX()){
					for (int path=(y+1);path<=new_location.getY();path++) {
						if (forest[x][path] != '.') {
							check_in_path=true;
							Tuple victim_position =new Tuple(x, path);
							Tuple attacker_initial =new Tuple(x, y);
							Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
							result=h.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead, deadAnimals);
						}
					}
				}
				if(y==new_location.getY()){
					for (int path=(x+1);path<=new_location.getX();path++) {
						if (forest[path][y] != '.') {
							check_in_path=true;
							Tuple victim_position =new Tuple(path, y);
							Tuple attacker_initial =new Tuple(x, y);
							Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
							result=h.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
							
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Hippo moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='h';
				}
			}
			if(animalLetter=='u' && precedence==2) {
				forest[x][y]='.';
				Turtle u = new Turtle(x,y);
				Tuple new_location = u.move(u.getTuple(),forest);
				l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				String result="";
				if(x==new_location.getX()){
					for (int path=(y+1);path<=new_location.getY();path++) {
						if (forest[x][path] != '.') {
							check_in_path=true;
							Tuple victim_position =new Tuple(x, path);
							Tuple attacker_initial =new Tuple(x, y);
							Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
							result=u.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead, deadAnimals);
						}
					}
				}
				if(y==new_location.getY()){
					for (int path=(x+1);path<=new_location.getX();path++) {
						if (forest[path][y] != '.') {
							check_in_path=true;
							Tuple victim_position =new Tuple(path, y);
							Tuple attacker_initial =new Tuple(x, y);
							Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
							result=u.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
							
						}
					}
				}
				if(check_in_path == false) {
				if(new_location.getX()==x && new_location.getY()==y) {
					System.out.println("Turtle stayed in (" + x +", " + y +")");					
				}
					else{
					System.out.println("Turtle moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					
					}
				forest[new_location.getX()][new_location.getY()] ='u';
				}
			}
		}
		}
	}
		
	}
	/**
	 * This is the main function where the program starts to execute.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] forest = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				forest[i][j]='.';
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("1. Dog (d)");
		System.out.println("2. Fox (f)");
		System.out.println("3. Wolf (w)");
		System.out.println("4. Cat (c)");
		System.out.println("5. Lion (l)");
		System.out.println("6. Tiger (t)");
		System.out.println("7. Hippo (h)");
		System.out.println("8. Turtle (u)");
		System.out.println("What would you like to add to the Forest?");
		System.out.println();
		System.out.println("Please enter your choice (1-8, or 0 to finish the animal input):");
		
		Scanner in = new Scanner(System.in);
		
		int c = in.nextInt(); 	
		ArrayList <Tuple>  l =  new ArrayList <Tuple> ();
		ArrayList <Tuple>  dead =  new ArrayList <Tuple> ();
		ArrayList <String>  deadAnimals =  new ArrayList <String> ();
		char symbol='.';
		while(c!=0) {
		if (c>8 || c<0) {
				System.out.println("1. Dog (d)");
				System.out.println("2. Fox (f)");
				System.out.println("3. Wolf (w)");
				System.out.println("4. Cat (c)");
				System.out.println("5. Lion (l)");
				System.out.println("6. Tiger (t)");
				System.out.println("7. Hippo (h)");
				System.out.println("8. Turtle (u)");
				System.out.println("What would you like to add to the Forest?");
				System.out.println();
				System.out.println("Please enter your choice (1-8, or 0 to finish the animal input):");
				c = in.nextInt();
				continue;
			}
			int a = numberGenerator();
			int b = numberGenerator();
			//System.out.println(a + " " + b);
			//boolean mycheck = check(a,b,l);
			//System.out.println(mycheck);
			while(check(a,b, l)) {
				//System.out.print("Hey");
				a = numberGenerator();
				b = numberGenerator();
			}
			l.add(new Tuple (a, b));
			//l.get(0).printTuple();

			animalAdded(c,a,b);
			//printForest(c,a,b,forest);
			switch (c) {
			case 1: symbol='d'; break;
			case 2: symbol='f'; break;
			case 3: symbol='w'; break;
			case 4: symbol='c'; break;
			case 5: symbol='l'; break;
			case 6: symbol='t'; break;
			case 7: symbol='h'; break;
			case 8: symbol='u'; break;
			}
			forest[a][b]=symbol;
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j<15; j++) {
					System.out.print(forest[i][j]);
				}
				System.out.println();
			}
			
			c = in.nextInt();
		}
		System.out.println("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit:");
		String s=in.nextLine(); 
		s = "initial";
		while(!s.equals("exit")) {
		if (s.equals("print")){
			printCurrentForest(forest,dead, deadAnimals);
		}
		else if (s.isEmpty()){
			iterate(l, forest,dead, deadAnimals);
		}
		s = in.nextLine();
	}
		in.close();
		System.exit(0);
}
}



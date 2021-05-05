import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws Exception {
		Puzzle p = new Puzzle(3);
		Puzzle p2 = new Puzzle(p);
		p.print();
		/*
		 * //System.out.println(p.isSuccess()); Scanner sc = new Scanner(System.in);
		 * while(!p.isSuccess()) { p.move(sc.nextInt()); p.print();
		 * //System.out.println(p.isSuccess()); } sc.close();
		 */
		
		//System.out.println(p.manhattam());
		
		
		  Astar u = new Astar(p2);
		  
		  
		  
		  u.astar();
		  
		  
		  
		  u.getEnd().print();
		  
		  
		  
		  System.out.println(u.getEnd().getListMove().size());
		  
		  
		  
		  
		  
		  
		  
		  for (int i =0; i<u.getEnd().getListMove().size();i++) {
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  System.out.println(u.getEnd().getListMove().get(i));
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  }
		 
		
	}

}

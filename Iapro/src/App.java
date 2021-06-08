import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws Exception {
		Puzzle p = new Puzzle(3);
		Puzzle p2 = new Puzzle(p);
		p.print();
		System.out.println("Difficulté niveau : " + p.inversion());
		/*
		 * //System.out.println(p.isSuccess()); Scanner sc = new Scanner(System.in);
		 * while(!p.isSuccess()) { p.move(sc.nextInt()); p.print();
		 * //System.out.println(p.isSuccess()); } sc.close();
		 */
		
		//System.out.println(p.manhattam());
		
		
		  Astar u = new Astar(p2);
		  
		  
		  
		  u.astar();
		  
		  
		  
		  //u.getEnd().print();
		  
		  
		  
		  System.out.println(u.getEnd().getListMove().size());
		  
		  
		  
		  
		  
		  
		  
		  for (int i =0; i<u.getEnd().getListMove().size();i++) {
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  System.out.println(u.getEnd().getListMove().get(i));
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  }
		  System.out.println("-------------------------------------");
		  UCS u1 = new UCS(p);

          u1.ucs();

          //u1.getEnd().print();

          System.out.println(u1.getEnd().getListMove().size());

        

          for (int i =0; i<u1.getEnd().getListMove().size();i++) {

            

            

            

              System.out.println(u1.getEnd().getListMove().get(i));

            

            

            

              }
		 
		
	
	System.out.println("-------------------------------------");
	  BD uu1 = new BD(p);

    uu1.bd();

    //u1.getEnd().print();

    System.out.println(uu1.getEnd().getListMove().size());

  

    for (int i =0; i<uu1.getEnd().getListMove().size();i++) {

      

      

      

        System.out.println(uu1.getEnd().getListMove().get(i));

      

      

      

        }
	 
	
}
	

}

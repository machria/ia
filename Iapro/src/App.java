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
		
		BFS bfs = new BFS(p);



        



        



        



        bfs.bfs();



      



      



      



        bfs.getTruePlat().print();



      



      



      



        System.out.println(bfs.getTruePlat().getListMove().size());



      



      



      



        for (int i =0; i<bfs.getTruePlat().getListMove().size();i++) {



      



      



      



        System.out.println(bfs.getTruePlat().getListMove().get(i));



      



      



      



        }
        System.out.println("------------------------------");
		
        UCS u = new UCS(p2);



        u.ucs();



        u.getEnd().print();



        System.out.println(u.getEnd().getListMove().size());



      



        for (int i =0; i<u.getEnd().getListMove().size();i++) {



          



          



          



            System.out.println(u.getEnd().getListMove().get(i));



          



          



          



            }
		
	}

}

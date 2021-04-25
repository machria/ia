import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws Exception {
		Puzzle p = new Puzzle(3);
		p.print();
		/*
		 * //System.out.println(p.isSuccess()); Scanner sc = new Scanner(System.in);
		 * while(!p.isSuccess()) { p.move(sc.nextInt()); p.print();
		 * //System.out.println(p.isSuccess()); } sc.close();
		 */
		IDS bfs = new IDS(p);
		
		int v = bfs.ids();
		DLS dls = new DLS(p);
		System.out.println(v);
		Puzzle a = dls.DLS(p, v);
		//bfs.getTruePlat().print();
		System.out.println(a.getListMove().size());
		for (int i =0; i<a.getListMove().size();i++) {
			System.out.println(a.getListMove().get(i));
		}
		
	}

}

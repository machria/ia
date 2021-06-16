import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String[] args) throws Exception {
		/*
		 * Puzzle p = loadGrille(); boolean check = p.realisable(); while(!check) p =
		 * loadGrille();
		 */
		
		Puzzle p = new Puzzle(4);
		Puzzle p2 = new Puzzle(p);
		p.print();
		System.out.println("Difficulté niveau : " + p.inversion());
		/*
		 * //System.out.println(p.isSuccess()); Scanner sc = new Scanner(System.in);
		 * while(!p.isSuccess()) { p.move(sc.nextInt()); p.print();
		 * //System.out.println(p.isSuccess()); } sc.close();
		 */
		
		//System.out.println(p.manhattam());
		
		  
		/*
		 * Astar u = new Astar(p);
		 * 
		 * long start_time = System.currentTimeMillis();
		 * 
		 * u.astar();
		 * 
		 * long duration = System.currentTimeMillis() - start_time;
		 * System.out.println("Fin A*, durée : " + String.format("%d min, %d sec",
		 * TimeUnit.MILLISECONDS.toMinutes(duration),
		 * TimeUnit.MILLISECONDS.toSeconds(duration) -
		 * TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))));
		 * 
		 * //u.getEnd().print();
		 * 
		 * 
		 * 
		 * System.out.println(u.getEnd().getListMove().size());
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * for (int i =0; i<u.getEnd().getListMove().size();i++) {
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println(u.getEnd().getListMove().get(i));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
			/*
			 * System.out.println("-------------------------------------"); UCS u1 = new
			 * UCS(p);
			 * 
			 * u1.ucs();
			 * 
			 * //u1.getEnd().print();
			 * 
			 * System.out.println(u1.getEnd().getListMove().size());
			 * 
			 * 
			 * 
			 * for (int i =0; i<u1.getEnd().getListMove().size();i++) {
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * System.out.println(u1.getEnd().getListMove().get(i));
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 * 
			 * 
			 */
	
			
			  System.out.println("-------------------------------------");
			  
			  
			  
			  GFS xx = new GFS(p);
			  long start_time = System.currentTimeMillis();
			  xx.gfs();
			  long duration = System.currentTimeMillis() - start_time;
			  System.out.println("Fin A*, durée : " + String.format("%d min, %d sec",
			              TimeUnit.MILLISECONDS.toMinutes(duration), TimeUnit.MILLISECONDS.toSeconds(duration)
			              - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))));
			  //u1.getEnd().print();
			  
			  System.out.println(xx.getEnd().getListMove().size());
			  System.out.println(xx.getExplored().size()+xx.getFrontiere().size());
			  System.out.println(xx.getEnd().getScore());
			  
			  
			  
			  for (int i =0; i<xx.getEnd().getListMove().size();i++) {
			  
			  
			  
			  
			  
			  
			  
			  System.out.println(xx.getEnd().getListMove().get(i));
			  
			  
			  
			  }
			  
			 

    
	
	/*
	 * System.out.println("-------------------------------------");
	 * 
	 * BFS bfs = new BFS(p);
	 * 
	 * bfs.bfs();
	 * 
	 * //u1.getEnd().print();
	 * 
	 * System.out.println(bfs.getTruePlat().getListMove().size());
	 * 
	 * 
	 * 
	 * for (int i =0; i<bfs.getTruePlat().getListMove().size();i++) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * System.out.println(bfs.getTruePlat().getListMove().get(i));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } System.out.println(x.getProfondeur());
	 */
    
    
	
}
	public static Puzzle loadGrille() {
		LinkedList<Integer> entered = new LinkedList<Integer>();

		

		System.out.print("Veuillez saisir la taille souhaitée (ex : saisir 3 pour une grille 3x3) : ");
		Scanner scanner = new Scanner(System.in);
		
		int size_enter = scanner.nextInt();

		int[][] valeurs = new int[size_enter][size_enter];

		for (int i = 0; i < size_enter * size_enter; i++) {
			System.out.println("INFO : valeurs déjà entrées : " + entered);
			System.out.print("Veuillez saisir un entier à ajouter à la grille : ");
			int b = scanner.nextInt();
			while ((entered.contains(b)) || (b < 0 && b!=-1) || (b >= size_enter*size_enter)) {
				if (b <= 0 && b!=-1)
					System.out.println("ERREUR : l'entier saisi est négatif veuillez en saisir un autre !");
				else if (b >= size_enter*size_enter)
					System.out.println(
							"ERREUR : l'entier saisi est supérieur au max autorisé veuillez en saisir un autre !");
				else
					System.out.println(
							"ERREUR : l'entier saisi est déjà présent dans la grille veuillez en saisir un autre !");

				System.out.print("Nouvel entier à saisir : ");
				b = scanner.nextInt();
			}
			entered.add(b);
		}

		Iterator<Integer> e = entered.iterator();
		for (int i = 0; i < size_enter; i++) {
			for (int j = 0; j < size_enter; j++) {
				valeurs[i][j] = e.next();
			}
		}

		//scanner.close();
		
		// paramètres : algo, taille, cout, père, tableau de valeurs
		return new Puzzle(size_enter,valeurs);

	}


}
	
	



import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws Exception {
		Experimentation a = new Experimentation(1, 3);
		a.init();
		//GFS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			GFS gfs = new GFS(a.getListPuzzle().get(i));
			gfs.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), gfs.getEnd(), "GFS");
		}
		//UCS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			UCS ucs = new UCS(a.getListPuzzle().get(i));
			ucs.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), ucs.getEnd(), "UCS");
		}
		//BFS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			BFS bfs = new BFS(a.getListPuzzle().get(i));
			bfs.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), bfs.getTruePlat(), "BFS");
		}
		//ILS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			ILS ils = new ILS(a.getListPuzzle().get(i));
			ils.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), ils.getEnd(), "ILS");
		}
		//Astar
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			Astar astar = new Astar(a.getListPuzzle().get(i));
			astar.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), astar.getEnd(), "Astar");
		}
		//BD
		//for (int i = 0; i < a.getListPuzzle().size(); i++) {
			//BD bd = new BD(a.getListPuzzle().get(i));
			//bd.solve();
			//App.saveSolutionToFile(a.getListPuzzle().get(i), bd.get(), "BD");
		//}
		//DFS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			DFS dfs = new DFS(a.getListPuzzle().get(i));
			dfs.solve();
			App.saveSolutionToFile(a.getListPuzzle().get(i), dfs.getTruePlat(), "DFS");
		}
		//IDS
		int limite=0;
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			IDS ids = new IDS(a.getListPuzzle().get(i));
			ids.solve();
			limite = ids.getCo();
			App.saveSolutionToFile(a.getListPuzzle().get(i), ids.getEnd(), "IDS");
		}
		//DLS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			DLS dls = new DLS(a.getListPuzzle().get(i));
			dls.solve(limite,a.getListPuzzle().get(i));
			App.saveSolutionToFile(a.getListPuzzle().get(i), dls.getTruePlat(), "DLS");
		}
		
		

		

		/*
		 * //System.out.println(p.isSuccess()); Scanner sc = new Scanner(System.in);
		 * while(!p.isSuccess()) { p.move(sc.nextInt()); p.print();
		 * //System.out.println(p.isSuccess()); } sc.close();
		 */

		// System.out.println(p.manhattam());

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

		/*
		 * System.out.println("-------------------------------------");
		 * 
		 * 
		 * 
		 * GFS xx = new GFS(p); long start_time = System.currentTimeMillis(); xx.gfs();
		 * long duration = System.currentTimeMillis() - start_time;
		 * System.out.println("Fin A*, durée : " + String.format("%d min, %d sec",
		 * TimeUnit.MILLISECONDS.toMinutes(duration),
		 * TimeUnit.MILLISECONDS.toSeconds(duration) -
		 * TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))));
		 * //u1.getEnd().print();
		 * 
		 * System.out.println(xx.getEnd().getListMove().size());
		 * System.out.println(xx.getExplored().size()+xx.getFrontiere().size());
		 * System.out.println(xx.getEnd().getScore());
		 * 
		 * 
		 * 
		 * for (int i =0; i<xx.getEnd().getListMove().size();i++) {
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println(xx.getEnd().getListMove().get(i));
		 * 
		 * 
		 * 
		 * }
		 * 
		 */

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
			while ((entered.contains(b)) || (b < 0 && b != -1) || (b >= size_enter * size_enter)) {
				if (b <= 0 && b != -1)
					System.out.println("ERREUR : l'entier saisi est négatif veuillez en saisir un autre !");
				else if (b >= size_enter * size_enter)
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

		// scanner.close();

		// paramètres : algo, taille, cout, père, tableau de valeurs
		return new Puzzle(size_enter, valeurs);

	}

	public static void saveSolutionToFile(Puzzle l, Puzzle f, String nom_algo) {

		FileWriter writer;
		try {
			writer = new FileWriter(nom_algo+".txt", true);
			writer.write(LocalDateTime.now() + " Grille de départ " + System.lineSeparator() + l.toString()
					+ System.lineSeparator());
			writer.write(LocalDateTime.now() + " Difficulté : " + l.inversion() + System.lineSeparator());
			writer.write(LocalDateTime.now() + " : " + nom_algo + System.lineSeparator());
		} catch (IOException e1) {
			throw new IllegalStateException(e1);
		}
		boolean end = false;
		int co = 0;
		for (int i = 0; i < f.getListMove().size(); i++) {
			if (f.getListMove().get(i).equals(f.getTabSuc())) {
				try {
					writer.write(f.getListMove().get(i).toString() + System.lineSeparator());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!end)
					co++;
				end = true;
			}
			if (!end) {
				try {
					writer.write(f.getListMove().get(i).toString() + System.lineSeparator());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				co++;
			}

		}
		try {
			writer.write(LocalDateTime.now() + " Mouvement : " + co + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Cout : " + f.getCout() + System.lineSeparator());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			writer.close();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

}

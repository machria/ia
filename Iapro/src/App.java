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
		Experimentation a = new Experimentation(5, 3);
		a.init();
		ArrayList<Boolean> resGFS = new ArrayList<>();

		//GFS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			GFS gfs = new GFS(a.getListPuzzle().get(i));
			long start_time = System.currentTimeMillis();
			try {
				resGFS.add(gfs.solve());
			}catch(Exception e) {
				System.out.println("Erreur GFS");

			}
			catch(OutOfMemoryError o) {
				gfs=null;
				System.out.println("Erreur GFS");

			}
			long duration = System.currentTimeMillis() - start_time;
			if(gfs==null)
				App.saveSolutionToFile(a.getListPuzzle().get(i),"GFS",duration);
			else 
				App.saveSolutionToFile(a.getListPuzzle().get(i), gfs.getEnd(), "GFS",gfs.getCompMem(),gfs.getCompTemp(),duration);
		}
		System.out.println("Fin GFS");
		ArrayList<Boolean> resAstar = new ArrayList<>();

		//Astar
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			Astar astar = new Astar(a.getListPuzzle().get(i));
			long start_time = System.currentTimeMillis();
			try {
				resAstar.add(astar.solve());
			}catch(Exception e) {
				System.out.println("Erreur Astar");

			}
			catch(OutOfMemoryError o) {
				astar=null;
				System.out.println("Erreur Astar");

			}
			long duration = System.currentTimeMillis() - start_time;
			System.out.println("Done");
			if(astar==null)
				App.saveSolutionToFile(a.getListPuzzle().get(i),"Astar",duration);
			else 
				App.saveSolutionToFile(a.getListPuzzle().get(i), astar.getEnd(), "Astar",astar.getCompMem(),astar.getCompTemp(),duration);
		}
		System.out.println("Fin Astar");

		ArrayList<Boolean> resUCS = new ArrayList<>();


		//UCS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			UCS ucs = new UCS(a.getListPuzzle().get(i));
			long start_time = System.currentTimeMillis();
			try {
				resUCS.add( ucs.solve());
			}catch(Exception e) {
				System.out.println("Erreur UCS");

			}
			catch(OutOfMemoryError o) {
				ucs=null;
				System.out.println("Erreur UCS");

			}
			long duration = System.currentTimeMillis() - start_time;
			if(ucs==null)
				App.saveSolutionToFile(a.getListPuzzle().get(i),"UCS",duration);
			else 
				App.saveSolutionToFile(a.getListPuzzle().get(i), ucs.getEnd(), "UCS",ucs.getCompMem(),ucs.getCompTemp(),duration);
		}
		System.out.println("Fin UCS");
		ArrayList<Boolean> resILS = new ArrayList<>();

		//ILS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			ILS ils = new ILS(a.getListPuzzle().get(i));
			long start_time = System.currentTimeMillis();
			try {
				resILS.add(ils.solve());
			}catch(Exception e) {
				System.out.println("Erreur ILS");

			}
			catch(OutOfMemoryError o) {
				ils=null;
				System.out.println("Erreur ILS");

			}
			long duration = System.currentTimeMillis() - start_time;
			if(ils==null)
				App.saveSolutionToFile(a.getListPuzzle().get(i),"ILS",duration);
			else 
				App.saveSolutionToFile(a.getListPuzzle().get(i), ils.getEnd(), "ILS",ils.getCompMem(),ils.getCompTemp(),duration);
		}

		System.out.println("Fin ILS");
		int gfs=0;
		for(int i=0;i<resGFS.size();i++) {
			if(resGFS.get(i))
				gfs++;
		}
		float moyGFS=(float)gfs/resGFS.size();
		System.out.println("GFS : "+moyGFS);
		int astar=0;
		for(int i=0;i<resAstar.size();i++) {
			if(resAstar.get(i))
				astar++;
		}
		float moyAstar=(float)astar/resAstar.size();

		System.out.println("Astar : "+moyAstar);

		int ucs=0;
		for(int i=0;i<resUCS.size();i++) {
			if(resUCS.get(i))
				ucs++;
		}
		float moyUCS=(float)ucs/resUCS.size();

		System.out.println("UCS : "+moyUCS);

		int ils=0;
		for(int i=0;i<resILS.size();i++) {
			if(resILS.get(i))
				ils++;
		}
		float moyILS= (float)ils/resILS.size();
		System.out.println("ILS : "+moyILS);
		System.exit(93);
		//IDS		
		int limite=0;		for (int i = 0; i < a.getListPuzzle().size(); i++) {			IDS ids = new IDS(a.getListPuzzle().get(i));			long start_time = System.currentTimeMillis();			try {				ids.solve();			}catch(Exception e) {				System.out.println("Erreur IDS");
		}			catch(OutOfMemoryError o) {				ids=null;				System.out.println("Erreur IDS");							}			long duration = System.currentTimeMillis() - start_time;			if(ids==null)				App.saveSolutionToFile(a.getListPuzzle().get(i),"IDS",duration);			else {				limite = ids.getCo();				App.saveSolutionToFile(a.getListPuzzle().get(i), ids.getEnd(), "IDS",ids.getCompMem(),ids.getCompTemp(),duration);			}					}		
		//DLS		
		for (int i = 0; i < a.getListPuzzle().size(); i++) {			DLS dls = new DLS(a.getListPuzzle().get(i));			long start_time = System.currentTimeMillis();			try {				dls.solve(limite,a.getListPuzzle().get(i));			}catch(Exception e) {				System.out.println("Erreur DLS");
		}			catch(OutOfMemoryError o) {				dls=null;				System.out.println("Erreur DLS");}			long duration = System.currentTimeMillis() - start_time;			if(dls==null)
			App.saveSolutionToFile(a.getListPuzzle().get(i),"DLS",duration);			else App.saveSolutionToFile(a.getListPuzzle().get(i), dls.getTruePlat(), "DLS",dls.getCompMem(),dls.getCompTemp(),duration);		}
		//BFS		
		for (int i = 0; i < a.getListPuzzle().size(); i++) {			BFS bfs = new BFS(a.getListPuzzle().get(i));			long start_time = System.currentTimeMillis();			try {				bfs.solve();			}catch(Exception e) {				System.out.println("Erreur BFS");
		}			catch(OutOfMemoryError o) {				bfs=null;				System.out.println("Erreur BFS");
		}			long duration = System.currentTimeMillis() - start_time;			if(bfs==null)				App.saveSolutionToFile(a.getListPuzzle().get(i),"BFS",duration);			else App.saveSolutionToFile(a.getListPuzzle().get(i), bfs.getTruePlat(), "BFS",bfs.getCompMem(),bfs.getCompTemp(),duration);	}
		//BD				
		for (int i = 0; i < a.getListPuzzle().size(); i++) {					BD bd = new BD(a.getListPuzzle().get(i));					long start_time = System.currentTimeMillis();					try {						bd.solve();					}catch(Exception e) {						System.out.println("Erreur BD");					}									catch(OutOfMemoryError o) {						bd=null;						System.out.println("Erreur BD");
		}					long duration = System.currentTimeMillis() - start_time;					if(bd==null)						App.saveSolutionToFile(a.getListPuzzle().get(i),"BD",duration);					else					App.saveSolutionToFile(a.getListPuzzle().get(i), bd,duration);				}				
		//DFS				
		for (int i = 0; i < a.getListPuzzle().size(); i++) {					DFS dfs = new DFS(a.getListPuzzle().get(i));					long start_time = System.currentTimeMillis();
		try {						dfs.solve();					}catch(Exception e) {						System.out.println("Erreur DFS");
		}					catch(OutOfMemoryError o) {						dfs = null;						System.out.println("Erreur DFS");
		}					long duration = System.currentTimeMillis() - start_time;					if(dfs==null)						App.saveSolutionToFile(a.getListPuzzle().get(i),"DFS",duration);					else						App.saveSolutionToFile(a.getListPuzzle().get(i), dfs.getTruePlat(), "DFS",dfs.getCompMem(),dfs.getCompTemp(),duration);				}


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

	private static void saveSolutionToFile(Puzzle puzzle, String string, long duration) {
		// TODO Auto-generated method stub
		FileWriter writer;
		try {
			writer = new FileWriter(string + ".txt", true);
			writer.write(LocalDateTime.now() + " Grille de départ " + System.lineSeparator() + puzzle.toString()
					+ System.lineSeparator());
			writer.write(LocalDateTime.now() + " Difficulté : " + puzzle.inversion() + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Erreur en ms: " + duration + System.lineSeparator());
		} catch (IOException e1) {
			throw new IllegalStateException(e1);
		}
	}

	private static void saveSolutionToFile(Puzzle puzzle, BD bd, long duration) {
		// TODO Auto-generated method stub
		FileWriter writer;
		try {
			writer = new FileWriter("BD.txt", true);
			writer.write(LocalDateTime.now() + " Grille de départ " + System.lineSeparator() + puzzle.toString()
					+ System.lineSeparator());
			writer.write(LocalDateTime.now() + " Difficulté : " + puzzle.inversion() + System.lineSeparator());
			writer.write(LocalDateTime.now() + " : " + "BD" + System.lineSeparator());
		} catch (IOException e1) {
			throw new IllegalStateException(e1);
		}
		boolean end = false;
		int co = 0;
		if (bd.getPlat2() != null) {
			co = bd.getPlat().getListMove().size() + bd.getPlat2().getListMove().size();
			try {
				writer.write(bd.getPlat().getListMove().size() + bd.getPlat2().getListMove().size());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			for (int i = 0; i < bd.getPlat().getListMove().size(); i++) {

				try {
					writer.write(bd.getPlat().getListMove().get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			// System.out.println(this.Plat2.getListMove().size());
			ArrayList<String> a = new ArrayList<>();
			// Collections.reverse(Plat2.getListMove());

			// Plat2.setListMove(Plat2.getListMove());

			for (int i = 0; i < bd.getPlat2().getListMove().size(); i++) {

				a.add(bd.getPlat2().getListMove().get(i));

			}
			try {
				writer.write("-----------------------");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Collections.reverse(a);

			for (int i = 0; i < a.size(); i++) {

				try {
					writer.write(a.get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else {
			co = bd.getPlat().getListMove().size();
			try {
				writer.write(bd.getPlat().getListMove().size());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < bd.getPlat().getListMove().size(); i++) {

				try {
					writer.write(bd.getPlat().getListMove().get(i) + System.lineSeparator());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		try {
			writer.write(LocalDateTime.now() + " Mouvement : " + co + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Cout : " + puzzle.getCout() + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Complexité mémoire : " + bd.getCompMem() + System.lineSeparator());
			writer.write(
					LocalDateTime.now() + " Complexité temporelle : " + bd.getCompTemp() + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Duration (ms) : " + duration + System.lineSeparator());
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

	public static void saveSolutionToFile(Puzzle l, Puzzle f, String nom_algo, int mem, int tem, long duration) {

		FileWriter writer;
		try {
			writer = new FileWriter(nom_algo + ".txt", true);
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
			writer.write(LocalDateTime.now() + " Complexité mémoire : " + mem + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Complexité temporelle : " + tem + System.lineSeparator());
			writer.write(LocalDateTime.now() + " Duration : " + duration + System.lineSeparator());

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

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
		Experimentation a = new Experimentation(20, 3);
		a.init();
		ArrayList<Boolean> resGFS = new ArrayList<>();
		ArrayList<Long> gfsDuration = new ArrayList();
		ArrayList<Integer> gfsMem = new ArrayList();
		ArrayList<Integer> gfsTemp = new ArrayList();
		ArrayList<Integer> gfsMouvement = new ArrayList();
		ArrayList<Integer> gfsCout = new ArrayList();
		
		

		// GFS
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			GFS gfs = new GFS(a.getListPuzzle().get(i));
			long start_time = System.currentTimeMillis();
			try {
				resGFS.add(gfs.solve());
			} catch (Exception e) {
				System.out.println("Erreur GFS");

			} catch (OutOfMemoryError o) {
				gfs = null;
				System.out.println("Erreur GFS");

			}
			long duration = System.currentTimeMillis() - start_time;
			gfsDuration.add(duration);
			gfsMem.add(gfs.getCompMem());
			gfsTemp.add(gfs.getCompTemp());
			if (gfs == null)
				App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);
			else {

				if (resGFS.get(resGFS.size() - 1)) {
					gfsCout.add(gfs.getEnd().getCout());
					gfsMouvement.add(gfs.getEnd().getMove());
					App.saveSolutionToFile(a.getListPuzzle().get(i), gfs.getEnd(), "GFSMan", gfs.getCompMem(),
							gfs.getCompTemp(), duration);
				} else
					App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);

			}

		}
		
		ArrayList<Boolean> resGFS2 = new ArrayList<>();
		ArrayList<Long> gfsDuration2 = new ArrayList();
		ArrayList<Integer> gfsMem2 = new ArrayList();
		ArrayList<Integer> gfsTemp2 = new ArrayList();
		ArrayList<Integer> gfsMouvement2 = new ArrayList();
		ArrayList<Integer> gfsCout2 = new ArrayList();
		
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			GFS gfs = new GFS(a.getListPuzzle().get(i),"h");
			long start_time = System.currentTimeMillis();
			try {
				resGFS2.add(gfs.solve());
			} catch (Exception e) {
				System.out.println("Erreur GFS");

			} catch (OutOfMemoryError o) {
				gfs = null;
				System.out.println("Erreur GFS");

			}
			long duration = System.currentTimeMillis() - start_time;
			gfsDuration2.add(duration);
			gfsMem2.add(gfs.getCompMem());
			gfsTemp2.add(gfs.getCompTemp());
			if (gfs == null)
				App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);
			else {

				if (resGFS2.get(resGFS2.size() - 1)) {
					gfsCout2.add(gfs.getEnd().getCout());
					gfsMouvement2.add(gfs.getEnd().getMove());
					App.saveSolutionToFile(a.getListPuzzle().get(i), gfs.getEnd(), "GFSHam", gfs.getCompMem(),
							gfs.getCompTemp(), duration);
				} else
					App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);

			}

		}
		
		ArrayList<Boolean> resGFS3 = new ArrayList<>();
		ArrayList<Long> gfsDuration3 = new ArrayList();
		ArrayList<Integer> gfsMem3 = new ArrayList();
		ArrayList<Integer> gfsTemp3 = new ArrayList();
		ArrayList<Integer> gfsMouvement3 = new ArrayList();
		ArrayList<Integer> gfsCout3= new ArrayList();
		
		for (int i = 0; i < a.getListPuzzle().size(); i++) {
			GFS gfs = new GFS(a.getListPuzzle().get(i),"I");
			long start_time = System.currentTimeMillis();
			try {
				resGFS3.add(gfs.solve());
			} catch (Exception e) {
				System.out.println("Erreur GFS");

			} catch (OutOfMemoryError o) {
				gfs = null;
				System.out.println("Erreur GFS");

			}
			long duration = System.currentTimeMillis() - start_time;
			gfsDuration3.add(duration);
			gfsMem3.add(gfs.getCompMem());
			gfsTemp3.add(gfs.getCompTemp());
			if (gfs == null)
				App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);
			else {

				if (resGFS3.get(resGFS3.size() - 1)) {
					gfsCout3.add(gfs.getEnd().getCout());
					gfsMouvement3.add(gfs.getEnd().getMove());
					App.saveSolutionToFile(a.getListPuzzle().get(i), gfs.getEnd(), "GFSInv", gfs.getCompMem(),
							gfs.getCompTemp(), duration);
				} else
					App.saveSolutionToFile(a.getListPuzzle().get(i), "GFS", duration);

			}

		}
		
		/*
		 * ArrayList<Boolean> resAstar = new ArrayList<>();
		 * 
		 * // Astar ArrayList<Long> astarDuration = new ArrayList(); ArrayList<Integer>
		 * astarMem = new ArrayList(); ArrayList<Integer> astarTemp = new ArrayList();
		 * ArrayList<Integer> astarMouvement = new ArrayList(); ArrayList<Integer>
		 * astarCout = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size();
		 * i++) { Astar astar = new Astar(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resAstar.add(astar.solve()); } catch
		 * (Exception e) { System.out.println("Erreur Astar");
		 * 
		 * } catch (OutOfMemoryError o) { astar = null;
		 * System.out.println("Erreur Astar");
		 * 
		 * } long duration = System.currentTimeMillis() - start_time;
		 * astarDuration.add(duration); astarMem.add(astar.getCompMem());
		 * astarTemp.add(astar.getCompTemp());
		 * 
		 * System.out.println("Done"); if (astar == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "Astar", duration); else {
		 * 
		 * if (resAstar.get(resAstar.size() - 1)) {
		 * astarCout.add(astar.getEnd().getCout());
		 * astarMouvement.add(astar.getEnd().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), astar.getEnd(), "Astar",
		 * astar.getCompMem(), astar.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "Astar", duration);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * ArrayList<Boolean> resUCS = new ArrayList<>();
		 */
		/*
		 * // BD ArrayList<Boolean> resBD = new ArrayList<>();
		 * 
		 * ArrayList<Long> bdDuration = new ArrayList(); ArrayList<Integer> bdMem = new
		 * ArrayList(); ArrayList<Integer> bdTemp = new ArrayList(); ArrayList<Integer>
		 * bdMouvement = new ArrayList(); ArrayList<Integer> bdCout = new ArrayList();
		 * for (int i = 0; i < a.getListPuzzle().size(); i++) { BD bd = new
		 * BD(a.getListPuzzle().get(i)); long start_time = System.currentTimeMillis();
		 * try { resBD.add(bd.solve());
		 * 
		 * } catch (Exception e) { System.out.println("Erreur BD"); } catch
		 * (OutOfMemoryError o) { bd = null; System.out.println("Erreur BD"); } long
		 * duration = System.currentTimeMillis() - start_time; bdDuration.add(duration);
		 * bdMem.add(bd.getCompMem()); bdTemp.add(bd.getCompTemp()); if (bd == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "BD", duration); else {
		 * if(resBD.get(resBD.size()-1)) { int bdC =0; int bdM =0;
		 * 
		 * if(bd.getPlat()!=null) { bdC=bdC+bd.getPlat().getCout();
		 * bdM=bdM+bd.getPlat().getMove(); } if(bd.getPlat2()!=null) {
		 * bdC+=bd.getPlat2().getCout(); bdM=bdM+bd.getPlat2().getMove();
		 * 
		 * } bdCout.add(bdC); bdMouvement.add(bdM);
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), bd, duration);
		 * 
		 * }else App.saveSolutionToFile(a.getListPuzzle().get(i), "BD", duration);
		 * 
		 * } }
		 */

		// UCS 
		/*
		 * ArrayList<Long> ucsDuration = new ArrayList(); ArrayList<Integer> ucsMem =
		 * new ArrayList(); ArrayList<Integer> ucsTemp = new ArrayList();
		 * ArrayList<Integer> ucsMouvement = new ArrayList(); ArrayList<Integer> ucsCout
		 * = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size(); i++) { UCS
		 * ucs = new UCS(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resUCS.add(ucs.solve()); } catch (Exception
		 * e) { System.out.println("Erreur UCS");
		 * 
		 * } catch (OutOfMemoryError o) { ucs = null; System.out.println("Erreur UCS");
		 * 
		 * } long duration = System.currentTimeMillis() - start_time;
		 * ucsDuration.add(duration); ucsMem.add(ucs.getCompMem());
		 * ucsTemp.add(ucs.getCompTemp()); if (ucs == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "UCS", duration); else {
		 * 
		 * if (resUCS.get(resUCS.size() - 1)) {
		 * ucsMouvement.add(ucs.getEnd().getCout());
		 * ucsCout.add(ucs.getEnd().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), ucs.getEnd(), "UCS",
		 * ucs.getCompMem(), ucs.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "UCS", duration);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * ArrayList<Boolean> resILS = new ArrayList<>();
		 * 
		 * // ILS ArrayList<Long> ilsDuration = new ArrayList(); ArrayList<Integer>
		 * ilsMem = new ArrayList(); ArrayList<Integer> ilsTemp = new ArrayList();
		 * ArrayList<Integer> ilsMouvement = new ArrayList(); ArrayList<Integer> ilsCout
		 * = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size(); i++) { ILS
		 * ils = new ILS(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resILS.add(ils.solve()); } catch (Exception
		 * e) { System.out.println("Erreur ILS");
		 * 
		 * } catch (OutOfMemoryError o) { ils = null; System.out.println("Erreur ILS");
		 * 
		 * } long duration = System.currentTimeMillis() - start_time;
		 * ilsDuration.add(duration); ilsMem.add(ils.getCompMem());
		 * ilsTemp.add(ils.getCompTemp()); if (ils == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "ILS", duration); else { if
		 * (resILS.get(resILS.size() - 1)) { ilsCout.add(ils.getEnd().getCout());
		 * ilsMouvement.add(ils.getEnd().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), ils.getEnd(), "ILS",
		 * ils.getCompMem(), ils.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "ILS", duration);
		 * 
		 * }
		 * 
		 * }
		 */

		/*
		 * // IDS ArrayList<Boolean> resIDS = new ArrayList<>();
		 * 
		 * ArrayList<Long> idsDuration = new ArrayList(); ArrayList<Integer> idsMem =
		 * new ArrayList(); ArrayList<Integer> idsTemp = new ArrayList();
		 * ArrayList<Integer> idsMouvement = new ArrayList(); ArrayList<Integer> idsCout
		 * = new ArrayList(); int limite = 0; for (int i = 0; i <
		 * a.getListPuzzle().size(); i++) { IDS ids = new IDS(a.getListPuzzle().get(i));
		 * long start_time = System.currentTimeMillis(); try { resIDS.add(ids.solve());
		 * } catch (Exception e) { System.out.println("Erreur IDS"); } catch
		 * (OutOfMemoryError o) { ids = null; System.out.println("Erreur IDS"); } long
		 * duration = System.currentTimeMillis() - start_time;
		 * idsDuration.add(duration); idsMem.add(ids.getCompMem());
		 * idsTemp.add(ids.getCompTemp()); if (ids == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "IDS", duration); else {
		 * 
		 * if (resIDS.get(resIDS.size() - 1)) { limite = ids.getCo();
		 * idsCout.add(ids.getEnd().getCout());
		 * idsMouvement.add(ids.getEnd().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), ids.getEnd(), "IDS",
		 * ids.getCompMem(), ids.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "IDS", duration);
		 * 
		 * } }
		 * 
		 * // DLS ArrayList<Boolean> resDLS = new ArrayList<>();
		 * 
		 * ArrayList<Long> dlsDuration = new ArrayList(); ArrayList<Integer> dlsMem =
		 * new ArrayList(); ArrayList<Integer> dlsTemp = new ArrayList();
		 * ArrayList<Integer> dlsMouvement = new ArrayList(); ArrayList<Integer> dlsCout
		 * = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size(); i++) { DLS
		 * dls = new DLS(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resDLS.add(dls.solve(limite,
		 * a.getListPuzzle().get(i))); } catch (Exception e) {
		 * System.out.println("Erreur DLS"); } catch (OutOfMemoryError o) { dls = null;
		 * System.out.println("Erreur DLS"); } long duration =
		 * System.currentTimeMillis() - start_time; dlsDuration.add(duration);
		 * dlsMem.add(dls.getCompMem()); dlsTemp.add(dls.getCompTemp()); if (dls ==
		 * null) App.saveSolutionToFile(a.getListPuzzle().get(i), "DLS", duration); else
		 * {
		 * 
		 * if (resDLS.get(resDLS.size() - 1)) {
		 * dlsCout.add(dls.getTruePlat().getCout());
		 * dlsMouvement.add(dls.getTruePlat().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), dls.getTruePlat(), "DLS",
		 * dls.getCompMem(), dls.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "DLS", duration);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * // BFS ArrayList<Boolean> resBFS = new ArrayList<>();
		 * 
		 * ArrayList<Long> bfsDuration = new ArrayList(); ArrayList<Integer> bfsMem =
		 * new ArrayList(); ArrayList<Integer> bfsTemp = new ArrayList();
		 * ArrayList<Integer> bfsMouvement = new ArrayList(); ArrayList<Integer> bfsCout
		 * = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size(); i++) { BFS
		 * bfs = new BFS(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resBFS.add(bfs.solve()); } catch (Exception
		 * e) { System.out.println("Erreur BFS"); } catch (OutOfMemoryError o) { bfs =
		 * null; System.out.println("Erreur BFS"); } long duration =
		 * System.currentTimeMillis() - start_time; bfsDuration.add(duration);
		 * bfsMem.add(bfs.getCompMem()); bfsTemp.add(bfs.getCompTemp()); if (bfs ==
		 * null) App.saveSolutionToFile(a.getListPuzzle().get(i), "BFS", duration); else
		 * { if (resBFS.get(resBFS.size() - 1)) {
		 * bfsCout.add(bfs.getTruePlat().getCout());
		 * bfsMouvement.add(bfs.getTruePlat().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), bfs.getTruePlat(), "BFS",
		 * bfs.getCompMem(), bfs.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "BFS", duration);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * // DFS ArrayList<Boolean> resDFS = new ArrayList<>();
		 * 
		 * ArrayList<Long> dfsDuration = new ArrayList(); ArrayList<Integer> dfsMem =
		 * new ArrayList(); ArrayList<Integer> dfsTemp = new ArrayList();
		 * ArrayList<Integer> dfsMouvement = new ArrayList(); ArrayList<Integer> dfsCout
		 * = new ArrayList(); for (int i = 0; i < a.getListPuzzle().size(); i++) { DFS
		 * dfs = new DFS(a.getListPuzzle().get(i)); long start_time =
		 * System.currentTimeMillis(); try { resDFS.add(dfs.solve());
		 * 
		 * } catch (Exception e) { System.out.println("Erreur DFS"); } catch
		 * (OutOfMemoryError o) { dfs = null; System.out.println("Erreur DFS"); } long
		 * duration = System.currentTimeMillis() - start_time;
		 * dfsDuration.add(duration); dfsMem.add(dfs.getCompMem());
		 * dfsTemp.add(dfs.getCompTemp()); if (dfs == null)
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "DFS", duration); else { if
		 * (resDFS.get(resDFS.size() - 1)) { dfsCout.add(dfs.getTruePlat().getCout());
		 * dfsMouvement.add(dfs.getTruePlat().getMove());
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), dfs.getTruePlat(), "DFS",
		 * dfs.getCompMem(), dfs.getCompTemp(), duration); } else
		 * App.saveSolutionToFile(a.getListPuzzle().get(i), "DFS", duration);
		 * 
		 * }
		 * 
		 * }
		 */

		System.out.println("Résultat GFS Manhattan");
		System.out.println("Succes");
		System.out.println(resGFS);
		System.out.println("Duration");
		System.out.println(gfsDuration);
		System.out.println("Memory");
		System.out.println(gfsMem);
		System.out.println("Temporelle");
		System.out.println(gfsTemp);
		System.out.println("Mouvement");
		System.out.println(gfsMouvement);
		System.out.println("Cout");
		System.out.println(gfsCout);
		System.out.println("Fin GFS Manhattan");
		
		System.out.println("Résultat GFS Hamming");
		System.out.println("Succes");
		System.out.println(resGFS2);
		System.out.println("Duration");
		System.out.println(gfsDuration2);
		System.out.println("Memory");
		System.out.println(gfsMem2);
		System.out.println("Temporelle");
		System.out.println(gfsTemp2);
		System.out.println("Mouvement");
		System.out.println(gfsMouvement2);
		System.out.println("Cout");
		System.out.println(gfsCout2);
		System.out.println("Fin GFS Hamming");
		
		System.out.println("Résultat GFS Inversion");
		System.out.println("Succes");
		System.out.println(resGFS3);
		System.out.println("Duration");
		System.out.println(gfsDuration3);
		System.out.println("Memory");
		System.out.println(gfsMem3);
		System.out.println("Temporelle");
		System.out.println(gfsTemp3);
		System.out.println("Mouvement");
		System.out.println(gfsMouvement3);
		System.out.println("Cout");
		System.out.println(gfsCout3);
		System.out.println("Fin GFS Inversion");

		/*
		 * System.out.println("Résultat Astar"); System.out.println("Succes");
		 * System.out.println(resAstar); System.out.println("Duration");
		 * System.out.println(astarDuration); System.out.println("Memory");
		 * System.out.println(astarMem); System.out.println("Temporelle");
		 * System.out.println(astarTemp); System.out.println("Mouvement");
		 * System.out.println(astarMouvement); System.out.println("Cout");
		 * System.out.println(astarCout); System.out.println("Fin Astar");
		 * 
		 * System.out.println("Résultat UCS"); System.out.println("Succes");
		 * System.out.println(resUCS); System.out.println("Duration");
		 * System.out.println(ucsDuration); System.out.println("Memory");
		 * System.out.println(ucsMem); System.out.println("Temporelle");
		 * System.out.println(ucsTemp); System.out.println("Mouvement");
		 * System.out.println(ucsMouvement); System.out.println("Cout");
		 * System.out.println(ucsCout); System.out.println("Fin UCS");
		 * 
		 * System.out.println("Résultat ILS"); System.out.println("Succes");
		 * System.out.println(resILS); System.out.println("Duration");
		 * System.out.println(ilsDuration); System.out.println("Memory");
		 * System.out.println(ilsMem); System.out.println("Temporelle");
		 * System.out.println(ilsTemp); System.out.println("Mouvement");
		 * System.out.println(ilsMouvement); System.out.println("Cout");
		 * System.out.println(ilsCout); System.out.println("Fin ILS");
		 */

		/*
		 * System.out.println("Résultat IDS"); System.out.println("Succes");
		 * System.out.println(resIDS); System.out.println("Duration");
		 * System.out.println(idsDuration); System.out.println("Memory");
		 * System.out.println(idsMem); System.out.println("Temporelle");
		 * System.out.println(idsTemp); System.out.println("Mouvement");
		 * System.out.println(idsMouvement); System.out.println("Cout");
		 * System.out.println(idsCout); System.out.println("Fin IDS");
		 * 
		 * System.out.println("Résultat DLS"); System.out.println("Succes");
		 * System.out.println(resDLS); System.out.println("Duration");
		 * System.out.println(dlsDuration); System.out.println("Memory");
		 * System.out.println(dlsMem); System.out.println("Temporelle");
		 * System.out.println(dlsTemp); System.out.println("Mouvement");
		 * System.out.println(dlsMouvement); System.out.println("Cout");
		 * System.out.println(dlsCout); System.out.println("Fin DLS");
		 * 
		 * System.out.println("Résultat BFS"); System.out.println("Succes");
		 * System.out.println(resBFS); System.out.println("Duration");
		 * System.out.println(bfsDuration); System.out.println("Memory");
		 * System.out.println(bfsMem); System.out.println("Temporelle");
		 * System.out.println(bfsTemp); System.out.println("Mouvement");
		 * System.out.println(bfsMouvement); System.out.println("Cout");
		 * System.out.println(bfsCout); System.out.println("Fin BFS");
		 * 
		 * System.out.println("Résultat BD"); System.out.println("Succes");
		 * System.out.println(resBD); System.out.println("Duration");
		 * System.out.println(bdDuration); System.out.println("Memory");
		 * System.out.println(bdMem); System.out.println("Temporelle");
		 * System.out.println(bdTemp); System.out.println("Mouvement");
		 * System.out.println(bdMouvement); System.out.println("Cout");
		 * System.out.println(bdCout); System.out.println("Fin BD");
		 */

		/*
		 * System.out.println("Résultat DFS"); System.out.println("Succes");
		 * System.out.println(resDFS); System.out.println("Duration");
		 * System.out.println(dfsDuration); System.out.println("Memory");
		 * System.out.println(dfsMem); System.out.println("Temporelle");
		 * System.out.println(dfsTemp); System.out.println("Mouvement");
		 * System.out.println(dfsMouvement); System.out.println("Cout");
		 * System.out.println(dfsCout); System.out.println("Fin DFS");
		 */

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
			writer.write(LocalDateTime.now() + " Complexité temporelle : " + bd.getCompTemp() + System.lineSeparator());
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

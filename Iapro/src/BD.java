import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BD {
	private Puzzle platform;
	private Puzzle platformf;
	private ArrayDeque<Puzzle> frontierf;
	private ArrayDeque<Puzzle> frontierb;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private Set<Puzzle> explored;
	private Puzzle Plat;
	private Puzzle Plat2;
	private int compTemp=0;
	private int compMem=0;

	public BD(Puzzle platform) {
		this.platform = platform;
		this.platformf = new Puzzle(platform);
		this.platformf.setEnd();
		this.frontierf = new ArrayDeque<Puzzle>();
		this.frontierb = new ArrayDeque<Puzzle>();
		this.explored = new HashSet<Puzzle>();
	}
	public int getCompTemp() {
		return compTemp;
	}

	public void setCompTemp(int compTemp) {
		this.compTemp = compTemp;
	}

	public int getCompMem() {
		return compMem;
	}

	public void setCompMem(int compMem) {
		this.compMem = compMem;
	}
	
	public Puzzle getPlat() {
		return Plat;
	}
	public void setPlat(Puzzle plat) {
		Plat = plat;
	}
	public Puzzle getPlat2() {
		return Plat2;
	}
	public void setPlat2(Puzzle plat2) {
		Plat2 = plat2;
	}
	public boolean bd() {
		if (this.platform.isSuccess()) {
			Plat= new Puzzle(platform);
			return true;

		}
		frontierf.add(platform);
		frontierb.add(platformf);
		explored.clear();
		Puzzle node;
		while(true) {
			long start_time = System.currentTimeMillis();
			long duration = System.currentTimeMillis() - start_time;
			while(duration<1000) {
				if(frontierf.isEmpty()||frontierb.isEmpty())
					return false;
				if(!frontierf.isEmpty()) {
					node = frontierf.pop();
					compTemp++;
					explored.add(node);
					for (String b : ACTIONS) {
						Puzzle child = new Puzzle(node);
						compTemp++;
						if(b.equals("H")){
							if(node.moveHaut2()) {
								child.Haut();
							}
						}
						if(b.equals("B")){
							if(node.moveBas2()) {
								child.Bas();
							
							}
						}
						if(b.equals("D")){
							if(node.moveDroite2()) {
								child.Droite();
							}
						}
						if(b.equals("G")){
							if(node.moveGauche2()) {
								child.Gauche();
							}
						}
						if(node.isSuccess()|| frontierb.contains(node)) {
							if(frontierb.contains(node)) {
								Plat= new Puzzle(node);
								compTemp++;

								Puzzle p = null;

								Iterator<Puzzle> it = frontierb.iterator();
								while(it.hasNext()) {
									p = it.next();
									if(p.printS().equals(node.printS())) {
										break;
									}
								}
								Plat2 = new Puzzle(p);
								return true;
							}else {
								Plat= new Puzzle(node);
								return true;

							}
								
						}
						if (!frontierf.contains(child)&&!explored.contains(child)) {
							frontierf.add(child);
						}
				}}
				if(!frontierb.isEmpty()) {
					node = frontierb.pop();
					compTemp++;
					explored.add(node);
					for (String b : ACTIONS) {
						Puzzle child = new Puzzle(node);
						compTemp++;
						if(b.equals("H")){
							if(node.moveHaut2()) {
								child.Haut();
							}
						}
						if(b.equals("B")){
							if(node.moveBas2()) {
								child.Bas();
							
							}
						}
						if(b.equals("D")){
							if(node.moveDroite2()) {
								child.Droite();
							}
						}
						if(b.equals("G")){
							if(node.moveGauche2()) {
								child.Gauche();
							}
						}
						if(frontierf.contains(node)) {
							Plat= new Puzzle(node);
							compTemp++;

							Puzzle p = null;

							Iterator<Puzzle> it = frontierf.iterator();
							while(it.hasNext()) {
								p = it.next();
								if(p.printS().equals(node.printS())) {
									break;
								}
							}
							Plat2 = new Puzzle(p);
							compTemp++;
							return true;
						}
						if (!frontierb.contains(child)&&!explored.contains(child)) {
							frontierb.add(child);
						}
				}
				
			}
			}
			
			return false;
		
	}
}

	public boolean solve() {
		boolean check = bd();
		
		compMem= this.frontierb.size()+this.frontierf.size()+this.explored.size();
		if (check) {
			if(Plat2!=null) {
				System.out.println(this.Plat.getListMove().size()+this.Plat2.getListMove().size());

				  

			    for (int i =0; i<Plat.getListMove().size();i++) {

			      

			      

			      

			        System.out.println(Plat.getListMove().get(i));

			      

			      

			      

			        }
			    
			    //System.out.println(this.Plat2.getListMove().size());
			    ArrayList<String> a = new ArrayList<>();
			   //Collections.reverse(Plat2.getListMove());
				  
			    //Plat2.setListMove(Plat2.getListMove());
			    
			    for (int i =0; i<Plat2.getListMove().size();i++) {

			      

			      

			      

			        a.add(Plat2.getListMove().get(i));

			      

			      

			      

			        }
			    System.out.println("-----------------------");
			    Collections.reverse(a);

			    for (int i =0; i<a.size();i++) {

				      

				      

				      

			        System.out.println(a.get(i));

			      

			      

			      

			        }
			}else {
				System.out.println(this.Plat.getListMove().size());

				  

			    for (int i =0; i<Plat.getListMove().size();i++) {

			      

			      

			      

			        System.out.println(Plat.getListMove().get(i));

			      

			      

			      

			        }
			}
			 return true;
		}else {
			return false;
		}
		
	   

	}
	
	
}

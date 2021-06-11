import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ILS {
	
	private int profondeur;
	private Puzzle racine;
	private ArrayList<Puzzle> frontiere;
	private ArrayList<Puzzle> frontiereTmp;
	private Set<Puzzle> explore;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private Puzzle solution;
	
	public ILS(Puzzle racine) {
		this.racine =racine;
		this.profondeur = 0;
		this.frontiere = new ArrayList<Puzzle>();
		this.frontiereTmp = new ArrayList<Puzzle>();
		this.explore = new HashSet<Puzzle>();
		this.solution = racine;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	public Puzzle getRacine() {
		return racine;
	}

	public void setRacine(Puzzle racine) {
		this.racine = racine;
	}

	public ArrayList<Puzzle> getFrontiere() {
		return frontiere;
	}

	public void setFrontiere(ArrayList<Puzzle> frontiere) {
		this.frontiere = frontiere;
	}

	public Set<Puzzle> getExplore() {
		return explore;
	}

	public void setExplore(Set<Puzzle> explore) {
		this.explore = explore;
	}
	
	
	
	public Puzzle getEnd() {
		return solution;
	}

	public void setSolution(Puzzle solution) {
		this.solution = solution;
	}
	
	public void copieFrontiereTmpDansFrontiere() {
		for(int i = 0; i<this.frontiereTmp.size();i++) {
			this.frontiere.add(this.frontiereTmp.get(i));
		}
	}

	public boolean ils() {
		if (this.racine.isSuccess())
			return true;
		this.frontiere.add(this.racine);
		while(true) {
			if (this.frontiere.isEmpty()) {
				return false;
			}
				
			this.profondeur = this.profondeur+1;
			for (int i = 0 ; i<this.frontiere.size();i++) {
				Puzzle b = this.frontiere.get(0);
				for (String a : ACTIONS) {
					Puzzle child = new Puzzle(b);
					if(a.equals("H")){
						if(b.moveHaut()&&b.getLastAction()!="B") {
							child.Haut();
							if(!this.explore.contains(child) && !this.frontiere.contains(child) && !this.frontiereTmp.contains(child)) {
								this.frontiereTmp.add(child);
							}
								
						}
					}
					if(a.equals("B")){
						if(b.moveBas()&&b.getLastAction()!="H") {
							child.Bas();
							if(!this.explore.contains(child) && !this.frontiere.contains(child) && !this.frontiereTmp.contains(child)) {
								this.frontiereTmp.add(child);
							}
						}
					}
					if(a.equals("D")){
						if(b.moveDroite()&&b.getLastAction()!="G") {
							child.Droite();
							if(!this.explore.contains(child) && !this.frontiere.contains(child) && !this.frontiereTmp.contains(child)) {
								this.frontiereTmp.add(child);
							}
						}
					}
					if(a.equals("G")){
						if(b.moveGauche()&&b.getLastAction()!="D") {
							child.Gauche();
							if(!this.explore.contains(child) && !this.frontiere.contains(child) && !this.frontiereTmp.contains(child)) {
								this.frontiereTmp.add(child);
							}
						}
					}
				}
			
			this.frontiere.remove(b);
			}
			this.copieFrontiereTmpDansFrontiere();
			for(Puzzle b : frontiere) {
				if(b.isSuccess()) {
					System.out.println(b);
					this.solution = b;
					return true;
				}
				else {
					this.explore.add(b);
				}
			}
		}
	}
}

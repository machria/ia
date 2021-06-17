import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GFS {
	private Puzzle racine;
	private TreeSet<Puzzle> frontiere;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private Set<Puzzle> explored;
	private Puzzle end;
	
	public GFS(Puzzle racine) {
		this.racine = new Puzzle(racine);
		this.end = new Puzzle(racine);
		this.explored = new HashSet<Puzzle>();
		this.frontiere = new TreeSet<Puzzle>();
	}
	
	public int Score(Puzzle puzzle, String action) {
		int x = 0;
		int y = 0;
		int score;
		for (int i=0;i<puzzle.getN();i++) {
			for(int j=0;j<puzzle.getN();j++) {
				if(puzzle.getTab()[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		if(action.equals("H")) {
			if(puzzle.getTab()[x-1][y]%2==0) {
				return puzzle.getScore()+1;
			}
			else {
				return puzzle.getScore()+2;
			}
		}
		else if(action.equals("B")) {
			if(puzzle.getTab()[x+1][y]%2==0) {
				return puzzle.getScore()+1;
			}
			else {
				return puzzle.getScore()+2;
			}
		}
		else if(action.equals("G")) {
			if(puzzle.getTab()[x][y-1]%2==0) {
				return puzzle.getScore()+1;
			}
			else {
				return puzzle.getScore()+2;
			}
		}
		else {
			if(puzzle.getTab()[x][y+1]%2==0) {
				return puzzle.getScore()+1;
			}
			else {
				return puzzle.getScore()+2;
			}
		}
	}
	
	public int Score2(Puzzle puzzle, String action) {
		int score;
		Puzzle tmp = new Puzzle(puzzle);
		if(action.equals("H")) {
			tmp.Haut();
			score = tmp.manhattam();
		}	
		else if(action.equals("B")) {
			tmp.Bas();
			score = tmp.manhattam();
		}
		else if(action.equals("G")) {
			tmp.Gauche();
			score = tmp.manhattam();
		}
		else {
			tmp.Droite();
			score = tmp.manhattam();
		}
		return score;
	}

	public Puzzle getRacine() {
		return racine;
	}

	public void setRacine(Puzzle racine) {
		this.racine = racine;
	}

	public TreeSet<Puzzle> getFrontiere() {
		return frontiere;
	}

	public void setFrontiere(TreeSet<Puzzle> frontiere) {
		this.frontiere = frontiere;
	}

	public Set<Puzzle> getExplored() {
		return explored;
	}

	public void setExplored(Set<Puzzle> explored) {
		this.explored = explored;
	}

	public Puzzle getEnd() {
		return end;
	}

	public void setEnd(Puzzle end) {
		this.end = end;
	}
	
	

	public boolean gfs() {
		if (this.racine.isSuccess())
			return true;
		this.frontiere.add(this.end);
		System.out.println(this.frontiere+"------------------------\n");
		while (true) {
			if (this.frontiere.isEmpty())
				return false;
			System.out.println(this.frontiere+"------------------------\n");
			Puzzle node = this.frontiere.pollFirst();
			this.explored.add(node);
			
			/*
			 * Iterator<Puzzle> itz = frontiere.iterator(); while(itz.hasNext()) {
			 * System.out.println(itz.next().getScore()); } System.out.println(
			 * "---------------------------------------------------------");
			 */
			
			for (String b : ACTIONS) {
				Puzzle child = new Puzzle(node);
				if(b.equals("H")){
					if(node.moveHaut()) {
						child.setScore(this.Score2(child, "H"));
						child = child.Haut();
						System.out.println("je suis dans haut");
					}
				}
				else if(b.equals("B")){
					if(node.moveBas()) {
						child.setScore(this.Score2(child, "B"));
						child = child.Bas();
					}
				}
				else if(b.equals("D")){
					if(node.moveDroite()) {
						child.setScore(this.Score2(child, "D"));
						child=child.Droite();
					}
				}
				else{
					if(node.moveGauche()) {
						child.setScore(this.Score2(child, "G"));
						child=child.Gauche();
					}
				}
				if(!this.explored.contains(child) && !this.frontiere.contains(child)) {
					if(child.isSuccess()) {
						this.end = child;
						return true;
					}
					this.frontiere.add(child);
					System.out.println("ajout");
				}
			}
			
		}
	}
	public boolean solve() {
		boolean check = gfs();
		if(check) {
			System.out.println(this.getEnd().getListMove().size());
			System.out.println(this.getFrontiere().size()+this.getExplored().size());
			for (int i =0; i<this.getEnd().getListMove().size();i++) {
				System.out.println(this.getEnd().getListMove().get(i));
			}
			System.out.println(this.getEnd().getScore());
			return true;
		}else {
			System.out.println(this.getFrontiere().size()+this.getExplored().size());
			return false;
		}
	}
	
}

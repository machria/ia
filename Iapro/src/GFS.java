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
	private int compTemp=0;
	private int compMem=0;
	public String h;
	
	public GFS(Puzzle racine) {
		this.racine = new Puzzle(racine);
		this.end = new Puzzle(racine);
		this.explored = new HashSet<Puzzle>();
		this.frontiere = new TreeSet<Puzzle>();
		h="M";
	}
	
	public GFS(Puzzle racine,String h) {
		this.racine = new Puzzle(racine);
		this.end = new Puzzle(racine);
		this.explored = new HashSet<Puzzle>();
		this.frontiere = new TreeSet<Puzzle>();
		this.h=h;
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
		if(this.h.equals("M")) {
			int score;
			Puzzle tmp = new Puzzle(puzzle);
			if(action.equals("H")) {
				tmp.Haut();
				score = tmp.manhattan();
			}	
			else if(action.equals("B")) {
				tmp.Bas();
				score = tmp.manhattan();
			}
			else if(action.equals("G")) {
				tmp.Gauche();
				score = tmp.manhattan();
			}
			else {
				tmp.Droite();
				score = tmp.manhattan();
			}
			return score;
		}else if(this.h.equals("h")) {
			int score;
			Puzzle tmp = new Puzzle(puzzle);
			if(action.equals("H")) {
				tmp.Haut();
				score = tmp.hamming();
			}	
			else if(action.equals("B")) {
				tmp.Bas();
				score = tmp.hamming();
			}
			else if(action.equals("G")) {
				tmp.Gauche();
				score = tmp.hamming();
			}
			else {
				tmp.Droite();
				score = tmp.hamming();
			}
			return score;
		}else {
			int score;
			Puzzle tmp = new Puzzle(puzzle);
			if(action.equals("H")) {
				tmp.Haut();
				score = tmp.inversion();
			}	
			else if(action.equals("B")) {
				tmp.Bas();
				score = tmp.inversion();
			}
			else if(action.equals("G")) {
				tmp.Gauche();
				score = tmp.inversion();
			}
			else {
				tmp.Droite();
				score = tmp.inversion();
			}
			return score;
		}
		
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
		long start_time = System.currentTimeMillis();
		long duration = System.currentTimeMillis() - start_time;
		
			while (true) {
				while(duration<1000) {
					duration = System.currentTimeMillis() - start_time;
				if (this.frontiere.isEmpty())
					return false;
				Puzzle node = this.frontiere.pollFirst();
				compTemp++;
				this.explored.add(node);
				
				/*
				 * Iterator<Puzzle> itz = frontiere.iterator(); while(itz.hasNext()) {
				 * System.out.println(itz.next().getScore()); } System.out.println(
				 * "---------------------------------------------------------");
				 */
				
				for (String b : ACTIONS) {
					Puzzle child = new Puzzle(node);
					compTemp++;
					if(b.equals("H")){
						if(node.moveHaut()) {
							child.setScore(this.Score2(child, "H"));
							child = child.Haut();
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
					}
				}
				
			}
				return false;

		}
	}
	public boolean solve() {
		boolean check = gfs();
		compMem=this.getFrontiere().size()+this.getExplored().size();
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

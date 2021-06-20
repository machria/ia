import java.util.HashSet;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.TreeSet;
public class Astar {
	

		
		private Puzzle racine;
		private TreeSet<Puzzle> frontiere;
		private static final String[] ACTIONS = { "H", "B", "G", "D" };
		private Set<Puzzle> explored;
		private Puzzle end;
		private int compTemp=0;
		private int compMem=0;
		
		public Astar(Puzzle racine) {
			this.racine = racine;
			this.end = racine;
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
					return puzzle.getScore()+1+puzzle.manhattan();
				}
				else {
					return puzzle.getScore()+2+puzzle.manhattan();
				}
			}
			else if(action.equals("B")) {
				if(puzzle.getTab()[x+1][y]%2==0) {
					return puzzle.getScore()+1+puzzle.manhattan();
				}
				else {
					return puzzle.getScore()+2+puzzle.manhattan();
				}
			}
			else if(action.equals("G")) {
				if(puzzle.getTab()[x][y-1]%2==0) {
					return puzzle.getScore()+1+puzzle.manhattan();
				}
				else {
					return puzzle.getScore()+2+puzzle.manhattan();
				}
			}
			else {
				if(puzzle.getTab()[x][y+1]%2==0) {
					return puzzle.getScore()+1+puzzle.manhattan();
				}
				else {
					return puzzle.getScore()+2+puzzle.manhattan();
				}
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
		
		

		public boolean astar() {
			if (this.racine.isSuccess())
				return true;
			this.frontiere.add(this.end);
			long start_time = System.currentTimeMillis();
			long duration = System.currentTimeMillis() - start_time;
			
				while (true) {
					while(duration<5000) {
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
							if(node.moveHaut()&&node.getLastAction()!="B") {
								child.setScore(this.Score(child, "H"));
								child.Haut();
							}
						}
						if(b.equals("B")){
							if(node.moveBas()&&node.getLastAction()!="H") {
								child.setScore(this.Score(child, "B"));
								child.Bas();
							}
						}
						if(b.equals("D")){
							if(node.moveDroite()&&node.getLastAction()!="G") {
								child.setScore(this.Score(child, "D"));
								child.Droite();
							}
						}
						if(b.equals("G")){
							if(node.moveGauche()&&node.getLastAction()!="D") {
								child.setScore(this.Score(child, "G"));
								child.Gauche();
							}
						}
						if(!this.explored.contains(child) && !this.frontiere.contains(child)) {
							if(child.isSuccess()) {
								this.end = child;
								return true;
							}
							this.frontiere.add(child);
						}
						Puzzle p = new Puzzle();
						if(this.frontiere.contains(child)) {
							Iterator<Puzzle> it = frontiere.iterator();
							while(it.hasNext()) {
								p = it.next();
								if(p.getTab().equals(child.getTab())) {
									break;
								}
							}
							if(p.getScore()>child.getScore()) {
								this.frontiere.remove(p);
								this.frontiere.add(child);
							}
						}
					}
				}
					return false;
				}
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

	public boolean solve() {
			boolean check = astar();
			compMem=this.frontiere.size()+this.getExplored().size();

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

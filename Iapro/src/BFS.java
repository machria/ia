import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {
	private Puzzle platform;
	private Queue<Puzzle> frontier;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private Set<Puzzle> explored;
	private Puzzle truePlat;

	public BFS(Puzzle platform) {
		this.platform = platform;
		this.truePlat = platform;
		this.frontier = new ArrayDeque<Puzzle>();
		this.explored = new HashSet<Puzzle>();
	}

	public boolean bfs() {
		if (this.platform.isSuccess())
			return true;
		this.frontier.add(this.truePlat);
		while (true) {
			if (this.frontier.isEmpty())
				return false;
			System.out.println(this.frontier.size());
			System.out.println(this.explored.size());
			Puzzle node = this.frontier.poll();
			this.explored.add(node);
			node.print();
			
			for (String b : ACTIONS) {
				Puzzle child = new Puzzle(node);
				if(b.equals("H")){
					if(node.moveHaut()) {
						child.Haut();
					}
				}
				if(b.equals("B")){
					if(node.moveBas()) {
						child.Bas();
					}
				}
				if(b.equals("D")){
					if(node.moveDroite()) {
						child.Droite();
					}
				}
				if(b.equals("G")){
					if(node.moveGauche()) {
						child.Gauche();
					}
				}
				if(!this.explored.contains(child) && !this.frontier.contains(child)) {
					if(child.isSuccess()) {
						this.truePlat = child;
						return true;
					}
					this.frontier.add(child);
				}
			}
			

		}
	}

	public Puzzle getPlatform() {
		return platform;
	}

	public void setPlatform(Puzzle platform) {
		this.platform = platform;
	}

	public Queue<Puzzle> getFrontier() {
		return frontier;
	}

	public void setFrontier(Queue<Puzzle> frontier) {
		this.frontier = frontier;
	}

	public Set<Puzzle> getExplored() {
		return explored;
	}

	public void setExplored(Set<Puzzle> explored) {
		this.explored = explored;
	}

	public Puzzle getTruePlat() {
		return truePlat;
	}

	public void setTruePlat(Puzzle truePlat) {
		this.truePlat = truePlat;
	}

	public static String[] getActions() {
		return ACTIONS;
	}

}

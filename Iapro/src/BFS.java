import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {
	private Puzzle platform;
	private Queue<Puzzle> frontier;
	private static final String[] ACTIONS = {"H","B","G","D"};
	private Set explored;
	private Puzzle truePlat;
	
	
	public BFS(Puzzle platform) {
		this.platform = platform;
		this.truePlat = platform;
		this.frontier = new ArrayDeque<Puzzle>();
		this.explored = new HashSet<Puzzle>();
	}



	public boolean bfs() {
		if(this.platform.isSuccess())
			return true;
		this.frontier.add(this.truePlat);
		while (true) {
			if(this.frontier.isEmpty())
				return false;
			Puzzle node = this.frontier.poll();
			this.explored.add(node);
			for(String b :ACTIONS) {
				switch(b) {
				case "H": 
					if(node.moveHaut()) {
						node.Haut();
					}
					break;
				case "B ": if(node.moveBas()) {
					node.Bas();
				}
					break;
				case "G":if(node.moveGauche()) {
					node.Gauche();
				}
					break;
				case "D": if(node.moveDroit()) {
					node.Droite();
				}
					break;
				default:
					break;
				}
			}
			
		}
	}
	
	
}

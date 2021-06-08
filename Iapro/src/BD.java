import java.util.ArrayDeque;
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

	public BD(Puzzle platform) {
		this.platform = platform;
		this.platformf = new Puzzle(platform);
		this.platformf.setEnd();
		this.frontierf = new ArrayDeque<Puzzle>();
		this.frontierb = new ArrayDeque<Puzzle>();
		this.explored = new HashSet<Puzzle>();
	}
	public boolean bd() {
		if (this.platform.isSuccess())
			return true;
		frontierf.add(platform);
		frontierb.add(platformf);
		explored.clear();
		Puzzle node;
		while(true) {
			if(frontierf.isEmpty()||frontierb.isEmpty())
				return false;
			if(!frontierf.isEmpty()) {
				node = frontierf.pop();
				explored.add(node);
				for (String b : ACTIONS) {
					Puzzle child = new Puzzle(node);
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
							Puzzle p = null;

							Iterator<Puzzle> it = frontierb.iterator();
							while(it.hasNext()) {
								p = it.next();
								if(p.getTab().equals(node.getTab())) {
									break;
								}
							}
							Plat2 = new Puzzle(p);
							return true;
						}else
						return true;
					}
					if (!frontierf.contains(child)&&!explored.contains(child)) {
						frontierf.add(child);
					}
			}}
			if(!frontierb.isEmpty()) {
				node = frontierb.pop();
				explored.add(node);
				for (String b : ACTIONS) {
					Puzzle child = new Puzzle(node);
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
						Puzzle p = null;

						Iterator<Puzzle> it = frontierf.iterator();
						while(it.hasNext()) {
							p = it.next();
							if(p.getTab().equals(node.getTab())) {
								break;
							}
						}
						Plat2 = new Puzzle(p);
						return true;
					}
					if (!frontierb.contains(child)&&!explored.contains(child)) {
						frontierb.add(child);
					}
			}
			
		}
			
		
	}
}

	public Puzzle getEnd() {
		return Plat;
	}
	
	
}

public class DLS {
	private Puzzle platform;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private Puzzle truePlat;
	private Puzzle node;
	
	public DLS(Puzzle platform) {
		this.platform = platform;
		this.truePlat = platform;
		this.node=platform;
		
	}
	
	public Puzzle getTruePlat() {
		return truePlat;
	}

	public void setTruePlat(Puzzle truePlat) {
		this.truePlat = truePlat;
	}

	public Puzzle dls(Puzzle node, int limit) throws Exception {
		if(node.isSuccess()) {
			truePlat=node;
			return node;
		}
		else if(limit==0) {
			return null;
		}else {
			boolean cutoff=false;
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
				Puzzle result  = DLS(child,limit-1);
				if (result==null)
						cutoff=true;
				else {
					truePlat=result;
					return result;

				}
		}
			if (cutoff)
					return null; 
				else
					throw new Exception("Faillure");
	}
	}
	public void solve(int limite, Puzzle p) {
		Puzzle check = dls(p,limite);
		if(check.isSuccess()) {
		}
		
	}
}
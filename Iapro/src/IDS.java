
public class IDS {
	private DLS dls;
	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

	private Puzzle platform;
	private int co=0;
	private int compTemp=0;
	private int compMem=0;
	
	public IDS(Puzzle platform) {
		this.platform = platform;
		dls = new DLS(platform);
		co=0;
	}
	
	public int ids() throws Exception {
		while(!dls.getTruePlat().isSuccess()) {
			dls.dls(platform, co);
			//System.out.println(c);
				co++;
			
		}
		return co;
	}
	
	public Puzzle getEnd() {
		return dls.getTruePlat();
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
	
	public boolean solve() throws Exception {
		int t = ids();
		System.out.println(this.getEnd().getListMove().size());
		System.out.println(t);
		for (int i =0; i<this.getEnd().getListMove().size();i++) {
			System.out.println(this.getEnd().getListMove().get(i));
		}
		System.out.println(this.getEnd().getScore());
		return true;
		
	}
}


public class IDS {
	private DLS dls;
	private Puzzle platform;
	private int co=0;
	
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

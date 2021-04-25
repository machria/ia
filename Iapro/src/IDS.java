
public class IDS {
	private DLS dls;
	private Puzzle platform;
	private Puzzle truePlat;
	
	public IDS(Puzzle platform) {
		this.platform = platform;
		this.truePlat = platform;
		dls = new DLS(platform);
	}
	
	public int ids() throws Exception {
		int c = 0;
		while(dls.DLS(platform, c)==null) {
				c++;
			
		}
		while(!dls.DLS(platform, c).isSuccess()) {
			c++;
		}
		return c;
	}
}

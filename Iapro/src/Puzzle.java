import java.util.ArrayList;
import java.util.Collections;

public class Puzzle {
	
	private int n;
	private int[][] tab;
	
	public Puzzle(int n) {
		this.n = n;
		this.tab =new int[n][n];
		init();
	}
	
	public void init() {
		int valueMax = (n*n)-1;
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 1;i<=valueMax;i++) {
			a.add(i);
		}
		a.add(-1);
		Collections.shuffle(a);
		int k = 0;
			for (int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					tab[i][j]=a.get(k);
					k++;
				}
			}
		
		
	}
	
	public void print() {
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1)
					System.out.print("b");
				else
					System.out.print(tab[i][j]);
				if (j==n-1)
					System.out.println();
				else
					System.out.print("|");
			}
		}
	}
	
	

}

import java.util.ArrayList;
import java.util.Collections;

public class Puzzle {
	
	private int n;
	private int[][] tab;
	private int[][] tabS;
	
	public Puzzle(int n) {
		this.n = n;
		this.tab =new int[n][n];
		this.tabS =new int[n][n];

		init();
	}
	
	public void init() {
		int valueMax = (n*n)-1;
		ArrayList<Integer> a = new ArrayList<>();
		tabS[0][0]=-1;
		for(int i = 1;i<=valueMax;i++) {
			a.add(i);
			
		}
		a.add(-1);
		int d=1;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i+j!=0) {
					tabS[i][j]=d;
					d++;
				}
				
			}
		}
			
		
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
	
	public boolean isSuccess() {
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]!=tabS[i][j]) {
					//System.out.println(tab[i][j]+"/"+tabS[i][j]);
					return false;

				}
			}
		}
		
		return true;
	}
	
	public void move(int a) {
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		boolean change = false;
		if(x-1>=0) {
			if(!change && tab[x-1][y]==a) {
				change = true;
				tab[x][y]=a;
				tab[x-1][y]=-1;
			}
			
		}
		if(!change && x+1<n &&tab[x+1][y]==a) {
			change = true;
			tab[x+1][y]=-1;
			tab[x][y]=a;

		}

		if(!change &&y-1>=0) {
			if(!change && tab[x][y-1]==a) {
				change = true;
				tab[x][y]=a;
				tab[x][y-1]=-1;
			}
		
		}
		if(!change && y+1< n && tab[x][y+1]==a) {
			change = true;
			tab[x][y]=a;
			tab[x][y+1]=-1;
		}
			
	}
	

}

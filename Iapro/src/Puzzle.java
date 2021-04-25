import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Puzzle {
	
	

	private int n;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private int[][] tab;
	private int[][] tabS;
	private int move=0;
	private ArrayList<String> listMove=new ArrayList<>();
	private int score;
	
	public Puzzle(int n) {
		this.n = n;
		this.tab =new int[n][n];
		this.tabS =new int[n][n];
		this.score =0;
		init();
	}
	
	public Puzzle() {
		
	}
	
	public Puzzle(Puzzle x) {
		this.n = x.n;
		this.tab =new int[n][n];
		this.tabS =new int[n][n];
		this.init();
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tab[i][j]=x.tab[i][j];
			}
		}
		this.tabS=x.tabS;
		this.move=x.move;
		for (int i =0; i<x.getListMove().size();i++) {
			this.listMove.add(x.getListMove().get(i));
		}
		this.score=0;
	}
	
	
	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public ArrayList<String> getListMove() {
		return listMove;
	}

	public void setListMove(ArrayList<String> listMove) {
		this.listMove = listMove;
	}

	public int[][] getTab() {
		return tab;
	}


	public void setTab(int[][] tab) {
		this.tab = tab;
	}


	public int[][] getTabS() {
		return tabS;
	}


	public void setTabS(int[][] tabS) {
		this.tabS = tabS;
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
	
	public void played() {
		String s="";
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1)
					s+="b";
				else
					s+=tab[i][j];
				if (j==n-1)
					s+="\n";
				else
					s+="|";
			}
		}
		listMove.add(s);
		move++;
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
				tab[x-1][y]=-1; //Bas
			}
			
		}
		if(!change && x+1<n &&tab[x+1][y]==a) {
			change = true;
			tab[x+1][y]=-1;
			tab[x][y]=a;//Haut

		}

		if(!change &&y-1>=0) {
			if(!change && tab[x][y-1]==a) {
				change = true;
				tab[x][y]=a;
				tab[x][y-1]=-1;//Gauche
			}
		
		}
		if(!change && y+1< n && tab[x][y+1]==a) {
			change = true;
			tab[x][y]=a;
			tab[x][y+1]=-1; //Droite
		}
			
	}
	public boolean moveBas() {
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
		if(!change && x+1<n ) {
			change = true;
			return true;

		}
		return false;
		
	}
	public boolean moveHaut() {
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
			if(!change ) {
				change = true;
				return true;
			}
			
		}
		return false;
	}
	public boolean moveDroite() {
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
		if(!change && y+1< n ) {
			change = true;
			return true;
		}
		return false;
	}
	public boolean moveGauche() {
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
		if(!change &&y-1>=0) {
			if(!change) {
				change = true;
				return true;
			}
		
		}
		return false;
	}
	public Puzzle Bas() {
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		tab[x][y]=tab[x+1][y];//Haut
		tab[x+1][y]=-1;
		played();
		return this;
	}
	public Puzzle Haut() {
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		tab[x][y]=tab[x-1][y];
		tab[x-1][y]=-1; //Bas
		played();
		return this;
	}
	public Puzzle Droite() {
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		tab[x][y]=tab[x][y+1];
		tab[x][y+1]=-1; //Droite
		played();
		return this;
	}
	public Puzzle Gauche() {
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		tab[x][y]=tab[x][y-1];
		tab[x][y-1]=-1;//Gauche
		played();
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n;
		result = prime * result + Arrays.deepHashCode(tab);
		result = prime * result + Arrays.deepHashCode(tabS);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puzzle other = (Puzzle) obj;
		if (n != other.n)
			return false;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]!=other.tab[i][j]) {
					return false;
				}
			}
		}
			
		return true;
	}
	
	public void init2() {
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
		
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tab[i][j]=tabS[i][j];
					

				
			}
		}
		
		
		for (int i = 0 ; i < 100; i++) {
			for(String b :ACTIONS) {
				switch(b) {
				case "H": 
					if(this.moveHaut()) {
						this.Haut();
					}
					break;
				case "B ": if(this.moveBas()) {
					this.Bas();
				}
					break;
				case "G":if(this.moveGauche()) {
					this.Gauche();
				}
					break;
				case "D": if(this.moveDroite()) {
					this.Droite();
				}
					break;
				default:
					break;
				}
		}
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

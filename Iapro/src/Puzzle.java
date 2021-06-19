import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Puzzle implements Comparable {
	
	

	private int n;
	private static final String[] ACTIONS = { "H", "B", "G", "D" };
	private int[][] tab;
	private int[][] tabS;
	private int move=0;
	private int cout=0;
	private ArrayList<String> listMove=new ArrayList<>();
	private int score;
	private HashMap<Integer,String>  solMan = new HashMap<>();
	private HashMap<Integer,String>  depMan = new HashMap<>();
	private String lastAction="";
	
	public Puzzle(int n) {
		this.n = n;
		this.tab =new int[n][n];
		this.tabS =new int[n][n];
		this.score =0;
		init();
		initialisation();
		 
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
		this.score=x.score;
		this.cout=x.cout;
	}
	
	
	public Puzzle(int size_enter, int[][] valeurs) {
		this.n = size_enter;
		this.tab =new int[n][n];
		this.tabS =new int[n][n];
		this.init();
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tab[i][j]=valeurs[i][j];
			}
		}
		this.print();
		System.out.println(this.inversion());
	}
	public String getTabSuc() {
		String s="";
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tabS[i][j]==-1)
					s+="b";
				else
					s+=tabS[i][j];
				if (j==n-1)
					s+="\n";
				else
					s+="|";
			}
		}
		return s;
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


	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
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
	
	public void setEnd() {
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
			
		
		//Collections.shuffle(a);
		int k = 0;
			for (int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
						tab[i][j]=a.get(k);
						k++;
					
						
					
				}
			}
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
			
		/*
		 * Collections.shuffle(a); int k = 0; for (int i=0;i<n;i++) { for(int
		 * j=0;j<n;j++) { tab[i][j]=a.get(k); k++;
		 * 
		 * 
		 * 
		 * } }
		 */
		
		
	}
	
	public void initialisation() {
		ArrayList<Integer> valeur = new ArrayList<Integer>();
		ArrayList<Integer> valeurTmp = new ArrayList<Integer>();
		boolean realisable = false;
		int nombreAlea;
		while(realisable==false) {
			valeur.add(-1);
			for(int i = 1;i<this.n*this.n;i++) {
				valeur.add(i);
			}
			while(!valeur.isEmpty()) {
				nombreAlea = (int)(Math.random()*valeur.size()-1);
				valeurTmp.add(valeur.get(nombreAlea));
				valeur.remove(nombreAlea);
			}
			int index=0;
			for (int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					tab[i][j]=valeurTmp.get(index);
					index++;
				}
			}
			if(this.realisable()) {
				System.out.println("Voici l'ordre des valeurs du puzzle :\n");
				System.out.println(valeurTmp+"\n");
				System.out.println("Voici le puzzle initialisé :\n");
				this.print();
				realisable=true;
			}
			valeurTmp.clear();
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
	public String printS() {
		String s="";
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1)
					s=s+"b";
				else
					s=s+tab[i][j];
				if (j==n-1)
					s=s+"\n";
				else
					s=s+"|";
			}
		}
		return s;
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
	
	
	@Override
	public String toString() {
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
		return s;
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
		if(this.isSuccess())
			return false;
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		//boolean change = false;
		if(x+1<n ) {
			//change = true;
			return true;

		}
		return false;
		
	}
	public boolean moveHaut() {
		if(this.isSuccess())
			return false;
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
		if(this.isSuccess())
			return false;
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
		if(this.isSuccess())
			return false;
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
	public boolean moveBas2() {
		
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
	public boolean moveHaut2() {
		
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
	public boolean moveDroite2() {
		
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
	public boolean moveGauche2() {
		
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
		if(this.getTab()[x+1][y]%2==0) {
			this.setCout( this.getCout()+1);
		}
		else {
			this.setCout( this.getCout()+2);
		}
		tab[x][y]=tab[x+1][y];//Haut
		tab[x+1][y]=-1;
		played();
		lastAction="B";
		
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
		if(this.getTab()[x-1][y]%2==0) {
			this.setCout( this.getCout()+1);
		}
		else {
			this.setCout( this.getCout()+2);
		}
		tab[x][y]=tab[x-1][y];
		tab[x-1][y]=-1; //Bas
		played();
		lastAction="H";
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
		if(this.getTab()[x][y+1]%2==0) {
			this.setCout( this.getCout()+1);
		}
		else {
			this.setCout( this.getCout()+2);
		}
		tab[x][y]=tab[x][y+1];
		tab[x][y+1]=-1; //Droite
		played();
		lastAction="D";
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
		if(this.getTab()[x][y-1]%2==0) {
			this.setCout( this.getCout()+1);
		}
		else {
			this.setCout( this.getCout()+2);
		}
		tab[x][y]=tab[x][y-1];
		tab[x][y-1]=-1;//Gauche
		played();
		lastAction="G";
		return this;
	}
	
	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}
	
	public Puzzle BasC() {
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
		lastAction="B";
		
		return this;
	}
	public Puzzle HautC() {
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
		lastAction="H";
		return this;
	}
	public Puzzle DroiteC() {
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
		lastAction="D";
		return this;
	}
	public Puzzle GaucheC() {
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
		lastAction="G";
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
		
		
		/*
		 * for (int i = 0 ; i < 100; i++) { for(String b :ACTIONS) { switch(b) { case
		 * "H": if(this.moveHaut2()) { this.Haut(); } break; case "B ":
		 * if(this.moveBas2()) { this.Bas(); } break; case "G":if(this.moveGauche2()) {
		 * this.Gauche(); } break; case "D": if(this.moveDroite2()) { this.Droite(); }
		 * break; default: break; } } }
		 */
		//this.DroiteC();
		//this.DroiteC();
		//this.DroiteC();
		this.BasC();
		//this.BasC();
	}
	
	public boolean realisable() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]!=-1)
				l.add(tab[i][j]);
				
			}
		}
		int inversion=0;
		for (int i = 0;i<l.size();i++) {
			int nb=l.get(i);
			for(int j=i+1;j<l.size();j++) {
				if(nb>l.get(j)) {
					inversion++;
				}
			}
		}
		int x = -93,y = -93;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]==-1) {
					x=i;
					y=j;
				}
					
			}
		}
		if(n%2==0&&(inversion+x)%2==0)
			return true;
		else if(n%2==1&&inversion%2==0)
			return true;
		return false;
	}
	public int inversion() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]!=-1) {
					l.add(tab[i][j]);
				}
			}
		}
		int inversion=0;
		for (int i = 0;i<l.size();i++) {
			int nb=l.get(i);
			for(int j=i+1;j<l.size();j++) {
				if(nb>l.get(j)) {
					inversion++;
				}
			}
		}
		return inversion;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public int compareTo(Object o) {
		Puzzle p = (Puzzle) o;
		if(this.getScore()-p.getScore()!=0) {
			return this.getScore()-p.getScore();
		}
		else {
			return this.toString().compareTo(p.toString());
		}
	}
	
	public int hamming() {
		int cpt = 0;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tab[i][j]!=tabS[i][j]) {
					cpt++;
				}
			}
		}
		return cpt;
	}
	
	public int manhattan() {
		int manhattan = 0;
		int cpt =0;
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				String indice = i+"_"+j;
				this.solMan.put(tabS[i][j], indice);
				this.depMan.put(tab[i][j], indice);
			}
		}

		for (Map.Entry depManEntry : this.depMan.entrySet()) {
			cpt=0;
			String indiceDepTmp = (String) depManEntry.getValue();
			int key = (int) depManEntry.getKey();
			String indiceSolTmp = this.solMan.get(key);
			String[] indiceSol = indiceSolTmp.split("_");
			String[] indiceDep = indiceDepTmp.split("_");
			int indiceISol = Integer.parseInt(indiceSol[0]);
			int indiceJSol = Integer.parseInt(indiceSol[1]);
			int indiceIDep = Integer.parseInt(indiceDep[0]);
			int indiceJDep = Integer.parseInt(indiceDep[1]);
			int resITmp = indiceISol - indiceIDep;
			int resJTmp = indiceJSol - indiceJDep;
			cpt = Math.abs(resITmp) + Math.abs(resJTmp);
			manhattan = manhattan +cpt;
		}
		return manhattan;
	}
	
}

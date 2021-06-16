import java.util.ArrayList;

public class Experimentation {
	
	private ArrayList<Puzzle> ListPuzzle;
	private int tailleList;
	private int taillePuzzle;
	
	public Experimentation(int tailleList, int taillePuzzle) {
		this.tailleList = tailleList;
		this.taillePuzzle = taillePuzzle;
		this.ListPuzzle = new ArrayList<Puzzle>();
	}
	
	public void init() {
		for(int i =0; i <this.tailleList;i++) {
			Puzzle p = new Puzzle(this.taillePuzzle);
			this.ListPuzzle.add(p);
		}
	}

	public ArrayList<Puzzle> getListPuzzle() {
		return ListPuzzle;
	}

	public void setListPuzzle(ArrayList<Puzzle> listPuzzle) {
		ListPuzzle = listPuzzle;
	}
	
	

}

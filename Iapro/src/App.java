import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Puzzle p = new Puzzle(2);
		p.print();
		System.out.println(p.isSuccess());
		Scanner sc = new Scanner(System.in);
		while(!p.isSuccess()) {
			p.move(sc.nextInt());
			p.print();
		}
		sc.close();
	}

}

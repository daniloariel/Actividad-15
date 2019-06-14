package DisjointSet;

public class testDisjointSet {

	public static void main(String[] args) {
		
		int cantNodos = 10;
		
		DisjointSet Ds = new DisjointSet(cantNodos);
		
		for(int i=0; i<cantNodos; i++) {
			Ds.makeSet(i);
		}
		
		Ds.union(2, 3);
		Ds.union(3, 4);
		Ds.union(3, 8);
		
		Ds.union(1, 9);
		Ds.union(7, 6);
		
		Ds.union(3,9);
		Ds.union(5, 0);
		Ds.union(0, 6);
		Ds.union(3,6);
		
		System.out.println(Ds.toString());

	}

}

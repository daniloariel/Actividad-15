package disjointSetHeuristicas;

public interface DisjointSet {
	
	public int makeSet(int n);
	
	public void union(int x, int y);
	
	public int findSet(int n);
	
	public String toString();

}

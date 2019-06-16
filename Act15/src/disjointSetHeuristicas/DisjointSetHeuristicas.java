package disjointSetHeuristicas;

import java.util.ArrayList;

public class DisjointSetHeuristicas implements DisjointSet{
	
	private int [] parent;
	private int [] rank;
	
	
	public DisjointSetHeuristicas(int cant) {
		parent = new  int[cant];
		rank = new int[cant];
	}
	
	public int makeSet(int x) {
		parent[x]=x;
		rank[x]=0;
		return x;
	}
	
	public void union(int x, int y) {
		
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		if(xRoot == yRoot) {
			return; //Se supone que esto no pasa porque no vamos a buscar el mismo elemento en dos conujunto diferentes
		}
		if(rank[xRoot] < rank[yRoot])
			parent[xRoot] = yRoot;
		
		else if(rank[xRoot] > rank[yRoot])
			parent[yRoot] = xRoot;
		
		else {
			parent[yRoot] = xRoot;
			rank[xRoot] = rank[xRoot]+1;
		}
		
	}
	
	public int findSet(int x) {
		if(parent[x]!=x)
			parent[x] = findSet(parent[x]);
		
		return parent[x];
	}

	public ArrayList<Integer> getSets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String toString() {
		String ret="";
		for(int i=0; i<parent.length;i++) {			
			ret+="{"+i+", ("+rank[i]+") -> padre: "+parent[i]+"}\n ";
		}
		return ret;
	}
}

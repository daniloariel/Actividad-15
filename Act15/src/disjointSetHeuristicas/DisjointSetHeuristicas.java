package disjointSetHeuristicas;

import java.util.ArrayList;

public class DisjointSetHeuristicas implements DisjointSet{
	//private int [] parent;
	//private int [] rank;

	ArrayList<Integer> parent;
	ArrayList<Integer> rank;
	
	
	public DisjointSetHeuristicas(int cant) {
		//parent = new  int[cant];
		//rank = new int[cant];
		parent = new ArrayList<Integer>();
		rank = new ArrayList<Integer>();
	}
	
	public int makeSet(int x) {
		//parent[x]=x;
		//rank[x]=0;
		parent.set(x,x);
		rank.set(x,0);
		return x;
	}
	
	public void union(int x, int y) {
		
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		/*
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
		}*/

		if(xRoot == yRoot) {
			return; //Se supone que esto no pasa porque no vamos a buscar el mismo elemento en dos conujunto diferentes
		}
		if(rank.get(xRoot) < rank.get(yRoot))
			parent.set(xRoot,yRoot);
		
		else if(rank.get(xRoot) > rank.get(yRoot))
			parent.set(yRoot,xRoot);
		
		else {
			parent.set(yRoot, xRoot);
			rank.set(xRoot , rank.get(xRoot) + 1);
		}
		
	}
	
	public int findSet(int x) {
		//if(parent[x]!=x)
		//	parent[x] = findSet(parent[x]);

		if(parent.get(x)!=x)
			parent.set(x,findSet(parent.get(x)));
		
		return parent.get(x);
	}

	public ArrayList<Integer> getSets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String toString() {
		String ret="";
		//for(int i=0; i<parent.length;i++) {			
			//ret+="{"+i+", ("+rank[i]+") -> padre: "+parent[i]+"}\n ";
		//}
		for(int i=0; i<parent.size();i++) {			
			ret+="{"+i+", ("+rank.get(i)+") -> padre: "+parent.get(i)+"}\n ";
		}
		return ret;
	}
}

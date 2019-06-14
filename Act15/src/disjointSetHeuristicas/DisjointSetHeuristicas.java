package disjointSetHeuristicas;

import java.util.LinkedList;

public class DisjointSetHeuristicas {
	
	private LinkedList<Nodo> sets;
	private Nodo[] allNodes;
	
	public DisjointSetHeuristicas(int cantNodos) {
		sets = new LinkedList<Nodo>();
		allNodes = new Nodo[cantNodos];
	}
	
	public Nodo makeSet(int n) {
		Nodo root = new Nodo(n);
		root.setPadre(root);
		
		sets.addFirst(root);
		allNodes[n] = root;
		
		return root;
	}
	
	public void union(int x, int y) {
		Nodo xRoot = findSet(x);
		Nodo yRoot = findSet(y);
		if(xRoot != yRoot) {
			if(xRoot.getRank() > yRoot.getRank()) 
				yRoot.setPadre(xRoot);			    
			else {
				xRoot.setPadre(yRoot);
				if(xRoot.getRank() == yRoot.getRank()) {
					yRoot.increaseRank();
				}
			}
		}
	}
	
	public Nodo findSet(int n) {  //Si no encontro el objeto devuelve nulo
		
		Nodo nodo = allNodes[n];  
		Nodo root = null;
		if(nodo!=null)
			root = pathCompress(nodo);
		
		return root;
	}
	
	
	private Nodo pathCompress(Nodo nodo) {
		
		if(nodo != nodo.getPadre())
			nodo.setPadre(pathCompress(nodo.getPadre()));
		
		return nodo.getPadre();	
	}
	
	public LinkedList<Nodo> getSets(){
		return sets;
	}
	
	public String toString() {
		String ret="";
		for(Nodo n : sets) {			
			ret+="{"+n.getValue()+", ("+n.getRank()+") -> padre: "+n.getPadre().getValue()+"}\n ";
		}
		return ret;
	}
}

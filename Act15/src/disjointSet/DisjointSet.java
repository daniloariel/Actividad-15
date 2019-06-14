package disjointSet;

import java.util.LinkedList;

public class DisjointSet {
	
	private LinkedList<Nodo> sets;
	private Nodo[] allNodes;
	
	public DisjointSet(int cantNodos) {
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
			yRoot.setPadre(xRoot);			    
		}
	}
	
	public Nodo findSet(int n) {  //Si no encontro el objeto devuelve nulo
		
		Nodo nodo = allNodes[n];  
		Nodo root = null;
		if(nodo!=null)
			root = findRoot(nodo);
		
		return root;
	}
	
	
	private Nodo findRoot(Nodo nodo) {
		
		if(nodo != nodo.getPadre())
			nodo = findRoot(nodo.getPadre());
		
		return nodo.getPadre();	
	}
	
	public LinkedList<Nodo> getSets(){
		return sets;
	}
	
	public String toString() {
		String ret="";
		for(Nodo n : sets) {			
			ret+="{"+n.getValue()+", -> padre: "+n.getPadre().getValue()+"}\n ";
		}
		return ret;
	}

}

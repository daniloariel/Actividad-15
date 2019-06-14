package DisjointSet;

import java.util.LinkedList;

public class DisjointSet {
	
	private LinkedList<DNode> sets;
	private DNode[] allNodes;
	
	public DisjointSet(int cantNodos) {
		sets = new LinkedList<DNode>();
		allNodes = new DNode[cantNodos];
	}
	
	public DNode makeSet(int n) {
		DNode root = new DNode(n);
		root.setPadre(root);
		
		sets.addFirst(root);
		allNodes[n] = root;
		
		return root;
	}
	
	public void union(int x, int y) {
		DNode xRoot = findSet(x);
		DNode yRoot = findSet(y);
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
	
	public DNode findSet(int n) {  //Si no encontro el objeto devuelve nulo
		
		DNode nodo = allNodes[n];  
		DNode root = null;
		if(nodo!=null)
			root = pathCompress(nodo);
		
		return root;
	}
	
	
	private DNode pathCompress(DNode nodo) {
		
		if(nodo != nodo.getPadre())
			nodo.setPadre(pathCompress(nodo.getPadre()));
		
		return nodo.getPadre();	
	}
	
	public LinkedList<DNode> getSets(){
		return sets;
	}
	
	public String toString() {
		String ret="";
		for(DNode n : sets) {			
			ret+="{"+n.getValue()+", ("+n.getRank()+") -> padre: "+n.getPadre().getValue()+"}\n ";
		}
		return ret;
	}
}

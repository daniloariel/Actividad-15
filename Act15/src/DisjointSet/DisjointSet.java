package DisjointSet;

import java.util.LinkedList;

public class DisjointSet {
	
	private LinkedList<LinkedList<DNode>> sets;
	
	public LinkedList<DNode> makeSet(int n) {
		DNode root = new DNode(n);
		root.setPadre(root);
		
		LinkedList<DNode> set = new LinkedList<DNode>();
		set.addFirst(root);
		
		sets.addLast(set);
		
		return set;
	}
	
	public void union(DisjointSet ds1, DisjointSet ds2) {};
	
	public DNode findSet(int n) {  //Si no encontro el objeto devuelve nulo
		
		DNode nodo = buscarDnodo(n);  
		DNode root = null;
		if(nodo!=null)
			root = pathCompress(nodo);
		
		return root;
	}
	
	private DNode buscarDnodo(int n) {  //Si no encontro el objeto devuelve nulo
		
		for(LinkedList<DNode> set : sets) {
			for(DNode dnodo : set) {
				if(n == dnodo.getValue())
					return dnodo;
			}
		}
		return null;
	}
	
	private DNode pathCompress(DNode nodo) {
		
		if(nodo != nodo.getPadre())
			nodo.setPadre(pathCompress(nodo.getPadre()));
		else
			return nodo;
		
		return null;
	}

}

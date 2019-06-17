package Ejercicios;

import java.util.ArrayList;
import Graph.Edge;
import Graph.Graph;
import Graph.Node;
import heap.*;
import disjointSetHeuristicas.*;

/**
	A partir de un grafo conexo, no dirigido y pesado, construir
	el árbol de cubrimiento minimal implementando 4 variantes 
	del algoritmo de Kruskal
*/

public class Ejercicio2{

	private ArrayList<Edge> mergeSort (ArrayList<Edge> arcos, int ini, int fin){

		if(ini==fin)
			return arcos;
		else{
			int mitad = (ini + fin)/2;
			ArrayList<Edge> izquierda = mergeSort(arcos,ini,mitad);
			ArrayList<Edge> derecha = mergeSort(arcos,mitad+1,fin);
			return merge(izquierda,derecha);
		}
	}

	private ArrayList<Edge> merge(ArrayList<Edge> izquierda, ArrayList<Edge> derecha){

		ArrayList<Edge> resultado = new ArrayList<Edge>();
		
		//HACER MERGE
		
		return resultado;
	}

	/*
		-----------------------ALGORITMOS DE KRUSKAL UTILIZANDO HEURISTICAS------------------------------------
	*/
	//Con ordenamiento de arcos
	private ArrayList<Edge> cubrimientoMinimoPesosH(Graph grafo){

		//obtengo los arcos y los ordeno de menor a mayor.
		ArrayList<Edge> arcos = mergeSort(grafo.getEdges(),0,grafo.cantArcos());

		ArrayList<Edge> solucion = new ArrayList<Edge>();

		//obtengo los nodos y creo un conjunto disjunto con ellos.
		ArrayList<Node> nodos = grafo.getNodes();
		DisjointSet conjunto = new DisjointSetHeuristicas(nodos.size());
		for(Node n : nodos) {
			conjunto.makeSet(n.getValue());
		}
		
		int i=0;
		do{
			Edge primero = arcos.get(i);
			int c1 = conjunto.findSet(primero.getOrigin().getValue());
			int c2 = conjunto.findSet(primero.getDestination().getValue());

			if(c1!=c2){
				conjunto.union(primero.getOrigin().getValue(),primero.getDestination().getValue());
				solucion.set(solucion.size(),primero);
			}
			i++;

		}while(i<grafo.cantArcos() && solucion.size()<grafo.cantNodos()-1);

		return solucion;
	}

	//Con un heap de arcos
	private ArrayList<Edge> cubrimientoMinimoHeapH(Graph grafo){

		//obtengo los arcos y los pongo en un heap
		ArrayList<Edge> arcos = grafo.getEdges();
		Heap<Edge> heap = new MinHeap<Edge>(arcos);
		
		ArrayList<Edge> solucion = new ArrayList<Edge>();
		
		//obtengo los nodos y los pongo en conjuntos disjuntos a cada uno separado
		ArrayList<Node> nodos = grafo.getNodes();
		DisjointSet conjunto = new DisjointSetHeuristicas(nodos.size());
		for(Node n : nodos) {
			conjunto.makeSet(n.getValue());
		}

		do{

			Edge primero = heap.removeMin();

			int c1= conjunto.findSet( primero.getOrigin().getValue() );
			int c2= conjunto.findSet( primero.getDestination().getValue() );

			if(c1!=c2){
				conjunto.union(primero.getOrigin().getValue(),primero.getDestination().getValue());
				solucion.set(solucion.size(),primero);
			}

		}while(solucion.size() < grafo.cantNodos()-1);

		return solucion;
	}
	
	/*
	 * ---------------------------------------------------------------------------------------------------------
	 */
	
	/*
	 *-----------------------ALGORITMOS DE KRUSKAL SIN HEURISTICAS----------------------------------------------
	 */
	//Con ordenamiento de arcos
		private ArrayList<Edge> cubrimientoMinimoPesos(Graph grafo){

			//obtengo los arcos y los ordeno de menor a mayor.
			ArrayList<Edge> arcos = mergeSort(grafo.getEdges(),0,grafo.cantArcos());

			ArrayList<Edge> solucion = new ArrayList<Edge>();

			//obtengo los nodos y creo un conjunto disjunto con ellos.
			ArrayList<Node> nodos = grafo.getNodes();
			DisjointSet conjunto = new DisjointSet(nodos.size());
			for(Node n : nodos) {
				conjunto.makeSet(n.getValue());
			}
			
			int i=0;
			do{
				Edge primero = arcos.get(i);
				int c1 = conjunto.findSet(primero.getOrigin().getValue());
				int c2 = conjunto.findSet(primero.getDestination().getValue());

				if(c1!=c2){
					conjunto.union(primero.getOrigin().getValue(),primero.getDestination().getValue());
					solucion.set(solucion.size(),primero);
				}
				i++;

			}while(i<grafo.cantArcos() && solucion.size()<grafo.cantNodos()-1);

			return solucion;
		}

		//Con un heap de arcos
		private ArrayList<Edge> cubrimientoMinimoHeap(Graph grafo){

			//obtengo los arcos y los pongo en un heap
			ArrayList<Edge> arcos = grafo.getEdges();
			Heap<Edge> heap = new MinHeap<Edge>(arcos);
			
			ArrayList<Edge> solucion = new ArrayList<Edge>();
			
			//obtengo los nodos y los pongo en conjuntos disjuntos a cada uno separado
			ArrayList<Node> nodos = grafo.getNodes();
			DisjointSet conjunto = new DisjointSet(nodos.size());
			for(Node n : nodos) {
				conjunto.makeSet(n.getValue());
			}

			do{

				Edge primero = heap.removeMin();

				int c1= conjunto.findSet( primero.getOrigin().getValue() );
				int c2= conjunto.findSet( primero.getDestination().getValue() );

				if(c1!=c2){
					conjunto.union(primero.getOrigin().getValue(),primero.getDestination().getValue());
					solucion.set(solucion.size(),primero);
				}

			}while(solucion.size() < grafo.cantNodos()-1);

			return solucion;
		}
	
	/*
	 * ---------------------------------------------------------------------------------------------------------
	 */
	

	public static void main(String[] args){

		//Esto lo copie de la actividad 1

		//Grafo 1: 3 nodos y conexo
		Node nodo1 = new Node(1);
		Node nodo2 = new Node(2);
		Node nodo3 = new Node(3);
		Node nodo4 = new Node(4);
		Node nodo5 = new Node(5);
		Node nodo6 = new Node(6);
		Node nodo7 = new Node(7);
		
		Edge arco1 = new Edge(nodo1,nodo2,2);
		Edge arco2 = new Edge(nodo2,nodo3,3);
		
		Graph grafo1= new Graph();
		grafo1.addNode(nodo1);
		grafo1.addNode(nodo2);
		grafo1.addNode(nodo3);
		grafo1.addEdge(arco1);
		grafo1.addEdge(arco2);

		//Grafo 4: 7 nodos y conexo
		Graph grafo4= new Graph();
		grafo4.addNode(nodo1);
		grafo4.addNode(nodo2);
		grafo4.addNode(nodo3);
		grafo4.addNode(nodo4);
		grafo4.addNode(nodo5);
		grafo4.addNode(nodo6);
		grafo4.addNode(nodo7);
		
		Edge arco10= new Edge(nodo1,nodo3,1);
		Edge arco11= new Edge(nodo1,nodo2,2);
		Edge arco12= new Edge(nodo2,nodo3,3);
		Edge arco13= new Edge(nodo3,nodo4,7);
		Edge arco14= new Edge(nodo4,nodo5,4);
		Edge arco15= new Edge(nodo6,nodo7,2);
		Edge arco16= new Edge(nodo4,nodo6,8);
		Edge arco17= new Edge(nodo4,nodo7,3);
		
		grafo4.addEdge(arco10);
		grafo4.addEdge(arco11);
		grafo4.addEdge(arco12);
		grafo4.addEdge(arco13);
		grafo4.addEdge(arco14);
		grafo4.addEdge(arco15);
		grafo4.addEdge(arco16);
		grafo4.addEdge(arco17);



	}

}

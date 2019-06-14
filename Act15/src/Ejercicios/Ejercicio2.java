package Ejercicios;

import java.util.LinkedList;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

/**
	A partir de un grafo conexo, no dirigido y pesado, construir
	el árbol de cubrimiento minimal implementando 4 variantes 
	del algoritmo de Kruskal
*/

public class Ejercicio2{

	private Edge [] mergeSort (Edge [] arreglo, int ini, int fin){

		if(ini==fin)
			return arreglo[ini];
		else{
			int mitad = (ini + fin)/2;
			Edge [] izquierda = mergeSort(arreglo,ini,mitad);
			Edge [] derecha = mergeSort(arreglo,mitad+1,fin);
			return merge(izquierda,derecha);
		}
	}

	private Edge [] merge(Edge [] izquierda, Edge [] derecha){

		int i = 0;
		Edge [] resultado = new Edge[izquierda.length + derecha.length]
		while(izquierda.length>0 && derecha.length>0){
			if(izquierda[i].getPeso()<=derecha[i].getPeso()){
				//ME DA TANTA PAJA ESTE ALGORITMO.
			}
		}

	}

	/*
		Conjunto de arcos ordenado por pesos
	*/
	private Edge [] cubrimientoMinimoPesos(Graph grafo){

		Edge [] arcos = grafo.getEdges();

		LinkedList<Edges> solucion = new LinkedList<Edges>();

		//inicializar conjunto disjunto con los nodos del grafo

		mergeSort(arcos);

		int i=0;

		do{
			Edge primero = arcos[i];
			c1 = conjunto.findSet(primero.getOrigin());
			c2 = conjunto.findSet(primero.getDestination());

			if(!c1.equals(c2)){
				conjunto.union(primero.getOrigin(),primero.getDestination());
				solucion.addLast(primero);
			}

			i++;

		}while(i<grafo.cantArcos() && solucion.size()==grafo.cantNodos()-1);

		return solucion;
	}

	/*
		Con min-heap 
	*/
	private Edge [] cubrimientoMinimoHeap(Graph grafo){

		Edge [] arcos = grafo.getEdges();

		//Heap heap = new Heap<Edge>(arcos);

		LinkedList<Edges> solucion = new LinkedList<Edges>();

		//crear conjunto disjunto con los nodos del grafo

		do{

			Edge primero = heap.removeMin();

			c1= conjunto.findSet(primero.getOrigin());
			c2= conjunto.findSet(primero.getDestination());

			if(!c1.equals(c2)){
				conjunto.union(primero.getOrigin(),primero.getDestination());
				solucion.addLast(primero);
			}

		}while(solucion.size() == grafo.cantNodos()-1);

		return solucion;
	}

	public static void main(String[] args){

		//Esto lo copie de la actividad 1

		//Grafo 1: 3 nodos y conexo
		Node nodo1 = new Node(1);
		Node nodo2 = new Node(2);
		Node nodo3 = new Node(3);
		
		Edge arco1 = new Edge(nodo1,nodo2,2);
		Edge arco2 = new Edge(nodo2,nodo3,3);
		
		Graph grafo1= new Graph(3,2);
		grafo1.addNode(nodo1);
		grafo1.addNode(nodo2);
		grafo1.addNode(nodo3);
		grafo1.addEdge(arco1);
		grafo1.addEdge(arco2);

		//Grafo 4: 7 nodos y conexo
		Graph grafo4= new Graph(7,8);
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

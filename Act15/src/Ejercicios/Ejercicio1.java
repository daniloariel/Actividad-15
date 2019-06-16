package Ejercicios;

import java.util.ArrayList;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;
import Graph.Queue;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Grafo 1: 3 nodos y conexo
		Node nodo1 = new Node(1);
		Node nodo2 = new Node(2);
		Node nodo3 = new Node(3);
		
		Edge arco1 = new Edge(nodo1,nodo2,2);
		Edge arco2 = new Edge(nodo2,nodo3,3);
		
		Graph grafo1= new Graph();
		grafo1.addNode(nodo1);
		grafo1.addNode(nodo2);
		grafo1.addNode(nodo3);
		grafo1.addEdge(arco1);
		grafo1.addEdge(arco2);
		
		//Grafo 2: 3 nodos y no conexo
		Edge arco3= new Edge(nodo1,nodo2,1);
		
		Graph grafo2 = new Graph();
		grafo2.addNode(nodo1);
		grafo2.addNode(nodo2);
		grafo2.addNode(nodo3);
		
		grafo2.addEdge(arco3);
				
		//Grafo 3: 7 nodos y no conexo
		Node nodo4 = new Node(4);
		Node nodo5 = new Node(5);
		Node nodo6 = new Node(6);
		Node nodo7 = new Node(7);
		
		Edge arco4= new Edge(nodo1,nodo3,1);
		Edge arco5= new Edge(nodo1,nodo2,2);
		Edge arco6= new Edge(nodo2,nodo3,3);
		Edge arco7= new Edge(nodo3,nodo4,7);
		Edge arco8= new Edge(nodo4,nodo5,4);
		Edge arco9= new Edge(nodo6,nodo7,2);
		
		Graph grafo3= new Graph();
		grafo3.addNode(nodo1);
		grafo3.addNode(nodo2);
		grafo3.addNode(nodo3);
		grafo3.addNode(nodo4);
		grafo3.addNode(nodo5);
		grafo3.addNode(nodo6);
		grafo3.addNode(nodo7);
		
		grafo3.addEdge(arco4);
		grafo3.addEdge(arco5);
		grafo3.addEdge(arco6);
		grafo3.addEdge(arco7);
		grafo3.addEdge(arco8);
		grafo3.addEdge(arco9);
		
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
		
		
		Boolean resp = BFS(grafo4);
		System.out.println("Es convexo? "+ resp);
		
		//String respuesta = grafo1.toString();
		
	    //System.out.println(respuesta);    
		allWhite(grafo1);
		allWhite(grafo2);
		allWhite(grafo3);
	}
	
	public static boolean BFS(Graph grafo) {
		
		for(Node nodo: grafo.getNodes() )
			nodo.setColor("blanco");
		Queue cola = new Queue();
		int i=0;
		for(Node nodo: grafo.getNodes())
		{
			if (nodo.getColor()=="blanco") {
				nodo.setColor("gris");
				cola.enqueue(nodo);
				visitarBF(grafo, cola);
				i++;
			}
			if(i==2)
				return false;
		}
		return true;
	}
	
	private static boolean visitarBF(Graph grafo, Queue cola) {
		
		Node nodo;
		ArrayList<Node> adyacentes;
		while(!cola.isEmpty()) {
			nodo = cola.front();
			adyacentes = grafo.getAdyacentes(nodo);
			if(!adyacentes.isEmpty()) {
				for(Node n : adyacentes) {
					if(n.getColor() == "blanco") {
						n.setColor("gris");
						cola.enqueue(n);
					}
				}
			}
			nodo.setColor("negro");
			cola.dequeue();
		}				
		return true;
	}
	
	private static void allWhite(Graph grafo) {
		for(Node nodo: grafo.getNodes() )
			nodo.setColor("blanco");
	}
	
}

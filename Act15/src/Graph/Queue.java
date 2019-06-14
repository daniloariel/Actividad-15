package Graph;

import java.util.LinkedList;

public class Queue {

	private LinkedList<Node> cola;
	
	public Queue() {
		cola = new LinkedList<Node>();
	}
	
	public boolean isEmpty() {
		return cola.size()==0;
	}
	
	public Node front() {
		return cola.getLast();
	}
	
	public void enqueue(Node nodo) {
		cola.addFirst(nodo);
	}
	
	public Node dequeue() {
		return cola.removeLast();
	}
}

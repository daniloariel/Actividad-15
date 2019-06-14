package Graph;

import java.util.LinkedList;
import java.util.List;
 
public class Graph {
 
    private Node [] nodes;
    private int nodesSize;
    private Edge [] edges;
    private int edgesSize;
    
    
    public Graph(int cantNodos, int cantArcos) {
    	nodes = new Node[cantNodos];
    	edges = new Edge[cantArcos];
    	nodesSize = 0;
    	edgesSize = 0;
     }
    
    public LinkedList<Node> getAdyacentes(Node nodo) {
    	LinkedList<Node> adyacentes = new LinkedList<Node>();
    	for(Edge arco : edges) {
    		if(arco.getOrigin() == nodo)
    			adyacentes.addLast(arco.getDestination());
    	}
    	
    	return adyacentes;
    }
    
    public void addNode(Node node) {
        nodes[nodesSize] = node;
        nodesSize++;
    }
    
    public void addEdge(Edge edge) {
       edges[edgesSize] = edge;
       edgesSize++;
    }
 
    public Edge[] getEdges(){
    	return edges;
    }
    
    public Node[] getNodes() {
        return nodes;
    }
 
    public int cantNodos() {
    	return nodes.length;
    }
    
    public int cantArcos() {
    	return edges.length;
    }
    
    @Override
    public String toString() {
    	String resp = "Graph [nodes=";
    	for(Node n : nodes)
    		resp+= n.toString();
    	resp+="\n      ]\n";
    	
    	resp += "[edges=";
    	for(Edge e: edges)
    		resp+= e.toString();
    	resp+="\n      ]";
    	
        return resp;
    } 
}

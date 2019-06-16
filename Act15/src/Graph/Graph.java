package Graph;

import java.util.ArrayList;
 
public class Graph {
 
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    
    public Graph() {
    	nodes = new ArrayList<Node>();
    	edges = new ArrayList<Edge>();
     }
    
    public ArrayList<Node> getAdyacentes(Node nodo) {
    	ArrayList<Node> adyacentes = new ArrayList<Node>();
    	for(Edge arco : edges) {
    		if(arco.getOrigin() == nodo)
    			adyacentes.add(adyacentes.size(),arco.getDestination());
    	}
    	
    	return adyacentes;
    }
    
    public void addNode(Node node) {
        nodes.set(nodes.size(),node);
    }
    
    public void addEdge(Edge edge) {
       edges.set(edges.size(), edge);
    }
 
    public ArrayList<Edge> getEdges(){
    	return edges;
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
 
    public int cantNodos() {
    	return nodes.size();
    }
    
    public int cantArcos() {
    	return edges.size();
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

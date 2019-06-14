package Graph;

public class Edge {
    private Node vertice1;
    private Node vertice2;
    private int peso;
 
    public Edge(Node origin, Node destination, int peso) {
        this.vertice1 = origin;
        this.vertice2 = destination;
        this.peso = peso;
    }
 
    public Node getOrigin() {
        return vertice1;
    }
 
    public void setOrigin(Node origin) {
        this.vertice1 = origin;
    }
 
    public Node getDestination() {
        return vertice2;
    }
 
    public void setDestination(Node destination) {
        this.vertice2 = destination;
    }
 
    public int getPeso() {
        return peso;
    }
 
    public void setPeso(int peso) {
        this.peso = peso;
    }
 
    @Override
    public String toString() {
        return "\n Edge [vertice 1=" + vertice1.getValue() + ", vertice 2=" + vertice2.getValue() + ", peso="
                + peso + "]";
    }
 
}
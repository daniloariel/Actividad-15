package disjointSetHeuristicas;

public class Nodo {
	
	private Nodo padre;
	private int rank;
	private int value;
	
	public Nodo(int value) {
		this.value = value;
		rank = 0;
	}
	
	public void increaseRank() {
		rank++;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getValue() {
		return value;
	}
	
	public Nodo getPadre() {
		return padre;
	}
	
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
}

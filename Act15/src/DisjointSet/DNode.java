package DisjointSet;

public class DNode {
	
	private DNode padre;
	private int rank;
	private int value;
	
	public DNode(int value) {
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
	
	public DNode getPadre() {
		return padre;
	}
	
	public void setPadre(DNode padre) {
		this.padre = padre;
	}
}

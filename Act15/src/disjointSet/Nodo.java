package disjointSet;

public class Nodo {

	private Nodo padre;
	private int value;
	
	public Nodo(int value) {
		this.value = value;
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

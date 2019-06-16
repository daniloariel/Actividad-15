package heap;


public interface Heap<E> {

	public int size();

	public boolean isEmpty();

	public E min();

	public E removeMin();


}

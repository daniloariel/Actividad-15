package heap;

import java.util.ArrayList;
import Graph.Edge;

public class MinHeap<E> implements Heap<E>{

	private ArrayList<E> heap;

	public MinHeap(ArrayList<E> lista){
		heap= lista;
		buildHeap();
	}

	public int size(){
		return heap.size();
	}

	public boolean isEmpty(){
		return heap.size()==0;
	}

	public E min(){
		if(heap.size()>0)
			return heap.get(0);
		else
			return null;
	}

	public E removeMin(){
		if(heap.size() == 1){
			E min = heap.get(0);
			heap.set(0,null);
			return min;
		}else{
			if(heap.size()>1){ //intercambio el ultimo con el primero, hago heapify
				E min = heap.get(0);
				heap.set(0, heap.get(heap.size() - 1));
				heap.remove(heap.size() - 1);
				heapify(0);
				return min;
			}else{
				return null;
			}
		}
		
	}

	private void heapify(int i){

		int izquierdo = 2 * i + 1;
        int derecho = 2 * i + 2;

        int menor = i;

        if (izquierdo < heap.size() - 1 && esMenor(izquierdo, menor))
            menor = izquierdo;

        if (derecho < heap.size() - 1 && esMenor(derecho, menor))
            menor = derecho;

        if (menor != i) {
            swap(menor, i);
            heapify(menor);
        }
	}

	private void swap(int i, int j) {
        E e = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, e);
    }

    public boolean esMenor(int i, int j) {
    	
        Edge ei = (Edge)heap.get(i);
        Edge ej = (Edge)heap.get(j);
        
        return ei.getPeso()<ej.getPeso();
        
    }

	private void buildHeap(){

		int i = heap.size() / 2;
        while (i >= 0) {
            heapify(i);
            i--;
        }
	}

}
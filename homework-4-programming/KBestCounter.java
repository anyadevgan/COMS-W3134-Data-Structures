import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
		
	private PriorityQueue<T> heap;
	private int k;
	
	public KBestCounter(int k){
		this.k = k;
		heap = new PriorityQueue<>(k);
	}
	
	public void count(T x){
		if(heap.size() < k){
			heap.offer(x);
		}
		else{
			if(heap.peek().compareTo(x) < 0){
				heap.poll();
				heap.offer(x);
			}
		}
	}
	
	public List<T> kbest(){
		ArrayList<T> resultList = new ArrayList<>();
		PriorityQueue<T> nHeap = new PriorityQueue<T>(heap);
		
		int x = 0;
		
		while(!heap.isEmpty()){
			T nextItem = heap.remove();
			resultList.add(x++, nextItem);
		}
		
		heap = nHeap;
		
		return resultList;
	}
		
}
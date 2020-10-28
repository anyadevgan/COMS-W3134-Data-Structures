/*
 * TwoStackQueue.java
 * Anya Devgan
 * ad3796
*/

public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
	
	private MyStack<T> s1;
	private MyStack<T> s2;
	
	public TwoStackQueue(){
		s1 = new MyStack<>(); //input
		s2 = new MyStack<>(); //output
	}
	
	//O(1)
	public void enqueue(T x){
		s1.push(x);
	}
	
	//O(n) when s2 is empty, where n == s1.size
	//O(1) when s2 is not empty
	public T dequeue(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		T temp = s2.pop();
		
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
		
		return temp;
	}
	
	public int size(){
		return s1.size() + s2.size();
	}
	
	public boolean isEmpty(){
		return (this.size() == 0);
	}
	
	
} 
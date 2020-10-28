/*
 * MyStack.java
 * Anya Devgan
 * ad3706
*/

@SuppressWarnings("unchecked")

public class MyStack<T> implements MyStackInterface<T>{
	
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private T[] stack;
	
	public MyStack(){
		this.theSize = 0;
		this.stack = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public void push(T x){
		if(this.theSize >= this.stack.length){
			T[] stack2 = (T[]) new Object[this.theSize * 2];
			for(int i = 0; i < this.stack.length; i++){
				stack2[i] = this.stack[i];
			}
			this.stack=stack2;
		}
		this.stack[theSize++] = x;
	}
	
	public T pop(){
		if(this.theSize <= 0){
			return null;
		}
		else{
			return this.stack[--theSize];
		}		
	}
	
	public T peek(){
		if(this.isEmpty()){
			return null;
		}
		return stack[theSize - 1];
	}
	
	public boolean isEmpty(){
		return (size() == 0);
	}
	
	public int size(){
		return this.theSize;
	}
	
}
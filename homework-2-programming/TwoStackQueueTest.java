public class TwoStackQueueTest{
	public static void main(String[] args){
		TwoStackQueue<Integer> x = new TwoStackQueue<Integer>();
		x.enqueue(5);
		x.enqueue(7);
		System.out.println(x.dequeue());
		System.out.println(x.dequeue());
	}
}
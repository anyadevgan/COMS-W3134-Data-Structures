import java.util.*;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{

	public BetterBST(){
		this.root = null;
	}
	
	public BetterBST(BinaryNode<T> root){
		this.root = root;
	}
	
	public int height(){
		return height(this.root);
	}
	
	private int height(BinaryNode<T> root){
		if(root == null){
			return -1;
		}
		return Math.max(height(root.right), height(root.left)) + 1;
	}
	
	public T imbalance(){
		return imbalance(this.root);
	}
	
	private T imbalance(BinaryNode<T> root){
		if(root == null){
			return null;
		}
		if(Math.abs(height(root.left) - height(root.right)) > 1){ 
			return root.data;
		}
		
		T leftImbalance = imbalance(root.left);
		T rightImbalance = imbalance(root.right);
		
		if(leftImbalance == null){
			return rightImbalance;
		}
		if(rightImbalance == null){
			return leftImbalance;
		}
		
		return rightImbalance;
	}
	
	public T smallestGreaterThan(T t){
		return smallestGreaterThan(t, root);
	}
	
	private T smallestGreaterThan(T t, BinaryNode<T> root){
		if(root == null){
			return null;
		}
		else if(t.compareTo(root.data) >= 0){
			return smallestGreaterThan(t, root.right);
		}
		else{
			T resultLeftSide = smallestGreaterThan(t, root.left);
			if(resultLeftSide == null){
				return root.data;
			}
			return resultLeftSide;
		}
	}
	
	public BinarySearchTree<T> mirror(){
		return new BetterBST<T>(mirror(this.root));
	}
	
	private BinaryNode<T> mirror(BinaryNode<T> root){
		if(root == null){
			return root;
		}
		return new BinaryNode<T>(root.data, mirror(root.right), mirror(root.left));
	}
	
	public void prettyPrint(){
		double maxWidth = Math.pow(2, height() + 1) - 1;
		double depth = 0;
		String empty = new String(new char[5]).replace('\0', ' ');
		LinkedList<BinaryNode<T>> x = new LinkedList<>();
		LinkedList<BinaryNode<T>> x2 = new LinkedList<>();
		x.offer(root);
		while(depth <= height()){
			String rowString = "";
			String rowSpaces = "";
			double spacingWidth = Math.pow(2, height() - depth + 1) - 1;
			double rowWidth = Math.pow(2, height() + 1) - spacingWidth;
			double sideFormat = (maxWidth - rowWidth)/2;
			
			for(int i = 0; i < spacingWidth; i++){
				rowSpaces += empty;
			}
			
			for(int j = 0; j < sideFormat; j++){
				rowString += empty;
			}
			
			BinaryNode<T> temp = null;
			while(x.size() > 0){
				temp = x.poll();
				if(temp != null){
					rowString += paddingHelper(temp.data);
					x2.offer(temp.left);
					x2.offer(temp.right);
				}
				else{
					rowString += empty;
					x2.offer(null);
					x2.offer(null);
				}
				rowString += rowSpaces;
			}
			System.out.println(rowString);
			x = x2;
			x2 = new LinkedList<>();
			depth++;
		}
	}
	
	private String paddingHelper(T t){
		String str = t.toString();
		int leftPadding = (5 - str.length()) / 2;
		int rightPadding = 5 - leftPadding - str.length();
		for(int i = 0; i < leftPadding; i++){
			str = " " + str;
		}
		for(int i = 0; i < rightPadding; i++){
			str += " ";
		}
		return str;
	}
}

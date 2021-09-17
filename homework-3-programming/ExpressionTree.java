import java.util.LinkedList;
import java.util.*;

public class ExpressionTree implements ExpressionTreeInterface{
		
	private String expression;
	private ExpressionNode root;
	
	public ExpressionTree(){
		root = null;
	}
	
	public ExpressionTree(String expression) throws Exception{
		LinkedList<ExpressionNode> stack = new LinkedList<>();
		String[] split_postfix = expression.split("\\s+");
		
		for(int i = 0; i < split_postfix.length; i++){
			String elm = split_postfix[i];
			ExpressionNode temp = new ExpressionNode(elm);
			
			if(temp.isOperator){
				if(stack.size() < 2){
					throw new Exception("Invalid postfix expression (stack underflow)");
				}
				
				temp.right = stack.pop();
				temp.left = stack.pop();
			}
			
			stack.push(temp);
		}
		
		root = stack.pop();
		
		if(!stack.isEmpty()){
			throw new Exception("Postfix expression has too many operands (non-empty stack)");
		}
	}
	
	public int eval(){
		return eval(this.root);
	}
	
	private int eval(ExpressionNode root){
		if(!root.isOperator){
			return Integer.parseInt(root.data);
		}
		if(root.data.equals("+")){
			return eval(root.left) + eval(root.right);
		}
		else if(root.data.equals("-")){
			return eval(root.left) - eval(root.right);
		}
		else if(root.data.equals("*")){
			return eval(root.left) * eval(root.right);
		}
		else{
			return eval(root.left) / eval(root.right);
		}
	}

	
	public String postfix(){
		return postfix(this.root);
	}
	
	private String postfix(ExpressionNode root){
		if(root == null){
			return "";
		}
		
		if(!root.isOperator){
			return "" +root.data;
		}
		
		return postfix(root.left) + " " + postfix(root.right) + " " + root.data;
	}
	
	public String prefix(){
		return prefix(this.root);
	}
	
	private String prefix(ExpressionNode root){
		if(root == null){
			return "";
		}
		
		if(!root.isOperator){
			return "" + root.data;
		}
		
		return root.data + " " + prefix(root.left) + " " + prefix(root.right);
	}
	
	public String infix(){
		String var = infix(this.root);
		return var.substring(1, var.length() -1);
	}
	
	private String infix(ExpressionNode root){
		if(root == null){
			return "";
		}
		
		if(!root.isOperator){
			return root.data;
		}
		
		return "(" + infix(root.left) + " " + root.data + " " + infix(root.right) + ")";
	}
	
	private static class ExpressionNode{
		public String data;
		public ExpressionNode left;
		public ExpressionNode right;
		public boolean isOperator;
		
		public ExpressionNode(){
			this.data = null;
			this.right = null;
			this.left = null;
			this.isOperator = false;
		}
		
		public ExpressionNode(String data){
			this.data = data;
			this.right = null;
			this.left = null;
			this.isOperator = typeDetermine(this.data);
		}
		
		public ExpressionNode(String data, ExpressionNode left, ExpressionNode right){
			this.data = data;
			this.left = left;
			this.right = right;
			this.isOperator = typeDetermine(this.data);
		}
		
		private boolean typeDetermine(String data){
			try{
				int temp = Integer.parseInt(data);
				return false;
			}
			catch(Exception e){
				return true;
			}
		}
	}
	
}
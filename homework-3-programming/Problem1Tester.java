public class Problem1Tester{
	
	public static void main(String[] args){
		ExpressionTree tree;
		
		try{
			tree = new ExpressionTree("34 2 - 5 *");
			System.out.println("Postfix Expression = " + tree.postfix());
			System.out.println("Prefix Expression = " + tree.prefix());
			System.out.println("Infix Expression = " +tree.infix());
			System.out.println("Evaluated Expression = " + tree.eval());
		}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
}
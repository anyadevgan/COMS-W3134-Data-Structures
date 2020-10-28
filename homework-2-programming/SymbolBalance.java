/*
 * SymbolBalance.java
 * Anya Devgan
 * ad3706
*/

import java.io.*;
import java.util.*;

public class SymbolBalance implements SymbolBalanceInterface{
	
	private MyStack<Character> stack;
	private boolean ignore;
	private Scanner sc;
	
	public void setFile(String filename){
		try{
			sc = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.println("The file with input can't be found");
		}
	}
	
	
	public BalanceError checkFile(){
		stack = new MyStack<>();
		ignore = false;
		String line;
		int lineCount = 0;
		
		while(sc.hasNextLine()){
			line = sc.nextLine();
			lineCount += 1;
			char[] characters = line.toCharArray();
			for(int i = 0; i < characters.length; i++){
				Character current = characters[i];
					
				if((current != '"') && (current != '*') && ignore){
					continue;
				}
				else if(ignore){
					Character top = stack.peek();
						
					if(top == null){
						return new EmptyStackError(lineCount);
					}
						
					if((current == '*') && (top == '*')){
						if((i+1 < characters.length && characters[i+1] == '/') && (characters[i-1] != '/')){
							ignore = false;
							stack.pop();
						}
					}
					else if((current == '"') && (top == '"')){
						ignore = false;
						stack.pop();
					}
				}
				else if((current == '(') || (current == '[') || (current == '{')){
					stack.push(current);
				}
				else if((current == '*') || (current == '"')){
					if(current == '"'){
						ignore = true;
						stack.push(current);
					}
					else if(current == '*'){
						if(i > 0 && characters[i-1] == '/'){
							ignore = true;
							stack.push(current);
						}
					}
				}
				else if((current == ')') || (current == ']') || (current == '}')){
					if(current == ')'){
						Character top = stack.peek();
						if(top == null){
							return new EmptyStackError(lineCount);
						}
						else if(top == '('){
							stack.pop();
						}
						else{
							return new MismatchError(lineCount, current, stack.peek());
						}
					}
					else if(current == ']'){
						Character top = stack.peek();
						if(top == null){
							return new EmptyStackError(lineCount);
						}
						else if(top == '['){
							stack.pop();
						}
						else{
							return new MismatchError(lineCount, current, stack.peek());
						}
					}
					else if(current == '}'){
						Character top = stack.peek();
						if(top == null){
							return new EmptyStackError(lineCount);
						}
						else if(top == '{'){
							stack.pop();
						}
						else{
							return new MismatchError(lineCount, current, stack.peek());
						}
					}
				}
				else{
					
				}
			}
		}
		
		if(this.stack.size() > 0){
			return new NonEmptyStackError(stack.peek(), stack.size());
		}
		
		return null;
	}
	
}
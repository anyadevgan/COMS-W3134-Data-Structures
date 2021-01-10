import java.io.*;
import java.util.*;

public class SpellChecker implements SpellCheckerInterface{
	HashSet<String> dictionary;
	
	public SpellChecker(String filename) throws IOException{
		dictionary = new HashSet<>();
		BufferedReader buffReader = new BufferedReader(new FileReader(filename));
		String line;
		
		while((line = buffReader.readLine()) != null){
			String[] fileWords = line.toLowerCase().split("\\s+");
			for(int x = 0; x < fileWords.length; x++){
				dictionary.add(fileWords[x]);
			}
		}
	}
	
	public List<String> getIncorrectWords(String filename){
		ArrayList<String> output = new ArrayList<>();
		
		try{
			BufferedReader buffReader = new BufferedReader(new FileReader(filename));
			String line;
			
			while((line = buffReader.readLine()) != null){
				String[] fileWords = line.toLowerCase().split("\\s+");
				for(int x = 0; x < fileWords.length; x++){
					String word = fileWords[x];
					word = word.replaceAll("[^0-9a-z]","");
					
					if(!dictionary.contains(word) && word.length() > 0){
						output.add(word);
					}
				}
			}
		}
		catch(Exception excep){
			System.out.println("Sorry, filename not found.");
		}
		return output;
	}
	
	private HashSet<String> addCharacter(String word){
		HashSet<String> output = new HashSet<>();
		StringBuilder strBuilder = new StringBuilder(word);
		
		for(int x = 0; x < strBuilder.length() + 1; x++){
			for(char character = 'a'; character <= 'z'; character++){
				strBuilder.insert(x, character);
				if(dictionary.contains(strBuilder.toString())){
					output.add(strBuilder.toString());
				}
				strBuilder.deleteCharAt(x);
			}
		}
		return output;
	}
	
	private HashSet<String> removeCharacter(String word){
		HashSet<String> output = new HashSet<>();
		StringBuilder strBuilder = new StringBuilder(word);
		
		for(int x = 0; x < strBuilder.length(); x++){
			char c = word.charAt(x);
			strBuilder.deleteCharAt(x);
			if(dictionary.contains(strBuilder.toString())){
				output.add(strBuilder.toString());
			}
			strBuilder.insert(x, c);
		}
		return output;
	}
	
	private HashSet<String> swapCharacters(String word){
		HashSet<String> output = new HashSet<>();
		
		for(int x = 0; x < word.length() - 1; x++){
			String temp;
			
			if(x != word.length() - 2){
				temp = word.substring(0, x) + word.charAt(x + 1) + word.charAt(x) + word.substring(x + 2, word.length());
			}
			else{
				temp = word.substring(0, x) + word.charAt(x + 1) + word.charAt(x);
			}
			
			if(dictionary.contains(temp)){
				output.add(temp);
			}
		}
		return output;
	}
	
	
	public Set<String> getSuggestions(String word){
		HashSet<String> output = new HashSet<>();
		word = word.toLowerCase().replaceAll("[^0-9a-z]","");
		
		if(dictionary.contains(word)){
			return output;
		}
		
		output.addAll(addCharacter(word));
		output.addAll(removeCharacter(word));
		output.addAll(swapCharacters(word));
		
		return output;
	}
	
}
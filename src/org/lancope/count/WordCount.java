package org.lancope.count;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	public static void main (String args[]) throws Exception {
		
		String delimiters = "[(),.;:?!]";
		HashMap<String, Integer> countMap = new HashMap<String,Integer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("src"+File.separator+"org"+File.separator+"lancope"+File.separator+"count"+File.separator+"input.txt"))) {
		    
			for(String line; (line = br.readLine()) != null; ) {
		        if (line.trim().isEmpty()) {
		        	continue;
		        }
				String sentences[] = line.split(delimiters);
				
				for (String sentence: sentences) {
					String words[] = sentence.trim().split("\\W+");
					for (String word: words) {
			        	
						if (countMap.containsKey(word)) {
			        		countMap.put(word, countMap.get(word)+1);
			        	}
			        	else {
			        		countMap.put(word, 1);
			        	}
			        }
				}
		    }
		}
		
		for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
			System.out.println(entry.getValue()+" "+entry.getKey());
		}
	}
}

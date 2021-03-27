import java.util.LinkedHashMap;
import java.util.Map;

public class MainClass {

	public static void main(String [] args) {
		//abc map(a,1) / 
		String v1 = "abc";
		String v2 = "acb";
		
		
		//cba map(a,-1)
		
		
	  System.out.println("Hi there");
	  Map<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();
	  for(int x=0; x<v1.length(); x++) {
		  
		  if(charCount.containsKey(v1.charAt(x))) {
			  charCount.put(v1.charAt(x), charCount.get(v1.charAt(x)) + 1);
		  } else {
			  charCount.put(v1.charAt(x), 1);
		  }
	  }
	  
	  for(int x=0; x<v2.length(); x++) {
		  if(charCount.containsKey(v2.charAt(x))) {
			  charCount.put(v2.charAt(x), charCount.get(v2.charAt(x)) - 1);
		  }
	  }
	  
	  boolean analog = (charCount.entrySet().stream().filter(entry -> entry.getValue() != 0).findAny().orElse(null))  == null ? true:false;
	  System.out.println(charCount);
	  
//	  Map.Entry<Character, Integer> entryValue = charCount.entrySet().stream().filter(entry -> 
//	  		entry.getValue() > 1).findFirst().orElse(null);
	}
}

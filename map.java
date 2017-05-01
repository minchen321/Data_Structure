import java.util.HashMap;
import java.util.Map;

public class map {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Ellen"); //add Ellen to the map with key 0
		map.put(1, "Mark");
		map.put(2, "Tom");
		map.put(3, "Kelly");
		//get(k) return the value associated with k
		System.out.println(map.get(2));
		
		Map<Character, Integer> letterMap = new HashMap<Character, Integer>();	
		String sentence = "Hello world";
		String s = sentence.toLowerCase();
		char[] letters = new char[sentence.length()];
		for(int i = 0; i < sentence.length(); i++){
			//convert string to a char array
			letters[i] = s.charAt(i);
			Integer count = letterMap.get(letters[i]);
			if(count == null)
				count = 0;
			letterMap.put(letters[i], 1 + count);
		}
		//number of occurrences
		System.out.println("\n" + letterMap.get('l'));
		
	}

}
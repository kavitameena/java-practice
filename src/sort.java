import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sort {
	public static void main (String args[]) {

		//  open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = null ;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		char[]char_array =str.toCharArray();
		Arrays.sort(char_array);
		int count = 0;
		char ch = char_array[count];


		Map<Character,Integer> charCounter=new HashMap<Character,Integer>();

		for(int i=0;i<str.length();i++)
		{
			ch = char_array[i];
			if(charCounter.containsKey(ch))
			{

				charCounter.put(ch, charCounter.get(ch)+1);
			} 
			else
			{
				charCounter.put(ch, 1);
			}
		}

		Map<Character, Integer> sortedMap = sortByComparator(charCounter);
		printMap(sortedMap);


	}

	private static Map<Character, Integer> sortByComparator(Map<Character, Integer> unsortMap) {

		// Convert Map to List
		List<Map.Entry<Character, Integer>> list = 
				new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o2,
					Map.Entry<Character, Integer> o1) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for (Iterator<Map.Entry<Character, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Character, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static void printMap(Map<Character, Integer> map) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
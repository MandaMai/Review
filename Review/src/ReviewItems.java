import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Hawesomeness.Hawesomeness;




public class ReviewItems {
	public static Map<Integer, String> testMapIndex;
	public static Map<String, String> testMapNames;
	public static Map<String, Double> testMapCalc;
	public static Map<Integer, Hawesomeness> testHawesomeness;
	public static Hawesomeness[] itemsOfHawesomeness; 
	
	public static void main(String[] args) {

	String testKeyName = "friend";
	int testIndex = 4;
	String testValue = "Graham";
	
	//HashMap work with integer index 
		testMapIndex = new HashMap<>();
		populateTestMapIndex();
		printStuff(testMapIndex, testMapIndex.containsKey(testIndex), testMapIndex.get(testIndex), testMapIndex.containsValue(testValue));
		testMapIndex.put(testIndex, "I am different now");
		printStuff(testMapIndex, testMapIndex.containsKey(testIndex), testMapIndex.get(testIndex), testMapIndex.containsValue(testValue));
		testMapIndex.remove(testIndex);
		printStuff(testMapIndex, testMapIndex.containsKey(testIndex), testMapIndex.get(testIndex), testMapIndex.containsValue(testValue));
	
	//HashMap work with string index	
		testMapNames = new HashMap<>();
		populateTestMapNames();
		printStuff(testMapNames, testMapNames.containsKey(testKeyName), testMapNames.get(testKeyName), testMapNames.containsValue(testValue));
		testMapNames.put(testKeyName, "Ashlee");
		printStuff(testMapNames, testMapNames.containsKey(testKeyName), testMapNames.get(testKeyName), testMapNames.containsValue(testValue));
	
	//Hashmap with calculation/iteration
		testMapCalc = new HashMap<>();
		populateTestMapCalc();
		makingStuffHappen(testMapCalc);
	
	testHawesomeness = Collections.synchronizedMap(new HashMap<>()); //thread-safe for multi-threading


	}
	
	
	public static void printStuff(Map temp, boolean foundKey, String itemAtKey, boolean foundValue) {
		Set<String> stringSet = temp.keySet();
		Collection<String> stringCollection = temp.values();
		
		System.out.println("The map includes: " + temp);
		System.out.println("The map has " + temp.size() + " elements");		
		System.out.println("The key was found: " + foundKey);
		System.out.println("The value was found: " + foundValue);
		System.out.println("The item at the key: " + itemAtKey);
		System.out.println("Set of strings in map: " + stringSet);
		System.out.println("Collection of strings in map: " + stringCollection);
	}
	
	public static void populateTestMapIndex() {
		//populate HashMap
		testMapIndex.put(1, "One");
		testMapIndex.put(2, "Two");
		testMapIndex.put(3, "Three");
		testMapIndex.put(4, "Four");
		testMapIndex.putIfAbsent(8, "Eight");
	}
	
	public static void populateTestMapNames() {
		testMapNames.put("cat", "Amelia");
		testMapNames.put("dog", "Sherlock");
		testMapNames.put("sister", "Jesica");
		testMapNames.put("mom", "Linda");
		testMapNames.put("brother", "Brad");
		testMapNames.put("grandma", "Lillian");
		testMapNames.put("grandpa", "Lloyd");
		testMapNames.put("friend", "Lisa");
		testMapNames.put("nephew", "Graham");
	}

	public static void populateTestMapCalc() {
		testMapCalc.put("Jesica", 10000.00);
		testMapCalc.put("Graham", 60000.00);
		testMapCalc.put("Sherlock", 50000.00);
		testMapCalc.put("Linda", 100000.00);
	}
	
	public static void makingStuffHappen(Map temp) {
		Double total = 0.0;
		temp.forEach((name, salary) -> {
			System.out.println(name + " => " + salary);
		});
	}
	
	
	public static void populateHawesomeness() {
		itemsOfHawesomeness = new Hawesomeness[5];
		itemsOfHawesomeness[0] = new Hawesomeness(1, "Amanda", "Seattle", 32, 90000.00);
		itemsOfHawesomeness[1] = new Hawesomeness(2, "Jesica", "Greenacres", 31, 92000.00);
		itemsOfHawesomeness[2] = new Hawesomeness(3, "Brad", "Spokane Valley", 32, 96000.00);
		itemsOfHawesomeness[3] = new Hawesomeness(4, "Linda", "Newman Lake", 53, 89000.00);
		itemsOfHawesomeness[4] = new Hawesomeness(5, "Graham", "Liberty Lake", 6, 58000.00);

		for(int i = 0; i < itemsOfHawesomeness.length; i++) {
			testHawesomeness.put(itemsOfHawesomeness[i].getId(), itemsOfHawesomeness[i]);
		}
	}
}
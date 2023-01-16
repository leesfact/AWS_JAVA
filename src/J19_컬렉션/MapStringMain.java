package J19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {
	
	
	public static void main(String[] args) {
		//Map Key, Value
		Map<String, String> strMap = new HashMap<>();
		
		strMap.put("가나다", "a");
		strMap.put("라마바", "b");
		strMap.put("사아자", "c");
		strMap.put("카타파", "d");
		
		System.out.println(strMap); // Key & Value pair로 나옴
		
		System.out.println(strMap.get("a")); // Key 검색하면 Value 나옴
		
		System.out.println(strMap.get("e")); // 
		
		
		for(String s: strMap.keySet()) {  // 키값을 for each로 빼올수 있음

			System.out.println(s);
		}
		
		for(String s: strMap.keySet()) {  // 벨류값을 뺴 올수도 있음

			System.out.println(strMap.get(s));
		}
		
		System.out.println(strMap.get("a"));
		
		for(String k : strMap.keySet()) {
			System.out.println("key: " + k);
			System.out.println(strMap.get(k));
		}
		
		for(String v : strMap.values()) {
			System.out.println("value: " + v);
		}
		
//		Set<Entry<String,String>> s = null;
		
		System.out.println(strMap.entrySet()); // 
		
		for(Entry<String, String>entry : strMap.entrySet()) {
			//System.out.println(entry);
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
		System.out.println("==========================");
		strMap.forEach((k,v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
		
		
	}

}

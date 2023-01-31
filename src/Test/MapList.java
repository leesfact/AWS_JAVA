package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {
		
	List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();	
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "name=홍길동");
		map.put("rating", "rating=vip");
		map.put("age", "age=30");
		customers.add(map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map2 = new HashMap<>();
		map2.put("name", "name=김기영");
		map2.put("rating", "rating=gold");
		map2.put("age", "age=35");
		
		customers.add(map2);
		
	
	for (Map<String, Object> customer : customers) {
		System.out.println(customer.get("name"));
		System.out.println(customer.get("rating"));
		System.out.println(customer.get("age"));
		
		}
	
	
	/*
	 * for(Map<String, Object> customer : customers) {
	 * 		for(Map.Entry<String,Object> entry : customer.entrySet()){
	 * 		System.out.println(entry);
	 * 		}
	 */
	}
}

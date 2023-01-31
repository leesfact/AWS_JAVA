package J19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SeachData {
	
	public static void main(String[] args) {
		
		Map<String, Object> seachData = new HashMap<>();
		
		seachData.put("category", "소설");
		seachData.put("seachValue", "불편한 편의점");
		
		System.out.println(seachData); //단순히 map을 tostring
		System.out.println(seachData.get("category"));
		System.out.println(seachData.get("seachValue"));
		
		System.out.println(seachData.keySet()); //반복가능
		System.out.println(seachData.values()); //반복가능
		
		
		System.out.println(seachData.entrySet()); //반복가능
		
		
//		for(int i = 0; i<seachData.size(); i++) {
//			System.out.println(seachData.get(null));
//			
//		} //index로는 반복을 뽑을 수 없다
		
		
		for(String key : seachData.keySet()) {
			System.out.println(seachData.get(key));
		}
	}

}

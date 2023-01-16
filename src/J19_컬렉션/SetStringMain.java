package J19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {
	
	public static void main(String[] args) {
		
		Set<String> setStr = new HashSet<>();  //순서가 없음....
		List<String> listStr = new ArrayList<>();
		
		listStr.add("이강용");
		listStr.add("이강용");
		listStr.add("이강용");
		
		System.out.println(listStr);
		
		setStr.add("가");
		setStr.add("나");
		setStr.add("다");
		setStr.add("라");
		setStr.add("라"); // 값이 이미 있으면 중복해서 들어가지 않음
		setStr.addAll(listStr); // 자동으로 중복제거 해주는 효과가 있다.
		
		System.out.println(setStr);
		String serachName = "가";
		
		for(String name : setStr) {
			if(name.equals(serachName)) {
			System.out.println(name);
		}
	  }
		
		Iterator<String> iterator = setStr.iterator();
		while(iterator.hasNext()) {
			
			String n = iterator.next();
			if(n.equals(serachName)) {
				System.out.println(n);
			}
			
		}
	}

}

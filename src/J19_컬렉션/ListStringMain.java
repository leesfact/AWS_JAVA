package J19_컬렉션;

import java.util.ArrayList;

public class ListStringMain {
	
	public static void main(String[] args) {
		
		String[] strArray = new String[] {"java","python","c++"};
		String[] newStrArray = new String[strArray.length+1];
		
		
		for(int i = 0; i<newStrArray.length-1;i++) {
			
			newStrArray[i] = strArray[i];
			
		}
		newStrArray[strArray.length]  ="html";
		
		
		//배열 끝에 html 추가 시키기..
		
		System.out.println("[strArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("[NewStrArray]");
		
		for(String str : newStrArray) {
			System.out.println(str);
		}
		
	
///////////////////////////////////////////////////////////////////////
		
		System.out.println("==================");
		ArrayList<String> strList = new ArrayList<>();
		
		strList.add("java");
		strList.add("python");
		strList.add("C#");
		strList.add("C");
		strList.add("C++");
		strList.add(1,"C++");
		strList.remove(1);
		
		for(int i = 0; i<strList.size(); i++) {
			System.out.print("[" + i+ "]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		
		
	}

}

package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lamdba2 {
	
	
	public static void main(String[] args) {
		
		// 1. Runnable - run()
		
		Runnable a = () -> System.out.println("실행");
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		
		};
		a.run();
		b.run();
		
		
		// 2. Supplier<T> - T get()
		
		Supplier<LocalDate> c = () -> LocalDate.now();
		Supplier<String> d  = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
			
		};
		
		System.out.println(c.get());
		System.out.println(d.get());
		
		// 3. Consumer<T> - void accept(T t)
		
		Consumer<String> e = name -> {
			System.out.println("이름: " + name);
			System.out.println("오늘 날짜: " + d.get());
		};
		e.accept("홍길동");
		
		
		// 메서드 참조 표현식 ( [인스턴스] :: [메서드명 또는 new])
		Consumer<String> f = System.out::println;
		f.accept("출력");
		
		List<String> names = new ArrayList<>();
		names.add("김동민");
		names.add("김두두");
		names.add("장진원");
		names.add("조병철");
		
		Consumer<String> g = name -> System.out.println("이름: " + name +"님");
		
		names.forEach(g);
		
		
		// this = names
		

		
		names.forEach(name -> {
		System.out.println("이름을 출력합니다.");
		System.out.println("이름: " + name);
		System.out.println();
		});
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("username","aaa");
		userMap.put("password","1234");
		
		userMap.forEach((key,value) ->{
			System.out.println("key: " + key);
			System.out.println("value: " + value);
			System.out.println();
		});
		
		/* forEach 안쓰면 이렇게 써야함 
		 * for(Entry<String,String> entry : userMap.entrySet()){
		 * System.out.println("key: " + key);
	     * System.out.println("value: " + value);
		 * System.out.println();
		}
		 */
		
		//4. Function<T, R> // 1회용
		
		Function<String, Integer> h = num -> Integer.parseInt(num);
		int convertStrNum1 = h.apply("100000");
		int convertStrNum2 = h.apply("200000");
		
		System.out.println(convertStrNum1+convertStrNum2);
		
		//5. Predicate<T> // 
		
//		Predicate<String> p = str -> str.startsWith("김");
//		Predicate<String> p2 = str -> str.startsWith("이");
		
		Function<Predicate<String>, Boolean> function1 = 
				predicate -> predicate.or(str -> str.startsWith("이")).test("김준일"); 
		
		
		boolean rs = function1.apply(str -> str.startsWith("김"));
		System.out.println(rs);
		
		System.out.println("========================================================");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("김종환");
		nameList.add("고병수");
		nameList.add("김상현");
		nameList.add("김준경");
		
		
		// 스트림 -> 일회용
		Stream<String> stream = nameList.stream().filter(name -> name.startsWith("김"));
		//stream.forEach(name -> System.out.println(name));
		List<String> newList = stream.collect(Collectors.toList());
		newList.forEach(str -> System.out.println(str));
		
		System.out.println("========================================================");
		
		nameList.stream()
			.filter(name -> name.startsWith("김"))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		  //.forEach(name -> System.out.println(name)); //똑같음
	}
}

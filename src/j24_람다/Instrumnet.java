package j24_람다;



@FunctionalInterface //람다 (중복 정의를 막아주는 어노테이션)
public interface Instrumnet {

	public String play(String instrument);
	
	public default void tsetPrint() {
		System.out.println("테스트");
	}
}

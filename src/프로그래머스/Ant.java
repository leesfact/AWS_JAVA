package 프로그래머스;

public class Ant {
	
    public static int solution(int hp) {
                    
       int a = hp / 5;
       int b = (hp % 5) / 3 ;
       int c = ((hp % 5) % 3);
       
       
       System.out.println(a+b+c); 
       return a+b+c;
    }
	    
	//return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;    
	
	public static void main(String[] args) {
		solution(999);
	}

}

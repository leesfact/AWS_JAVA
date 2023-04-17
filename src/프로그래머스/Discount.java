package 프로그래머스;

public class Discount {

	public static int solution(int price) {
		if(price > 500000){
            
            return (int) (price - (price*0.2));
            
        }else if(price > 300000){
            return (int)(price - (price*0.1));
        }else if(price > 100000){
            return (int)(price - (price*0.05));
        }else {
        	return (int)price;
        }
		
	}
    
	
	
	public static void main(String[] args) {
		solution(30000);
	}
	
}

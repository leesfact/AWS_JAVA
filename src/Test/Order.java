package Test;


public class Order {
	
	
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	
	public Order(int orderId, String productName, String consumerName, int price, int stock) {
		this.orderId = orderId;
		this.productName = productName;
		this.consumerName = consumerName;
		this.price = price;
		this.stock = stock;
	}

	public String showOrderInfo() {
		return "주문번호: " 
				+ orderId 
				+ "\n상품명: " + productName 
				+ "\n구매자: " + consumerName
				+ "\n가격: " + price + "\n수량: " + stock ;
	}

	public static class OrderBulider{
		private int orderId;
		private String productName;
		private String consumerName;
		private int price;
		private int stock;
		
	
		public OrderBulider setOrderId(int orderId) {
			this.orderId = orderId;
			return this;
		}
		public OrderBulider setProductName(String productName) {
			this.productName = productName;
			return this;
		}
		public OrderBulider setConsumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		public OrderBulider setPrice(int price) {
			this.price = price;
			return this;
		}
		public OrderBulider setStock(int stock) {
			this.stock = stock;
			return this;
		}

		public Order build() {
			return new Order(orderId,productName,consumerName,price,stock);
		}
	}
	
}


/*
 * public class Student {
 * public Student(String a, String b){
 * this a = a;
 * this b = b;
 * 		}
 * }
 * 
 * public static class StudentBuilder{
 * private String a;
 * private String b;
 * 
 * 
 * 
 * public Student build(){
 * 
 * return new Student(a,b);
 * }
 * 
 * public StudentBuilder a(String a){
 * this.a = a;
 * return this;
 * 
 */
		


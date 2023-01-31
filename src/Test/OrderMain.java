package Test;



public class OrderMain {

	public static void main(String[] args) {
		
			Order order = null;
			order=	new Order.OrderBulider()
							   .setOrderId(100)
							   .setProductName("Samsung GalaxyBook2 Pro")
							   .setConsumerName("홍길동")
							   .setPrice(1450000)
							   .setStock(2)
						   	   .build();
		
		System.out.println(order.showOrderInfo());
								
	}

}

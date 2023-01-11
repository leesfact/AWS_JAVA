package J17_스태틱;

public class CustomerTest1 {
	public static void main(String[] args) {
	
		
		Customer customer = new Customer(); // 인스턴스 및 객체 생성
		
		customer.setCustomID(1000);
		customer.setCustomerName("이순신");
		customer.bonusPoint = 1000;
		
		System.out.println(customer.showCustomerInfo());
		
		System.out.println("=========================");
		
		VipCustomer vipCustomer = new VipCustomer();
		
		vipCustomer.setCustomID(1002);
		vipCustomer.setCustomerName("김유신");
		vipCustomer.bonusPoint =  100000;
		 
		System.out.println(vipCustomer.showCustomerInfo());
		
		
		
		
	}
}

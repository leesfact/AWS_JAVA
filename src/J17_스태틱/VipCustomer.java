package J17_스태틱;

public class VipCustomer extends Customer {
	
	private int agentID;
	double saleRatio;
	
	public VipCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		
		
	}
	
	public int getAgentID() {
		return agentID;
	}

}

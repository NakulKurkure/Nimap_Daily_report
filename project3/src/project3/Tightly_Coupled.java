package project3;

public class Tightly_Coupled {

//	classes and objects are dependent on one another
	double taxIncome;
	
	public Tightly_Coupled(double taxIncome) {
		super();
		this.taxIncome = taxIncome;
	}

	public double getTaxIncome() {
		return taxIncome;
	}

	public void setTaxIncome(double taxIncome) {
		this.taxIncome = taxIncome;
	}
	
	double show()
	{
		return taxIncome*0.3;
	}

	
	
	
	

}

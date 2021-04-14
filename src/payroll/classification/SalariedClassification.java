package payroll.classification;

import payroll.PaymentClassification;

public class SalariedClassification extends PaymentClassification {

	private double salary;
	public SalariedClassification(double salary) {
		this.salary = salary;
		
	}
	public double getSalary() {
		
		return 0;
	}

}

package payroll.classification;

import payroll.PaymentClassification;

public class HourlyClassification extends PaymentClassification{

	private double hourlyRate;

	
	public HourlyClassification(double hourlyRate) {
		// TODO Auto-generated constructor stub
		this.hourlyRate = hourlyRate;
	}

	public double getHourlyRate() {
		return  hourlyRate;
	}

}

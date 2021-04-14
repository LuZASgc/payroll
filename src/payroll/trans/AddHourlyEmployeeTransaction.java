package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.HourlyClassification;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double hourlyRate;

	public AddHourlyEmployeeTransaction(int empId, String name, String address, 
			double hourlyRate) {
		
				
				super(empId,name,address);
				this.hourlyRate = hourlyRate;
	}
	
	@Override
	protected PaymentClassification getPaymentClassification() {
		return new HourlyClassification(hourlyRate);
	}

}

package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.SalariedClassification;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double salary;
	public AddSalariedEmployeeTransaction(int empId, String name, 
			String address, double salary) {
				this.empId = empId;
				this.name = name;
				this.address = address;
				this.salary = salary;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		return new SalariedClassification(salary);
	}

}

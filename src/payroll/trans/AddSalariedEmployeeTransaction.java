package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double salary;
	public AddSalariedEmployeeTransaction(int empId, String name, 
			String address, double salary) {
				this.empId = empId;
				this.name = name;
				this.address = address;
				this.salary = salary;
	}

	@Override
	public void execute() {
		Employee employee = new Employee(empId,name,address);
		employee.setPaymentClassification(getPaymentClassification());
		employee.setPaymentMethod(new HoldMethod());
		PayrollDatabase.save(employee);
	}

	protected PaymentClassification getPaymentClassification() {
		return new SalariedClassification(salary);
	}

}

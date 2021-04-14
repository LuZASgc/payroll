package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	
	public AddEmployeeTransaction(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	public AddEmployeeTransaction() {
		super();
	}

	@Override
	public void execute() {
		Employee employee = new Employee(empId,name,address);
		employee.setPaymentClassification(getPaymentClassification());
		employee.setPaymentMethod(new HoldMethod());
		PayrollDatabase.save(employee);
	}
	protected abstract PaymentClassification getPaymentClassification();

}
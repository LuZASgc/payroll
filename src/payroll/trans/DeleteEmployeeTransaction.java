package payroll.trans;

import java.util.NoSuchElementException;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
		
	}

	@Override
	public void execute() {
		Employee employee = PayrollDatabase.getEmployee(empId);
		if(employee != null) {
			PayrollDatabase.deleteEmployee(empId);
		}else {
			throw new NoSuchEmployeeException("No such employee empId =" + empId);
		}

	}

}

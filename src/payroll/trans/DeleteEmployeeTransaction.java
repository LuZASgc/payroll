package payroll.trans;

import payroll.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}

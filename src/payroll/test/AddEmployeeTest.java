package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.Transaction;
import payroll.trans.AddHourlyEmployeeTransaction;

public class AddEmployeeTest {

	@Test
	public void testAddHourlyEmployeeTransaction() {
		int empId = 1001;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		
		// �½�����ӵ㹤��������ִ��
		Transaction t = new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate);
		t.execute();
		// ��ִ֤�н��
		Employee e = PayrollDatabase.getEmployee(empId); // ���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e); // ��Ա��¼����
		assertEquals(empId, e.getEmpId()); // �����ȷ
	    assertEquals(name, e.getName()); // ������ȷ
		assertEquals(address, e.getAddress()); // ��ַ��ȷ
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification); // �ӵ㹤
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(hourlyRate, hc.getHourlyRate(), 0.01); // Сʱ������ȷ
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod); // ֧����ʽĬ��Ϊ����֧Ʊ
	}

}

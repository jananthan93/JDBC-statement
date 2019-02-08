package com.jdbc.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmployeeDoaImpl;
import com.jdbc.model.Employee;

public class ClientTestPrepairedStatement {

	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDoaImpl();
		Employee employee=getEmployee();
//		employeeDao.createEmployee(employee);
		
//		getEmployeeById(employeeDao);
//		employeeDao.updateEmployeeEmailById("jana43@gmail.com", 2);
//		employeeDao.deleteEmployeeById(1);
		getEmployeesInfo(employeeDao);
	}



	private static void getEmployeesInfo(EmployeeDao employeeDao) {
		List<Employee> employees = employeeDao.getAllEmployeesInfo();
		employees.forEach(System.out::println);
	}

	

	private static void getEmployeeById(EmployeeDao employeeDao) {
		Employee employee2=employeeDao.getEmployeeById(2);
		
		if (employee2 != null) {
			System.out.println(employee2);
		}else {
			System.out.println("employee doesn't exist");
		}
	}

	private static Employee getEmployee() {
		Employee employee=new Employee();
		employee.setBonus(new BigDecimal(290));
		employee.setDoj(new Date());
		employee.setEmail("jananthan2@gmail.com");
		employee.setEmpName("Jananthan");
		employee.setSalary(25000.00);
		return employee;
	}

}

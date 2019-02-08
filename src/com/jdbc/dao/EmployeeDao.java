package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Employee;

public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer empId);
	public abstract void updateEmployeeEmailById(String newEmail,Integer empId);
	public abstract void deleteEmployeeById(Integer empId);
	public abstract List<Employee> getAllEmployeesInfo();
}

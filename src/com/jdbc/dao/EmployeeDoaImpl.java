package com.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Employee;
import com.jdbc.util.DBUtil;

public class EmployeeDoaImpl implements EmployeeDao {

	@Override
	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO employee_table (employee_name,email,salary,date_of_joining,bonus) VALUES(?,?,?,?,?)";

		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
			ps.setString(1, employee.getEmpName());
			ps.setString(2, employee.getEmail());
			ps.setDouble(3, employee.getSalary());
			ps.setDate(4, new Date(employee.getDoj().getTime()));
			ps.setBigDecimal(5, employee.getBonus());

			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1)
				System.out.println("employee is created..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee employee = null;
		String SQL = "SELECT * FROM employee_table WHERE employee_id=?";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				Date doj = rs.getDate("date_of_joining");

				employee = new Employee();
				employee.setBonus(bonus);
				employee.setDoj(doj);
				employee.setEmail(email);
				employee.setSalary(salary);
				employee.setEmpName(eName);

//				System.out.println(employeeId+"\t"+eName+"\t"+salary+"\t"+email+"\t"+bonus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, Integer empId) {
		String SQL = "UPDATE employee_table set email=? WHERE employee_id=?";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
			ps.setString(1, newEmail);
			ps.setInt(2, empId);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1)
				System.out.println("employee email is updated..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		String SQL = "DELETE FROM employee_table  WHERE employee_id=?";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

			ps.setInt(1, empId);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1)
				System.out.println("employee is deleted..");
			else {
				System.out.println("employee doesn't exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getAllEmployeesInfo() {
		List<Employee> empList = new ArrayList<>();
		String SQL = "SELECT * FROM employee_table";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				Date doj = rs.getDate("date_of_joining");

				Employee employee = new Employee();
				employee.setBonus(bonus);
				employee.setDoj(doj);
				employee.setEmail(email);
				employee.setSalary(salary);
				employee.setEmpName(eName);

				empList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;

	}

}

package com.jdbc.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.util.DBUtil;
import com.jdbc.util.DBUtilProperties;
import com.mysql.cj.protocol.Resultset;


public class ClientTest {

	public static void main(String[] args) {
		Connection connection1=DBUtil.getConnection();
		if (connection1 != null) 
			System.out.println("JDBC:connection 1 is taken..");
		
		Connection connection4=DBUtilProperties.getConnection();
		if (connection4 != null) 
			System.out.println("JDBC:connection 4 is taken..");
		
		//Insert query
//		createEmployee();
//		updateEmployeeEmailById();
//		deleteEmployee();
//		getEmployeeId( 2);
//		getAllEmployee();
		getEmployeeByName("martin");
	}

	private static void getAllEmployee() {
		try(Connection connection = DBUtil.getConnection();
				Statement statement=connection.createStatement();) {
				String SQL="SELECT * FROM employee_table";
				ResultSet rs =statement.executeQuery(SQL);
				while(rs.next()) {
					int empId = rs.getInt("employee_id");
					String eName = rs.getString("employee_name");
					String email =rs.getString("email");
					Double salary = rs.getDouble("salary");
					BigDecimal bonus =rs.getBigDecimal("bonus");
					
					System.out.println(empId+"\t"+eName+"\t"+salary+"\t"+email+"\t"+bonus);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private static void getEmployeeByName(String name) {
			
			try(Connection connection = DBUtil.getConnection();
					Statement statement=connection.createStatement();) {
//				String SQL="SELECT * FROM employee_table  WHERE employee_name="+name+"";
					String SQL="SELECT * FROM employee_table  WHERE employee_name='"+name+"'";
					System.out.println(SQL);
					ResultSet rs =statement.executeQuery(SQL);
					if(rs.next()) {
						int empId = rs.getInt("employee_id");
						String eName = rs.getString("employee_name");
						String email =rs.getString("email");
						Double salary = rs.getDouble("salary");
						BigDecimal bonus =rs.getBigDecimal("bonus");
						
						System.out.println(empId+"\t"+eName+"\t"+salary+"\t"+email+"\t"+bonus);
					}
					else {
						System.out.println("Employee doesn't exist with provided name");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	private static void getEmployeeId(Integer idNum) {
		
		try(Connection connection = DBUtil.getConnection();
				Statement statement=connection.createStatement();) {
				String SQL="SELECT * FROM employee_table  WHERE employee_id="+idNum;
				ResultSet rs =statement.executeQuery(SQL);
				if(rs.next()) {
					int empId = rs.getInt("employee_id");
					String eName = rs.getString("employee_name");
					String email =rs.getString("email");
					Double salary = rs.getDouble("salary");
					BigDecimal bonus =rs.getBigDecimal("bonus");
					
					System.out.println(empId+"\t"+eName+"\t"+salary+"\t"+email+"\t"+bonus);
				}
				else {
					System.out.println("Employee doesn't exist with provided Id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private static void deleteEmployee() {
		try(Connection connection = DBUtil.getConnection();
				Statement statement=connection.createStatement();) {
				String SQLDELETE="DELETE FROM employee_table  WHERE employee_id=2";
				int executeUpdate =statement.executeUpdate(SQLDELETE);
				
				if(executeUpdate == 1) {
					System.out.println("Employee is deleted..");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private static void updateEmployeeEmailById() {
		try(Connection connection = DBUtil.getConnection();
				Statement statement=connection.createStatement();) {
				String SQLUPDATE="UPDATE employee_table set email='janan93@gmail.com' WHERE employee_id=1";
				int executeUpdate =statement.executeUpdate(SQLUPDATE);
				
				if(executeUpdate == 1) {
					System.out.println("Employee is updated..");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	public static void createEmployee() {
		try(Connection connection = DBUtil.getConnection();
			Statement statement=connection.createStatement();) {
			String SQLINSERT="INSERT INTO employee_table (employee_name,email,salary,date_of_joining,bonus) "
					+ "VALUES('Martin','martin.cs2009@yahoo.com',6000.00,'2017-05-17',400.00)";
			int executeUpdate =statement.executeUpdate(SQLINSERT);
			
			if(executeUpdate == 1) {
				System.out.println("Employee is created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

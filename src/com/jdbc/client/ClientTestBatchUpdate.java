package com.jdbc.client;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.util.DBUtil;

public class ClientTestBatchUpdate {

	public static void main(String[] args) {
		String UPDATESQL="UPDATE employee_table set salary=? WHERE employee_id=?";
		try(Connection connection=DBUtil.getConnection();
				PreparedStatement ps=connection.prepareStatement(UPDATESQL)) {
			ps.setDouble(1, 55000.00);
			ps.setInt(2, 2);
			ps.addBatch();
			
			ps.setDouble(1, 55000.00);
			ps.setInt(2, 5);
			ps.addBatch();
			
			ps.setDouble(1, 55000.00);
			ps.setInt(2, 8);
			ps.addBatch();
			
//			ps.executeBatch();
//			int[] executeBatch=ps.executeBatch();
//			for(int i:executeBatch) {
//				System.out.println(i);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		int a=-130;  
//		byte b=(byte)a;  
//		System.out.println(a);  
//		System.out.println(b);  
	}

	
}

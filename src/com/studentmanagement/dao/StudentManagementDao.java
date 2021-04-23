package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentmanagement.entity.Student;

public class StudentManagementDao {
	public static final String SQL_INSERT_STUDENT = "INSERT INTO STUDENT (USERNAME, NAME, EMAIL,PASSWORD) VALUES (?,?,?,?)";
	public static final String SQL_VALIDATE_USER = "SELECT COUNT(*) FROM  STUDENT WHERE USERNAME=? AND PASSWORD=?";
	public static final String SQL_FETCH_USER = "SELECT USERNAME, NAME, EMAIL,PASSWORD FROM STUDENT  WHERE USERNAME=?";

	public String saveStudent(Student student) {
		String status = "";

		try {
			Connection con = ConnectionFactory.getMysqlDbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_STUDENT);

			preparedStatement.setString(1, student.getUserName());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getPassword());

			int row = 0;
			row = preparedStatement.executeUpdate();

			if (row != 0) {
				status = "Regstration successfull";
				System.out.println("Student Created  Successfully");
			} else {
				status = "Regstration failed try again";
				System.out.println("Not able to Create Student");
			}
		} catch (Exception e) {
			System.out.println("Database exception occcquered  " + e.getMessage());
		}

		return status;

	}

	public Student validateUser(String username, String password) {
		Student st = null;
		try {
			Connection con = ConnectionFactory.getMysqlDbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_VALIDATE_USER);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1);
				if (result >= 1) {
					st = getUser(username);
				}
			}



		} catch (Exception ex) {
			// Exception LOgic
		}

		return st;

	}

	public Student getUser(String userName) {
		Student st = null;
		try {
			Connection con = ConnectionFactory.getMysqlDbConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SQL_FETCH_USER);

			preparedStatement.setString(1, userName);		
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String dbuserName=rs.getString(1);
				String name=rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				
				st = new Student(dbuserName, password, name, email);
			}
		} catch (Exception e) {

		}
		return st;
	}
}

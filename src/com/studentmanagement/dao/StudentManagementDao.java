package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentmanagement.entity.Student;

public class StudentManagementDao {
	public static final String SQL_INSERT_STUDENT = "INSERT INTO STUDENT (USERNAME, NAME, EMAIL,PASSWORD) VALUES (?,?,?,?)";

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
}

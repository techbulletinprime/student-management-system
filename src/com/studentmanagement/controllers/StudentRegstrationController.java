package com.studentmanagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.dao.StudentManagementDao;
import com.studentmanagement.entity.Student;

/**
 * Servlet implementation class StudentRegstrationController
 */
public class StudentRegstrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegstrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentManagementDao studentManagementDao = new StudentManagementDao();
		Student student = new Student(request.getParameter("userName"), request.getParameter("pswd"),
				request.getParameter("name"), request.getParameter("email"));

		String status = studentManagementDao.saveStudent(student);

		if (status.equals("Regstration successfull")) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/regstrationFailed.jsp").forward(request, response);

		}
		
		
		doGet(request, response);
	}

}

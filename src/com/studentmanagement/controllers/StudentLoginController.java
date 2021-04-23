package com.studentmanagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.dao.StudentManagementDao;
import com.studentmanagement.entity.Student;

/**
 * Servlet implementation class StudentLoginController
 */

public class StudentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginController() {
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
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("LoginController");
		StudentManagementDao dao = new StudentManagementDao();
		Student st = dao.validateUser(username, password);
		if (st != null) {

			request.setAttribute("student", st);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

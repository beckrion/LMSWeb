package com.gcit.training.lms.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lms.dao.AuthorDAO;
import com.gcit.training.lms.entity.Author;
import com.gcit.training.lms.service.ConnectionUtil;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
		String authorName = request.getParameter("authorName");
		if (authorName.length() < 1 || authorName.length() > 40) {
			rd = getServletContext().getRequestDispatcher("/addauthor.jsp");
			request.setAttribute("result", "Author Name cannot be more than 45 chars!");
			rd.forward(request, response);
		}
		Author author = new Author();
		author.setAuthorName(authorName);
		ConnectionUtil util = new ConnectionUtil();
		AuthorDAO adao = new AuthorDAO(util.getConnection());

		try {
			adao.create(author);
			request.setAttribute("result", "Author Added Sucessfully!");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			rd = getServletContext().getRequestDispatcher("/addauthor.jsp");
			request.setAttribute("result", "Author Add Failed!");
			rd.forward(request, response);
		}
	}

}

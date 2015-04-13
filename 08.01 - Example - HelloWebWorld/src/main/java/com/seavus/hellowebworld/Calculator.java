package com.seavus.hellowebworld;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class Calculator extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ArrayList<String> sessionList = new ArrayList<String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String operandOne = req.getParameter("operandOne");
		String operandTwo = req.getParameter("operandTwo");
		String operation = req.getParameter("operation");
		String sessionOperation = "" + operandOne + " " + operation + " "
				+ operandTwo;

		HttpSession session = req.getSession();
		session.setAttribute("calculate", sessionOperation);
		String u = (String) session.getAttribute("calculate");
		sessionList.add(u);
		if (operation != null) {
			if (operation.contentEquals("ADD")) {

				resp.getWriter().println(add(operandOne, operandTwo));

			}

			if (operation.contentEquals("SUBSTRACT")) {

				resp.getWriter().println(substract(operandOne, operandTwo));
			}

			if (operation.contentEquals("MULTIPLY")) {
				resp.getWriter().println(multiply(operandOne, operandTwo));
			}

			if (operation.contentEquals("DEVIDE")) {
				resp.getWriter().println(devide(operandOne, operandTwo));
			}
			if (operation.contentEquals("HISTORY")) {

				resp.getWriter().println(sessionList);

			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	public int add(String operandOne, String operandTwo) {
		int result = 0;
		int one = 0;
		int two = 0;
		if (operandOne != null) {
			one = Integer.parseInt(operandOne);
		}
		if (operandTwo != null) {
			two = Integer.parseInt(operandTwo);
		}
		result = one + two;

		return result;
	}

	public int substract(String operandOne, String operandTwo) {

		int result = 0;

		int one = Integer.parseInt(operandOne);
		int two = Integer.parseInt(operandTwo);
		result = one - two;

		return result;
	}

	public int multiply(String operandOne, String operandTwo) {

		int result = 0;

		int one = Integer.parseInt(operandOne);
		int two = Integer.parseInt(operandTwo);
		result = one * two;

		return result;
	}

	public float devide(String operandOne, String operandTwo) {

		int result = 1;

		int one = Integer.parseInt(operandOne);
		int two = Integer.parseInt(operandTwo);
		result = one / two;

		return result;
	}

}

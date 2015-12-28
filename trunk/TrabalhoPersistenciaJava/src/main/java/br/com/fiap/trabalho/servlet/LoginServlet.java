package br.com.fiap.trabalho.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.trabalho.dao.jdbc.JDBCLoginDAO;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JDBCLoginDAO dao = new JDBCLoginDAO();
		dao.createLogin();
		String login = (String) req.getParameter("login");
		String senha = (String) req.getParameter("senha");
		System.out.println(login + " " + senha);
		boolean ret = dao.login(login, senha);
		PrintWriter out = resp.getWriter();
		if (ret) {
			out.print("LOGADO");
		} else {
			out.print("Usuário ou Senha inválidos");
		}
	}
}

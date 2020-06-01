package com.qst.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.bean.NoteBean;
import com.qst.note.dao.NoteDao;

/**
 * Servlet implementation class GetNoteServlet
 */
@WebServlet("/GetNoteServlet")

public class GetNoteServlet extends HttpServlet {
	private static final long serialVersionUlD = 1L;

	public GetNoteServlet() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		int id = Integer.valueOf(request.getParameter("id"));
		NoteDao dao = new NoteDao(); // dao¿‡

		NoteBean note = dao.getNoteByID(id);
		Gson gson = new Gson();

		response.getWriter().append(gson.toJson(note));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

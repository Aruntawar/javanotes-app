package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int  noteId=Integer.parseInt(request.getParameter("note_id").trim());

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Note note=s.get(Note.class,noteId);
			s.delete(note);
			tx.commit();
			response.sendRedirect("all_notes.jsp");
			s.close();
		}catch(Exception e){

		}
	}




}

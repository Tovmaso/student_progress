package controllers;

import db.DBManager;
import entiny.Discipline;
import entiny.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name="DisciplineModifyController" , urlPatterns = "/discipline-modify")
public class DisciplineModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("hiddenModifyDiscipline");
        DBManager dbManager = new DBManager();
        Discipline discipline = dbManager.getDisciplineById(id);

        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("WEB-INF/discipline-modify.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        String discipline = req.getParameter("discipline");

        DBManager dbManager = new DBManager();
        dbManager.modifyDiscipline(ids,discipline);
        resp.sendRedirect("/disciplines");
    }
}


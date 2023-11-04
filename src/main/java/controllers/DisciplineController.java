package controllers;

import db.DBManager;
import entiny.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplineController" , urlPatterns = "/disciplines")
public class DisciplineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        List<Discipline> disciplines = dbManager.getAllActiveDisciplines();
        req.setAttribute("discipline" , disciplines);
        req.getRequestDispatcher("WEB-INF/disciplines.jsp").forward(req,resp);
    }
}

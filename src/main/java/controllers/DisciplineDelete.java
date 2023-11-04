package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DisciplineDelete" , urlPatterns = "/discipline-delete")
public class DisciplineDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hiddenDeleteDiscipline = req.getParameter("hiddenDeleteDiscipline");
        String [] ids = hiddenDeleteDiscipline.split(" ");
        DBManager dbManager = new DBManager();
        dbManager.deleteDisciplines(ids);
        resp.sendRedirect("/disciplines");
    }
}

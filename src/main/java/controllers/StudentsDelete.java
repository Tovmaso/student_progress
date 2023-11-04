package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentsDelete" , urlPatterns = "/student-delete")
public class StudentsDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hiddenDelete = req.getParameter("hiddenDelete");
        String [] ids = hiddenDelete.split(" ");
        DBManager dbManager = new DBManager();
        dbManager.deleteStudent(ids);

        resp.sendRedirect("/students");
    }
}

package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentsCreateController", urlPatterns = "/student-create")
public class StudentsCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");  // то что ввел пользователь (вытянули инфу)


        if ((surname == null || surname.equals("") || name == null || name.equals("") || group == null || group.equals("") || date == null || date.equals(""))) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);

                return;
        }

        DBManager dbManager = new DBManager(); // подсоединение к БД
        dbManager.createStudent(surname, name, group, date);
        resp.sendRedirect("/students");
    }
}

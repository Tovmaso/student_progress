package controllers;

import db.DBManager;
import entiny.Mark;
import entiny.Student;
import entiny.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet (name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Данный метод будет вызываться при нажатии на две разные кнопки
        DBManager dbManager = new DBManager();

        String idStudent = req.getParameter("hiddenProgress"); // В двух кнопках нужно передавать обязательно данный параметр
        Student student = dbManager.getStudentById(idStudent);
        req.setAttribute("student",student);

        List<Term> terms = dbManager.getAllActiveTerm();
        req.setAttribute("terms",terms);

        // Может передаваться selectedTermId (если было нажатие на кнопку выбрать)
        String selectedTermId =req.getParameter("selectedTermId");
        if(selectedTermId != null){ // иф отрабатывает когда была нажата кнопка выбрать и мы получили ID выбранного семестра
            req.setAttribute("selected",selectedTermId);
        }else{ // когда нажали посмотреть успеваемость на главной странице
            selectedTermId = terms.get(0).getId()+"";
            req.setAttribute("selected",terms.get(0).getId()+"");
        }
        List<Mark> marks = dbManager.getMarksByStudent(idStudent,selectedTermId);
        req.setAttribute("marks",marks);

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}

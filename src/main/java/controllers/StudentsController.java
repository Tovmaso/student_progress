package controllers;
import db.DBManager;
import entiny.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="StudentsController" , urlPatterns = "/students")
public class StudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        List<Student> students = dbManager.getAllActiveStudent();
        req.setAttribute("students",students);
        req.getRequestDispatcher("WEB-INF/students.jsp").forward(req,resp);
    }
}

package db;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import constants.Constants;
import entiny.Discipline;
import entiny.Mark;
import entiny.Student;
import entiny.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.PaintEvent.UPDATE;

public class DBManager implements IDBManager{
    @Override
    public List<Student> getAllActiveStudent() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement(); // используется для выполнения SQL запросов к базе данных
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE status = 1");

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));

                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void deleteStudent(String[] ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement();  // создали пустой запрос
            for (String delStudent : ids)
                stmt.executeUpdate("UPDATE students_39.student SET status = '0' WHERE id = ('"+delStudent+"');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getStudentById(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement(); // используется для выполнения SQL запросов к базе данных
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE status = 1 AND id = " + id);

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));

                return student;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline WHERE status = '1'");

            while (rs.next()){
              Discipline discipline = new Discipline();
              discipline.setId(rs.getInt("id"));
              discipline.setDiscipline(rs.getString("discipline"));

              disciplines.add(discipline);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return disciplines;
    }

    @Override
    public void deleteDisciplines(String[] ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement();  // создали пустой запрос
            for (String delDiscipline : ids)
                stmt.executeUpdate("UPDATE students_39.discipline SET status = '0' WHERE id = ('"+delDiscipline+"');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Discipline getDisciplineById(String id) {
        return null;
    }

    @Override
    public void modifyDiscipline(String id, String newDiscipleName) {

    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подкл драйвера jdbc
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement(); // используется для выполнения SQL запросов к базе данных
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifyStudent(String id, String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подкл драйвера jdbc
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement(); // используется для выполнения SQL запросов к базе данных
            stmt.execute("UPDATE `student` SET `surname` = '"+surname+"', `name` = '"+name+"', `group` = '"+group+"', `date` = '"+date+"' WHERE (`id`='"+id+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createDiscipline(String discipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подкл драйвера jdbc
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement(); // используется для выполнения SQL запросов к базе данных
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('"+discipline+"');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Term> getAllActiveTerm() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term WHERE status = '1'");

            while (rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
                terms.add(term);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return terms;
    }

    @Override
    public List<Mark> getMarksByStudent(String idStudent, String idTerm) {
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Constants.URL_TO_DATABASE);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n" +
                    "left join term_discipline as td on m.id_term_discipline = td.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where m.id_student = 2 and td.id_term = 1");

            while (rs.next()){
                Mark mark = new Mark();
                mark.setMark(rs.getInt("mark"));
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline);
                marks.add(mark);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return marks;
    }
}

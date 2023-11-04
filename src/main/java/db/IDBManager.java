package db;

import entiny.Discipline;
import entiny.Mark;
import entiny.Student;
import entiny.Term;

import java.util.List;

public interface IDBManager {

    List<Student> getAllActiveStudent();

    void deleteStudent (String[] ids);

    Student getStudentById (String id);

    List<Discipline> getAllActiveDisciplines();

    void deleteDisciplines(String[] ids);

    Discipline getDisciplineById(String id);

    void modifyDiscipline(String id , String newDiscipleName);

    void createStudent(String surname , String name , String group , String date);

    void modifyStudent (String id, String surname , String name , String group , String date);

    void createDiscipline (String discipline);

    List<Term> getAllActiveTerm();
    List<Mark> getMarksByStudent(String idStudent, String idTerm);


}

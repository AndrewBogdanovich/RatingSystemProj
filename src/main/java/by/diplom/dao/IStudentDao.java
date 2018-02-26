package by.diplom.dao;

import by.diplom.model.Student;

import java.util.List;

public interface IStudentDao {

    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int id);

    Student getStudentById(int id);

    List<Student> listStudents();
}

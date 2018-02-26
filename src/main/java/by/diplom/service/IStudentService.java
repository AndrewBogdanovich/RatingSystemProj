package by.diplom.service;

import by.diplom.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int id);

    Student getStudentById(int id);

    List<Student> listStudents();
}

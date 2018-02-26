package by.diplom.service;

import by.diplom.dao.IStudentDao;
import by.diplom.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao iStudentDao;

    public void setiStudentDao(IStudentDao iStudentDao) {
        this.iStudentDao = iStudentDao;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        this.iStudentDao.addStudent(student);

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.iStudentDao.updateStudent(student);

    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        this.iStudentDao.removeStudent(id);

    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return this.iStudentDao.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return this.iStudentDao.listStudents();
    }
}

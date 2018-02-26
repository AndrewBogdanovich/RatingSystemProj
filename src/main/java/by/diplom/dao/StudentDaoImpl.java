package by.diplom.dao;

import by.diplom.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements IStudentDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);

    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);

    }

    @Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, new Integer(id));
        if(student!=null){
            session.delete(student);
        }

    }

    @Override
    public Student getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, new Integer(id));
        return student;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student").list();
        return studentList;
    }
}

package hw5.DAO;

import hw5.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDAO {
    private static SessionFactory factory;

    public static void init(){
        factory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
        Session currentSession;
        try {
            String sql1 = Files.lines(Paths.get("src/main/resources/sql/time.sql")).collect(Collectors.joining(" "));
            String sql2 = Files.lines(Paths.get("src/main/resources/sql/drop.sql")).collect(Collectors.joining(" "));
            String sql3 = Files.lines(Paths.get("src/main/resources/sql/students.sql")).collect(Collectors.joining(" "));

            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.createNativeQuery(sql1).executeUpdate();
            currentSession.createNativeQuery(sql2).executeUpdate();
            currentSession.createNativeQuery(sql3).executeUpdate();
            currentSession.getTransaction().commit();
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.getTransaction().commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudent(String name, int mark){
        try (Session session = factory.getCurrentSession();){
            session.beginTransaction();
            Student student = new Student(name, mark);
//            System.out.println(student);
            session.save(student);
            session.getTransaction().commit();
//            System.out.println(student);
        }
    }

    public static void getStudent(Long id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            System.out.println(student);
            session.getTransaction().commit();
        }
    }

    public static void updateStudent(Long id, String name){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        System.out.println(student);
        student.setName(name);
        System.out.println(student);
        session.getTransaction().commit();
        System.out.println(student);
    }

    public static void updateStudent(Long id, int mark){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        System.out.println(student);
        student.setMark(mark);
        System.out.println(student);
        session.getTransaction().commit();
        System.out.println(student);
    }

    public static void findAll(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            List<Student> productLis = session.createQuery("select s from Student s").getResultList();
            System.out.println(productLis.toString());
            session.getTransaction().commit();
        }
    }

    public static void removeStudent(Long id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            System.out.println(student);
            session.remove(session);
            System.out.println(student);
            session.getTransaction().commit();
            System.out.println(student);
        }
    }



    public static void  shutDown(){
        factory.close();
    }
}

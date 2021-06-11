package hw5;

import hw5.DAO.StudentDAO;
import hw5.model.StudentNames;

public class Main {
    public static void main(String[] args) {
        fillingTheTable();
        StudentDAO.getStudent(10L);
        StudentDAO.updateStudent(10L, "Алёна");
    }

    private static void fillingTheTable(){
        StudentDAO.init();
        StudentNames sn = new StudentNames();
        for (int i = 0; i < 1000; i++) {
            StudentDAO.saveStudent(sn.getNames().get((int)(Math.random()*12)), (int)(Math.random()*100));
        }
    }
}

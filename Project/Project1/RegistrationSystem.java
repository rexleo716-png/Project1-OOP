package Project1;

import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<Student> students = new ArrayList<Student>();

    public boolean addStudent(Student s) {
        if (findStudent(s.getId()) != null) {
            return false;
        }
        students.add(s);
        return true;
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean updateMark(int id, double newMark) {
        Student s = findStudent(id);
        if (s == null) {
            return false;
        }
        return s.setMark(newMark);
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public int getCount() {
        return students.size();
    }
}

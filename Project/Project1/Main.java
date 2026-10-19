package Project1;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static RegistrationSystem system = new RegistrationSystem();

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            showMenu();
            choice = readInt("Your choice: ");
            switch (choice) {
                case 1:
                    addStudent(false);
                    break;
                case 2:
                    addStudent(true);
                    break;
                case 3:
                    updateMark();
                    break;
                case 4:
                    system.displayAll();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== Registration System =====");
        System.out.println("1. Add undergraduate student");
        System.out.println("2. Add graduate student");
        System.out.println("3. Update student mark");
        System.out.println("4. Display all students");
        System.out.println("5. Exit");
    }

    static void addStudent(boolean isGrad) {
        System.out.print("Name: ");
        String name = input.nextLine();
        int id = readInt("ID: ");
        double mark = readDouble("Mark (0-100): ");

        Student s;
        if (isGrad) {
            s = new GradStudent(name, id, mark);
        } else {
            s = new UndergradStudent(name, id, mark);
        }

        if (mark < 0 || mark > 100) {
            System.out.println("Mark was invalid, it was set to 0.");
        }

        if (system.addStudent(s)) {
            System.out.println("Student added.");
        } else {
            System.out.println("A student with this ID already exists.");
        }
    }

    static void updateMark() {
        int id = readInt("Student ID: ");
        double newMark = readDouble("New mark (0-100): ");
        if (system.findStudent(id) == null) {
            System.out.println("Student not found.");
        } else if (system.updateMark(id, newMark)) {
            System.out.println("Mark updated.");
        } else {
            System.out.println("Invalid mark, nothing changed.");
        }
    }

    static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}

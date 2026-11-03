
package stu;

import java.util.ArrayList;

public class StudentManagement {

    ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {

        for (Student s : students) {

            if (s.studentId.equalsIgnoreCase(student.studentId)) {
                System.out.println("\nStudent ID already exists!");
                return;
            }

            if (s.email.equalsIgnoreCase(student.email)) {
                System.out.println("\nEmail already registered!");
                return;
            }
        }

        students.add(student);
        System.out.println("\nStudent registered successfully!");
    }

    // View All Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search Student by ID
    public void searchStudentById(String id) {

        for (Student student : students) {

            if (student.studentId.equalsIgnoreCase(id)) {
                System.out.println("\nStudent found successfully!");
                student.displayStudent();
                return;
            }
        }

        System.out.println("\nStudent not found with ID: " + id);
    }

    // Search Student by Name
    public void searchStudentByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.name.toLowerCase().contains(name.toLowerCase())) {

                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo student found with name: " + name);
        }
    }

    // Update Student
    public void updateStudent(String id, String email,
                              String mobile, String address) {

        for (Student student : students) {

            if (student.studentId.equalsIgnoreCase(id)) {

                // Check whether email belongs to another student
                for (Student s : students) {
                    if (s != student &&
                        s.email.equalsIgnoreCase(email)) {

                        System.out.println("\nEmail already registered to another student!");
                        return;
                    }
                }

                student.email = email;
                student.mobile = mobile;
                student.address = address;

                System.out.println("\nStudent details updated successfully!");
                return;
            }
        }

        System.out.println("\nStudent not found!");
    }

    // Delete Student
    public void deleteStudent(String id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).studentId.equalsIgnoreCase(id)) {

                students.remove(i);

                System.out.println("\nStudent deleted successfully!");
                return;
            }
        }

        System.out.println("\nStudent not found!");
    }
}

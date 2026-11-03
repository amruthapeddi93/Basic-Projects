
package stu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagement management = new StudentManagement();

        int choice=0;

        do {

            System.out.println("\n======================================");
            System.out.println("        STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student Details");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice (1-7): ");

            if (!sc.hasNextInt()) {
                System.out.println("\nInvalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n========== REGISTER STUDENT ==========");

                    System.out.print("Enter 10-character Student ID (e.g., 23CS001A01): ");
                    String id = sc.nextLine().trim();

                    if (!id.matches("[A-Za-z0-9]{10}")) {
                        System.out.println("\nInvalid Student ID! Enter exactly 10 alphanumeric characters.");
                        break;
                    }

                    System.out.print("Enter Student Full Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Date of Birth (DD-MM-YYYY): ");
                    String dob = sc.nextLine().trim();

                    System.out.print("Enter Gender (Male/Female/Other): ");
                    String gender = sc.nextLine().trim();

                    System.out.print("Enter Department (e.g., CSE): ");
                    String department = sc.nextLine().trim();

                    System.out.print("Enter Year of Study (1-4): ");
                    int year;

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid year!");
                        sc.nextLine();
                        break;
                    }

                    year = sc.nextInt();
                    sc.nextLine();

                    if (year < 1 || year > 4) {
                        System.out.println("Year must be between 1 and 4!");
                        break;
                    }

                    System.out.print("Enter Section (e.g., A): ");
                    String section = sc.nextLine().trim();

                    System.out.print("Enter Email Address: ");
                    String email = sc.nextLine().trim();

                    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                        System.out.println("Invalid email address!");
                        break;
                    }

                    System.out.print("Enter Mobile Number (10 digits): ");
                    String mobile = sc.nextLine().trim();

                    if (!mobile.matches("[0-9]{10}")) {
                        System.out.println("Invalid mobile number!");
                        break;
                    }

                    System.out.print("Enter Residential Address: ");
                    String address = sc.nextLine().trim();

                    if (name.isEmpty() || department.isEmpty() ||
                        section.isEmpty() || address.isEmpty() ||
                        dob.isEmpty() || gender.isEmpty()) {

                        System.out.println("Required fields cannot be empty!");
                        break;
                    }

                    Student student = new Student(
                        id, name, dob, gender, department,
                        year, section, email, mobile, address
                    );

                    management.addStudent(student);

                    break;

                case 2:

                    management.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID to search: ");
                    id = sc.nextLine().trim();

                    if (!id.matches("[A-Za-z0-9]{10}")) {
                        System.out.println("Enter a valid 10-character Student ID!");
                        break;
                    }

                    management.searchStudentById(id);

                    break;

                case 4:

                    System.out.print("Enter Student Name to search: ");
                    name = sc.nextLine().trim();

                    management.searchStudentByName(name);

                    break;

                case 5:

                    System.out.print("Enter Student ID to update: ");
                    id = sc.nextLine().trim();

                    if (!id.matches("[A-Za-z0-9]{10}")) {
                        System.out.println("Enter a valid 10-character Student ID!");
                        break;
                    }

                    System.out.print("Enter New Email Address: ");
                    email = sc.nextLine().trim();

                    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                        System.out.println("Invalid email address!");
                        break;
                    }

                    System.out.print("Enter New Mobile Number: ");
                    mobile = sc.nextLine().trim();

                    if (!mobile.matches("[0-9]{10}")) {
                        System.out.println("Invalid mobile number!");
                        break;
                    }

                    System.out.print("Enter New Residential Address: ");
                    address = sc.nextLine().trim();

                    management.updateStudent(id, email, mobile, address);

                    break;

                case 6:

                    System.out.print("Enter Student ID to delete: ");
                    id = sc.nextLine().trim();

                    if (!id.matches("[A-Za-z0-9]{10}")) {
                        System.out.println("Enter a valid 10-character Student ID!");
                        break;
                    }

                    management.deleteStudent(id);

                    break;

                case 7:

                    System.out.println("\nThank you for using Student Management System!");

                    break;

                default:

                    System.out.println("\nInvalid choice! Enter a number between 1 and 7.");
            }

        } while (choice != 7);

        sc.close();
    }
}

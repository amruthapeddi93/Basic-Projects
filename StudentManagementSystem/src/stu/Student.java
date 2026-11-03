
package stu;

public class Student {

    String studentId;
    String name;
    String dateOfBirth;
    String gender;
    String department;
    int year;
    String section;
    String email;
    String mobile;
    String address;

    // Constructor
    public Student(String studentId, String name,
                   String dateOfBirth, String gender,
                   String department, int year,
                   String section, String email,
                   String mobile, String address) {

        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.department = department;
        this.year = year;
        this.section = section;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    // Display Student Details
    public void displayStudent() {

        System.out.println("\n========== STUDENT DETAILS ==========");
        System.out.println("Student ID    : " + studentId);
        System.out.println("Student Name  : " + name);
        System.out.println("Date of Birth : " + dateOfBirth);
        System.out.println("Gender        : " + gender);
        System.out.println("Department    : " + department);
        System.out.println("Year          : " + year);
        System.out.println("Section       : " + section);
        System.out.println("Email         : " + email);
        System.out.println("Mobile        : " + mobile);
        System.out.println("Address       : " + address);
        System.out.println("=====================================");
    }
}

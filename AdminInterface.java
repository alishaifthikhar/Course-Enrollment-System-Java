import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminInterface {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign a grade");
            System.out.println("4. Calculate overall grade");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter course code:");
                    String courseCode = scanner.nextLine();
                    System.out.println("Enter course name:");
                    String courseName = scanner.nextLine();
                    System.out.println("Enter course maximum capacity:");
                    int maxCapacity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    break;
                case 2:
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter course code for enrollment:");
                    String enrollCourseCode = scanner.nextLine();
                    Student student = new Student(studentName, studentId);
                    students.add(student);  // Add student to the list
                    Course enrollCourse = getCourseByCode(enrollCourseCode);
                    if (enrollCourse != null) {
                        CourseManagement.enrollStudent(student, enrollCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID:");
                    String gradeStudentId = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String gradeCourseCode = scanner.nextLine();
                    System.out.println("Enter grade:");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Student gradeStudent = getStudentById(gradeStudentId);
                    Course gradeCourse = getCourseByCode(gradeCourseCode);
                    if (gradeStudent != null && gradeCourse != null) {
                        CourseManagement.assignGrade(gradeStudent, gradeCourse, grade);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID:");
                    String overallGradeStudentId = scanner.nextLine();
                    Student overallGradeStudent = getStudentById(overallGradeStudentId);
                    if (overallGradeStudent != null) {
                        CourseManagement.calculateOverallGrade(overallGradeStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static Course getCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

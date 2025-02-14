import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Map<Student, Double> overallGrades = new HashMap<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
    }

    public static void enrollStudent(Student student, Course course) {
        if (course.getEnrolledStudents() < course.getMaxCapacity()) {
            student.enrollCourse(course);
            course.enrollStudent();
        } else {
            System.out.println("Course capacity reached. Cannot enroll student.");
        }
    }

    public static void assignGrade(Student student, Course course, double grade) {
        course.assignGrade(student, grade);
    }

    public static void calculateOverallGrade(Student student) {
        double total = 0;
        int count = 0;
        for (Map.Entry<Course, Double> entry : student.getGrades().entrySet()) {
            if (entry.getValue() != null) {
                total += entry.getValue();
                count++;
            }
        }
        double overallGrade = (count == 0) ? 0 : total / count;
        overallGrades.put(student, overallGrade);
        System.out.println("Overall grade for student " + student.getId() + " is: " + overallGrade);
    }

    public static List<Course> getCourses() {
        return courses;
    }
}

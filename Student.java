import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<Course, Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void enrollCourse(Course course) {
        grades.put(course, null);  // null means the student is enrolled but has no grade yet
    }

    public void setGrade(Course course, double grade) {
        if (grades.containsKey(course)) {
            grades.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    public double getGrade(Course course) {
        return grades.getOrDefault(course, -1.0);  // -1.0 means no grade assigned
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }
}

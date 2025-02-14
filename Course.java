public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledStudents;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
        } else {
            System.out.println("Course is at full capacity.");
        }
    }

    public void assignGrade(Student student, double grade) {
        student.setGrade(this, grade);
    }
}

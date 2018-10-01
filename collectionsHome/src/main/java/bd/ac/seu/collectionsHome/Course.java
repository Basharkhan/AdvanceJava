package bd.ac.seu.collectionsHome;

public class Course {
    private String courseCode;
    private String courseTitles;
    private double credits;

    public Course() {
    }

    public Course(String courseCode, String courseTitles, double credits) {
        this.courseCode = courseCode;
        this.courseTitles = courseTitles;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitles() {
        return courseTitles;
    }

    public double getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitles='" + courseTitles + '\'' +
                ", credits=" + credits +
                '}';
    }
}

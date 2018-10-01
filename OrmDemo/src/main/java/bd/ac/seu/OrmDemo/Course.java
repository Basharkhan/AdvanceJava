package bd.ac.seu.OrmDemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private double creditHour;
    @ManyToMany
    @JoinTable(name = "Registration", joinColumns = {@JoinColumn(name = "courseCode")},
            inverseJoinColumns = {@JoinColumn(name = "studentId")})

    private Set<Student> studentSet;

    public Course() {
        studentSet = new HashSet<>();
    }

    public Course(String courseCode, String courseTitle, double creditHour) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.creditHour = creditHour;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(double creditHour) {
        this.creditHour = creditHour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", creditHour=" + creditHour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
}

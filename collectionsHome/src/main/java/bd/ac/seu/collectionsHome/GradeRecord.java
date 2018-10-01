package bd.ac.seu.collectionsHome;

public class GradeRecord {
    private int studentId;
    private String courseCode;
    private String facultyInitilas;
    private String grade;
    private int semesterId;

    public GradeRecord(int studentId, String courseCode, String facultyInitilas, String grade, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitilas = facultyInitilas;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getFacultyInitilas() {
        return facultyInitilas;
    }

    public String getGrade() {
        return grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    @Override
    public String toString() {
        return "GradeRecord{" +
                "studentId=" + studentId +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitilas='" + facultyInitilas + '\'' +
                ", grade='" + grade + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}

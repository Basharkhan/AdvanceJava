package bd.ac.seu.collectionsHome;

public class Registartion {
    private int studentId;
    private String courseCode;
    private String facultyInitilas;
    private int semesterId;

    public Registartion() {
    }

    public Registartion(int studentId, String courseCode, String facultyInitilas, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitilas = facultyInitilas;
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

    public int getSemesterId() {
        return semesterId;
    }

    @Override
    public String toString() {
        return "Registartion{" +
                "studentId=" + studentId +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitilas='" + facultyInitilas + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}

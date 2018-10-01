package bd.ac.seu.OrmDemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    private int id;
    @Embedded
    private Name name;
    private String emailAddress;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @ManyToMany
    @JoinTable(name = "Registration", joinColumns = {@JoinColumn(name = "studentId")},
                                    inverseJoinColumns = {@JoinColumn(name = "courseCode")})
    private Set<Course> courseSet;

    public Student() {
        courseSet = new HashSet<>();
    }

    public Student(int id,
                   Name name,
                   String emailAddress,
                   Address address,
                   Sex sex) {
        this();
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.address = address;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", emailAddress='" + emailAddress + '\'' +
                ", address=" + address +
                ", sex=" + sex +
                ", courseSet=" + courseSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}

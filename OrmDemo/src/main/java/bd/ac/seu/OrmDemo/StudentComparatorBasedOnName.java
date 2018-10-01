package bd.ac.seu.OrmDemo;

import java.util.Comparator;

public class StudentComparatorBasedOnName implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        int length1 = s1.getName().firstName.length();
        int length2 = s2.getName().firstName.length();

        return length1 == length2 ? s1.getName().
                firstName.
                compareTo(s2.getName().firstName) : length1 - length2;

/*
        if(length1 > length2)
            return +1;
        else if(length1 < length2)
            return -1;
        else {
            if(s1.getName().firstName.compareTo(s2.getName().firstName) > 0)
                return +1;
            else if(s1.getName().firstName.compareTo(s2.getName().firstName) < 0)
                return -1;
            else return 0;
        }
*/

    }
}

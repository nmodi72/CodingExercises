package main.concept.Comparable;

import java.util.Comparator;
import main.concept.Comparator.Student;

/**
 * This is the comparator class which compares the object based on Student Name
 */
public class NameComparable implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return toString().compareTo(o.toString());
    }
}

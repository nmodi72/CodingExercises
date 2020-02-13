package main.java.Impl.concept.Comparable;

import main.java.Impl.concept.Comparator.Student;

/**
 * This is the comparator class which compares the object based on Student Name
 */
public class NameComparable implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return toString().compareTo(o.toString());
    }
}

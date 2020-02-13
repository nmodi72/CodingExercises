package main.java.Impl.concept.Comparator;

import java.util.Comparator;

/**
 * This is the comparator class which compares the object based on Student Name
 */
public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        String student1 = o1.getName();
        String student2 = o2.getName();
        return student1.compareTo(student2);
    }

}

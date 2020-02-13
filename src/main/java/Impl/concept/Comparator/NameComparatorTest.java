package main.java.Impl.concept.Comparator;

import java.util.Arrays;

/**
 * This is test to test NameComparable
 */
public class NameComparatorTest {

    public static void main(String args[]) {
        Student[] student = new Student[3];
        student[0] = new Student();
        student[0].setId(1);
        student[0].setName("Nick");
        student[0].setAge(23);

        student[1] = new Student();
        student[1].setId(2);
        student[1].setName("Helen");
        student[1].setAge(43);

        student[2] = new Student();
        student[2].setId(3);
        student[2].setName("Maregni");
        student[2].setAge(34);

        System.out.println(student[0].toString());
        System.out.println(student[1].toString());
        System.out.println(student[2].toString());

        System.out.println("Order of students before sorting is: ");
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t" + student[i].getAge());
        }
//        Arrays.sort(student, new NameComparator());
        Arrays.sort(student, (a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("Order of students after sorting by student name is");
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t" + student[i].getAge());
        }

    }
}

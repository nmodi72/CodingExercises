package main.concept.Comparator;

import java.util.Comparator;

/**
 * This is Student class
 */
public class Student {

    private int id;
    private String name;
    private int age;

    public Student() {
        // Not implemented.
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student object: Id: [%s], Name: [%s] and Age: [%s] ", id, name, age);
    }
}

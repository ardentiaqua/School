package Zwykla;

import util.ObjectPlus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student extends ObjectPlus {
    private String name;
    private Set<Course> courses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 6.1. Getter – zwraca niemodyfikowalny zbiór
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

    // 6.2. Dodanie kursu (tworzy obustronne powiązanie)
    public void addCourse(Course course) {
        if (course == null || courses.contains(course)) return;
        courses.add(course);
        course.addStudent(this); // referencja zwrotna
    }

    // 6.3. Usunięcie kursu (usuwa obustronnie)
    public void removeCourse(Course course) {
        if (course == null || !courses.contains(course)) return;
        courses.remove(course);
        course.removeStudent(this); // referencja zwrotna
    }

    // 6.4. Zastąpienie jednego kursu innym
    public void replaceCourse(Course oldCourse, Course newCourse) {
        if (oldCourse == null || newCourse == null || oldCourse.equals(newCourse)) return;
        removeCourse(oldCourse);
        addCourse(newCourse);
    }
}

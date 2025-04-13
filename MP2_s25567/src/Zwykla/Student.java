package Zwykla;

import util.ObjectPlus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student extends ObjectPlus {
    private String name;
    private Set<Course> courses = new HashSet<>();

    public Student(String name, Set<Course> courses) {
        try{
     setName(name);
     setCourses(courses);}
        catch(Exception e){
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Student name cannot be null or empty");
        this.name = name;
    }

    public void setCourses(Set<Course> courses) {
        if(courses == null || courses.isEmpty()) throw new IllegalArgumentException("Student courses cannot be null or empty");
        this.courses = courses;
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

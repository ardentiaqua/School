package Zwykla;

import util.ObjectPlus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Course extends ObjectPlus {
    public Course(String name, Set<Student> students) {
     try{
         setName(name);
         setStudents(students);
     }catch(Exception e){
         e.printStackTrace();
         removeFromExtent();
     }
    }

    private String name;
    private Set<Student> students = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 6.1. Getter
    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    // 6.2. Dodanie studenta
    public void addStudent(Student student) {
        if (student == null || students.contains(student)) return;
        students.add(student);
        student.addCourse(this); // referencja zwrotna
    }

    // 6.3. Usunięcie studenta
    public void removeStudent(Student student) {
        if (student == null || !students.contains(student)) return;
        students.remove(student);
        student.removeCourse(this); // referencja zwrotna
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Student name cannot be empty");
        this.name = name;
    }

    public void setStudents(Set<Student> students) {
        if (students == null || students.isEmpty()) throw new IllegalArgumentException("Students cannot be empty");
        this.students = students;
    }

    // 6.4. Zastąpienie studenta innym
    public void replaceStudent(Student oldStudent, Student newStudent) {
        if (oldStudent == null || newStudent == null || oldStudent.equals(newStudent)) return;
        removeStudent(oldStudent);
        addStudent(newStudent);
    }
}

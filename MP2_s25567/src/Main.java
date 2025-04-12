import Zwykla.Course;
import Zwykla.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//zwykla
        Student anna = new Student("Anna");
        Student bartek = new Student("Bartek");

        Course java = new Course("Java");
        Course python = new Course("Python");

        anna.addCourse(java);
        bartek.addCourse(java);
        anna.addCourse(python);

        System.out.println("Kursy Anny:");
        for (Course c : anna.getCourses()) {
            System.out.println("- " + c.getName());
        }

        System.out.println("Studenci na kursie Java:");
        for (Student s : java.getStudents()) {
            System.out.println("- " + s.getName());
        }

        // Usunięcie powiązania
        anna.removeCourse(java);

        System.out.println("Po usunięciu kursu Java z Anny:");
        System.out.println("Kursy Anny: " + anna.getCourses().size());
        System.out.println("Studenci na kursie Java: " + java.getStudents().size());
    //z Atrybutem
    }
}
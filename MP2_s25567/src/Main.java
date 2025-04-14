import ZAtrybutem.Book;
import ZAtrybutem.Loan;
import ZAtrybutem.Reader;
import Zwykla.Course;
import Zwykla.Student;

import java.time.LocalDate;

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

        Reader reader = new Reader("Ola");
        Book book = new Book("Zbrodnia i kara");

        Loan loan = new Loan(reader, book, LocalDate.now(), LocalDate.now().plusDays(30));

        System.out.println(reader.getName() + " wypożyczył/a: " + loan.getBook().getTitle());
        System.out.println("Data zwrotu: " + loan.getReturnDeadline());

        System.out.println("Liczba wypożyczeń książki: " + book.getLoans().size());
        loan.removeFromExtent();
        System.out.println("Po usunięciu: " + book.getLoans().size());
    }
}
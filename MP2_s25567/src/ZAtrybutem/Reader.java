package ZAtrybutem;

import util.ObjectPlus;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Reader extends ObjectPlus {
    private String name;
    private Set<Loan> loans = new HashSet<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Loan> getLoans() {
        return Collections.unmodifiableSet(loans);
    }

    // Dodanie nowego wypożyczenia
    void addLoan(Loan loan) {
        // Sprawdzenie, czy już istnieje takie wypożyczenie
        if (loans.stream().noneMatch(existingLoan -> existingLoan.getBook() == loan.getBook())) {
            loans.add(loan);
            loan.getBook().addLoan(loan);  // Dodajemy to wypożyczenie do książki
        }
    }

    // Usuwanie wypożyczenia
    void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.getBook().removeLoan(loan);  // Usuwamy powiązanie z książką
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", loans=" + loans +
                '}';
    }
}

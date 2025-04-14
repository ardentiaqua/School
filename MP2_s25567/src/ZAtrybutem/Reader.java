package ZAtrybutem;

import util.ObjectPlus;

import java.util.*;

public class Reader extends ObjectPlus {
    private String name;
    private ArrayList<Loan> loans = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    // Dodanie nowego wypożyczenia
    void addLoan(Loan loan) {
        if (loan != null && !loans.contains(loan)) {
            loans.add(loan);
        }
    }

    // Usuwanie wypożyczenia
    void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", loans=" + loans +
                '}';
    }
}

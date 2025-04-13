package ZAtrybutem;

import util.ObjectPlus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Book extends ObjectPlus {
    private String title;

    public Book(String title, Set<Loan> loans) {
        try{
            setTitle(title);
            setLoans(loans);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        if (title == null || title.equals("") ) throw new NullPointerException("title is null or empty");
        this.title = title;
    }

    public void setLoans(Set<Loan> loans) {
        if (loans == null) throw new NullPointerException("loans is null");
        this.loans = loans;
    }

    private Set<Loan> loans = new HashSet<>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Set<Loan> getLoans() {
        return Collections.unmodifiableSet(loans);
    }

    void addLoan(Loan loan) {
        if (loans.stream().noneMatch(existingLoan -> existingLoan.getReader() == loan.getReader())) {
            loans.add(loan);
            loan.getReader().addLoan(loan);   }
    }

    // Usuwanie wypożyczenia
    void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.getReader().removeLoan(loan);
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", loans=" + loans +
                '}';
    }
}

package ZAtrybutem;

import util.ObjectPlus;

import java.util.*;

public class Book extends ObjectPlus {
    private String title;

    public Book(String title, ArrayList<Loan> loans) {
        try {
            setTitle(title);
            setLoans(loans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        if (title == null || title.equals("")) throw new NullPointerException("title is null or empty");
        this.title = title;
    }

    public void setLoans(ArrayList<Loan> loans) {
        if (loans == null) throw new NullPointerException("loans is null");
        this.loans = loans;
    }

    private ArrayList<Loan> loans = new ArrayList<Loan>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

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
        return "Book{" +
                "title='" + title + '\'' +
                ", loans=" + loans +
                '}';
    }
}

package ZAtrybutem;
import util.ObjectPlus;

import java.time.LocalDate;

public class Loan extends ObjectPlus {
    private final Reader reader;
    private final Book book;
    private final LocalDate loanDate;
    private final LocalDate returnDeadline;
    private boolean returned;

    public Loan(Reader reader, Book book, LocalDate loanDate, LocalDate returnDeadline) {
        this.reader = reader;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDeadline = returnDeadline;
        this.returned = false;

        reader.addLoan(this);
        book.addLoan(this);
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDeadline() {
        return returnDeadline;
    }

    public boolean isReturned() {
        return returned;
    }

    public void markAsReturned() {
        this.returned = true;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "reader=" + reader.getName() +
                ", book=" + book.getTitle() +
                ", loanDate=" + loanDate +
                ", returnDeadline=" + returnDeadline +
                ", returned=" + returned +
                '}';
    }
}

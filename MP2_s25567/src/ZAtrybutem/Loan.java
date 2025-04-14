package ZAtrybutem;

import util.ObjectPlus;

import java.time.LocalDate;

public class Loan extends ObjectPlus {
    private Reader reader;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDeadline;
    private boolean returned;

    public Loan(Reader reader, Book book, LocalDate loanDate, LocalDate returnDeadline) {
        try {
            setReader(reader);
            setBook(book);
            setLoanDate(loanDate);
            setReturnDeadline(returnDeadline);
            setReturned(false);

            reader.addLoan(this);
            book.addLoan(this);

        } catch (Exception e) {
            removeFromExtent();
        }


    }


    public void setReader(Reader reader) {
        if (reader != null) {
            this.reader = reader;
        }
    }

    public void setBook(Book book) {
        if (reader != null) {
            this.book = book;
        }
    }

    public void delete() {
        if (reader != null) {
            reader.removeLoan(this);
        }
        if (book != null) {
            book.removeLoan(this);
        }
        this.reader = null;
        this.book = null;
        removeFromExtent();
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

    private void setReturned(boolean isReturned) {
        this.returned = isReturned;
    }

    private void setReturnDeadline(LocalDate returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    private void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
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

    @Override
    public void removeFromExtent() {
        super.removeFromExtent();
        this.delete();
    }
}

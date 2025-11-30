package Library;

import java.io.*;
import java.time.LocalDate;

public class LoanDTO {
    private int id;
    private int userId;
    private int bookId;
    private boolean returned;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanDTO() {}
    public LoanDTO(int id, int userId, int bookId, LocalDate loanDate) {
        this.id = id; this.userId = userId; this.bookId = bookId; this.loanDate = loanDate; this.returned = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public boolean isReturned() { return returned; }
    public void setReturned(boolean returned) { this.returned = returned; }
    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}

package BankStatementAnalyser;

import java.time.LocalDate;

public class BankTransaction {

    private LocalDate transactionDate;
    private double amount;
    private String description;

    public BankTransaction(LocalDate transactionDate, double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}

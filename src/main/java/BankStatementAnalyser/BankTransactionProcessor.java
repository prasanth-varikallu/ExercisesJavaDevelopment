package BankStatementAnalyser;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionProcessor {
    private List<BankTransaction> transactions;

    BankTransactionProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    double calculateTotal() {
        return transactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double getTotalByMonth(Month month) {
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionDate().getMonth() == month)
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double getTotalByType(String description) {
        return transactions.stream()
                .filter(t -> t.getDescription().equals(description))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public List<BankTransaction> getTransactionsOver(double amount) {
        return transactions.stream()
                .filter(t -> t.getAmount() >= amount)
                .collect(Collectors.toList());
    }
}

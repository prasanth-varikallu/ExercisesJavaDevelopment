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
//        return transactions.stream()
//                .filter(transaction -> transaction.getTransactionDate().getMonth() == month)
//                .mapToDouble(BankTransaction::getAmount)
//                .sum();

        BankTransactionSummarizer summarizer = (result, transaction) ->
                transaction.getTransactionDate().getMonth() == month ? result + transaction.getAmount() : result;

        return summarizeTransactions(summarizer);
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

    public List<BankTransaction> findTransaction(BankTransactionFilter transactionFilter) {
        return transactions.stream()
                .filter(t -> transactionFilter.test(t) == true)
                .collect(Collectors.toList());
    }

    public double summarizeTransactions(BankTransactionSummarizer transactionSummarizer) {
        double result = 0;

        for (var transaction : transactions) {
            result = transactionSummarizer.summarize(result, transaction);
        }

        return result;
    }
}

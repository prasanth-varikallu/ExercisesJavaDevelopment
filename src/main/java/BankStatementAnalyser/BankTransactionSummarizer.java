package BankStatementAnalyser;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction transaction);
}

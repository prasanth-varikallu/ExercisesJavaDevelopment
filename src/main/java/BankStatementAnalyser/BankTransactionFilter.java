package BankStatementAnalyser;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction transaction);
}


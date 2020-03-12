package BankStatementAnalyser;

import BankStatementAnalyser.StatementParser.BankStatementCSVParser;
import BankStatementAnalyser.StatementParser.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyser {
    private static final String RESOURCES = "src/test/resources/Statement.csv";

    public void analyse(final BankStatementParser statementParser) throws IOException {

        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> transactions = statementParser.parseLinesFrom(lines);
        BankTransactionProcessor transactionProcessor = new BankTransactionProcessor(transactions);

        System.out.println(transactionProcessor.calculateTotal());
        System.out.println(transactionProcessor.getTotalByMonth(Month.JANUARY));
        List<BankTransaction> filteredTransactions = transactionProcessor.findTransaction(bankTransaction ->
                bankTransaction.getTransactionDate().getMonth() == Month.FEBRUARY
                        && bankTransaction.getAmount() >= 1_000);

        filteredTransactions.forEach(System.out::println);

    }
}

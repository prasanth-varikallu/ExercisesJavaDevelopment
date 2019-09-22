package BankStatementAnalyser;

import BankStatementAnalyser.StatementParser.BankStatementCSVParser;
import BankStatementAnalyser.StatementParser.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyser {
    private static final String RESOURCES = "src/test/resources/Statement.csv";

    public static void main(String[] args) throws IOException {

        BankStatementAnalyser statementAnalyser = new BankStatementAnalyser();
        statementAnalyser.analyse(new BankStatementCSVParser());
    }

    private void analyse(BankStatementParser statementParser) throws IOException {

        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> transactions = statementParser.parseLinesFrom(lines);
        BankTransactionProcessor transactionProcessor = new BankTransactionProcessor(transactions);

        System.out.println(transactionProcessor.calculateTotal());
    }
}

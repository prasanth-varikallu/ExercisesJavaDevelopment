package BankStatementAnalyser.StatementParser;

import BankStatementAnalyser.BankTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCSVParser implements BankStatementParser {

    public BankTransaction parseLine(String line) {
        String[] transaction = line.split(",");
        LocalDate tranDate = LocalDate.parse(transaction[0], PATTERN);
        double amount = Double.parseDouble(transaction[1]);

        return new BankTransaction(tranDate, amount, transaction[2]);

    }

    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return lines.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());

    }
}

package BankStatementAnalyser.StatementParser;

import BankStatementAnalyser.BankTransaction;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface BankStatementParser {
    DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyy");

    BankTransaction parseLine(String transaction);

    List<BankTransaction> parseLinesFrom(List<String> lines);


}

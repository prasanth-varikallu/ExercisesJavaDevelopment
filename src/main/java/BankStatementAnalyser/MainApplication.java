package BankStatementAnalyser;

import BankStatementAnalyser.StatementParser.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {

    public static void main(String... args) throws IOException {
        BankStatementAnalyser statementAnalyser = new BankStatementAnalyser();
        statementAnalyser.analyse(new BankStatementCSVParser());
    }
}

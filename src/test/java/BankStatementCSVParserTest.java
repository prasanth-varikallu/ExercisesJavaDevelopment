import BankStatementAnalyser.BankTransaction;
import BankStatementAnalyser.StatementParser.BankStatementCSVParser;
import BankStatementAnalyser.StatementParser.BankStatementParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankStatementCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction expectedTransaction = new BankTransaction(LocalDate.of(2017, 1, 30), -50, "Tesco");
        BankTransaction actualTransaction = statementParser.parseLine(line);

        assertEquals(expectedTransaction.getAmount(), actualTransaction.getAmount());
        assertEquals(expectedTransaction.getTransactionDate(), actualTransaction.getTransactionDate());
        assertEquals(expectedTransaction.getDescription(), actualTransaction.getDescription());
    }
}

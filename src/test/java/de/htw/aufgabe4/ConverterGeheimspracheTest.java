package de.htw.aufgabe4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConverterGeheimspracheTest {

    // TODO TIPP: wenn Ihnen Testcases zum Entwickeln fehlen ergänzen Sie diese.

    public static Stream<Object[]> getInputAndExpecded() {
        return Stream.of(new Object[][]{
                {"A", "X"},
                {"a", "X"},
                {"Klausur", "HIXRPRO"},
                {"Hochschule", "ELZEPZERIB"},
                {"Apfel", "XMCBI"},
                {"Informatik", "FKCLOJXQFH"},
                {"INFORMATIK", "FKCLOJXQFH"},
                {"Mathematik", "JXQEBJXQFH"},
                {"Xylophon", "UVILMELK"},
                {"Zimmer", "WFJJBO"},
                {"C", "Z"},
                {"Buecher", "YRBZEBO"},
                {"Haftpflichtversicherung", "EXCQMCIFZEQSBOPFZEBORKD"},
                {"Dampfschifffahrtsgesellschaft", "AXJMCPZEFCCCXEOQPDBPBIIPZEXCQ"},
                {"Finanzdienstleistungsunternehmen", "CFKXKWAFBKPQIBFPQRKDPRKQBOKBEJBK"},
                {"Veranstaltungsinformationsdienst", "SBOXKPQXIQRKDPFKCLOJXQFLKPAFBKPQ"},
                {"Wortschatx", "TLOQPZEXQU"},
                {"Aepfel", "XBMCBI"},
                {"M", "J"},
                {"Geheimgesellschaft", "DBEBFJDBPBIIPZEXCQ"},
                {"Mathe", "JXQEB"},
                {"Kinder", "HFKABO"},
                {"Studentinnen", "PQRABKQFKKBK"}
        });
    }

    @ParameterizedTest
    @MethodSource("getInputAndExpecded")
    public void checkAllInputs(String input, String expected) {
        GeheimspracheEncoder converter = new GeheimspracheEncoder();
        String result = converter.encode(input);
        assertEquals(expected, result);
    }
}
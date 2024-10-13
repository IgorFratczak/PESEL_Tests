import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PeselTest {

    private final String csvFile = "src/pesel_test_data.csv";
    private String line;
    private final String cvsSplitBy = ",";

    @BeforeEach
    void setUp() {
        System.out.println("Start testing \n");
    }

    @AfterEach
    void tearDown() {
        System.out.println("End testing");
    }

    @Test
    void testPeselData() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] peselData = line.split(cvsSplitBy);

                String pesel = peselData[0];
                String expectedGender = peselData[1];
                String expectedBirthDate = peselData[2];
                boolean expectedIsValid = Boolean.parseBoolean(peselData[3]);
                System.out.println("Pesel: "+peselData[0]+ "\nGender: " + peselData[1] + "\nBirth date: " +peselData[2]+"\nExpectet valid: "+peselData[3] + "\n");
                assertEquals(expectedIsValid, Pesel.isValidPesel(pesel));
                if (expectedIsValid) {
                    assertEquals(expectedGender, Pesel.gender(pesel));
                }
                if (expectedIsValid) {
                    assertEquals(expectedBirthDate, Pesel.birthDate(pesel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
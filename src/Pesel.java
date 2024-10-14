/**
 * Class for calculating gender and birthdate from a PESEL number.
 *
 * <p>This class provides methods to determine gender and birthdate
 * based on a given PESEL number. It also includes validation methods
 * to ensure the PESEL number is correctly formatted and valid.</p>
 *
 * @author Igor Frątczak
 * @version 1.0
 * @since 2024-10-13
 */
public class Pesel {

    /**
     * Determines the gender based on the provided PESEL number.
     *
     * @param peselNumber the PESEL number as a string
     * @return "K" for female and "M" for male
     * @throws IllegalArgumentException if the PESEL number is invalid
     */
    public static String gender(String peselNumber) throws IllegalArgumentException {
        check_Pesel(peselNumber);
        int genderDigit = Character.getNumericValue(peselNumber.charAt(9));
        return (genderDigit % 2 == 0) ? "K" : "M";
    }

    /**
     * Extracts the birthdate from the provided PESEL number.
     *
     * @param peselNumber the PESEL number as a string
     * @return the birthdate formatted as "dd.MM.yyyy"
     * @throws IllegalArgumentException if the PESEL number is invalid
     */
    public static String birthDate(String peselNumber) throws IllegalArgumentException {
        check_Pesel(peselNumber);
        int year = Integer.parseInt(peselNumber.substring(0, 2));
        int month = Integer.parseInt(peselNumber.substring(2, 4));
        int day = Integer.parseInt(peselNumber.substring(4, 6));

        if (month >= 1 && month <= 12) {
            year += 1900;
        } else if (month >= 21 && month <= 32) {
            year += 2000;
            month -= 20;
        } else if (month >= 81 && month <= 92) {
            year += 1800;
            month -= 80;
        } else if (month >= 41 && month <= 52) {
            year += 2100;
            month -= 40;
        } else if (month >= 61 && month <= 72) {
            year += 2200;
            month -= 60;
        } else {
            throw new IllegalArgumentException("Invalid month in PESEL.");
        }

        return String.format("%02d.%02d.%d", day, month, year);
    }



    /**
     * Validates the provided PESEL number for correctness.
     *
     * @param pesel the PESEL number as a string
     * @throws IllegalArgumentException if the PESEL number is invalid
     */
    public static Boolean check_Pesel(String pesel) throws IllegalArgumentException {
        if (pesel == null) {
            throw new IllegalArgumentException("Pesel is null pointer");
        }
        if (pesel.length() != 11) {
            throw new IllegalArgumentException("Pesel length is not corect");
        }
        if (!pesel.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        int checksum = (10 - (sum % 10)) % 10;
        int lastDigit = Character.getNumericValue(pesel.charAt(10));
        return checksum == lastDigit;
    }


}
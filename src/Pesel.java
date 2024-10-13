public class Pesel {

    public static String gender(String peselNumber) {
        if (!isValidPesel(peselNumber)) {
            throw new IllegalArgumentException("Invalid PESEL number.");
        }
        int genderDigit = Character.getNumericValue(peselNumber.charAt(9));
        return (genderDigit % 2 == 0) ? "K" : "M";
    }

    public static String birthDate(String peselNumber) {
        if (!isValidPesel(peselNumber)) {
            throw new IllegalArgumentException("Invalid PESEL number.");
        }
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

    public static boolean isValidPesel(String pesel) {
        if (pesel == null || pesel.length() != 11 || !pesel.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid PESEL number.");
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
public class Pesel {

    public static String gender(String peselNumber) throws IllegalArgumentException {
        validatePesel(peselNumber);
        int genderDigit = Character.getNumericValue(peselNumber.charAt(9));
        return (genderDigit % 2 == 0) ? "K" : "M";
    }

    public static String birthDate(String peselNumber) throws IllegalArgumentException {
        validatePesel(peselNumber);
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
        try {
            validatePesel(pesel);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static class PeselNullException extends IllegalArgumentException {
        public PeselNullException() {
            super("PESEL is null.");
        }
    }

    public static class PeselLengthException extends IllegalArgumentException {
        public PeselLengthException() {
            super("PESEL must be 11 characters long.");
        }
    }

    public static class PeselInvalidCharacterException extends IllegalArgumentException {
        public PeselInvalidCharacterException() {
            super("PESEL contains invalid characters.");
        }
    }

    public static class PeselChecksumMismatchException extends IllegalArgumentException {
        public PeselChecksumMismatchException() {
            super("PESEL checksum mismatch.");
        }
    }

    public static class PeselInvalidMonthException extends IllegalArgumentException {
        public PeselInvalidMonthException() {
            super("Invalid month in PESEL.");
        }
    }

    private static Boolean validatePesel(String pesel) throws IllegalArgumentException {
        if (pesel == null) {
            throw new PeselNullException();
        }
        if (pesel.length() != 11) {
            throw new PeselLengthException();
        }
        if (!pesel.matches("\\d+")) {
            throw new PeselInvalidCharacterException();
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        int checksum = (10 - (sum % 10)) % 10;
        int lastDigit = Character.getNumericValue(pesel.charAt(10));

        if (checksum != lastDigit) {
            throw new PeselChecksumMismatchException();
        }

        int month = Integer.parseInt(pesel.substring(2, 4));
        if (!isValidMonth(month)) {
            throw new PeselInvalidMonthException();
        }

        return true;
    }

    private static boolean isValidMonth(int month) {
        return (month >= 1 && month <= 12) || // 1900-1999
                (month >= 21 && month <= 32) || // 2000-2099
                (month >= 41 && month <= 52) || // 2100-2199
                (month >= 61 && month <= 72) || // 2200-2299
                (month >= 81 && month <= 92);   // 1800-1899
    }
}
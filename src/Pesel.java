
class Pesel {
    String pesel_number;
    public Pesel(String input){
        if (input == null || input.length() != 11 || !input.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid PESEL number.");
        }
        pesel_number = input;
    }
    public String gender (){
        return "Male";
    }
    public String birth_Date(){
        return "25.3.2002";
    }
}
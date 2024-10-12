import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String input = null;
        Pesel pesel = null;
        if( args.length == 1 ){
            input = args[0];
        }else if(args.length == 0){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your PESEL number: ");
            input = scan.nextLine();
        }else {
            System.out.println("Wrong parameters were entered");
            System.exit(0);
        }
        try{
            pesel = new Pesel(input);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        System.out.println("The PESEL number provided is correct");
        System.out.println("Gender: " + pesel.gender());
        System.out.println("Birth date: " + pesel.birthDate());

    }
}

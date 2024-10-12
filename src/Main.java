import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String input = "";
        Pesel pesel;
        if( args.length == 1 ){
            input = args[0];
        }else if(args.length == 0){
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj numer PESEL: ");
            input = scan.nextLine();
        }else {
            System.out.println("Podano złe parametry");
            System.exit(0);
        }
        try{
            pesel = new Pesel(input);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }
}

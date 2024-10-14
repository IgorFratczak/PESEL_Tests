import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String input = null;
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
            if(!Pesel.check_Pesel(input)){
                System.out.println("PESEL number provided is not correct");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        //there should be "finnaly" here, but I don't know what it should display there
        System.out.println("PESEL number provided is correct");
        System.out.println("Gender: " + Pesel.gender(input));
        System.out.println("Birth date: " + Pesel.birthDate(input));

    }
}

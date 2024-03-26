import java.util.Scanner;

public class fomsApp {
    public fomsApp() {
    }
    public void customerMode(){

    }
    public void staffMode(){

    }


    public static void main(String[] args)  {




        int choice;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                Are you a customer or a staff?
                (1) Customer
                (2) Staff
                
                (3) exit
                """);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.println("Program terminating ....");
            }
        } while (choice < 3) ;
    } }


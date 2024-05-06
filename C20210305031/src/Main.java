import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hotel Reservation System");
        while (true) {
            System.out.println("1-User Login");
            System.out.println("2-Search for a room");
            System.out.println("3-Make a Reservation");
            System.out.println("4-View Reservations/Payment ");
            System.out.println("5-Logout/Exit");
            System.out.print("Choose:");
            int choose = input.nextInt();

                if (choose == 1)
                {

                    Users_dal udal = new Users_dal();
                    udal.ListToConsole();
                }
                if(choose==2)
                {
                     Room_dal rdal = new Room_dal();
                     rdal.ListToConsole();

                }
                if(choose==3)
                {
                Reservations_dal redal = new Reservations_dal();
                redal.ListToConsole();

                }
                if(choose==4)
                {
                    Payment_dal pdal = new Payment_dal();
                    pdal.ListToConsole();

                }
                if (choose==5)
                {
                    break;
                }
        }
    }
}



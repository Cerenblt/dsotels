import java.sql.*;
import java.util.ArrayList;
public class Payment_dal {


    // for MySQL Server
    // mysql.connector.j-8.3.0
    String user="user1", pass="123";
    String conUrl = "jdbc:mysql://localhost/dsotel";

    public void Test()
    {
        try {
            Connection conn = DriverManager.getConnection(conUrl, user, pass);
            System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ListToConsole() { String cmd = "SELECT `İD`,`Reservatıon ıd`,`Amount`,`Payment_Date`,`Payment_method` FROM `payment`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say = 0;
            int ID;
            String Reservationıd, Amount, Paymentdate, Paymentmethod;

            System.out.println("result set ready");
            while (res.next()) {
                ID = res.getInt(1);
                Reservationıd = res.getString(2);
                Amount = res.getString(3);
                Paymentdate = res.getString(4);
                Paymentmethod = res.getString(5);


                System.out.printf("Id= %d, Reservatıon ıd=%s Amount=%s Payment_Date=%s Payment_method=&s %n", ID,Reservationıd, Amount, Paymentdate, Paymentmethod);
                say++;
            }
            System.out.println("End of List.");
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Payment> GetPayment()
    {
        ArrayList<Payment> plist = new ArrayList<>();

        String cmd = "SELECT `İD`,`Reservatıon ıd`,`Amount`,`Payment_Date`,`Payment_method` FROM `payment`";
        Payment p;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                p = new Payment();

                p.ID = res.getInt(1);
                p.Reservationıd= res.getString(2);
                p.Amount = res.getString(3);
                p.Paymentdate = res.getString(4);
                p.Paymentmethod =res.getString(5);
                plist.add(p);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return plist;
    }
}

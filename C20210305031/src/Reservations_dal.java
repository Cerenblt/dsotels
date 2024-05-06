import java.sql.*;
import java.util.ArrayList;
public class Reservations_dal {


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
    public void ListToConsole() { String cmd = "SELECT `ReservatıonID`,`UserID`,`Room Number`,`Check_in_date`,`Check_out_date`,`Total_Price` FROM reservations";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say = 0;
            int ReservationID;
            String UserID, Roomnumber, Checkindate, Checkoutdate, Totalprice;

            System.out.println("result set ready");
            while (res.next()) {
                ReservationID = res.getInt(1);
                UserID = res.getString(1);
                Roomnumber = res.getString(1);
                Checkindate = res.getString(1);
                Checkoutdate = res.getString(1);
                Totalprice = res.getString(1);

                System.out.printf("ReservatıonID= %d, UserID= %s Room Number=%s Check_in_date=%s Check_out_date=%s Total_Price=%s %n" ,ReservationID, UserID, Roomnumber, Checkindate, Checkoutdate, Totalprice);
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

    public ArrayList<Reservations> GetReservations()
    {
        ArrayList<Reservations> rlist = new ArrayList<>();

        String cmd = "SELECT `ReservatıonID`,`UserID`,`Room Number`,`Check_in_date`,`Check_out_date`,`Total_Price` FROM reservations";
        Reservations r;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                r = new Reservations();

                r.ReservationID = res.getInt(1);
                r.UserID= res.getString(2);
                r.Roomnumber = res.getString(3);
                r.Checkindate = res.getString(4);
                r.Checkoutdate =res.getString(5);
                r.Totalprice =res.getString(6);
                rlist.add(r);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return rlist;
    }
}




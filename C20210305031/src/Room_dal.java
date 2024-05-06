import java.sql.*;
import java.util.ArrayList;
public class Room_dal {


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
    public void ListToConsole() { String cmd = "SELECT `ID`,`Room Number`,`Type`,`Price_per_Night`,`Availability`FROM `room`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say = 0;
            int ID;
            String Id,Roomnumber,Type,Pricepernight,Availability;
            ;

            System.out.println("result set ready");
            while (res.next()) {
                ID = res.getInt(1);
                Roomnumber = res.getString(1);
                Type = res.getString(1);
                Pricepernight = res.getString(1);
                Availability = res.getString(1);


                System.out.printf("Id= %d, Roomnumber= %s Pricepernight=%s Type=%s Availability=%s %n", ID, Roomnumber, Type, Pricepernight, Availability);
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

    public ArrayList<Room> GetRoom()
    {
        ArrayList<Room> rolist = new ArrayList<>();

        String cmd = "SELECT `ID`,`Room Number`,`Type`,`Price_per_Night`,`Availability` FROM `room`";
        Room ro;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                ro = new Room();

                ro.ID = res.getInt(1);
                ro.Roomnumber = res.getString(2);
                ro.Type = res.getString(3);
                ro.Pricepernight = res.getString(4);
                ro.Availability =res.getString(5);

                rolist.add(ro);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return rolist;
    }
}


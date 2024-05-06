import java.sql.*;
import java.util.ArrayList;
public class Users_dal {


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
    public void ListToConsole() { String cmd = "SELECT `UserID`,`Username`,`Password`,`First Name`,`Last Name`,`Email`  FROM `users`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say = 0;
            int UserID,Password;
            String Username, Firstname, Lastname, Email, SessionStatus;

            System.out.println("result set ready");
            while (res.next()) {
                UserID = res.getInt(1);
                Username = res.getString(2);
                Password = res.getInt(3);
                Firstname = res.getString(4);
                Lastname = res.getString(5);
                Email = res.getString(6);

                System.out.printf("Id= %d, UserName= %s Password=%d  FirstName=%s LastName=%s Email=%s  %n", UserID, Username, Password, Firstname, Lastname, Email);
                say++;
            }
            System.out.println("End of List.");
            res.close();


        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Users> GetUsers()
    {
        ArrayList<Users> ulist = new ArrayList<>();

        String cmd = "SELECT `UserID`,`Username`,`Password`,`First Name`,`Last Name`,`Email` FROM `users`";
        Users u;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                u = new Users();

                u.UserID = res.getInt(1);
                u.Username= res.getString(2);
                u.Password = res.getInt(3);
                u.Firstname = res.getString(4);
                u.Lastname =res.getString(5);
                u.Email =res.getString(6);
                ulist.add(u);
            }
            res.close();


        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return ulist;
    }
}





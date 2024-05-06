import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserForm extends JFrame {
    private JPanel JPanel1;
    private JScrollBar scrollBar1;
    private JTable table1;

    Users_dal udal;
    private ArrayList<Users> ulist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "UserId" , "UserName ", "Password", "FirstName", "LastName" ,"Email"};

    public UserForm()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        udal = new Users_dal();
        ulist= udal.GetUsers();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }

    private void UpdateTable()
    {
        // clear table rows
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        // fill the table
        for (Users k: ulist)
        {
            String data[] = {String.valueOf(k.UserID), k.Username, String.valueOf(k.Password),k.Firstname, k.Lastname, k.Email};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new UserForm();
    }
}

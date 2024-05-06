import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RoomForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    Room_dal rdal;
    private ArrayList<Room> rlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id" , "Room Number ", "Type", "Price_per_Night", "Availability" };

    public RoomForm()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rdal = new Room_dal();
        rlist= rdal.GetRoom();

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
        for (Room k: rlist)
        {
            String data[] = {String.valueOf(k.ID), k.Roomnumber, k.Type,k.Pricepernight, k.Availability};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new RoomForm();
    }
}

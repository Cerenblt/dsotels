import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ReservationsForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    Reservations_dal rdal;
    private ArrayList<Reservations> rlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "ReservatıonID" , "UserID ", "Room Number", "Check_in_date", "Check_out_date","Total_Price" };

    public ReservationsForm()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rdal = new Reservations_dal();
        rlist= rdal.GetReservations();

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
        for (Reservations k: rlist)
        {
            String data[] = {String.valueOf(k.ReservationID), k.UserID, k.Roomnumber,k.Checkindate, k.Checkoutdate,k.Totalprice};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new ReservationsForm();
    }
}

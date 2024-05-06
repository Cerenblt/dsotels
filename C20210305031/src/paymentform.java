import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class paymentform extends  JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    Payment_dal payment;
    private ArrayList<Payment> plist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id" , "Reservatıon ıd", "Amount", "Payment_Date", "Payment_method" };// column names

    public paymentform()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

       payment = new Payment_dal();
       plist= payment.GetPayment();

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
        for (Payment k: plist) {
            String data[] = {String.valueOf(k.ID), k.Reservationıd, k.Amount,k.Paymentdate, k.Paymentmethod};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new paymentform();
    }
}

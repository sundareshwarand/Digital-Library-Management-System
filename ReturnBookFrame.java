import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class ReturnBookFrame extends JFrame {

    JTextField issueIdField;

    public ReturnBookFrame() {

        setTitle("Return Book");
        setSize(400,250);
        setLayout(null);

        JLabel label = new JLabel("Issue ID");
        label.setBounds(50,50,100,25);

        issueIdField = new JTextField();
        issueIdField.setBounds(150,50,150,25);

        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBounds(120,120,140,35);

        returnBtn.addActionListener(e -> returnBook());

        add(label);
        add(issueIdField);
        add(returnBtn);

        setVisible(true);
    }

    private void returnBook() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "UPDATE issued_books SET return_date=? WHERE issue_id=?";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setDate(
                1,
                Date.valueOf(LocalDate.now())
            );

            pst.setInt(
                2,
                Integer.parseInt(issueIdField.getText())
            );

            int rows = pst.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(
                    this,
                    "Book Returned Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Issue ID Not Found!"
                );
            }

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
            );
        }
    }
}
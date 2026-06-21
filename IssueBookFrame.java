import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class IssueBookFrame extends JFrame {

    JTextField bookIdField;
    JTextField studentField;

    public IssueBookFrame() {

        setTitle("Issue Book");
        setSize(400,300);
        setLayout(null);

        JLabel idLabel = new JLabel("Book ID");
        idLabel.setBounds(50,50,100,25);

        bookIdField = new JTextField();
        bookIdField.setBounds(150,50,150,25);

        JLabel studentLabel = new JLabel("Student Name");
        studentLabel.setBounds(50,100,100,25);

        studentField = new JTextField();
        studentField.setBounds(150,100,150,25);

        JButton issueBtn = new JButton("Issue Book");
        issueBtn.setBounds(120,180,140,35);

        issueBtn.addActionListener(e -> issueBook());

        add(idLabel);
        add(bookIdField);
        add(studentLabel);
        add(studentField);
        add(issueBtn);

        setVisible(true);
    }

    private void issueBook() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO issued_books(book_id, student_name, issue_date) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1,
                    Integer.parseInt(bookIdField.getText()));

            pst.setString(2,
                    studentField.getText());

            pst.setDate(3,
                    Date.valueOf(LocalDate.now()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book Issued Successfully!"
            );

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }
}
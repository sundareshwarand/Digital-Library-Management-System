import javax.swing.*;
import java.sql.*;

public class DeleteBookFrame extends JFrame {

    JTextField bookIdField;

    public DeleteBookFrame() {

        setTitle("Delete Book");
        setSize(400,250);
        setLayout(null);

        JLabel label = new JLabel("Book ID:");
        label.setBounds(50,50,100,25);

        bookIdField = new JTextField();
        bookIdField.setBounds(150,50,150,25);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(130,120,120,35);

        deleteBtn.addActionListener(e -> deleteBook());

        add(label);
        add(bookIdField);
        add(deleteBtn);

        setVisible(true);
    }

    private void deleteBook() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "DELETE FROM books WHERE book_id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(
                    1,
                    Integer.parseInt(bookIdField.getText())
            );

            int rows = pst.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Deleted Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Book ID Not Found!"
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
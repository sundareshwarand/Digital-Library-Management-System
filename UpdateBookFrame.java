import javax.swing.*;
import java.sql.*;

public class UpdateBookFrame extends JFrame {

    JTextField idField;
    JTextField titleField;
    JTextField authorField;
    JTextField quantityField;

    public UpdateBookFrame() {

        setTitle("Update Book");
        setSize(450,350);
        setLayout(null);

        JLabel idLabel = new JLabel("Book ID");
        idLabel.setBounds(50,40,100,25);

        idField = new JTextField();
        idField.setBounds(180,40,180,25);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setBounds(50,80,100,25);

        titleField = new JTextField();
        titleField.setBounds(180,80,180,25);

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(50,120,100,25);

        authorField = new JTextField();
        authorField.setBounds(180,120,180,25);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(50,160,100,25);

        quantityField = new JTextField();
        quantityField.setBounds(180,160,180,25);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(150,230,120,35);

        updateBtn.addActionListener(e -> updateBook());

        add(idLabel);
        add(idField);
        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(quantityLabel);
        add(quantityField);
        add(updateBtn);

        setVisible(true);
    }

    private void updateBook() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "UPDATE books SET title=?, author=?, quantity=? WHERE book_id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, titleField.getText());
            pst.setString(2, authorField.getText());
            pst.setInt(3,
                    Integer.parseInt(quantityField.getText()));
            pst.setInt(4,
                    Integer.parseInt(idField.getText()));

            int rows = pst.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Updated Successfully!"
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
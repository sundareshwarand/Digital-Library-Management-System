import javax.swing.*;
import java.sql.*;

public class AddBookFrame extends JFrame {

    JTextField titleField, authorField, quantityField;

    public AddBookFrame() {

        setTitle("Add Book");
        setSize(400, 350);
        setLayout(null);

        JLabel titleLabel = new JLabel("Book Title");
        titleLabel.setBounds(50, 50, 100, 25);

        titleField = new JTextField();
        titleField.setBounds(150, 50, 180, 25);

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(50, 100, 100, 25);

        authorField = new JTextField();
        authorField.setBounds(150, 100, 180, 25);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(50, 150, 100, 25);

        quantityField = new JTextField();
        quantityField.setBounds(150, 150, 180, 25);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(130, 220, 120, 35);

        saveBtn.addActionListener(e -> saveBook());

        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(quantityLabel);
        add(quantityField);
        add(saveBtn);

        setVisible(true);
    }

    private void saveBook() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "INSERT INTO books(title, author, quantity) VALUES(?,?,?)";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setString(1, titleField.getText());
            pst.setString(2, authorField.getText());
            pst.setInt(3,
                Integer.parseInt(quantityField.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Book Added Successfully!"
            );

            titleField.setText("");
            authorField.setText("");
            quantityField.setText("");

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
            );
        }
    }
}
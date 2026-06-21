import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SearchBookFrame extends JFrame {

    JTextField searchField;
    JTable table;
    DefaultTableModel model;

    public SearchBookFrame() {

        setTitle("Search Book");
        setSize(700, 400);
        setLayout(null);

        JLabel label = new JLabel("Book Title:");
        label.setBounds(20, 20, 100, 25);

        searchField = new JTextField();
        searchField.setBounds(120, 20, 200, 25);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(340, 20, 100, 25);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Book ID");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Quantity");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 70, 640, 250);

        searchBtn.addActionListener(e -> searchBook());

        add(label);
        add(searchField);
        add(searchBtn);
        add(scrollPane);

        setVisible(true);
    }

    private void searchBook() {

        try {

            model.setRowCount(0);

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM books WHERE title LIKE ?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(
                    1,
                    "%" + searchField.getText() + "%"
            );

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity")
                });
            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }
}
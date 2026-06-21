import javax.swing.*;

public class LibraryDashboard extends JFrame {

    public LibraryDashboard() {

        setTitle("Library Dashboard");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addBookBtn = new JButton("Add Book");
        addBookBtn.setBounds(150, 50, 180, 40);

        JButton viewBookBtn = new JButton("View Books");
        viewBookBtn.setBounds(150, 110, 180, 40);

        JButton searchBookBtn = new JButton("Search Book");
        searchBookBtn.setBounds(150, 170, 180, 40);

        JButton updateBookBtn = new JButton("Update Book");
        updateBookBtn.setBounds(150, 230, 180, 40);

        JButton deleteBookBtn = new JButton("Delete Book");
        deleteBookBtn.setBounds(150, 290, 180, 40);

        JButton issueBookBtn = new JButton("Issue Book");
        issueBookBtn.setBounds(150, 350, 180, 40);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(150, 410, 180, 40);

        addBookBtn.addActionListener(e -> new AddBookFrame());

        viewBookBtn.addActionListener(e -> new ViewBooksFrame());

        searchBookBtn.addActionListener(e -> new SearchBookFrame());

        updateBookBtn.addActionListener(e -> new UpdateBookFrame());

        deleteBookBtn.addActionListener(e -> new DeleteBookFrame());

        issueBookBtn.addActionListener(e -> new IssueBookFrame());

        exitBtn.addActionListener(e -> System.exit(0));

        add(addBookBtn);
        add(viewBookBtn);
        add(searchBookBtn);
        add(updateBookBtn);
        add(deleteBookBtn);
        add(issueBookBtn);
        add(exitBtn);

        setVisible(true);
    }
}
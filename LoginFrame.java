import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Digital Library Management System");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Library Login");
        title.setBounds(150,30,150,30);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50,80,100,25);

        JTextField userField = new JTextField();
        userField.setBounds(150,80,150,25);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50,120,100,25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150,120,150,25);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150,180,100,30);

        loginBtn.addActionListener(e -> {
            new LibraryDashboard();
            dispose();
        });

        add(title);
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
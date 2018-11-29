import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasinoWindow {
    public Account ac = new Account();
    private JFrame frame, frameWar, frameBlackJack, frameBlindBluff;
    private JTextField textField;

    /**
     * Create the application.
     */
    public CasinoWindow() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CasinoWindow window = new CasinoWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frameBlackJack = new JFrame();
        frameBlackJack.setBounds(100, 100, 450, 300);
        frameBlackJack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBlackJack.getContentPane().setLayout(null);

        frameBlindBluff = new JFrame();
        frameBlindBluff.setBounds(100, 100, 450, 300);
        frameBlindBluff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBlindBluff.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("War");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameWar.setVisible(true);
            }
        });
        btnNewButton.setBounds(335, 227, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Blackjack");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameBlackJack.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(236, 227, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Blind Bluff");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameBlindBluff.setVisible(true);
            }
        });
        btnNewButton_2.setBounds(137, 227, 89, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.setBounds(38, 227, 89, 23);
        frame.getContentPane().add(btnNewButton_3);

        JLabel userBalanceLabel = new JLabel("$" + ac.userBalance + " Balance");
        userBalanceLabel.setBounds(10, 30, 89, 23);
        frame.getContentPane().add(userBalanceLabel);

        JLabel label = new JLabel("$" + ac.balanceCasino + " Casino Balance");
        label.setBounds(10, 11, 134, 14);
        frame.getContentPane().add(label);

        JLabel lblGamesAvailable = new JLabel("Games Available");
        lblGamesAvailable.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblGamesAvailable.setBounds(10, 193, 166, 23);
        frame.getContentPane().add(lblGamesAvailable);

       /* userBalanceLabel.setBounds(10, 30, 89, 23);
        frameWar.getContentPane().add(userBalanceLabel);

        label.setBounds(10, 11, 134, 14);
        frameWar.getContentPane().add(label);*/

        textField = new JTextField("Bet Amount", 30);
        textField.setBounds(220, 227, 89, 23);
        frameWar.getContentPane().add(textField);

        frameWar = new JFrame();
        frameWar.setBounds(100, 100, 450, 300);
        frameWar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWar.getContentPane().setLayout(null);

        JButton backButton = new JButton("Back");
        backButton.setBounds(38, 227, 89, 23);
        frameWar.getContentPane().add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameWar.setVisible(false);
            }
        });

        JButton betButton = new JButton("Bet");
        betButton.setBounds(335, 227, 89, 23);

        betButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bet = textField.getText();
                ac.betPlace = Integer.parseInt(bet);
                ac.setCasinoBalance();
            }
        });
        frameWar.getContentPane().add(betButton);
    }
}

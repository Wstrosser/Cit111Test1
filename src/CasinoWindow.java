import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class CasinoWindow {
Account ac = new Account();
	private JFrame frame, frameWar;
	private final Action action = new SwingAction();

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
	 * Create the application.
	 */
	public CasinoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frameWar = new JFrame();
		frameWar.setBounds(100, 100, 450, 300);
		frameWar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWar.getContentPane().setLayout(null);
		
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
		btnNewButton_1.setBounds(236, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Blind Bluff");
		btnNewButton_2.setBounds(137, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(38, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("$" + ac.userBalance+ " Balance");
		lblNewLabel.setBounds(10, 30, 89, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGamesAvailable = new JLabel("Games Available");
		lblGamesAvailable.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblGamesAvailable.setBounds(10, 193, 166, 23);
		frame.getContentPane().add(lblGamesAvailable);
		
		JLabel label = new JLabel("$" +ac.balanceCasino+ " Casino Balance");
		label.setBounds(10, 11, 134, 14);
		frame.getContentPane().add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

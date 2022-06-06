package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import AppAndParsers.AppManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updates extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String[] updateInfoStrings = new String[] {"",""};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updates frame = new Updates(new AppManager());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Updates(AppManager appManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thank you for using our App\r\n");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel.setBounds(92, 46, 382, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please update:");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(64, 169, 102, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("How long was your preparation time?");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(64, 235, 280, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("How long was the cooking time?");
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(64, 294, 280, 23);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(359, 239, 69, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(305, 289, 69, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(appManager);
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoStrings[0]=textField.getText();
				updateInfoStrings[1]=textField_1.getText();
				
			}
		});
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(441, 432, 85, 21);
		contentPane.add(btnNewButton);
		
	}
	
	public String[] getRecipeUpdateInfo() {
	return updateInfoStrings;
	}
}

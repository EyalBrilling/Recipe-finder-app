package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sql.rowset.JoinRowSet;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import AppAndParsers.*;
public class Sign_in {

	//private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	public static List<String> textArrayStrings= new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//showWindow(new UiManager());
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_in frame = new Sign_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	public Sign_in(AppManager appManager) {
		
		showWindow(appManager);
	}
	public List<String> ReturnVars() {
		return textArrayStrings;
	}

	public static void showWindow(AppManager appManager) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Test 1");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(430, 100, 650, 600);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
		rdbtnNewRadioButton.setBounds(183, 325, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Male");
		rdbtnNewRadioButton_1.setBounds(323, 325, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(164, 50, 359, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Full Name:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel.setBounds(53, 52, 111, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(53, 111, 56, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 105, 359, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age:");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(53, 170, 61, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 164, 359, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Height:");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(53, 216, 73, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 216, 359, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Weight:");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(53, 270, 65, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 270, 359, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(53, 327, 73, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Create Username:");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(49, 382, 150, 29);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(208, 382, 315, 29);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Create Password:");
		lblNewLabel_7.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(53, 434, 146, 29);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(208, 437, 315, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setName("sign_in_menu_button");
		btnNewButton.addActionListener(appManager);
		btnNewButton.setBounds(246, 511, 111, 21);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				Log_in t1 = new Log_in(appManager);
				t1.setVisible(true);
				frame.setVisible(false);
				
				
				textArrayStrings.add(textField.getText());
				textArrayStrings.add(textField_1.getText());
				textArrayStrings.add(textField_2.getText());
				//female
				if(rdbtnNewRadioButton.isSelected()) {
					textArrayStrings.add("1");
				}
				//male
				
				else if(rdbtnNewRadioButton_1.isSelected()) {
					textArrayStrings.add("0");
				}
				else {
					//errors.didnt choose gender.
				}
				
				
				textArrayStrings.add(textField_3.getText());
				textArrayStrings.add(textField_4.getText());
				textArrayStrings.add(textField_5.getText());
				textArrayStrings.add(textField_6.getText());
				
				
				//textArrayStrings={textField.getText(),textField_1.getText(),textField_2.getText(),
					//textField_3.getText(),textField_4.getText(),textField_5.getText(),textField_6.getText()};
				//t1.initialize1();
			}
		});
		
		frame.setVisible(true);
	}
	
	public static List<String> getSignInInfo(){
		return textArrayStrings;
	}
}

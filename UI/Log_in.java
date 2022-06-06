package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppAndParsers.AppManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
public class Log_in {

	//private JPanel contentPane;
	private JFrame jframe;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	public static String[] textArrayStrings= new String[] {"",""};
	public static AppWin ap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Log_in frame = new Log_in(new ActionListener());
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//	});
	}
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		jframe.setVisible(b);
	}
	public Log_in(AppManager appManager) {
		
		showWindow2(appManager);
		setVisible(true);
	}
	
	public String[] ReturnVars() {
		return textArrayStrings;
	}

	public void showWindow2(AppManager appManager) {
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(400, 200, 350, 350);
		jframe.getContentPane().setLayout(null);
		//frame2.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel.setBounds(40, 62, 102, 16);
		jframe.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 57, 124, 30);
		jframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(40, 135, 85, 19);
		jframe.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 128, 124, 30);
		jframe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setName("log_in_button");
		btnNewButton.addActionListener(appManager);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ap = new AppWin(appManager);
				ap.setVisible(true);
				jframe.setVisible(false);
				textArrayStrings[0]=(textField.getText());
				textArrayStrings[1]=(textField_1.getText());
			}
		});
		btnNewButton.setBounds(112, 240, 102, 30);
		jframe.getContentPane().add(btnNewButton);
		
	}
	
	public String[] getRecipeVars() {
		return ap.getRecipeVars();
	}


}

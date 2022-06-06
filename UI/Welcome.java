package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.SwingConstants;

import AppAndParsers.AppManager;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JMenu;
import java.awt.Checkbox;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JEditorPane;

public class Welcome {

	private JFrame OpeningWindow;
	
	
	Log_in t1;
	Sign_in s1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.OpeningWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome(AppManager appManager) {
		initialize1(appManager);
	}
	
	public String[] ReturnLogInVars() {
		return t1.ReturnVars();
	}
	
	public List<String> ReturnSignInVars() {
		return Sign_in.getSignInInfo();
	}
	
	public String[] getRecipeVars() {
		return t1.getRecipeVars();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize1(AppManager appManager) {
		OpeningWindow = new JFrame();
		OpeningWindow.getContentPane().setBackground(new Color(245, 245, 245));
		OpeningWindow.getContentPane().setFont(new Font("Symbol", Font.PLAIN, 14));
		OpeningWindow.getContentPane().setForeground(new Color(240, 255, 255));
		OpeningWindow.setBounds(500, 200, 450, 450);
		OpeningWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OpeningWindow.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sign up");
		
		
		btnNewButton.setFont(new Font("Open Sans Semibold", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(106, 90, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpeningWindow.setVisible(false);
				
				Sign_in.showWindow(appManager);
			}
		});
		
		btnNewButton.setBounds(148, 203, 174, 37);
		OpeningWindow.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log in");
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1 = new Log_in(appManager);
				t1.setVisible(true);
				OpeningWindow.setVisible(false);
				//t1.initialize1();
			}
			
		});
		btnNewButton_1.setForeground(new Color(106, 90, 205));
		btnNewButton_1.setFont(new Font("Open Sans Semibold", Font.BOLD, 15));
		btnNewButton_1.setBounds(148, 303, 174, 37);
		OpeningWindow.getContentPane().add(btnNewButton_1);
	
		
		JLabel lblNewLabel = new JLabel("Welcome To Our App");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
		lblNewLabel.setBackground(new Color(255, 192, 203));
		lblNewLabel.setBounds(81, 37, 251, 56);
		OpeningWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Already Registered?");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 10));
		lblNewLabel_1.setBounds(42, 312, 107, 23);
		OpeningWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Here?");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 10));
		lblNewLabel_2.setBounds(92, 212, 66, 23);
		OpeningWindow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Food Recipes App");
		lblNewLabel_3.setForeground(new Color(123, 104, 238));
		lblNewLabel_3.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(106, 103, 221, 31);
		OpeningWindow.getContentPane().add(lblNewLabel_3);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	
		OpeningWindow.setVisible(b);
		
	}
	

}

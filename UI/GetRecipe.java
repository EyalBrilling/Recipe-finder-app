package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppAndParsers.AppManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetRecipe extends JFrame {

	private JPanel contentPane;
	private JFrame jframe;
	Updates up;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRecipe frame = new GetRecipe();
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
	public GetRecipe(AppManager appManager) {
		jframe = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Here is your Recipe");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBounds(311, 266, 285, 80);
		contentPane.add(lblNewLabel_1);
		

		JButton btnNewButton = new JButton("Update");
		//btnNewButton.setName("recipe_update_button");
		btnNewButton.addActionListener(appManager);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(333, 500, 137, 32);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up = new Updates(appManager);
				up.setVisible(true);
				jframe.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 926, 553);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc2\\Downloads\\photo-1543353071-873f17a7a088.jfif"));
		contentPane.add(lblNewLabel);
	
		
	
	
	}
	
	public String[] getRecipeUpdateInfo() {
	return up.getRecipeUpdateInfo();
	}

}

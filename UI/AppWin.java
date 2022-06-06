package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppAndParsers.AppManager;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.Canvas;
import java.awt.Choice;
import javax.swing.JCheckBox;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class AppWin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxSodium_1;
	private JCheckBox chckbxSodium_2;
	private JCheckBox chckbxSodium_3;
	private Button button;
	private JComboBox comboBox;
	private JButton btnNewButton;
	// 1. category 2.ingredient 3.nutrition 4.nutrition_quantity
	public String[] textArrayStrings= new String[] {"","","",""};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWin frame = new AppWin(new AppManager());
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
	public AppWin(AppManager appManager) {
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 80, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		lblNewLabel_1 = new JLabel("Search Recipes According To:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel_1.setBounds(264, 258, 460, 47);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setMaximumRowCount(14);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nutrition", "Category", "Nutrition quantity", "Ingredient", "Random"}));
		comboBox.setSelectedIndex(-1);
	
		comboBox.setBounds(264, 329, 392, 34);
		contentPane.add(comboBox);
	
	
		
		button = new Button("EXIT");
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBackground(SystemColor.scrollbar);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
		});
		button.setBounds(10, 506, 85, 34);
		contentPane.add(button);
		
		
		btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					Nutrition nt = new Nutrition(frame,appManager);
					textArrayStrings[2]=nt.getNutritionString();
					textArrayStrings[3]=nt.getNutrition_queString();
					frame.setVisible(false);
					nt.setVisible(true);
				}
				else if (comboBox.getSelectedIndex() == 1) {
					Category ct = new Category(frame,appManager);
					textArrayStrings[0]=ct.getCategoryString();
					frame.setVisible(false);
					ct.setVisible(true);
				}

				else if (comboBox.getSelectedIndex() == 3) {
					Ingredient in = new Ingredient(frame,appManager);
					textArrayStrings[1]=in.getIngredientString();
					frame.setVisible(false);
					in.setVisible(true);
				}
				else if (comboBox.getSelectedIndex() == 4) {
					GetRecipe gr = new GetRecipe(appManager);
					frame.setVisible(false);
					gr.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(821, 506, 93, 34);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 926, 553);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc2\\Downloads\\photo-1543353071-873f17a7a088.jfif"));
		contentPane.add(lblNewLabel);
		
		
	}
	
	public String[] getRecipeVars() {
		return textArrayStrings;
	}
}

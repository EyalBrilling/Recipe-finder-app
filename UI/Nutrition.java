package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppAndParsers.AppManager;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Nutrition extends JFrame {

	private JPanel contentPane;
	//BELOW_AVERAGE = 0
    //ABOVE_AVERAGE = 1
    //LOW = 2
    //HIGH = 3
	private String nutrition_que_String;
	private String nutrition_selected_String;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nutrition frame = new Nutrition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param appManager 
	 */
	public Nutrition(JFrame frame, AppManager appManager) {
		JFrame fm = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Nutrition:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(218, 82, 248, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Get Recipe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetRecipe ga = new GetRecipe(appManager);
				fm.setVisible(false);
				ga.setVisible(true);
			
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(708, 430, 123, 34);
		contentPane.add(btnNewButton);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setToolTipText("1\r\n2\r\n3\r\n4\r\nm");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Calories", "Fat", "Saturated Fat", "Cholesterol", "Sodium", "Carbohydrate", "Fiber ", "Sugar", "Protein"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(444, 92, 305, 34);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("I want Maximum Value");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(253, 262, 230, 34);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("I want Minimum Value");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBounds(253, 318, 230, 34);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("I need above the value Average");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(253, 394, 258, 34);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("I need below the value Average");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.setBounds(253, 441, 258, 29);
		contentPane.add(rdbtnNewRadioButton_3);
		
		ActionListener nutritionListener= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()==-1){
					//error no selected nutrition
				}
				
				nutrition_selected_String=comboBox.getSelectedItem().toString();
				
			}
		};
		
		comboBox.addActionListener(nutritionListener);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		ActionListener nutrition_que_Listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (buttonGroup.isSelected(rdbtnNewRadioButton.getModel())){
					nutrition_que_String="3";
				}
				else if (buttonGroup.isSelected(rdbtnNewRadioButton_1.getModel())){
					nutrition_que_String="2";
				} 
				
				else if (buttonGroup.isSelected(rdbtnNewRadioButton_2.getModel())){
					nutrition_que_String="1";
				} 
				
				else if (buttonGroup.isSelected(rdbtnNewRadioButton_3.getModel())){
					nutrition_que_String="0";
				} 
				else {
					//error no quanity is selected
				}
			}
		};
		rdbtnNewRadioButton.addActionListener(nutrition_que_Listener);
		rdbtnNewRadioButton_1.addActionListener(nutrition_que_Listener);
		rdbtnNewRadioButton_2.addActionListener(nutrition_que_Listener);
		rdbtnNewRadioButton_3.addActionListener(nutrition_que_Listener);
		
		JButton btnNewButton_1 = new JButton("Choose more option");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				frame.setVisible(true);
				fm.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(685, 474, 146, 29);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 826, 503);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc2\\Downloads\\greek-food-background-traditional-different-dishes-top-view-close-up-143835841.jpg"));
		contentPane.add(lblNewLabel);
		
		
	}
	
	public String getNutritionString() {
		return nutrition_selected_String;
	}
	
	public String getNutrition_queString() {
		return nutrition_que_String;
	}
}

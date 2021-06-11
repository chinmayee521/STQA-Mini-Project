

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class OrderPage {
	public int mobcnt=0,furcnt=0,tcnt=0,vegcnt=0,gcnt=0;
	static int TotalPrice=0;
	static String address;
	String op="";
	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 OrderPage window = new OrderPage(address);
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
	public OrderPage(String address) {
		this.address=address;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 10));
		frame.setBounds(100, 100, 830, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("mobile.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));

		
		//ImageIcon mobile = new ImageIcon("mobile.jpeg");
		//lblNewLabel.setIcon(mobile);
		lblNewLabel.setBounds(108, 39, 141, 153);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon("furniture.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(359, 39, 135, 153);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon("tshirt.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(592, 39, 135, 153);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(new ImageIcon("vegetables.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(512, 231, 129, 153);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(new ImageIcon("grocery.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(206, 231, 129, 153);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mobcnt++;
				textField.setText(Integer.toString(mobcnt));
			}
		});
		btnNewButton.setBounds(193, 204, 44, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Products");
		lblNewLabel_5.setFont(new Font("FreeSans", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(362, 0, 141, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("-");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mobcnt!=0)
					mobcnt--;
				textField.setText(Integer.toString(mobcnt));
			}
		});
		btnNewButton_4.setBounds(108, 204, 42, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		//mobile 
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("0");
		textField.setBounds(153, 204, 38, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton_5 = new JButton("Cart");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cart

				op = "Products        Count        Total\n";
				if(mobcnt>0)
					op+="Mobile                "+mobcnt+"        "+mobcnt*10000;
				if(furcnt>0)
					op+="\nFurniture        "+furcnt+"                "+furcnt*17000;
				if(tcnt>0)
					op+="\nT-shirt                "+tcnt+"        "+tcnt*300;
				if(gcnt>0)
					op+="\nGrocery        "+gcnt+"                "+gcnt*2000;
				if(vegcnt>0)
					op+="\nVegetables        "+vegcnt+"        "+vegcnt*500;
				
				TotalPrice = mobcnt*10000+furcnt*17000+tcnt*300+gcnt*2000+vegcnt*500;
				op+="\nTotal Price                        "+TotalPrice;
				
				
				JOptionPane.showMessageDialog(frame,op);
			}
		});
		btnNewButton_5.setBounds(12, 13, 117, 25);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile : Rs.10000");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(96, 191, 153, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				furcnt++;
				textField_1.setText(Integer.toString(furcnt));
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBounds(442, 204, 44, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(402, 204, 38, 25);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_4_1 = new JButton("-");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(furcnt!=0)
					furcnt--;
				textField_1.setText(Integer.toString(furcnt));
			}
		});
		btnNewButton_4_1.setBounds(359, 204, 42, 25);
		frame.getContentPane().add(btnNewButton_4_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Furniture : Rs.17000");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(347, 191, 147, 15);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcnt++;
				textField_2.setText(Integer.toString(tcnt));
			}
		});
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(675, 204, 44, 25);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("+");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gcnt++;
				textField_3.setText(Integer.toString(gcnt));
			}
		});
		btnNewButton_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(284, 395, 44, 25);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("+");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vegcnt++;
				textField_4.setText(Integer.toString(vegcnt));
			}
		});
		btnNewButton_1_3.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1_3.setBounds(592, 395, 44, 25);
		frame.getContentPane().add(btnNewButton_1_3);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(636, 204, 38, 25);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(246, 396, 38, 25);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(554, 396, 38, 25);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton_4_2 = new JButton("-");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcnt!=0)
					tcnt--;
				textField_2.setText(Integer.toString(tcnt));
			}
		});
		btnNewButton_4_2.setBounds(592, 204, 42, 25);
		frame.getContentPane().add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3 = new JButton("-");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gcnt!=0)
					gcnt--;
				textField_3.setText(Integer.toString(gcnt));
			}
		});
		btnNewButton_4_3.setBounds(206, 396, 42, 25);
		frame.getContentPane().add(btnNewButton_4_3);
		
		JButton btnNewButton_4_4 = new JButton("-");
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vegcnt!=0)
					vegcnt--;
				textField_4.setText(Integer.toString(vegcnt));
			}
		});
		btnNewButton_4_4.setBounds(512, 395, 42, 25);
		frame.getContentPane().add(btnNewButton_4_4);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("T-shirt : Rs.300");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setBounds(592, 191, 127, 15);
		frame.getContentPane().add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Grocery : Rs.2000");
		lblNewLabel_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_2.setBounds(206, 376, 129, 15);
		frame.getContentPane().add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("Vegetables : Rs.500");
		lblNewLabel_6_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_3.setBounds(493, 376, 158, 15);
		frame.getContentPane().add(lblNewLabel_6_1_3);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Place Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cart

				op = "Products        Count        Total\n";
				if(mobcnt>0)
					op+="Mobile                "+mobcnt+"        "+mobcnt*10000;
				if(furcnt>0)
					op+="\nFurniture        "+furcnt+"                "+furcnt*17000;
				if(tcnt>0)
					op+="\nT-shirt                "+tcnt+"        "+tcnt*300;
				if(gcnt>0)
					op+="\nGrocery        "+gcnt+"                "+gcnt*2000;
				if(vegcnt>0)
					op+="\nVegetables        "+vegcnt+"        "+vegcnt*500;
				
				TotalPrice = mobcnt*10000+furcnt*17000+tcnt*300+gcnt*2000+vegcnt*500;
				op+="\nTotal Price                        "+TotalPrice;
				
				
				if(TotalPrice>0) {
				ConfirmOrder c= new ConfirmOrder(TotalPrice,address);
				frame.dispose();
				c.NewScreen();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Order cannot be placed as there is nothing in the cart!!");

				}
			}
		});
		btnNewButton_2.setBounds(359, 457, 129, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(703, 13, 97, 25);
		frame.getContentPane().add(btnNewButton_3);
	}
}

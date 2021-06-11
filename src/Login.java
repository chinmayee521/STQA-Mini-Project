import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField pass;
	public static String pwd ;
	public static String Uname ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login(int x)
	{
		
	}
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	
	public boolean does_exist(String name) 
	{
		
		try {
		     // Class.forName("com.mysql.jdbc.Driver");
		      
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement s = conn.createStatement();
			String q ="select password,address from account where fname = '"+name+"'";
			ResultSet rs  = s.executeQuery(q);
			if(rs.next()==false)
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
		
		
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(100, 31, 415, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(103, 195, 211, 22);
		panel.add(pass);
		
		JLabel lblNewLabel = new JLabel("ONLINE SHOPPING SYSTEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(39, 24, 345, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel uname = new JLabel("Username");
		uname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uname.setBounds(103, 102, 121, 16);
		panel.add(uname);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(103, 131, 211, 22);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(103, 166, 196, 16);
		panel.add(lblNewLabel_1);
		
		JButton Login = new JButton("Login");
		Login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Login.setBounds(103, 252, 97, 25);
		panel.add(Login);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				 Uname=username.getText();
				 pwd = pass.getText();
				 try {
						
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
						Statement s = conn.createStatement();
						String q ="select password,address from account where fname = '"+Uname+"'";
						//System.out.print(q);
						ResultSet rs = s.executeQuery(q);
						if(rs.next()==false)
						{
							
							JOptionPane.showMessageDialog(null, "Account doesn't exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(true);
							username.setText("");
							pass.setText("");
							
							
						}
						else {
							
								
							String address=rs.getString("address");
							String db_pwd= rs.getString("password");
							
							if(pwd.equals(db_pwd))
							{
								OrderPage o=new OrderPage(address);
								JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
								frame.dispose();
								o.NewScreen();
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect pwd", "ate", JOptionPane.INFORMATION_MESSAGE);
								frame.setVisible(true);
								username.setText("");
								pass.setText("");
								
							}
						}
						
							   
							                    
							
							
						
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
			}
		});
		Login.setBackground(Color.LIGHT_GRAY);
		
		JButton Signup = new JButton("SignUp");
		Signup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Signup.setBounds(217, 252, 97, 25);
		panel.add(Signup);
		Signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup s = new Signup();
				frame.dispose();
				s.NewScreen();
			}
		});
	}
}

package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.UserController;
import Controllers.Models.RegisterUserObject;
import DataAccess.UnitOfWork;
import DataAccess.Models.Users.UserBuilder;
import DataAccess.Repositories.UserRepository;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegisterUserView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField email;
	private JTextField jmbg;
	private JTextField name;
	private JTextField lastname;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel emailField;
	private JLabel jmbgField;
	private JLabel nameField;
	private JLabel lastnameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUserView frame = new RegisterUserView();
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
	public RegisterUserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(32, 215, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserLogInView.userLogInView.setVisible(true);
				UserLogInView.registerUserView.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		username = new JTextField();
		username.setBounds(284, 12, 114, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(284, 43, 114, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		email = new JTextField();
		email.setBounds(284, 74, 114, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		jmbg = new JTextField();
		jmbg.setBounds(284, 105, 114, 19);
		contentPane.add(jmbg);
		jmbg.setColumns(10);
		
		name = new JTextField();
		name.setBounds(284, 136, 114, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(284, 167, 114, 19);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = username.getText();
				String pass = password.getText();
				String e_mail = email.getText();
				String _name = name.getText();
				String _lastname = lastname.getText();
				String _jmbg = jmbg.getText();
				
				RegisterUserObject registerUserObject = new RegisterUserObject(new UserBuilder().buildUser(_jmbg, uname, e_mail, pass, _name, _lastname));
				
				UserController userController = new UserController(UnitOfWork.getUnitOfWorkInstance());
				boolean result = userController.registerUser(registerUserObject);
				
				if(result) {
					UserLogInView.userLogInView.setVisible(true);
					UserLogInView.registerUserView.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Username/Email alredy in use.");
				}
			}
		});
		btnNewButton_1.setBounds(32, 78, 117, 25);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(180, 14, 82, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(180, 45, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		emailField = new JLabel("Email");
		emailField.setBounds(182, 76, 70, 15);
		contentPane.add(emailField);
		
		jmbgField = new JLabel("JMGB");
		jmbgField.setBounds(182, 107, 70, 15);
		contentPane.add(jmbgField);
		
		nameField = new JLabel("Name");
		nameField.setBounds(182, 138, 70, 15);
		contentPane.add(nameField);
		
		lastnameField = new JLabel("Lastname");
		lastnameField.setBounds(182, 169, 70, 15);
		contentPane.add(lastnameField);
	}

}

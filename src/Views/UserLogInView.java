package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;

import Controllers.TaskController;
import Controllers.UserController;
import Controllers.Models.LogInUserObject;
import DataAccess.UnitOfWork;
import DataAccess.Models.Tasks.Task;
import DataAccess.Models.Users.User;
import DataAccess.Models.Users.UserBuilder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserLogInView extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public static UserLogInView userLogInView;
	public static TasksView taskView;
	public static RegisterUserView registerUserView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userLogInView = new UserLogInView();
					userLogInView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogInView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(156, 76, 114, 19);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserController userController = new UserController(UnitOfWork.getUnitOfWorkInstance());
				
				String username = usernameField.getText().toString();
				String password = passwordField.getText().toString();
				
				LogInUserObject logInUserObject = new LogInUserObject(new UserBuilder().buildUser(username, password));
				
				boolean result = userController.logInUser(logInUserObject);
				
				if(result) {
					
					taskView = new TasksView();
					taskView.setVisible(true); 
					userLogInView.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Wrong username/password");
				}
				
			}
		});
		btnNewButton.setBounds(63, 170, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				registerUserView = new RegisterUserView();
				registerUserView.setVisible(true);
				
				UserLogInView.userLogInView.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(232, 170, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(40, 78, 88, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(40, 109, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 107, 114, 19);
		contentPane.add(passwordField);
		
	}
	
}

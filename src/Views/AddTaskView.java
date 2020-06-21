package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.TaskController;
import Controllers.Models.TaskPostObject;
import DataAccess.UnitOfWork;
import DataAccess.Models.Tasks.TaskBuilder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class AddTaskView extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField desField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTaskView frame = new AddTaskView();
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
	public AddTaskView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserLogInView.taskView.setVisible(true);
				TasksView.addTaskView.dispose();
			}
		});
		btnNewButton.setBounds(27, 233, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TaskController taskController = new TaskController(UnitOfWork.getUnitOfWorkInstance());
				
				String name = nameField.getText();
				String description = desField.getText();
				
				TaskPostObject taskPostObject = new TaskPostObject(new TaskBuilder().buildTask(name, description));
				
				boolean result = taskController.addTask(taskPostObject);
				
				if(result) {
					
					UserLogInView.taskView.setVisible(true);
					TasksView.addTaskView.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Saving task failed");
				}
			}
		});
		btnNewButton_1.setBounds(226, 233, 117, 25);
		contentPane.add(btnNewButton_1);
		
		nameField = new JTextField();
		nameField.setBounds(187, 64, 114, 19);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(49, 66, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(49, 127, 95, 15);
		contentPane.add(lblNewLabel_1);
		
		desField = new JTextField();
		desField.setBounds(187, 125, 114, 19);
		contentPane.add(desField);
		desField.setColumns(10);
	}

}

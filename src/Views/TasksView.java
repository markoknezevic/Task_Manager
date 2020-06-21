package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.TaskController;
import Controllers.Models.TaskDeleteObject;
import DataAccess.UnitOfWork;
import DataAccess.Models.Tasks.Task;
import DataAccess.Models.Tasks.TaskBuilder;
import DataAccess.Models.Users.User;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class TasksView extends JFrame {

	private JPanel contentPane;
	public static AddTaskView addTaskView;
	private static JTextArea textArea;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					TasksView frame = new TasksView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		getTasks();
	}

	/**
	 * Create the frame.
	 */
	public TasksView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserLogInView.userLogInView.setVisible(true);
				UserLogInView.taskView.setVisible(false);
			}
		});
		btnNewButton.setBounds(288, 12, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new task");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addTaskView = new AddTaskView();
				addTaskView.setVisible(true);
				
				UserLogInView.taskView.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(217, 209, 139, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete task");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TaskController taskController = new TaskController(UnitOfWork.getUnitOfWorkInstance());
				
				String selectedTask = textField.getText();
				TaskDeleteObject taskDeleteObject = new TaskDeleteObject(new TaskBuilder().buildTask(selectedTask));
				
				boolean result = taskController.deleteTask(taskDeleteObject);
				
				if(result) {
					
					JOptionPane.showMessageDialog(null, "Task deleted");
				}else {
					
					JOptionPane.showMessageDialog(null, "Deleting failed");
				}
				
				getTasks();
			}
		});
		
		btnNewButton_2.setBounds(50, 209, 155, 25);
		contentPane.add(btnNewButton_2);
		
		textArea = new JTextArea();
		textArea.setBounds(50, 49, 358, 148);
		contentPane.add(textArea);
		
		JButton btnNewButton_3 = new JButton("Get tasks");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TaskController taskController = new TaskController(UnitOfWork.getUnitOfWorkInstance());
					
				ArrayList<Task> tasks = taskController.getAllTasks(User.getLoggedUser().getJmbg());
					
				String data = "";
						
				for (Task task : tasks) {
					
					data += task.toString();
				}
				
				textArea.setText(data);
			}
			});
		btnNewButton_3.setBounds(24, 12, 117, 25);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(91, 239, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		getTasks();
	}
	
	public static void getTasks(){
		
		TaskController taskController = new TaskController(UnitOfWork.getUnitOfWorkInstance());
		
		ArrayList<Task> tasks = taskController.getAllTasks(User.getLoggedUser().getJmbg());
			
		String data = "";
				
		for (Task task : tasks) {
			
			data += task.toString();
		}

		textArea.setText(data);
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StudentController;
import model.dto.Student;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentDetialForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TableModel tableModel;

	private JMenuBar menubar;
	private JMenu studentmenu, helpMenu;
	
	private JMenuItem addItem,deleteITem;
	private JButton btnAdd;
	
	private StudentController controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetialForm frame = new StudentDetialForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentDetialForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(799, 400);
		setLocationRelativeTo(null);
		/*addItem=new JMenuItem("add");
		deleteITem=new JMenuItem("Delete");
		
		studentmenu=new JMenu("Student");
		studentmenu.add(addItem);
		studentmenu.add(deleteITem);
		menubar=new JMenuBar();

		setJMenuBar(menubar);*/
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel btnPanel=new JPanel();
		btnAdd=new JButton("add");
		btnPanel.add(btnAdd);
		
		contentPane.add(btnPanel,BorderLayout.NORTH);
		
		
		tableModel =new TableModel();
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		refresh();
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddDialog dialog=new AddDialog();
				dialog.setVisible(true);
				
			}
		});
	}

	private void refresh() {
		controller=new StudentController();
		List<Student> list=controller.getStudentDetail();
		tableModel.setStudentsList(list);
		tableModel.updateTable();
	}

}

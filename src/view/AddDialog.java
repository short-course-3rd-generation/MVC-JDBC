package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StudentController;
import model.dto.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField roleNO;
	private JTextField name;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRoleNo = new JLabel("Role No :");
		lblRoleNo.setBounds(91, 60, 46, 14);
		contentPanel.add(lblRoleNo);
		
		roleNO = new JTextField();
		roleNO.setBounds(175, 57, 141, 20);
		contentPanel.add(roleNO);
		roleNO.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(91, 95, 46, 14);
		contentPanel.add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(175, 92, 141, 20);
		contentPanel.add(name);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String roleNo=roleNO.getText().toString();
						String n=name.getText().toString();
						
						Student stu=new Student(roleNo,n);
						StudentController con=new StudentController();
						con.createStudent(stu);
						
						JOptionPane.showMessageDialog(AddDialog.this,"add stduent success");
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

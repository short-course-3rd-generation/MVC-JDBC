package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.dto.Student;

public class TableModel extends AbstractTableModel{
	private List<Student> studentsList;
	private String[] columns={"Role NO","NAME"};

	@Override
	public int getRowCount() {
		return this.studentsList.size();
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student=this.studentsList.get(rowIndex);
		switch (columnIndex) {
		case 0: return student.getRoleNo(); 
		case 1: return student.getName(); 
		default:
			return null;
		}
		
	}
	
	public void setStudentsList(List<Student> list){
		this.studentsList=list;
	}
	public void updateTable(){
		fireTableDataChanged();
	}
}

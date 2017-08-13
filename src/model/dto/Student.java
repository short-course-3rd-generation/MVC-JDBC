package model.dto;

public class Student {
	private String roleNo;
	private String name;
	
	public Student() {}
	
	public Student(String roleNo, String name) {
		super();
		this.roleNo = roleNo;
		this.name = name;
	}
	
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [roleNo=" + roleNo + ", name=" + name + "]";
	}

	
}

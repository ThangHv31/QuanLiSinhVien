package Students;

import Suport.Sp;

public class Student {
	private int ID;
	private String surName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	
	
	
	public Student() {
		super();
	}
	
	public Student(int iD, String surName, String lastName, String dateOfBirth, String gender) {
		super();
		ID = iD;
		this.surName = surName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void input() {
		System.out.println("\t Nhap ID: ");
		ID = Integer.parseInt(Sp.sc.nextLine());
		System.out.println("\t Nhap ho dem: ");
		surName = Sp.sc.nextLine();
		System.out.println("\t Nhap ten: ");
		lastName = Sp.sc.nextLine();
		System.out.println("\t Nhap ngay sinh: ");
		dateOfBirth = Sp.sc.nextLine();
		System.out.println("\t Nhap gioi tinh: ");
		gender = Sp.sc.nextLine();
	}
	public void display() {
		System.out.printf("%-14d %-13s %-8s %-10s %-6s %n", ID, surName, lastName, dateOfBirth, gender);
		//System.out.printf("%-14s %-12s %-8s %-10s %-6s", "Ma Sinh Vien", "Ho dem", "Ten", "Ngay sinh", "Gioi Tinh");
	}
	
}

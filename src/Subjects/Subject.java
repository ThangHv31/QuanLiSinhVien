package Subjects;

import java.util.ArrayList;

import SubjectInTable.StudentInTable;
import Suport.Sp;

public class Subject {
	private int ID_Sb;
	private String nameSb;
	private double coefficient;
	private ArrayList<StudentInTable> list = new ArrayList<StudentInTable>();
	public Subject() {
		super();
	}
	
	
	public ArrayList<StudentInTable> getList() {
		return list;
	}


	public void setList(ArrayList<StudentInTable> list) {
		this.list = list;
	}


	public Subject(int iD_Sb, String nameSb, double coefficient) {
		super();
		ID_Sb = iD_Sb;
		this.nameSb = nameSb;
		this.coefficient = coefficient;
	}


	public int getID_Sb() {
		return ID_Sb;
	}

	public void setID_Sb(int iD_Sb) {
		ID_Sb = iD_Sb;
	}

	public String getNameSb() {
		return nameSb;
	}


	public void setNameSb(String nameSb) {
		this.nameSb = nameSb;
	}


	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public void input() {
		System.out.println("\t Nhap ten mon: ");
		nameSb = Sp.sc.nextLine();
		System.out.println("\t Nhap he so: ");
		coefficient = Double.parseDouble(Sp.sc.nextLine());
	}
	public void display() {
		
System.out.printf("%-14d %-20s %-6.2f %n", ID_Sb, nameSb, coefficient);		
	}
}

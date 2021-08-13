package Suport;

import java.util.ArrayList;
import java.util.Scanner;


import Points.Point;
import Students.Student;
import Students.StudentManagement;
import Subjects.Subject;
import Subjects.SubjectManagement;


public class Sp {
  public static Scanner sc = new Scanner(System.in);
  // tim sinh vien trong danh sach theo ma sinh vien
  public static int indexOfStudent(int id) {
	for (int i = 0; i < StudentManagement.list.size(); i++) {
		if(StudentManagement.list.get(i).getID() == id) {
			return i;
		}
	}
	return -1;
}

  // tim mon hoc trong danh sach theo ma mon hoc
  public static int indexOfSubject(int id) {
	for (int i = 0; i < SubjectManagement.list.size(); i++) {
		if(SubjectManagement.list.get(i).getID_Sb()==id) {
			return i;
		}
	}
	return -1;
}
  public static String nameOfSubject(int id) {
		for(Subject s: SubjectManagement.list) {
			if(s.getID_Sb()==id) {
			return s.getNameSb();
			}
		}
		return null;
	}
  // tra ve ten sinh vien theo id
	public static String nameOfStudent(int id) {
		for(Student s: StudentManagement.list) {
			if(s.getID()==id) {
			return s.getLastName();
			}
		}
		return null;
	}
	public static String firstNameOfStudent(int id) {
		for(Student s: StudentManagement.list) {
			if(s.getID()==id) {
			return s.getSurName();
			}
		}
		return null;
	}
	

}

package Students;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Suport.Sp;

public class StudentManagement {
		static int autoID = 10001;
		public static ArrayList<Student> list = new  ArrayList<Student>();
		public static void menu() {
			// TODO Auto-generated method stub
			do {

			System.out.println("\n------- CAP NHAP DANH SACH SINH VIEN--------");
			System.out.println("Chon mot chuc nang quan ly");
			System.out.println("Chon 1: Them sinh vien moi.");
			System.out.println("Chon 2: Xem danh sach sinh vien");
			System.out.println("Chon 3: Sua thong tin sinh vien");
			System.out.println("Chon 4: Xoa thong tin sinh vien");
			System.out.println("Chon 0: Quay lai");
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(Sp.sc.nextLine());
			switch (chon){
				case 1: add(); break;
				case 2: display(); break;
				case 3: update();break;
				case 4: remove(); break;
				case 0: return;
				default: System.out.println("Lua chon khong hop le");
			}
		}while(true);
		}
		private static void remove() {
			// TODO Auto-generated method stub
			System.out.println("\tNhap ma sinh vien can xoa: ");
			int id = Integer.parseInt(Sp.sc.nextLine());
			int index = Sp.indexOfStudent(id);
			if(index == -1) {
				System.out.println("Khong co sinh vien trong danh sach !");
				return;
			}
			list.remove(index);
			System.out.println("Done !");
		}
		private static void update() {
			// TODO Auto-generated method stub
			System.out.println("\tNhap ma sinh vien can sua: ");
			int id = Integer.parseInt(Sp.sc.nextLine());
			int index = Sp.indexOfStudent(id);
			if(index == -1) {
				System.out.println("Khong co sinh vien trong danh sach !");
				return;
			}
			do {
			System.out.println("------SUA THONG TIN SINH VIEN-------");
			System.out.println("Chon mot thanh phan de sua");
			System.out.println("Chon 1: Sua ten sinh vien.");
			System.out.println("Chon 2: Sua ngay sinh");
			System.out.println("Chon 3: Sua gioi tinh");
			System.out.println("Chon 0: Quay lai");
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(Sp.sc.nextLine());
			switch (chon){
				case 1: updateName(index); break;
				case 2: updateDate(index); break;
				case 3: updateGender(index);break;
				case 0: return;
				default: System.out.println("Lua chon khong hop le");
				}
			}while(true);
		}
		private static void updateGender(int index) {
			// TODO Auto-generated method stub
			System.out.println("Nhap gioi tinh khac: ");
			String gender = Sp.sc.nextLine();
			if (gender.length() == 0) {
				System.out.println("Khong hop le!");
				return;
			}
			list.get(index).setGender(gender);
			System.out.println("Done..!");
		}
		private static void updateDate(int index) {
			// TODO Auto-generated method stub
			System.out.println("Nhap ngay sinh khac: ");
			String date = Sp.sc.nextLine();
			if (date.length() < 8||date.length() > 10) {
				System.out.println("Khong hop le!");
				return;
			}
			list.get(index).setDateOfBirth(date);
			System.out.println("Done..!");
		}
		private static void updateName(int index) {
			// TODO Auto-generated method stub
			System.out.println("Nhap ten khac: ");
			String surName = Sp.sc.nextLine();
			String lastName = Sp.sc.nextLine();
			if (surName.length() == 0||lastName.length() == 0) {
				System.out.println("Khong hop le!");
				return;
			}
			list.get(index).setSurName(surName);
			list.get(index).setLastName(lastName);
			System.out.println("Done..!");
		}
			
		private static void display() {
			// TODO Auto-generated method stub
			System.out.println("------------DANH SACH SINH VIEN-------------");
			System.out.printf("%-5s %-14s %-12s %-8s %-10s %-6s %n", "STT", "Ma Sinh Vien", "Ho dem", "Ten", "Ngay sinh", "Gioi Tinh");
			Collections.sort(list, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getLastName().compareToIgnoreCase(o2.getLastName());
				}
				
			});
			int stt = 1;
			for(Student s : list) {
				System.out.printf("%-6d",stt);
				s.display();
				stt++;
			}
		}
		private static void add() {
			// TODO Auto-generated method stub
			System.out.println("\n-------- THEM SINH VIEN MOI ----------");
			System.out.println("\tNhap ho dem :");
			String Fname  = Sp.sc.nextLine();
			if(Fname.length()==0) {
				System.out.println("Ho dem khong hop le !");
				return;
			}
			System.out.println("\tNhap ten :");
			String Lname  = Sp.sc.nextLine();
			if(Lname.length()==0) {
				System.out.println("Ho dem khong hop le !");
				return;
			}
			System.out.println("\tNhap ngay sinh(dd/mm/yyyy)");
			String date = Sp.sc.nextLine();
			if(date.length()<8||date.length()>10) {
				System.out.println("Ngay sinh khong hop le !");
				return;
			}
			System.out.println("\tNhap gioi tinh :");
			String gender  = Sp.sc.nextLine();
			if(gender.length()==0) {
				System.out.println(" khong hop le !");
				return;
			}
			list.add(new Student(autoID, Fname, Lname, date, gender));
			autoID++;
			System.out.println("\tThem moi thanh cong!");
		}

}

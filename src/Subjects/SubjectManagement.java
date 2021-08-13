package Subjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Students.Student;
import Suport.Sp;

public class SubjectManagement {
	static int autoID = 9001;
	public static ArrayList<Subject> list = new ArrayList<Subject>();
	public static void menu() {
		// TODO Auto-generated method stub
		do {

		System.out.println("\n------- CAP NHAP MON HOC--------");
		System.out.println("Chon mot chuc nang quan ly");
		System.out.println("Chon 1: Them mon hoc moi.");
		System.out.println("Chon 2: Xem danh sach mon hoc");
		System.out.println("Chon 3: Sua thong tin mon hoc");
		System.out.println("Chon 4: Xoa thong tin mon hoc");
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
		System.out.println("\tNhap ma mon hoc can xoa: ");
		int id = Integer.parseInt(Sp.sc.nextLine());
		int index = Sp.indexOfSubject(id);
		if(index == -1) {
			System.out.println("Khong co mon hoc trong danh sach !");
			return;
		}
		list.remove(index);
		System.out.println("Done !");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\tNhap ma mon hoc can sua: ");
		int id = Integer.parseInt(Sp.sc.nextLine());
		int index = Sp.indexOfSubject(id);
		if(index == -1) {
			System.out.println("Khong co mon hoc trong danh sach !");
			return;
		}
		do {
		System.out.println("------SUA THONG TIN MON HOC-------");
		System.out.println("Chon mot thanh phan de sua");
		System.out.println("Chon 1: Sua ten sinh vien.");
		System.out.println("Chon 2: Sua ngay sinh");
		System.out.println("Chon 0: Quay lai");
		System.out.println("Lua chon cua ban: ");
		int chon = Integer.parseInt(Sp.sc.nextLine());
		switch (chon){
			case 1: updateName(index); break;
			case 2: updateCoef(index); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		}while(true);
	}
	
	private static void updateCoef(int index) {
		// TODO Auto-generated method stub
		System.out.println("Nhap he so khac: ");
		Double coef = Double.parseDouble(Sp.sc.nextLine());
		if (coef <= 0) {
			System.out.println("Khong hop le!");
			return;
		}
		list.get(index).setCoefficient(coef);
		System.out.println("Done..!");
	}

	private static void updateName(int index) {
		// TODO Auto-generated method stub
		System.out.println("Nhap ten khac: ");
		String name = Sp.sc.nextLine();
		if (name.length() == 0) {
			System.out.println("Khong hop le!");
			return;
		}
		list.get(index).setNameSb(name);
		System.out.println("Done..!");
	}
	

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("------------DANH SACH MON HOC-------------");
		System.out.printf("%-5s %-14s %-20s %-6s %n", "STT", "Ma Mon Hoc", "Ten Mon Hoc", "He so");
		Collections.sort(list, new Comparator<Subject>() {
			@Override
			public int compare(Subject o1, Subject o2) {
				// TODO Auto-generated method stub
				return o1.getNameSb().compareToIgnoreCase(o2.getNameSb());
			}
		});
		int stt = 1;
		for(Subject sb : list) {
			System.out.printf("%-6d",stt);
			sb.display();
			stt++;
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n-------- THEM MON HOC MOI ----------");
		System.out.println("\tNhap ten mon hoc :");
		String name  = Sp.sc.nextLine();
		if(name.length()==0) {
			System.out.println("Ho dem khong hop le !");
			return;
		}
		System.out.println("\tNhap he so mon:");
		double coef = Double.parseDouble(Sp.sc.nextLine());
		if(coef <= 0) {
			System.out.println("He so mon khong hop le !");
			return;
		}
		list.add(new Subject(autoID, name, coef));
		autoID++;
		System.out.println("\tThem moi thanh cong!");
	}
}

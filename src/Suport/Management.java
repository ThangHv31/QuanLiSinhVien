package Suport;

import Points.Point;
import Points.PointManagement;
import Students.StudentManagement;
import Subjects.SubjectManagement;

public class Management {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			System.out.println("====== QUAN LY THONG TIN =====");
			System.out.println("Chon mot chuc nang quan ly");
			System.out.println("Chon 1: Cap nhap thong tin.");
			System.out.println("Chon 2: Tim kiem thong tin.");
			System.out.println("Chon 0: Thoat!");
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(Sp.sc.nextLine());
			switch(chon) {
			case 1: update(); break;
			case 2: search(); break;
			case 0:
				System.out.println("Da dong ung dung!");
				System.exit(0);
			default: System.out.println("Chon khong dung!");
			}
		}while(true);

	}

		private static void search() {
		// TODO Auto-generated method stub
			do {
				System.out.println("\n-----------Tim kiem diem----------------");
				System.out.println("Chon mot chuc nang tim kiem:");
				System.out.println("\t1. Tim kiem theo ma sinh vien");
				System.out.println("\t2. Tim kiem theo ma mon hoc");
				System.out.println("\t0. Quay lai");
				System.out.println("Chon mot chuc nang: ");
				int chon = Integer.parseInt(Sp.sc.nextLine());
				switch(chon) {
				case 1: PointManagement.searchByIdStudent();  break;
				case 2: searchCustomer(); break;
				case 0: return;
				default: System.out.println("Lua chon khong hop le");
				}
			}while(true);
	}

		private static void searchCustomer() {
			// TODO Auto-generated method stub
			
		}

		private static void update() {
			// TODO Auto-generated method stub
			do {
			System.out.println("\n-----------Cap nhap thong tin he thong----------------");
			System.out.println("Chon mot chuc nang cap nhap:");
			System.out.println("\t1. Cap nhap thong tin sinh vien");
			System.out.println("\t2. Cap nhap thong tin mon hoc");
			System.out.println("\t3. Cap nhap thong tin bang diem");
			System.out.println("\t0. Quay lai");
			System.out.println("Chon mot chuc nang: ");
			int chon = Integer.parseInt(Sp.sc.nextLine());
			switch(chon) {
			case 1: StudentManagement.menu();  break;
			case 2: SubjectManagement.menu(); break;
			case 3: PointManagement.menu(); break;

			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
			
		}while(true);
	  }
}

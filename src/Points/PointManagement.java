package Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Students.Student;
import SubjectInTable.StudentInTable;
import SubjectInTable.SubjectInT;
import Subjects.Subject;
import Subjects.SubjectManagement;
import Suport.Sp;


public class PointManagement {
	public static ArrayList<Point> list = new  ArrayList<Point>();
	

	public static void menu() {

		do {
			System.out.println("====== QUAN LY BANG DIEM =====");
			System.out.println("Chon mot chuc nang quan ly");
			System.out.println("Chon 1: Cap nhap diem.");
			System.out.println("Chon 2: Quan li diem.");
			System.out.println("Chon 0: Quay lai !");
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(Sp.sc.nextLine());
			switch(chon) {
			case 1: updatePoint(); break;
			case 2: pointManagement(); break;
			case 0: return;
			default: System.out.println("Chon khong dung!");
				}
			}while(true);
		}
		private static void updatePoint() {
			// TODO Auto-generated method stub
			System.out.println("-------CAP NHAP THONG TIN BANG DIEM---------");
			Point point = new Point();
			System.out.println("Chon ma sinh vien");
			int idSv = Integer.parseInt(Sp.sc.nextLine());
			if (Sp.indexOfStudent(idSv)==-1) {
				System.out.println("Khong co sinh vien trong danh sach");
				return;
			}
			point.setIdStu(idSv);
			do {
				System.out.println("Chon chuc nang cap nhap bang diem: ");
				System.out.println("Chon 1: Them diem.");
				System.out.println("Chon 2: Xem diem.");
				System.out.println("Chon 3: Sua diem.");
				System.out.println("Chon 4: Xoa diem.");
				System.out.println("Chon 0: Quay lai !");
				System.out.println("Lua chon cua ban");
				int chon = Integer.parseInt(Sp.sc.nextLine());
				switch(chon) {
				case 1: Add(point); break;
				case 2: Display(point); break;
				case 3: update(point); break;
				case 4: remove(point); break;
				case 0: return;
				default: System.out.println("Lua chon khong hop le!");
				
				}	
			}while(true);
		}
		
		private static void remove(Point point) {
			// TODO Auto-generated method stub
			System.out.println("\n------------XOA DIEM	------------");
			System.out.println("Chon ma mon hoc: ");
			int id = Integer.parseInt(Sp.sc.nextLine());
			///
			int index = 0;
			while(index < point.getList().size()&&
					point.getList().get(index).getId()!=id) {
					index ++;
					}
			if(index == point.getList().size()) {
				System.out.println("Mon hoc chua co ");
			}
			point.getList().remove(index);
			System.out.println("Xoa thanh cong!");
		}
		private static void update(Point point) {
			// TODO Auto-generated method stub
			System.out.println("\n------------SUA DIEM------------");
			System.out.println("Chon ma mon hoc can sua");
			int id = Integer.parseInt(Sp.sc.nextLine());
			///
			int index = 0;
			while(index < point.getList().size()&&
					point.getList().get(index).getId() != id) {
					index ++;
					}
			if(index == point.getList().size()) {
				System.out.println("Mon hoc khong co!");
			}
			System.out.println("\nNhap diem moi: ");
			int mark = Integer.parseInt(Sp.sc.nextLine());
			if(mark < 0|| mark>10) {
				System.out.println("\n so luong phai la so duong <= 10");
				return;
			}
			point.getList().get(index).setMark(mark);
			System.out.println("Sua thanh cong!");
		}
		private static void Display(Point point) {
			// TODO Auto-generated method stub
			System.out.println("------THONG TIN BANG DIEM CUA BAN---------");
			System.out.println("Ma sinh vien: " + point.getIdStu());
			String fName = Sp.firstNameOfStudent(point.getIdStu());
			String lName = Sp.nameOfStudent(point.getIdStu());
			System.out.println("Ten sinh vien: " +fName + lName);
			double  k = 0, tongHs = 0;
			System.out.println("Bang diem: ");
			System.out.printf("%-3s %-20s %-8s %-14s %n", "STT", "Ten Mon Hoc", "Diem", "He so");
			int stt = 1;
			for (SubjectInT p : point.getList()) {
				int index = Sp.indexOfSubject(p.getId());
				String name = SubjectManagement.list.get(index).getNameSb();
				double coef = SubjectManagement.list.get(index).getCoefficient();
				k += coef*p.getMark();
				tongHs += coef;
				System.out.printf("%-3d %-20s %-8.1f %-14.1f %n", stt, name, p.getMark(), coef);
				stt++;
			}
			double dtb = k/tongHs;
			System.out.printf("Diem tong ket : %.2f %n", dtb);
		}
		private static void Add(Point point) {
			// TODO Auto-generated method stub
			System.out.println("---------Them diem----------");
			System.out.print("Chon ma mon hoc: ");
			int idSb = Integer.parseInt(Sp.sc.nextLine());
			int index = Sp.indexOfSubject(idSb);
			if(index == -1) {
				System.out.println("Mo hoc khong co trong danh sach!");
				return;
			}
			System.out.println("Nhap diem moi :");
			double mark = Integer.parseInt(Sp.sc.nextLine());
			
			if(mark < 0|| mark> 10) {
					System.out.println("diem khong hop le!");
					return;
				}
				else {
					SubjectInT sb = new SubjectInT(idSb, mark);
					point.getList().add(sb);
					System.out.println("Them thanh cong..!");
				}
			}		
		private static void displayBySb(Subject subject) {
			System.out.println("------THONG TIN BANG DIEM CUA MON HOC---------");
			System.out.println("Ma mon hoc: " + subject.getID_Sb());
			String name = Sp.nameOfSubject(subject.getID_Sb());
			System.out.println("Ten mon hoc: " + name);
			double dtb = 0, k = 0;
			System.out.println("Bang diem theo mon hoc: ");
			System.out.printf("%-3s %-12s %-20s %-8s %-6s %n", "STT","Ma mon hoc", "Ten Mon Hoc", "Diem", "He so");
			int stt = 1;
			for (StudentInTable s: subject.getList()) {
				int index = Sp.indexOfSubject(s.getId());
				String nameS = SubjectManagement.list.get(index).getNameSb();
				int idS = SubjectManagement.list.get(index).getID_Sb();
				double coef = SubjectManagement.list.get(index).getCoefficient();
				System.out.printf("%-3d %-12s %-20s %-8.1f %-6.1f %n", stt, idS, nameS, coef);
				stt++;
			}
		}
		private static void pointManagement() {
			// TODO Auto-generated method stub
			do{
				System.out.println("\n----------HIEN THI BANG DIEM------------");
				System.out.println("Chon mot chuc nang quan ly");
				System.out.println("Chon 1: Xem toan bo danh sach bang diem cua sinh vien.");
				System.out.println("Chon 2: Xem toan bo danh sach bang diem cua mon hoc.");
				System.out.println("Chon 0: Quay lai !");
				System.out.println("Lua chon cua ban: ");
				int chon = Integer.parseInt(Sp.sc.nextLine());
				switch(chon) {
				case 1: displayAllStudentPoint(); break;
				case 2: displayAllSubjectPoint(); break;
				case 0: return;
				default: System.out.println("Chon khong dung!");
					}
				}while(true);
					
				}
		private static void displayAllSubjectPoint() {
			// TODO Auto-generated method stub
			System.out.println("\n------DANH SACH BANG DIEM-----------");
			for(Point p : list) {
				Display(p);
				System.out.println("-------------------------------------------");
				}
		}
		private static void displayAllStudentPoint() {
			// TODO Auto-generated method stub
			Subject subject =new Subject();
			System.out.println("\n------DANH SACH BANG DIEM-----------");
			for(StudentInTable studentInTable: subject.getList() ) {
				displayBySb(subject);
				System.out.println("-------------------------------------------");
				}
		}
		public static void searchByIdStudent() {
			System.out.println("\n--------TIM BANG DIEM THEO MA SINH VIEN--------");
			System.out.println("Nhap ma snh vien: ");
			int id = Integer.parseInt(Sp.sc.nextLine());
			String fName = Sp.firstNameOfStudent(id);
			String lName = Sp.nameOfStudent(id);
			int idStu = Sp.indexOfStudent(id);
			if(idStu == -1) {
				System.out.println("khong co sinh vien ma" + id);
				return;
				}
			System.out.println("bang diem cua "+fName+" "+lName);
			int dem = 0;
			for(Point point : list) {
				Display(point);
				System.out.println("----------------------------");
				dem++;
			}
			if(dem==0) {
				System.out.println("Sinh vien chua co diem");
			}
			
			
		}
}

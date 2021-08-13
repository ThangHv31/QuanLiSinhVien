package Points;

import java.util.ArrayList;

import SubjectInTable.SubjectInT;
import Subjects.Subject;
import Suport.Sp;

public class Point{
	private  double point;
	private int idStu;
	private int idSbj;
	private ArrayList<SubjectInT> list = new ArrayList<SubjectInT>();
	public double getPoint() {
		return point;
	}
	public Point(double point, int idStu, int idSbj, ArrayList<SubjectInT> list) {
		super();
		this.point = point;
		this.idStu = idStu;
		this.idSbj = idSbj;
		this.list = list;
	}
	public ArrayList<SubjectInT> getList() {
		return list;
	}
	public void setList(ArrayList<SubjectInT> list) {
		this.list = list;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public int getIdStu() {
		return idStu;
	}
	public void setIdStu(int idStu) {
		this.idStu = idStu;
	}
	public int getIdSbj() {
		return idSbj;
	}
	public void setIdSbj(int idSbj) {
		this.idSbj = idSbj;
	}
	public Point() {
		super();
	}
	public void input() {
		System.out.println("Nhap diem : ");
		point = Double.parseDouble(Sp.sc.nextLine());
	}
	public void display() {
		System.out.printf("%-4.2f", point);
	}
}

package ermvc;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


public class ERModel {
	private int rno;
	private String sname;
	private double m1,m2;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getM1() {
		return m1;
	}
	public void setM1(double m1) {
		this.m1 = m1;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public double getTotal() {
		return m1+m2;
	}
	public double getAvg() {
		return (m1+m2)/2;
	}
	public String getResult() {
		return (m1>34.4 && m2 > 34.4 ? "Pass":"Fail");
	}
	public String getGrade() {
		if(getResult().equals("fail")) {
			return "-";
		}
		double avg=getAvg();
		
		if(avg >95) {
			return "O";
		}else if(avg>85) {
			return "A+";
		}
		else if(avg>75) {
			return "A";
		}
		else if(avg>65) {
			return "B";
		}
		else if(avg>59)
				 {
			return "C";
		}else {
			return "-";
		}
	}
	
	public ERModel(){
		this(null,-1,-1);
	}
	public ERModel(String sname,double m1,double m2) {
		this.sname=sname;
		this.m1=m1;
		this.m2=m2;
	}

}
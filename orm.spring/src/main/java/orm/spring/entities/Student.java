package orm.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Table")
public class Student {
	@Id
	private int student_Id;
	private String student_name;
	private String student_city;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int student_Id, String student_name, String student_city) {
		this.student_Id = student_Id;
		this.student_name = student_name;
		this.student_city = student_city;
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_city() {
		return student_city;
	}

	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}

	@Override
	public String toString() {
		return "Student [student_Id=" + student_Id + ", student_name=" + student_name + ", student_city=" + student_city
				+ "]";
	}

}

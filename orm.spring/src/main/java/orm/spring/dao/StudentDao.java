package orm.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import orm.spring.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;

	// Insert Student into DB
	@Transactional
	public int insert(Student student) {
		Integer count = (Integer) this.hibernateTemplate.save(student);
		return count;
	}
	//Read the data from DB single data
	public Student getStudent(int st_id) {
		Student student = this.hibernateTemplate.get(Student.class, st_id);
		return student;
	}

	//Read the data from DB multiple data
	public List<Student> getAllstudent(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//Delete data from the student
	@Transactional
	public void deleteStudent(int st_id) {
		 Student student = hibernateTemplate.get(Student.class, st_id);
		 hibernateTemplate.delete(student);
	}
	
	//Update Operation
	@Transactional
	public void studentUpdate(Student student) {
		hibernateTemplate.update(student);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

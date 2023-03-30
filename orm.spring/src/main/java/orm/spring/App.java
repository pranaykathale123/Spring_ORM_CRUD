package orm.spring;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import orm.spring.dao.StudentDao;
import orm.spring.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(232,"pranay","wardha");
//        int r = studentDao.insert(student);
//        System.out.println("Done"+ r);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			System.out.println("press 1 for add new Student");
			System.out.println("press 2 for display all Student");
			System.out.println("press 3 for get Details of a single Student");
			System.out.println("press 4 for delete Student");
			System.out.println("press 5 for Update Student");
			System.out.println("press 6 for Exit Student");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// add new student
					System.out.println("Enter Student Id : ");
					int uId = Integer.parseInt(br.readLine());
					System.out.println("Enter Student Name : ");
					String sName = br.readLine();
					System.out.println("Enter Student City : ");
					String city = br.readLine();
					
					Student st = new Student();
					
					st.setStudent_name(sName);
					st.setStudent_Id(uId);
					st.setStudent_city(city);
					
					int count = studentDao.insert(st);
					System.out.println("Inserted"+count+"Data succesfully");
					break;
				case 2:
					// display all student
					List<Student> allstudent = studentDao.getAllstudent();
					for(Student ob: allstudent) {
						System.out.println(ob);
					}
					break;
				case 3:
					// get details of single student
					System.out.println("Enter Student Id");
					int id = Integer.parseInt(br.readLine());
					Student ob = studentDao.getStudent(id);
					System.out.println(ob.getStudent_Id()+" "+ob.getStudent_city()+" "+ob.getStudent_name());
					break;
				case 4:
					// delete student
					System.out.println("Enter Student Id");
					int user = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(user);
					System.out.println(user+"Deleted from student database");
					
					break;
				case 5:
					// Update Student
					System.out.println("Enter the student which you want to update");
					int studentId = Integer.parseInt(br.readLine());
					System.out.println("If you want to update name then please :Enter");
					String studentName = br.readLine();
					System.out.println("Enter Your City");
					String studentCity = br.readLine();
					//creating Object of student to pass 
					Student ob1 = new Student();
					ob1.setStudent_city(studentCity);
					ob1.setStudent_Id(studentId);
					ob1.setStudent_name(studentName);
					
					studentDao.studentUpdate(ob1);
					System.out.println("Updated student Details");
					
					break;
				case 6:
					// exit
				    flag=false;
				    break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Input");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thank You for Using My Application :)");

	}
}

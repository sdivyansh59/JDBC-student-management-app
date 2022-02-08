import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to exit Student");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				// add student
				System.out.println("Enter user name:");
				String name = br.readLine();
				
				System.out.println("Enter user phone:");
				String phone = br.readLine();
				System.out.println("Enter user city:");
				String city = br.readLine();
				
				// creating student obj
				Student st =new Student(name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully");
				}else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
				
			}else if( c== 2) {
				// delte student
				System.out.println("Enter student id to delete: ");
				int userId =Integer.parseInt(br.readLine());
				boolean answer =StudentDao.deleteStudent(userId);
				if(answer) {
					System.out.println("Student is deleted successfully");
				}else {
					System.out.println("Something went wrong try again...");
				}
				
				
			}else if(c==3) {
				// display student
				StudentDao.showAllStudent();
			}else {
				// exit
				break;
			}
			
		}
		System.out.println("Thank you for using application\n See you soon Bye! ");
	}

}

package schoolmanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class SchoolOperation {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=====================================================");
		System.out.println("=====================ABC SCHOOL======================");
		System.out.println("=====================================================");
		
		System.out.println("\t\t 1 --> ADMIN");
		System.out.println("\t\t 2 --> TEACHER");
		System.out.println("\t\t 3 --> STUDENT");
		
		System.out.println("Enter your choice: ");
		int choice = Integer.parseInt(br.readLine());
		
		
		//Choice == 1 --> ADMIN 
		if(choice == 1) {
			Admin ad=new Admin();
			 ad.Admin();	
		}
		
		//Choice == 2 --> TEACHER
		else if(choice == 2) {
			Teacher te=new Teacher();
			te.Teacher();
		}
		
		
		//Choice == 3 --> STUDENT
		else if(choice == 3) {
			Student st=new Student();
			st.Student();
		}
		
		
		//Choice not available 
		else {
			System.out.println("Enter valid choice...");
		}
	}

}

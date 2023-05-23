package schoolmanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

	public void Student() throws IOException, ClassNotFoundException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Connection conn = MysqlConnection.getConnection();
		
		System.out.println("Enter Student id: ");
		int studentId1 = br.read();
		
		PreparedStatement ps = conn.prepareStatement("select from students where studId=?");
		ps.setInt(1, studentId1);
		ResultSet students = ps.executeQuery();

		
		System.out.println("                                                                                  STUDENT TABLE                                                                                       ");
		System.out.println("======================================================================================================================================================================================");
		System.out.println("studId \t\tfirst_name\t\tlast_name\t\tmiddle_name\t\tmother_name\t\tgender\t\tdate\t\temail\t\tphone\t\taddress\t\tadd_date");
		System.out.println("======================================================================================================================================================================================");
		
		
	
		while (students.next()) {
			System.out.println(students.getInt("studId") +"\t\t"+students.getString("first_name") +"\t\t"+students.getString("last_name")+"\t\t"
		            +students.getString("middle_name")+"\t\t"+students.getString("mother_name")+"\t\t"+students.getString("gender")+"\t\t"
					+students.getDate("dob")+"\t\t"+students.getString("email")+"\t\t"+students.getLong("phone")+"\t\t"
		            +students.getString("address")+"\t\t"+students.getDate("add_date"));
		}
		System.out.println("===================================================================================================================================");
		
		
		
	}

}

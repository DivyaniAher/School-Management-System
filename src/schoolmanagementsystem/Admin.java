package schoolmanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Admin {

	public void Admin() throws ClassNotFoundException, SQLException, IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("==================================================");
		System.out.println("                   ADMIN LOGIN                    ");
		System.out.println("==================================================");
		
		System.out.println("\t Enter username: ");
		String userName = br.readLine();
		System.out.println("\t Enter password: ");
		String userPassword = br.readLine();
		
		try {
			Connection conn = MysqlConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin where username=?");
			
			ps.setString(1, userName);
			ResultSet result = ps.executeQuery();
			String password = null;
			boolean login = false;
			
			while(result.next()) {
				password = result.getString("password");
				login = true;
			}
			
			if(password.equals(userPassword)) {
				String status = "y";
				
				System.out.println("===========================================");
				System.out.println("                ADMIN PANEL                ");
				System.out.println("===========================================");
				
				do {
					System.out.println("=============================================");
					System.out.println("\t\t 1 --> Manage Students");
					System.out.println("\t\t 2 --> Manage Teachers");
					System.out.println("\t\t 3 --> Exit/Logout");
					System.out.println("=============================================");
					
					System.out.println("Enter your choice: ");
					int operation = Integer.parseInt(br.readLine());
					
					switch(operation) {
					
					case 1: 
						System.out.println("=========================================");
						System.out.println("             STUDENT DETAILS             ");
						System.out.println("=========================================");
						
						System.out.println("\t\t 1 --> ADD");
						System.out.println("\t\t 2 --> UPDATE");
						System.out.println("\t\t 3 --> DELETE");
						System.out.println("\t\t 4 --> DISPLAY");
						
						System.out.println("Enter your choice: ");
						int opt = Integer.parseInt(br.readLine());
						ResultSet res;
						
						
						//ADMIN module option 1 -- Manage student switch case
						
						switch(opt) {
						
						//case 1 of switch(opt)
						case 1: 
							
							System.out.println("Enter First name: ");
							String first_name = br.readLine();
							
							System.out.println("Enter Last name: ");
							String last_name = br.readLine();
							
							System.out.println("Enter Middle name: ");
							String middle_name = br.readLine();
							
							System.out.println("Enter Mother's name: ");
							String mother_name = br.readLine();
							
							System.out.println("Gender: ");
							String gender = br.readLine();
							
							System.out.println("Date Of Birth: ");
							String dob = br.readLine();
							
							System.out.println("Enter email id: ");
							String email = br.readLine();
							
							System.out.println("Enter phone number: ");
							long phone = Long.parseLong(br.readLine());
							
							System.out.println("Enter address: ");
							String address = br.readLine();
							
							System.out.println("Date of Admission:(DD/MM/YYYY)  ");
							String add_date = br.readLine();
							
							ps = conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?");
							
							ps.setString(1, first_name);
							ps.setString(2, last_name);
							ps.setString(3, middle_name);
							ps.setString(4, mother_name);
							ps.setString(5, gender);
							
							SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
							java.util.Date utilDate = format.parse(dob);
							java.sql.Date date = new java.sql.Date(utilDate.getTime());
							
							ps.setDate(6,  date);
							ps.setString(7, email);
							ps.setLong(8, phone);
							ps.setString(9, address);
							
							SimpleDateFormat format1 = new SimpleDateFormat("DD/MM/YYYY");
							java.util.Date utilDate1 = format1.parse(add_date);
							java.sql.Date date1 = new java.sql.Date(utilDate1.getTime());
							ps.setDate(10, date1);
							
						
							if(ps.executeUpdate() > 0) {
								System.out.println("===================================================");
								System.out.println("        Student Details Added Successfully         ");
								System.out.println("===================================================");
							}
							
							System.out.println("Do you want to continue?(Y/N)");
							status = br.readLine();
							
							if(status.equals("n") || status.equals("N")) {
								login = false;
							}
							break;
							
							
							
							//case 2 of switch(opt)
						case 2:/*
							System.out.println("==================================================");
							System.out.println("             UPDATE DETAILS                       ");
							System.out.println("==================================================");
							
							System.out.println("Enter Student id: ");
							int studentId = br.read();
							
							System.out.println("\t\t 1 --> Update Email Id:  ");
							System.out.println("\t\t 2 --> Update Phone no: ");
							System.out.println("\t\t 3 --> Update Address: ");
							int choice2 = Integer.parseInt(br.readLine());
							
							if(choice2 == 1) {
							ps = conn.prepareStatement("update students set email=? where studentId=?");
							
							System.out.println("Enter the old email: ");
							String emailid = br.readLine();
							
							System.out.println("Enter the new email:");
							String newemail = br.readLine();
							
							res = ps.executeQuery();
							String existingEmail = null;
							while (res.next()) {
								existingEmail = res.getString("accPassword");

							}

							if (existingPassword.equals(oldPassword)) {
								if (newPassword.equals(rePassword)) {
									ps = conn.prepareStatement("update accounts set accPassword=? where accUsername=?");
									ps.setString(1, newPassword);
									ps.setString(2, userName);

									if (ps.executeUpdate() > 0) {
										System.out.println(
												"==============================================================================");
										System.out.println("Password changed successfully!!");
										System.out.println(
												"==============================================================================");

									} else {
										System.out.println(
												"==============================================================================");
										System.out.println("Problem in password changed!!");
										System.out.println(
												"==============================================================================");

									}

								} else {
									System.out.println(
											"==============================================================================");
									System.out.println("New password and retype password must be same!!");
									System.out.println(
											"==============================================================================");

								}
							} else {
								System.out.println(
										"==============================================================================");
								System.out.println("Old password is wrong!!");
								System.out.println(
										"==============================================================================");

							}
							System.out.println("Do you want to continue?(Y/N)");
							status = br.readLine();

							if (status.equals("n") || status.equals("N")) {
								login = false;
							}


							
							
							}
							
							break;
							*/
							
							//case 3 of switch(opt)
						case 3:
							System.out.println("Enter Student id: ");
							int studentId1 = br.read();
							
							ps = conn.prepareStatement("delete from students where stuId=?");
							ps.setInt(1, studentId1);
							
							if(ps.executeUpdate() > 0) {
								System.out.println("=================================================");
								System.out.println("             Student Deleted Successfully        ");
								System.out.println("=================================================");
							  }
							else {
								System.out.println("==================================================");
								System.out.println("       Problem in deleting student details        ");
								System.out.println("==================================================");
							}
							
							System.out.println("Do you want to continue?(Y/N)");
							status = br.readLine();
							
							if(status.equals("n") || status.equals("N")) {
								login = false;
							}
							break;
							
						case 4: 
							System.out.println("                                                                                  STUDENT TABLE                                                                                       ");
							System.out.println("======================================================================================================================================================================================");
							System.out.println("studId \t\tfirst_name\t\tlast_name\t\tmiddle_name\t\tmother_name\t\tgender\t\tdate\t\temail\t\tphone\t\taddress\t\tadd_date");
							System.out.println("======================================================================================================================================================================================");
							
							
							ps = conn.prepareStatement("select * from students");
							ResultSet students = ps.executeQuery();

							while (students.next()) {
								System.out.println(students.getInt("studId") +"\t\t"+students.getString("first_name") +"\t\t"+students.getString("last_name")+"\t\t"
							            +students.getString("middle_name")+"\t\t"+students.getString("mother_name")+"\t\t"+students.getString("gender")+"\t\t"
										+students.getDate("dob")+"\t\t"+students.getString("email")+"\t\t"+students.getLong("phone")+"\t\t"
							            +students.getString("address")+"\t\t"+students.getDate("add_date"));
							}
							System.out.println("===================================================================================================================================");
							
							System.out.println("Do you want to continue?(Y/N)");
							status = br.readLine();

							if (status.equals("n") || status.equals("N")) {
								login = false;
							}
							break;
							
						default: 
							System.out.println("Wrong Choice!!");
							break;
							
						}//switch(opt) close
					
						
					case 2:
						System.out.println("=======================================================");
						System.out.println("                   TEACHER DETAILS                     ");
						System.out.println("=======================================================");
						
						System.out.println("\t\t 1 --> ADD");
						System.out.println("\t\t 2 --> UPDATE");
						System.out.println("\t\t 3 --> DELETE");
						
						System.out.println("Enter your choice: ");
						int opt1 = Integer.parseInt(br.readLine());
						ResultSet res1;
						
						
						//Admin module option 2 -->Manage Teacher switch case
						
						switch(opt1) {
						
						case 1: 
						
						}//switch(opt1) close
						
						
					}//switch(operation) close
					
					
					
				}//do loop close
				while(login);
					System.out.println("=============================================");
					System.out.println("Bye. Have a nice day!!");
					System.out.println("=============================================");

				
			}//if loop close
			else {
					System.out
							.println("================================================");
					System.out
							.println("================  Wrong password  ==============");
					System.out
							.println("================================================");
			}
			
		}//try close
		catch (Exception e) {
			System.out.println(e);
			System.out.println("==============================================================================");
			System.out.println("===========================  Wrong username/password  ========================");
			System.out.println("==============================================================================");
		}
	


	}
}

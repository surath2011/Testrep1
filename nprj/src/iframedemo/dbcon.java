package iframedemo;

import java.sql.*;

public class dbcon {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public dbcon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/surath", "root", "root1234");
			st= con.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void getdata(){
		try{
			String user= "bose";
			int pass= 24;
			int cnt=0;
			String q= "select * from customer where cname='"+user+"' AND age='"+pass+"'";
			rs= st.executeQuery(q);
			System.out.println("+++++++++++++");
			while(rs.next()){
				cnt++;
			}
			if(cnt>0){
				System.out.println("WELCOME  "+user);
			}
			else{
				System.out.println("INVALID");
			}
		}
	
	catch(Exception ex){
		System.out.println(ex);
	}

}
}
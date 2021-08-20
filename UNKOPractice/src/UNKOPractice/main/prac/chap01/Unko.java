package UNKOPractice.main.prac.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Unko{
	
	class IDNum{
	private int ID;
	
	public void setID(int ID) {
		this.ID = ID;
		
	}
	public int getID() {
		return this.ID;
	}
	}
	public  ArrayList<Integer> str;
	public Unko() { 
	try {
		Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:~/mydb","sa","");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MEMBERSLIST");
			
		ResultSet rs = pstmt.executeQuery();
		
		str = new ArrayList<Integer>();
		while(rs.next()) {
			IDNum IDnum = new IDNum();
			IDnum.setID(rs.getInt("ID"));
			str.add(IDnum.getID());
		}
		rs.close();
		pstmt.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}
		}
	}

	public ArrayList<Integer> UnkoExe() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Unko un = new Unko();
		for(int i = 0;i < un.str.size();i++) {
			list.add(un.str.get(i));
		}
		return list;
	}	
	}
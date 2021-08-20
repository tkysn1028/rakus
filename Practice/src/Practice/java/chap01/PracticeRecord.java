package Practice.java.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PracticeRecord {

	public void recordExe(String title,int textnum) {
		try {
			Class.forName("org.h2.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:h2:~/mydb","sa","");
				
				PreparedStatement pstmt = con.prepareStatement("UPDATE PRACTICETABLE SET TIME =?, TEXTNUM =?  WHERE ID=?");
				pstmt.setString(1, LocalDateTime.now().toString());
				pstmt.setInt(2, textnum);
				pstmt.setString(3, title);
				
				int r = pstmt.executeUpdate();
				pstmt.close();
				
				Practice p = new Practice();
				p.PracExe();
				
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
}

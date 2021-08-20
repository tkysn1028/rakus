package Practice.java.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Practice {

	public void PracExe() {
		try {
			Class.forName("org.h2.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:h2:~/mydb","sa","");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PRACTICETABLE");
				ResultSet rsl = pstmt.executeQuery();
			ArrayList<LIST> list = new ArrayList<LIST>();	
				while(rsl.next()) {
			LIST txttmlist = new LIST();
			txttmlist.setID(rsl.getString("ID"));
			txttmlist.setTime(rsl.getString("TIME"));
			txttmlist.setTextnum(rsl.getInt("TEXTNUM"));
			list.add(txttmlist);
			}
			
				for(LIST aa : list) {
				System.out.println("------------");
							
				System.out.println("内容 : " + aa.getID());
				System.out.println("書いた字数 : " + aa.getTextnum());
				System.out.println("最後に書いた日付 : " + aa.getTime());
				
				}
				System.out.println("---------------end");
				
				rsl.close();
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
}

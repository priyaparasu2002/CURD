package ermvc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ulibrary.mysql.UDatabase;

public class ERCTRLDelete {
	public int execute(UDatabase dbs,ERModel erm) {
		try {
			Connection cn=dbs.getConnection();
			if(cn==null) {
				return -1;
				
			}
			
			String qryStr="delete from ertbl where rno=?";
			
			PreparedStatement st=cn.prepareStatement(qryStr);
			st.setInt(1, erm.getRno());
			
			int r=st.executeUpdate();
			
			st.close();
			cn.close();
			
			
			return r;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
		
	}
	public int execute(UDatabase dbs,int rno) {
		try {
			Connection cn=dbs.getConnection();
			if(cn==null) {
				return -1;
			}
			String qryStr="delete from ertbl where rno=?";
			
			PreparedStatement st=cn.prepareStatement(qryStr);
			st.setInt(1, rno);
			
			int r=st.executeUpdate();
			
			
			st.close();
			cn.close();
			
			return r;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
			
		}
	}

}

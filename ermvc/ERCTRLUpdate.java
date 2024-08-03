package ermvc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ulibrary.mysql.UDatabase;

public class ERCTRLUpdate {
	public int execute (UDatabase dbs,ERModel erm) {
		try {
			Connection cn= dbs.getConnection();
			if (cn == null) {
				return -1;
			}
			String qryStr="update ertbl set sname=?, m1=?,m2=? where rno=?";
			
			PreparedStatement st=cn.prepareStatement(qryStr);
			st.setString(1, erm.getSname());
			st.setDouble(2, erm.getM1());
			st.setDouble(3, erm.getM2());
			st.setDouble(4, erm.getRno());
			
			int r=st.executeUpdate();
			
			st.close();
			cn.close();
			
			return r;	
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
		
	}

}

package ermvc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ulibrary.mysql.UDatabase;

public class ERCTRLInsert {
	public int execute (UDatabase dbs,ERModel erm) {
		try {
			Connection cn=dbs.getConnection();
			
			if(cn == null) {
				return -1;
			}
			String qryStr ="insert into  ertbl(sname,m1,m2) values(?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(qryStr);
			ps.setString(1,erm.getSname());
			ps.setDouble(2, erm.getM1());
			ps.setDouble(3, erm.getM2());
			
			int r=ps.executeUpdate();
			ps.close();
			cn.close();
			
			return r;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}

}

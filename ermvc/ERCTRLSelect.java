package ermvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSetMetaData;

import ulibrary.mysql.UDatabase;

public final class ERCTRLSelect extends UDatabase {
	public List<String> getColumnName(UDatabase dbs,String qryStr){
		try {
			Connection cn = dbs.getConnection();
			PreparedStatement ps=cn.prepareStatement(qryStr);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			List<String> Lst=new ArrayList<String>();
			
			for (int i=1;i<=rsmd.getColumnCount();i++) {
				Lst.add(rsmd.getColumnName(i).toUpperCase());
			}
			ps.close();
			cn.close();

			return Lst;	
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}	
	}
	public List<ERModel>getRows(UDatabase dbs,String qryStr){
		try {
			Connection cn=dbs.getConnection();
			PreparedStatement ps=cn.prepareStatement(qryStr);
			ResultSet rs=ps.executeQuery();
			
			List<ERModel> Lst=new ArrayList<ERModel>();
			
			while (rs.next()) {
				ERModel erm=new ERModel();
				erm.setRno(rs.getInt("rno"));
				erm.setSname(rs.getString("sname"));
				erm.setM1(rs.getDouble("m1"));
				erm.setM2(rs.getDouble("m2"));
				
				Lst.add(erm);
			}
			ps.close();
			cn.close();
			return Lst;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}
	public ERModel getRow(UDatabase dbs,String qryStr) {
		try {
			Connection cn=dbs.getConnection();
			PreparedStatement ps=cn.prepareStatement(qryStr);
			ResultSet rs=ps.executeQuery();
			ERModel erm=null;
			
			if(rs.next()) {
				erm=new ERModel();
				erm.setRno(rs.getInt("rno"));
				erm.setSname(rs.getString("sname"));
				erm.setM1(rs.getDouble("m1"));
				erm.setM2(rs.getDouble("m2"));
				
			}
			ps.close();
			cn.close();
			
			return erm;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
			
		}
	}


}

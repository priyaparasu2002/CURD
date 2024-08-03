package ermvc;

import java.util.List;

import ulibrary.mysql.UDatabase;

public  final class ERViewSelect {

	public static void main(String[] args) {
		UDatabase udb=new UDatabase();
		udb.setProtocol("jdbc:mysql");
		udb.setServerIP("127.0.0.1");
		udb.setServerPort(3306);
		udb.setName("ppdb");
		udb.setUser("root");
		udb.setPassword("");
		
		ERCTRLSelect erc=new ERCTRLSelect();
		
		List<String>LstCols=erc.getColumnName(udb,"select * from ertbl");
		List<ERModel>Lst=erc.getRows(udb, "select * from ertbl");
		
		System.out.printf("\n%8s",LstCols.get(0));
		System.out.printf("\t%7s",LstCols.get(1));
		System.out.printf("\t%7s",LstCols.get(2));
		System.out.printf("\t%7s",LstCols.get(3));
		System.out.printf("\t%8s",LstCols.get(4));
		System.out.printf("\t%7s",LstCols.get(5));
		System.out.printf("\t%6s",LstCols.get(6));
		System.out.printf("\t%6s",LstCols.get(7));
		
		if(Lst==null) {
			return;
			
		}
		for (int r=0; r<Lst.size();r++) {
			
			ERModel erm=Lst.get(r);
			System.out.printf("\n%8d",erm.getRno());
			System.out.printf("\t%7s",erm.getSname());
			System.out.printf("\t%7.2f",erm.getM1());
			System.out.printf("\t%7.2f",erm.getM2());
			System.out.printf("\t%8.2f",erm.getTotal());
			System.out.printf("\t%7.2f",erm.getAvg());
			System.out.printf("\t%6s",erm.getResult());
			System.out.printf("\t%6s",erm.getGrade());
				
		}
	}

}

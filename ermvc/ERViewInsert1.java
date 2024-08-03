package ermvc;

import ulibrary.mysql.UDatabase;

public class ERViewInsert1 {
	public static void main(String...args) {
		UDatabase udb=new UDatabase();
		
		udb.setProtocol("jdbc:mysql");
		udb.setServerIP("127.0.0.1");
		udb.setServerPort(3306);
		udb.setName("ppdb");
		udb.setUser("root");
		udb.setPassword("");
		
		ERModel erm=new ERModel();
		erm.setSname("x5");
		erm.setM1(56.5);
		erm.setM2(63);
		
		ERCTRLInsert erc=new ERCTRLInsert();
		
		int r=erc.execute(udb, erm);
		
		if(r>0) {
			System.out.print("1 row inserted");
		}
		else
		{
			System.out.println("0 row inserted");
		}
	}

}
/*
 * output:
 * 1 row inserted
 *  
 */
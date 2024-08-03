package ermvc;

import ulibrary.mysql.UDatabase;

public final class ERViewDelete {
	public static void main(String [] args) {
		UDatabase udb=new UDatabase();
		
		udb.setProtocol("jdbc:mysql");
		udb.setServerIP("127.0.0.1");
		udb.setServerPort(3306);
		udb.setName("ppdb");
		udb.setUser("root");
		udb.setPassword("");
		
		ERModel erm=new ERModel();
		erm.setRno(1003);
		
		ERCTRLDelete erc=new ERCTRLDelete();
		
		int r=erc.execute(udb, erm);
		
		if(r>0) {
			System.out.println("1 row deleted");
		}else
		{
			System.out.println("0 row deleted");
		}
	}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	



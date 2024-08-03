package ermvc;

import ulibrary.mysql.UDatabase;

public final class ERViewUpdate {

	public static void main(String[] args) {
		UDatabase udb=new UDatabase();
		
		udb.setProtocol("jdbc:mysql");
		udb.setServerIP("127.0.0.1");
		udb.setServerPort(3306);
		udb.setName("ppdb");
		udb.setUser("root");
		udb.setPassword("");
		
		ERModel erm=new ERModel();
		erm.setRno(1004);
		erm.setSname("x2");
		erm.setM1(63.5);
		erm.setM2(79);
		
		ERCTRLUpdate erc=new ERCTRLUpdate();
		
		int r=erc.execute(udb, erm);
		
		if(r>0) {
			System.out.println("1 row updated");
		}else {
			System.out.println("0 row updated");
		}


	}

}

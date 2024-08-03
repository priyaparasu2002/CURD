package ermvc;

import java.util.ArrayList;
import java.util.List;

import ulibrary.mysql.UDatabase;

public final class ERViewInsert2 {
	public static void main(String []args) {
		UDatabase udb=new UDatabase();
		
		udb.setProtocol("jdbc:mysql");
		udb.setServerIP("127.0.0.1");
		udb.setServerPort(3306);
		udb.setName("ppdb");
		udb.setUser("root");
		udb.setPassword("");
		
		ERCTRLInsert erc=new ERCTRLInsert();
		
		List<ERModel>LstErm=new ArrayList<ERModel>();
		LstErm.add(new ERModel("x3",95,97));
		LstErm.add(new ERModel ("x1",90.5,90));
		LstErm.add(new ERModel ("x2",98,20));
		LstErm.add(new ERModel ("x4",88,72.5));
		
		int r=0;
		for(ERModel erm: LstErm) {
			r += erc.execute(udb, erm);
		}
		
		if(r>0) {
			System.out.println(r+"row(s) inserted");
		}else
		{
			System.out.println("0 row inserted");
		}	
	
	}

}
/*
 * output:
 * 4row(s) inserted
 * 
 */

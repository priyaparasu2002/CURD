<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@
    page import="
    ulibrary.mysql.UDatabase,
    ermvc.ERCTRLDelete"
     %>
     
     <%!
     UDatabase udb;
     ERCTRLDelete ercd;
     %>
     
     <%
     udb=new UDatabase();
     udb.setProtocol("jdbc:mysql");
     udb.setServerIP("127.0.0.1");
     udb.setServerPort(3306);
     udb.setName("ppdb");
     udb.setUser("root");
     udb.setPassword("");
try{
	ercd=new ERCTRLDelete();
	int rno=Integer.parseInt(request.getParameter("rno"));
	int r=ercd.execute(udb, rno);
	
	//'session 'transaction data between webpages or web-services
	// request.getSession().setAttribute("msgDelete",r);
}catch (Exception e){
	out.println("Err:"+e.getMessage());
}finally{
	RequestDispatcher rd=request.getRequestDispatcher("erview.select.jsp");
	rd.forward(request,response);
}
%>


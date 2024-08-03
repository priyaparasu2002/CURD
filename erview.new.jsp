<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%!
String sname,m1,m2;
%>

<%
sname=request.getParameter("tbxsname");
m1=request.getParameter("tbxm1");
m2=request.getParameter("tbxm2");
%>

<%
if(sname==null || m1== null || m2==null){
	return ;
}
%>
<%@
page import="ulibrary.mysql.UDatabase,
ermvc.ERModel,ermvc.ERCTRLInsert"
 %>
 
<%!
ERModel erm;
UDatabase udb;
ERCTRLInsert erci;
%>

<%
try{
	erm=new ERModel();
	erm.setSname(sname);
	erm.setM1(Double.parseDouble(m1));
	erm.setM2(Double.parseDouble(m2));
}catch(Exception e){
	out.println("err:"+e.getMessage());
	//RequestDispatcher rd=request.getRequestDispatcher("erview.new.html)";
	
	//rd.forward (request,responsse);
	return;
}
udb=new UDatabase();
udb.setProtocol("jdbc:mysql");
udb.setServerIP("127.0.0.1");
udb.setServerPort(3306);
udb.setName("ppdb");
udb.setUser("root");
udb.setPassword("");

try{
	erci=new ERCTRLInsert();
	int r=erci.execute(udb,erm);
	
	//'session' transaction data between or web-services
	request.getSession().setAttribute("msgInsert",r);
}catch(Exception e){
	out.println("Err:"+e.getMessage());
	RequestDispatcher rd=request.getRequestDispatcher("erview.new.html");
	rd.forward(request,response);
}finally{
	RequestDispatcher rd=request.getRequestDispatcher("erview.select.jsp");
	rd.forward(request,response);
}
%>

</html>
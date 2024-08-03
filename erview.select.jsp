<%@page import="javax.tools.DocumentationTool.Location" %>
<%@page import="
ulibrary.mysql.UDatabase,
ermvc.ERModel,ermvc.ERCTRLSelect,ermvc.ERCTRLDelete,
java.util.List"
 %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/utable.css">
<title>Exam Result|SYSTech</title>
</head>
<%
try{
	//convert getAttribute' property Object as Integer
	Object obj=null;
	if(obj==null){
		obj=request.getSession().getAttribute("msgInsert");
	}
	if(obj==null){
		obj=request.getSession().getAttribute("msgUpdate");
	}
	if(obj==null){
		obj=request.getSession().getAttribute("msgDelete");
	}
	if(obj != null){
		int rst=(Integer)obj;
		
		if(rst == -1){
			
			out.println("<script>alert('0 record affected')");
		}
		
		// 'invalidate' method reset (or erase) session data's
		request.getSession().invalidate();
	}
}catch (Exception e){
	out.println("err:"+e.getMessage());
}
%>
<%!
UDatabase udb;
ERCTRLSelect ercs;

List<String> LstCols;
List<ERModel>LST;
%>

<%
udb=new UDatabase();
udb.setProtocol("jdbc:mysql");
udb.setServerIP("127.0.0.1");
udb.setServerPort(3306);
udb.setName("ppdb");
udb.setUser("root");
udb.setPassword("");

ercs=new ERCTRLSelect();

LstCols=ercs.getColumnName(udb,"select* from ertbl");
LST=ercs.getRows(udb,"select * from ertbl");

out.println("<table border='1' width='100%'>");

if(LstCols !=null){
	out.println("<thead>");
	for(String columnName:LstCols){
		out.println("<th>"+columnName);
	}
	out.println("<th colspan='2'>");
	out.println("<a href='erview.new.html'><b>&#10009;</b</a>");
	out.println("</thead>");
}


if(LST == null){
	out.println("</table>");
	return;
}

for(int r=0;r<LST.size();r++){
	ERModel erm=LST.get(r);
	%>
	<tr>
	<td><%=erm.getRno()%>
	<td><%=erm.getSname()%>
	<td><%=erm.getM1()%>
	<td><%=erm.getM2()%>
	<td><%=erm.getTotal()%>
	<td><%=erm.getAvg()%>
	<td><%=erm.getResult()%>
	<td><%=erm.getGrade()%>
	<td align='center'>
	<a href="erview.edit.jsp?rno=<%=erm.getRno()%>"><b>&#9998;</b></a>
	<td align='center'>
	<a href='#' onclick="
	if(confirm('Sure,Delete a Record')){
	location.href='erview.del.jsp?rno=<%=erm.getRno()%>';
	}
	">
	<b>&#10008;</b>
	</a>
	<%
	}//for-each'loop ends here 
	%>
	</table>
	
	
	







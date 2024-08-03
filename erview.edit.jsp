<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@
page import="
ulibrary.mysql.UDatabase,ermvc.ERModel,
ermvc.ERCTRLSelect,ermvc.ERCTRLUpdate"
 %>
    
<!DOCTYPE html>


<title>Exam Result| Edit Record|SYSTech</title>

<%!
ERModel erm;
UDatabase udb;
ERCTRLSelect ercs;
ERCTRLUpdate ercu;
%>

<%
udb=new UDatabase();
udb.setProtocol("jdbc:mysql");
udb.setServerIP("127.0.0.1");
udb.setServerPort(3306);
udb.setName("ppdb");
udb.setUser("root");
udb.setPassword("");

if(request.getParameter("btnsave")!=null){
	int rno=Integer.parseInt(request.getParameter("tbxrno"));
	String sname=request.getParameter("tbxsname");
	double m1=Double.parseDouble(request.getParameter("tbxm1"));
	double m2=Double.parseDouble(request.getParameter("tbxm2"));
	
	
	erm=new ERModel();
	erm.setRno(rno);
	erm.setSname(sname);
	erm.setM1(m1);
	erm.setM2(m2);
	
	ercu=new ERCTRLUpdate();
	int r=ercu.execute(udb,erm);
	
	request.getSession().setAttribute("msgUpdate",r);
	RequestDispatcher rd=request.getRequestDispatcher("erview.select.jsp");
	rd.forward(request,response);

}else{
	ercs=new ERCTRLSelect();
	
	try{
		int rno=Integer.parseInt(request.getParameter("rno"));
		erm=ercs.getRow(udb,"select * from ertbl where rno="+rno);
	}catch(Exception e){
		out.println("err:"+e.getMessage());
		RequestDispatcher rd=request.getRequestDispatcher("erview.select.jsp");
		rd.forward(request,response);
		
	}
	
}
%>
<script>
function computeData(){
	var m1=tbxm1.value;
	var m2=tbxm2.value;
	
	m1=parseFloat(m1);
	m1=isNaN(m1)?0:m1;
	
	m2=parseFloat(m2);
	m2=isNaN(m2)?0:m2;
	
	var total=m1+m2;
	var avg=total/ 2;
	var result=m1>34.4&&m2>34.4?"Pass":"Fail";
	var grade="-";
	
	if(result == "Pass"){
		if(avg>95){
			grade="O";
		}else if(avg>85){
			grade="A+";
		}
		else if(avg>75){
			grade="A";
		}
		else if(avg>65){
			grade="B";
		}
		else if(avg>59){
			grade="C";
		}
}
	tbxtotal.value=total;
	tbxavg.value=avg;
	tbxresult.value=result;
	tbxgrade.value=grade;
}
</script>
<form action="erview.edit.jsp" method="post">
<table>
<tr>
<td>Roll no.
<td><input type="text" name="tbxrno" id="tbxrno" placeholder="0"
 readonly="readonly" value="<%=erm.getRno()
%>"/>

<tr>
<td>Student name
<td><input type="text" name="tbxsname" id="tbxsname" placeholder="unknown" 
value="<%=erm.getSname()%>"/>


<tr>
<td>Mark-1
<td><input type="text" name="tbxm1" id="tbxm1" placeholder="0.00" 
oninput="computeData();"
value="<%=erm.getM1()%>"/>

<tr>
<td>Mark-2
<td><input type="text" name="tbxm2" id="tbxm2" placeholder="0.00" 
oninput="computeData();"
value="<%=erm.getM2()%>"/>

<tr>
<td>Total
<td><input type="text" name="tbxtotal" id="tbxtotal" placeholder="0.00" 
readonly="readonly"
value="<%=erm.getTotal()%>"/>

<tr>
<td>Average
<td><input type="text" name="tbxavg" id="tbxavg" placeholder="0.00" 
readonly="readonly"
value="<%=erm.getAvg()%>"/>  

<tr>
<td>Result  
<td><input type="text" name="tbxresult" id="tbxresult" placeholder="0.00" readonly="readonly"
value="<%=erm.getResult()%>"/>


<tr>
<td>Grade
<td><input type="text" name="tbxgrade" id="tbxgrade"  placeholder="-" readonly="readonly"
value="<%=erm.getGrade()%>"/>

<tr>
<td>
<input type="button" value="Cancel" onclick="loation.href='erview.edit.jsp';"/>
<td>
<input type="submit"  name="btnsave" value="Save"/>
</table>
</form>



</html>
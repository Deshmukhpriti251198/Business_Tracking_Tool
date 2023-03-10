<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<br><br><br><br><br><br>
<table width="700px" align="center"
style="border:1px solid #000000;">
<tr>
<td colspan=19 align="center"
style="background-color:ffeeff">
<b>Product Record</b></td>
</tr>
<tr style="background-color:efefef;">
<td><b>ID</b></td>
<td><b>PRODUCT_CODE</b></td>
<td><b>PRODUCT_NAME</b></td>
<td><b>GRADE</b></td>
<td><b>UNIT_OF_MEASUREMENT</b></td>
<td><b>MANUFACTURER</b></td>
<td><b>COUNTRY</b></td>
<td><b>TDS</b></td>
<td><b>MSDS</b></td>
<td><b>FREE_TRADE_AGREEMENT</b></td>
<td><b>IMAGE</b></td>


</tr>
<%
int count=0;
String color = "#F9EBB3";


if(request.getAttribute("empList")!=null)
{
ArrayList al = (ArrayList)request.getAttribute("empList");
Iterator itr = al.iterator();


while(itr.hasNext()){

if((count%2)==0){
color = "#eeffee";
}
else{
color = "#F9EBB3";
}
count++;
ArrayList empList = (ArrayList)itr.next();
%>
<tr style="background-color:<%=color%>;">
<td><%=empList.get(0)%></td>
<td><%=empList.get(1)%></td>
<td><%=empList.get(2)%></td>
<td><%=empList.get(3)%></td>
<td><%=empList.get(4)%></td>
<td><%=empList.get(5)%></td>
<td><%=empList.get(6)%></td>
<td><%=empList.get(7)%></td>
<td><%=empList.get(8)%></td>
<td><%=empList.get(9)%></td>
<td><%=empList.get(10)%></td>
<td><%=empList.get(11)%></td>

</tr>
<%
}
}
%>
<%
if(count==0){
%>
<tr>
<td colspan=19 align="center"
style="background-color:eeffee"><b>No Record</b></td>
</tr>
<%
}
%>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="java.util.List"
    import="Model.porder"
    import="Dao.porder.implPorder"%>
 <%
 /*
 1.讀取取資料庫 queryAll():List
 2.List--->for-each排版
 3.搭配-->table
 */
 List<porder> l=new implPorder().queryAll();
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<table width=600 align=center border=1>
		<tr height=100>
			<td align=center><%@include file="../title.jsp" %>
		<tr height=450>
			<td>
				<table width=500  align=center  border=1>
					<tr align=center>
						<td>ID<td>桌號<td>A餐<td>B餐<td>C餐<td>金額
						<%
						for(porder p:l)
						{
							out.println("<tr align=center><td>"+p.getId()+
									"<td>"+p.getDesk()+
									"<td>"+p.getA()+
									"<td>"+p.getB()+
									"<td>"+p.getC()+
									"<td>"+p.getSum());
						}
						
						%>
					<tr>
						<td colspan=6 align=center>
						<a href="porder.jsp">回購物管理頁</a>
				</table>
		<tr height=50>
			<td align=center><%@include file="../end.jsp" %>
	</table>
</body>
</html>
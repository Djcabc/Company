<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.porder"%>
 <%
 /*
 1.接收-->request->desk,A,B,C
 2.A,B,C-->String--->int
 3.new porder

 */
request.setCharacterEncoding("big5");
 String Desk=request.getParameter("desk");
 int A=Integer.parseInt(request.getParameter("A"));
 int B=Integer.parseInt(request.getParameter("B"));
 int C=Integer.parseInt(request.getParameter("C"));
 
 porder p=new porder(Desk,A,B,C);
 session.setAttribute("P", p);
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
			<table width=400 align=center  border=1>
				<tr>
					<td colspan=2  align=center>
					<h4>你的訂單細目為:</h4>
				<tr>
					<td>桌號
					<td><%=	p.getDesk() %>
				<tr>
					<td>A餐
					<td><%=p.getA() %>
				<tr>
					<td>B餐
					<td><%=p.getB() %>
				<tr>
					<td>C餐
					<td><%=p.getC() %>
				<tr>
					<td>共
					<td><%=p.getSum() %>元
				<tr>
					<td colspan=2 align=center>
					<a href="addPorder.jsp">重新選擇</a>
					<a href="../addPorderController">確定</a>
			</table>
		<tr height=50>
			<td align=center><%@include file="../end.jsp" %>
	</table>
</body>
</html>
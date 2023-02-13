<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
				<form action="../addMemberConrotller" method="post">
					<table width=400 align="center" border=1>
						<tr>
							<td colspan=2 align="center">
							<h3>會員註冊</h3>
						<tr align="center">
							<td width=100>帳號
							<td><input type="text" name="username">
						<tr align="center">
							<td width=100>密碼
							<td><input type="password" name="password">
						<tr align="center">
							<td width=100>姓名
							<td><input type="text" name="name">
						<tr align="center">
							<td width=100>地址
							<td><input type="text" name="address">
						<tr align="center">
							<td width=100>電話
							<td><input type="text" name="phone">
						<tr align="center">
							<td width=100>行動電話
							<td><input type="text" name="mobile">
						<tr>
							<td colspan=2 align=center>
							<input type="submit" value="ok">
					</table>
				</form>
				
		<tr height=50>
			<td align=center><%@include file="../end.jsp" %>
	</table>
	
</body>
</html>
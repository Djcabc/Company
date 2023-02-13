<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.porder"
    import="Model.member"
    %>
    <%
    /*
    1.擷取 session物件-->登入會員+訂單細目物件
	2.設計出貨單的頁面
	3.結合javaScript列印按鈕
    */
    porder p=(porder)session.getAttribute("P");
    member m=(member) session.getAttribute("M");
  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript">

<!-- This script and many more are available free online at -->
<!-- The JavaScript Source!! http://javascript.internet.com -->

<!-- Begin
function varitext(text){
text=document
print(text)
}
//  End -->
</script>
</head>
<body>
	<table width=600 align=center border=1>
		<tr height=100>
			<td align=center><%@include file="../title.jsp" %>
		<tr height=450>
			<td>
				<table width=450 align=center border=1>
					<tr>
						<td colspan=2 align=center>
						<h4>訂位成功，這是你的細目</h4>	
					<tr>
						<td width=100 align=center>訂購者:
						<td><%=m.getName() %>
					<tr>
						<td width=100 align=center>桌號:
						<td><%=p.getDesk() %>
					<tr>
						<td width=100 align=center>A餐:
						<td><%=p.getA() %>
					<tr>
						<td width=100 align=center>B餐:
						<td><%=p.getB() %>
					<tr>
						<td width=100 align=center>C餐:
						<td><%=p.getC() %>
					<tr>
						<td width=100 align=center>共:
						<td><%=p.getSum() %>元
					<tr>
						<td width=100 align=center>出貨地址:
						<td><%=m.getAddress() %>
					<tr>
						<td width=100 align=center>連絡電話:
						<td><%=m.getPhone() %>
					<tr>
						<td width=100 align=center>行動:
						<td><%=m.getMobile() %>
					<tr>
						<td colspan=2   align=center>
						<a href="porder.jsp">回購物頁</a>
					<DIV ALIGN="CENTER">
							<FORM>
								<INPUT NAME="print" TYPE="button" VALUE="列印此頁"
								ONCLICK="varitext()">
							</FORM>
						</DIV>
				
				</table>
		<tr height=50>
			<td align=center><%@include file="../end.jsp" %>
	</table>
</body>
</html>
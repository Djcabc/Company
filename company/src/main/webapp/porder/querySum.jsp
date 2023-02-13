<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="java.util.List"
    import="Model.porder"
    import="Dao.porder.implPorder"
    %>
    <%
    /*
    1.getParameter--->沒資料-->null(表單物件沒產生),""->表單沒輸入資料
    2.getParameter擷取-->start,end物件
    3.if-->start+end--->null,""-->queryAll
    4.if-->star+end-->有資料--->querySum
    */
    String Start=request.getParameter("start");
    String End=request.getParameter("end");
    
    List<porder> l=null;
    
    if(Start!=null && Start!="" && End!=null && End!="")
    {
    	int S=Integer.parseInt(Start);
    	int E=Integer.parseInt(End);
    	l=new implPorder().querySum(S, E);
    }
    else
    {
   	 l=new implPorder().queryAll();
    }
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
			<form action="querySum.jsp" method="post">
				<table width=500 align=center border=1>
					<tr align=center>
						<td>
						金額從
						<input type="text" name="start" size=3>
						到
						<input type="text" name="end" size=3>
						<input type="submit" value="ok">
				
				</table>		
			
			</form>
			<hr>
			<table width=500 align=center border=1>
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
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="jdbc.lianjie" %>
<%@ page import="Model.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果</title>
</head>
<body>
<h3>搜索结果如下：</h3>

<table style="text-align:center">
		<thead>
			<tr >
<!-- 				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd" >guitarID</font></strong></h5></th> -->
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar弦数</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar价格</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar制造商</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar模型</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar种类</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar后木</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">guitar上木</font></strong></h5></th>
				<th style="background-color:#444;width:100px;"><h5 ><strong><font style="color:#ddd">操作</font></strong></h5></th>
			</tr>
		</thead>
		<tbody>
	<% 
		Inventory inventory = new Inventory();
		inventory = (Inventory)request.getAttribute("result");
		List guitars = new ArrayList();
		guitars = inventory.getGuitars();
		System.out.print(guitars.size());
		if(guitars.size()>0){
		Iterator i = guitars.iterator();
		while(i.hasNext()){
			
			Guitar guitar = (Guitar) i.next();
		 %>
		 <tr  >

		 <td >
		 <text style="font-size:17px;color:#555"><%=guitar.getSerialNumber() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getPrice() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getGuitarSpec().getBuilder() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getGuitarSpec().getModel() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getGuitarSpec().getType() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getGuitarSpec().getBackWood() %></text>
		 </td>
		 
		 <td>
		 <text style="font-size:17px;color:#555"><%=guitar.getGuitarSpec().getTopWood() %></text>
		 </td>

		 <td>
		 <a href="DeleteGuitar?id=<%=guitar.getId()%>" style="font-size:13px;color:#555;font-weight:bold">删除</a>
		 </td>
		 
		 </tr>
		
		 <%	
		}
		%>
		 共搜出<%=guitars.size() %>把符合的吉他。
		 <%
		}else{
		%>
		抱歉！ 并没有符合的吉他。
		<% 	
		}
	%>
	</tbody>
</table>

<a href="index.jsp" style="display:inline-block;margin-top:20px;">重新搜索</a>
</body>
</html>
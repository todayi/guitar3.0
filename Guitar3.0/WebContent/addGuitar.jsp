<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="Enum.builder" %>
  <%@ page import="Enum.type" %>
  <%@ page import="Enum.wood" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加吉他</title>
</head>
<body>
<form action="AddGuitar" method="post">
<h3>请输入你想添加的吉他</h3>
<table style="margin-left:50px">
<tr>
<td style="padding-left:20px">
<label>Model：&nbsp;</label>
<input type="text" name="model" >
</td>
</tr>

<tr>
<td style="padding-left:20px">
<label>弦数：&emsp;</label>
<input type="text" name="serialNumber" >
</td>
</tr>


<tr>
<td style="padding-left:20px">
<label>价格：&emsp;</label>
<input type="text" name="price" >
</td>
</tr>

<tr>
<td style="padding-left:20px">
<label>制造商：</label>
<%
		for(int i = 0; i<builder.values().length;i++){
%>
<input type="radio" name="builder" value="<%=builder.values()[i] %>">
<span style="width:12px;display:inline-block"><%=builder.values()[i] %></span>
		<%} %>
</td>
</tr>

<tr>
<td style="padding-left:20px">
<label>种类：&emsp;</label>
<%
		for(int i = 0; i<type.values().length;i++){
%>
<input type="radio" name="type" value="<%=type.values()[i] %>">
<span style="width:12px;display:inline-block"><%=type.values()[i] %></span>
		<%} %>
</td>
</tr>

<tr>
<td style="padding-left:20px">
<label>后木：&emsp;</label>
<%
		for(int i = 0; i<wood.values().length;i++){
%>
<input type="radio" name="backwood" value="<%=wood.values()[i] %>">
<span style="width:12px;display:inline-block"><%=wood.values()[i] %></span>
		<%} %>
</td>
</tr>
<tr>
<td style="padding-left:20px">
<label>上木：&emsp;</label>
<%
		for(int i = 0; i<wood.values().length;i++){
%>
<input type="radio" name="topwood" value="<%=wood.values()[i] %>">
<span style="width:12px;display:inline-block"><%=wood.values()[i] %></span>
		<%} %>
</td>
</tr>
</table>
<input type="submit" value="添加" style="margin-left:250px;margin-top:20px;">

</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1 align="center">水上无人船上位机</h1>
  	<center>
	<form action="${pageContext.request.contextPath}/user_add" method="post">
		船速:<input type="text" name="shipData.speedShip"/><br/>
		<s:fielderror name="shipData.speedShip"></s:fielderror>
		
		水速:<input type="text" name="shipData.speedWater"/><br/>
		<s:fielderror name="shipData.speedWater"></s:fielderror>
		
		水质:<input type="text" name="shipData.scoreWater"/><br/>
		<s:fielderror name="shipData.scoreWater"></s:fielderror>
		
		<input type="submit" value="添加"/>
	</form>
	</center>	
  </body>
</html>

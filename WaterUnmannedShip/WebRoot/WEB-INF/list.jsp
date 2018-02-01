<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>table</title>
	<meta charset="utf-8" http-equiv="Content-Type">
	<link rel="stylesheet" type="text/css" href="./bs/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="./css/table.css">
	<script src="./bs/js/bootstrap.js"></script>
	<script src="./bs/js/jquery.min.js"></script>
  <style type="text/css">
  *{
      padding: 0px;
      margin: 0px;
}
  .container{
    background: url(./images/top2.jpg) no-repeat ;
    background-size: 100%; 
  }
  </style>
</head>
<body>

	<h1 align="center">水上无人船后台系统</h1>
     <div class="container">
        <div id="one" class="table-responsive">
          <table class="table table-striped table-bordered table-hover" align="center">
          	<tr class="danger">
          		<th>编号</th>
          		<th>船速</th>
          		<th>水速</th>
          		<th>水质</th>
          	</tr>
          	
          	<s:iterator var="ship" value="#session.shipdata" status="vs">
				<tr>
					<td>
						<s:property value="#vs.count"/>
					</td>
					<td>
						<s:property value="#ship.speedShip"/>
					</td>
					<td>
						<s:property value="#ship.speedWater"/>
					</td>
					<td>
						<s:property value="#ship.scoreWater"/>
					</td>
				</tr>
			</s:iterator>
          </table>
       	
        </div>
     </div>
</body>
</html>
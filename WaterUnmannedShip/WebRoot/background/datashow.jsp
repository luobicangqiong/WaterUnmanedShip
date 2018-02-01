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
     <h1>无人船后台数据</h1>
     <div class="container">
        <div id="one" class="table-responsive">
          <table class="table table-striped table-bordered table-hover" align="center">
          	<tr class="danger">
          		<th>ID</th>
          		<th>油门</th>
          		<th>方向</th>
          		<th>控制电压</th>
          		<th>牵引电压</th>
          		<th>船的温度</th>
          		<th>水的温度</th>
          		<th>PH值</th>
          		<th>经度</th>
          		<th>维度</th>
          	</tr>
          	
          	<s:iterator var="ship" value="#session.shipdata" status="vs">
				<tr>
					<td>
						<s:property value="#ship.id"/>
					</td>
					<td>
						<s:property value="#ship.throttle"/>
					</td>
					<td>
						<s:property value="#ship.direction"/>
					</td>
					<td>
						<s:property value="#ship.controlvol"/>
					</td>
					<td>
						<s:property value="#ship.tractionvol"/>
					</td>
					<td>
						<s:property value="#ship.shiptemp"/>
					</td>
					<td>
						<s:property value="#ship.watertemp"/>
					</td>
					<td>
						<s:property value="#ship.ph"/>
					</td>
					<td>
						<s:property value="#ship.latitude"/>
					</td>
					<td>
						<s:property value="#ship.longitude"/>
					</td>
				</tr>
			</s:iterator>
          </table>
       	
        </div>
     </div>
</body>
</html>
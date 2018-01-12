<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>table</title>
	<meta charset="utf-8" http-equiv="Content-Type">
	<link rel="stylesheet" type="text/css" href="../bs/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../css/table.css">
	<script src="../bs/js/bootstrap.js"></script>
	<script src="../bs/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div id="one" class="table-responsive">
			<form action="${pageContext.request.contextPath}/user_add.action"
				method="post">
				<table class="table table-striped table-bordered table-hover">
					<tr class="danger">
						<th>当前船速</th>
						<th>当前水速</th>
						<th>当前水质</th>
					</tr>
					<tr class="active">
						<td><input type="text" name="shipData.speedShip" /></td>
						<td><input type="text" name="shipData.speedWater" /></td>
						<td><input type="text" name="shipData.scoreWater" /></td>

					</tr>
					<tr>
						<td colspan=3 align="center"><input class="btn btn-big" type="submit" value="提交" /></td>
					</tr>

				</table>
			</form>

		</div>
	</div>
</body>
</html>
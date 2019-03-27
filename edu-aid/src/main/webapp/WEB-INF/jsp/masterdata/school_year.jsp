<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0" />
<title>This is title</title>
<!-- < %@ include file="../common/_header_include.jsp"%> -->

<style>
table,th,td {border:1px solid #ccc; text-align:center; border-collapse:collapse;}
</style>
</head>
<body>
<!-- < %@ include file="../common/_left_nav.jsp"%> -->
<!-- < %@ include file="../common/_right_topbar.jsp"%> -->

<div class="container">
学年管理<hr/>
Title: ${title}

<br/><br/>
<table>
	<tr><th>id</th><th>name</th><th>active</th><th></th></tr>
	<c:forEach var="row" items="${schoolYearList}">
	<tr>
		<td>${row.id}</td>
		<td>${row.name}</td>
		<td>${row.active}</td>
		<td></td>
	<tr>
	</c:forEach>
</table>

<script type="text/javascript">
$(document).ready(function(){
});
</script>
</div>
<!-- < %@ include file="../common/_footer_include.jsp"%> -->
</body>
</html>
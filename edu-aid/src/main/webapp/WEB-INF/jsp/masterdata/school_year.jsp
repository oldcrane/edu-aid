<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0" />
<title>主数据 - 学年</title>
<%@ include file="../common/_head_include.jsp" %>

<style>

</style>

</head>
<body>
<%@ include file="../common/_page_header.jsp" %>

<div id="g_content"><!-- do NOT change it. It's part of the global page structure. -->

<%@ include file="../common/_page_menubar.jsp" %>


<div id="g_workspace"><!-- do NOT change it. It's part of the global page structure. -->

<h3 style="display:inline; margin-right:20px;">学年管理</h3>

<select id="selectStatus">
  <option value ="" selected="selected">all</option>
  <option value ="Y">active</option>
  <option value="N">inactive</option>
</select>

<input id="btnFilter" type="button" value="筛选"/>
<span id="bthAdd" class="clickable">新增学年</span>
<br/><br/>

<table class="simpleDataGrid">
	<tr><th>id</th><th>name</th><th>active</th></tr>
	<c:forEach var="row" items="${schoolYearList}">
	<tr>
		<td>${row.id}</td>
		<td>${row.name}</td>
		<td>${row.active}</td>
	<tr>
	</c:forEach>
</table>
<br/>
<p>共xx条记录</p>

<script type="text/javascript">
$(document).ready(function(){
});
</script>

</div>
</div>
<%@ include file="../common/_page_footer.jsp" %>
</body>
</html>
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

<h3>学年管理</h3>


<select id="selectActive">
  <option value ="" selected="selected">all</option>
  <option value ="Y">active</option>
  <option value="N">inactive</option>
</select>

<input id="btnFilter" type="button" value="筛选"/>
<span id="bthAdd" class="clickable">新增学年</span>
<br/><br/>


<table id="tableSchoolYears" class="simpleDataGrid">
	<thead><tr><th>id</th><th>name</th><th>active</th><th></th></tr></thead>
	<tbody>
	<!--  
	<c:forEach var="row" items="${schoolYearList}">
	<tr>
		<td>${row.id}</td>
		<td>${row.name}</td>
		<td>${row.active}</td>
		<td></td>
	<tr>
	</c:forEach>
	-->
	</tbody>
</table>
<br/>
<p id="txtCountSummary"></p>
<br/>

<p id="txtMessage"></p>

<div id="dialogAdd" title="增加新的学年" style="display:none;">
<form id="formAdd">
	<br/>
	<label for="name">name:</label>
	<input type="text" name="name" id="name" value="" maxlength="16" class="text ui-widget-content ui-corner-all"><br/><br/>
	<label for="active">active:</label>
	<label><input name="active" type="radio" value="Y" checked="checked" />active</label>
	<label><input name="active" type="radio" value="N" />inactive</label>
</form>
</div>

<div id="dialogEdit" title="修改学年" style="display:none;">
<form id="formEdit">
	<input type="hidden" id="id" name="id" />
	<br/>
	<label for="name">name:</label>
	<input type="text" name="name" id="name" maxlength="16" class="text ui-widget-content ui-corner-all"><br/><br/>
	<label for="active">active:</label>
	<label><input name="active" type="radio" value="Y" />active</label>
	<label><input name="active" type="radio" value="N" />inactive</label>
</form>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/masterdata/school_year.js"></script>


</div>
</div>
<%@ include file="../common/_page_footer.jsp" %>
</body>
</html>
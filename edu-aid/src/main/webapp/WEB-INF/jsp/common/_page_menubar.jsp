<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div id="g_menubar">
	<ul id="g_menu_tree" class="ztree"></ul>
<script type="text/javascript">
$(document).ready(function(){
	var setting = {
		data:{simpleData:{enable:true}}
	};
	var zNodes = [
		{id:1, name:"学生信息"},
		{id:2, name:"资助人信息"},
		{id:3, name:"志愿者信息"},
		{id:4, name:"资助工作"},
		{id:5, name:"资金管理"},
		{id:6, name:"报表和统计"},
		{id:7, name:"主数据", open:true},
		{id:71, pId:7, name:"学年", url:"<%=request.getContextPath() %>/masterdata/schoolyear/entry", target:"_self"},
		{id:8, name:"技术参数维护"}
	];
	$.fn.zTree.init($("#g_menu_tree"), setting, zNodes);
});
</script>
</div>
$(document).ready(function(){
	$("#btnFilter").click(function(){
		filterSchoolYearBySelectedOption();
	});
	$("#bthAdd").click(function(){
		popupAddDialog();
	});
	filterSchoolYearBySelectedOption();
});

function filterSchoolYearBySelectedOption() {
	filterSchoolYear($("#selectActive").val());
}

function filterSchoolYear(active) {
	$("#txtMessage").text("页面正在加载...")
    $.ajax({
        type: "GET",
        url: "list",
        data: {active: active},
        dataType: "json",
        success: function (resp) {
            if (resp.code == "0") {
                var tableBodyObj = $("#tableSchoolYears tbody");
                tableBodyObj.html("");
                $.each(resp.data,function(index, item) {
                	var rowHtml = "<tr>";
                	rowHtml += "<td>" + item.id + "</td>";
                	rowHtml += "<td>" + item.name + "</td>";
                	rowHtml += "<td>" + item.active + "</td>";
                	rowHtml += "<td><span class='clickable' onclick='popupEditDialog(event)'>edit</span></td>";
                	rowHtml += "</tr>";
                	tableBodyObj.append(rowHtml);
                });
                
                var countSummaryObj = $("#txtCountSummary");
                countSummaryObj.html("共 " + resp.data.length + " 条记录");
                
            } else {
                alert("服务器返回出错信息：\n\n" + resp.message);
            }
        	$("#txtMessage").text("");
        },
        error: function () { alert("Sorry，服务器处理请求出错，请联系IT运维人员。"); }
    });
}

var dialogAdd = $("#dialogAdd").dialog({
    autoOpen: false,
    height:200,
    width: 300,
    modal: true,
    buttons: {
    	"添加新学年": addShoolYear,
    	Cancel: function() {
    		dialogAdd.dialog("close");
    	}
	},
	close: function() {
    	$("#dialogAdd #name").val("");
    	$("#dialogAdd input[name='active']").get(0).checked=true;
	}
});

function popupAddDialog() {
	dialogAdd.dialog("open");
}

function addShoolYear() {
	var name = $("#dialogAdd #name").val();
	var active = $("#dialogAdd input[name='active']:checked").val();
	var postData = {name:name, active:active};
    $.ajax({
        type: "POST",
        url: "add",
        data: JSON.stringify(postData),
        dataType: "json",
        contentType:"application/json",
        success: function (resp) {
            if (resp.code == "0") {
            	dialogAdd.dialog("close");
            	filterSchoolYear(active); // 刷新页面
                
            } else {
            	alert("服务器返回出错信息：\n\n" + resp.message);
            }
        },
        error: function() { alert("Sorry，服务器处理请求出错，请联系IT运维人员。"); }
    });    
}

var dialogEdit = $("#dialogEdit").dialog({
    autoOpen: false,
    height:200,
    width: 300,
    modal: true,
    buttons: {
    	"保存修改内容": updateShoolYear,
    	Cancel: function() {
    		dialogEdit.dialog("close");
    	}
	},
	close: function() {
		$("#dialogEdit #id").val("");    	
		$("#dialogEdit #name").val("");
	}
});

function popupEditDialog(event) {
	event = event || window.event;
    var sourceObj = event.srcElement || event.target;
    var fields = $(sourceObj).closest("td").siblings();
    var active = fields[2].innerText;
    $("#dialogEdit #id").val(fields[0].innerText);
    $("#dialogEdit #name").val(fields[1].innerText);
    var radioSelectorStr = "#dialogEdit input[name='active'][value='" + active + "']";
    $(radioSelectorStr).get(0).checked = true;
    dialogEdit.dialog("open");
}

function updateShoolYear() {
	var id = $("#dialogEdit #id").val();
	var name = $("#dialogEdit #name").val();
	var active = $("#dialogEdit input[name='active']:checked").val();
	var postData = {id:id, name:name, active:active};
    $.ajax({
        type: "POST",
        url: "update",
        data: JSON.stringify(postData),
        dataType: "json",
        contentType:"application/json",
        success: function (resp) {
            if (resp.code == "0") {
            	dialogEdit.dialog("close");
            	filterSchoolYear(); // 刷新页面               
            } else {
            	alert("服务器返回出错信息：\n\n" + resp.message);
            }
        },
        error: function () { alert("Sorry，服务器处理请求出错，请联系IT运维人员。"); }
    });
}

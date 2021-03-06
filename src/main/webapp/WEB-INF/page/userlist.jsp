<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/admin/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/layer/2.4/layer.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
<style>
	.input-father input {
		margin-left: 5px;
	}
	.table td.text-l {
		text-align: center!important;
	}
</style>
<title>员工管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 员工管理
 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
 	<i class="Hui-iconfont">&#xe68f;</i>
 </a>
</nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a class="btn btn-primary radius" onclick="employee_add('员工录入','${pageContext.request.contextPath}/admin/user/add')" href="javascript:;">
				<i class="Hui-iconfont">&#xe600;</i> 员工录入
			</a>
		</span> 
		<span class="r">共有数据：<strong>${count}</strong> 条</span> 
	</div>
	<div class="mt-20 input-father">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="80">用户ID</th>
					<th width="80">登录名</th>
					<th width="80">用户名</th>
					<th width="80">部门</th>
					<th width="120">邮箱地址</th>
					<th width="80">角色</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">  
				<tr class="text-c">
					<input type="hidden" value="${user.userId}" name="userId">
					<td>${user.userId}</td>
					<td>${user.loginName}</td>
					<td>${user.userName}</td>
					<td>${user.department}</td>
					<td>${user.email}</td>
					<td><c:if test="${user.role=='0'}">admin</c:if>
					<c:if test="${user.role=='1'}">管理员</c:if>
					<c:if test="${user.role=='2'}">普通用户</c:if></td>
					<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="employee_edit('编辑','${pageContext.request.contextPath}/employee/preSave?id=${employee.id }','10001')" href="javascript:;" title="编辑">
							<i class="Hui-iconfont">&#xe6df;</i>
						</a>
						<a style="text-decoration:none" class="ml-5" onClick="employee_del(this,${employee.id })" href="javascript:;" title="删除">
							<i class="Hui-iconfont">&#xe6e2;</i>
						</a>
					</td>
				</tr>
			</c:forEach> 		
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "asc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[5]}// 制定列不参与排序
	]
});

/*员工-添加*/
function employee_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*员工-编辑*/
function employee_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*导出所有员工*/
function export_all_employees(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function employee_del(obj, id) {
    layer.confirm('删除员工会同时删除该名员工的系统假期详情，以及其所对应的的请假记录，您确认要删除该名员工吗？', function() {
    	$.ajax({
    		url : "${pageContext.request.contextPath}/employee/deleteById",
			type : "post",
			data : {
				"id":id
    		},
    		datatype:'json',
    		success : function(result) {
    		var result = eval('('+result+')');
    		if (result.success) {
            	layer.confirm('删除成功！', function() {
            		location.replace(location.href);
            	});    	
            } else {
                layer.alert(result.message);
            }
      	  }
	  });
   });
}

</script> 
</body>
</html>
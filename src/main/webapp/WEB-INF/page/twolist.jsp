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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 文件管理 <span class="c-gray en">&gt;</span> 二级文件管理
 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
 	<i class="Hui-iconfont">&#xe68f;</i>
 </a>
</nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a class="btn btn-primary radius" onclick="employee_add('项目录入','${pageContext.request.contextPath}/admin/two/add')" href="javascript:;">
				<i class="Hui-iconfont">&#xe600;</i> 新增编号
			</a>
		</span> 
		<span class="r">共有数据：<strong>${count}</strong> 条</span> 
	</div>
	<div class="mt-20 input-father">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="60">ID</th>
					<th width="60">部门</th>
					<th width="80">文件名称</th>
					<th width="80">版本号</th>
					<th width="80">发布年份</th>
					<th width="80">编号名</th>
					<th width="80">创建人</th>
					<th width="80">创建时间</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${twoValues}" var="two">  
				<tr class="text-c">
					<input type="hidden" value="${two.userId}" name="userId">
					<td>${two.twoId}</td>
					<td>
						<c:if test="${two.department=='YF'}">研发部</c:if>
						<c:if test="${two.department=='SC'}">生产部</c:if>
						<c:if test="${two.department=='ZL'}">质量部</c:if>
						<c:if test="${two.department=='CW'}">财务部</c:if>
						<c:if test="${two.department=='ZH'}">综合部</c:if>
						<c:if test="${two.department=='YX'}">营销部</c:if>
					</td>
					<td>
						<c:if test="${two.fileName=='001'}">公司质量责任制</c:if>
						<c:if test="${two.fileName=='002'}">风险管理程序</c:if>
						<c:if test="${two.fileName=='003'}">人力资源管理程序</c:if>
						<c:if test="${two.fileName=='004'}">基础设施控制程序</c:if>
						<c:if test="${two.fileName=='005'}">过程运行环境控制程序</c:if>
						<c:if test="${two.fileName=='006'}">监视和测量设备控制程序</c:if>
						<c:if test="${two.fileName=='007'}">知识管理</c:if>
						<c:if test="${two.fileName=='008'}">文件控制程序</c:if>
						<c:if test="${two.fileName=='009'}">记录控制程序</c:if>
						<c:if test="${two.fileName=='010'}">质量信息控制程序</c:if>
						<c:if test="${two.fileName=='011'}">顾客需求管理程序</c:if>
						<c:if test="${two.fileName=='012'}">设计开发和新产品试制程序</c:if>
						<c:if test="${two.fileName=='013'}">设计和开发的试验控制程序</c:if>
						<c:if test="${two.fileName=='014'}">技术状态管理程序</c:if>
						<c:if test="${two.fileName=='015'}">采购程序</c:if>
						<c:if test="${two.fileName=='016'}">供方管理程序</c:if>
						<c:if test="${two.fileName=='017'}">计量、试验外包方控制程序</c:if>
						<c:if test="${two.fileName=='018'}">外部运输方控制程序</c:if>
						<c:if test="${two.fileName=='019'}">生产和服务提供控制程序</c:if>
						<c:if test="${two.fileName=='020'}">关键特殊过程控制程序</c:if>
						<c:if test="${two.fileName=='021'}">产品放行程序</c:if>
						<c:if test="${two.fileName=='022'}">不合格品控制程序</c:if>
						<c:if test="${two.fileName=='023'}">顾客满意度的监视和测量程序</c:if>
						<c:if test="${two.fileName=='024'}">内部审核控制程序</c:if>
						<c:if test="${two.fileName=='025'}">管理评审控制程序</c:if>
						<c:if test="${two.fileName=='026'}">纠正、改进程序</c:if>
						<c:if test="${two.fileName=='000'}">无程序文件</c:if>
					</td>
					<td>${two.version}</td>
					<td>${two.year}</td>
					<td>${two.twoName}</td>
					<td>${two.username}</td>
					<td>${two.createTime}</td>
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
	"aaSorting": [[ 7, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0]}// 制定列不参与排序
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
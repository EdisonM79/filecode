<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();
	String url = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" />
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
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
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<input type="hidden" id="basePath" th:value="${springMacroRequestContext.contextPath}" />
<div class="page-container">
	<form action="${pageContext.request.contextPath}/admin/twotable/save" method="post" class="form form-horizontal" id="form-product-add">
		<input type="hidden" id="createUser" name="createUser" value="${currentUser.userId}" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>部门：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="department" id="department" class="select">
					<option value="YF">研发部</option>
					<option value="SC">生产部</option>
					<option value="CW">财务部</option>
					<option value="ZL">质量部</option>
					<option value="ZH">综合部</option>
					<option value="YX">营销部</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>文件名称：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="twoName" id="twoName" class="select">
					<option value="001">公司质量责任制</option>
					<option value="002">风险管理程序</option>
					<option value="003">人力资源管理程序</option>
					<option value="004">基础设施控制程序</option>
					<option value="005">过程运行环境控制程序</option>
					<option value="006">监视和测量设备控制程序</option>
					<option value="007">知识管理</option>
					<option value="008">文件控制程序</option>
					<option value="009">记录控制程序</option>
					<option value="010">质量信息控制程序</option>
					<option value="011">顾客需求管理程序</option>
					<option value="012">设计开发和新产品试制程序</option>
					<option value="013">设计和开发的试验控制程序</option>
					<option value="014">技术状态管理程序</option>
					<option value="015">采购程序</option>
					<option value="016">供方管理程序</option>
					<option value="017">计量、试验外包方控制程序</option>
					<option value="018">外部运输方控制程序</option>
					<option value="019">生产和服务提供控制程序</option>
					<option value="020">关键特殊过程控制程序</option>
					<option value="021">产品放行程序</option>
					<option value="022">不合格品控制程序</option>					
					<option value="023">顾客满意度的监视和测量程序</option>
					<option value="024">内部审核控制程序</option>
					<option value="025">管理评审控制程序</option>
					<option value="026">纠正、改进程序</option>
					<option value="000">无程序文件</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>版本号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="tableVersion" name="tableVersion"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>表单名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="tableName" name="tableName"/>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="addButton" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<!-- <button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> -->
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div> 
		</div>
	</form>
</div>
<script>
function article_submit(){
	$("#form-product-add").submit();
	layer.alert('提交成功！',function(){
		layer_close();
	})
}
$(document).ready(function ()
{
	$("#addButton").click(function( )
	{
		 var department = $("#department").val();
         var twoName = $("#twoName").val();
         var tableVersion = $("#tableVersion").val();
         var tableName = $("#tableName").val();
         var createUser = $("#createUser").val();
         
         if(department==null||department==""){
        	 layer.alert("请选择部门！");
        	 return false;
         }
         
         if(twoName==null||twoName==""){
             layer.alert("请选择文件名称！");
             return false;
         }
         
         if(tableVersion==null||tableVersion==""){
        	 layer.alert("请填写文件版本号！");
        	 return false;
         }
         
         if(tableName==null||tableName==""){
             layer.alert("请填写表单名！");
             return false;
         }
         if(createUser==null||createUser==""){
             layer.alert("系统错误，请联系管理员！");
             return false;
         }
         $.ajax({
             cache: true,
             type: "POST",
             dataType: "json",
             url:"${pageContext.request.contextPath}/admin/twotable/save",
             data:$('#form-product-add').serialize(),// 你的formId
             async: true,
             success: function (result) {
            	 console.log(result);
                 //var jsonObj=eval('('+result+')');
                 if (result.success) {
                     layer.confirm('添加成功！', function(){
                         parent.location.replace(parent.location.href);
                         var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                         parent.layer.close(index); //再执行关闭  
                     });     
                 }
                 else {
                     layer.alert(result.message);
                 }
             }
         });
	});
});
</script>
</body>
</html>
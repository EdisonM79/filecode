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
	<form action="${pageContext.request.contextPath}/admin/product/save" method="post" class="form form-horizontal" id="form-product-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>项目代号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="project" name="project"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>模块代号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="module" name="module"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>职能代号：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="function" id="function" class="select">
					<option value="CZ">生产操作文件</option>
                    <option value="JZ">检验操作文件</option>
					<option value="GY">工艺文件</option>
                    <option value="SB">设备文件</option>
					<option value="JY">检验标准文件</option>
                    <option value="SJ">设计文件</option>
					<option value="BZ">标准作业指导书</option>
                    <option value="LC">标准作业卡</option>
					<option value="JX">采购技术协议</option>
                    <option value="ZB">质量保证书</option>
					<option value="AZ">安装手册</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类代号：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="type" id="type" class="select">
					<option value="DOC">公司内部产生的文档性文件</option>
                    <option value="ECR">电路设计变更需求表</option>
					<option value="MIG">外部输入文件</option>
                    <option value="SCR">软件变更需求表</option>
					<option value="SCH">电路原理图</option>
                    <option value="PCB">电路印制板设计图</option>
					<option value="GAB">光绘文件设计图</option>
                    <option value="DWG">结构设计图纸</option>
					<option value="BOM">元器件清单</option>
                    <option value="TMP">模板文档</option>
				</select>
				</span> </div>
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
		 var project = $("#project").val();
         var module = $("#module").val();
         
         if(project==null||project==""){
        	 layer.alert("请先上传图片！");
        	 return false;
         }
         
         if(module==null||module==""){
             layer.alert("请先填写产品名称！");
             return false;
         }
         
         $.ajax({
             cache: true,
             type: "POST",
             dataType: "json",
             url:"${pageContext.request.contextPath}/admin/filecode/save",
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
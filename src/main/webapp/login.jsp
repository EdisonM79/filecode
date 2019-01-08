<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/filecode/static/admin/static/h-ui/css/H-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="/filecode/static/admin/static/h-ui.admin/css/H-ui.login.css"/>
<link rel="stylesheet" type="text/css" href="/filecode/static/admin/static/h-ui.admin/css/style.css"/>
<link rel="stylesheet" type="text/css" href="/filecode/static/admin/lib/Hui-iconfont/1.0.8/iconfont.css"/>
<link rel="stylesheet" type="text/css" href="/filecode/static/css/qqhz.css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<title>成都精准时空文件编码管理系统</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<input type="hidden" id="basePath" value="${springMacroRequestContext.contextPath}" />
<input type="hidden" id="actionError" value='${actionError}' />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="/user/login.action" method="post" id="loginForm">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="username" name="userInfo.username" type="text" placeholder="账户" class="input-text size-L"/>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="userInfo.password" type="password" placeholder="密码" class="input-text size-L"/>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="code" name="code" class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;"/>
          <img id="imgVerify" src="/filecode/getVerify.action" onclick="getVerify(this)"/> <!-- <a id="kanbuq"  href="javascript:;">看不清，换一张</a> --> </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value=""/>
            	使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"/>
          <input name="" type="reset" class="btn btn-default radius size-L"  value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;"/>
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 成都精准时空  </div>
<script type="text/javascript" src="/filecode/static/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/filecode/static/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/filecode/static/js/qqhz.js"></script>
<script> 
function getVerify(obj){
	var path = $("#basePath").val();
	 obj.src = "/getVerify?time"+Math.random();
	};
</script>
</body>
</html>
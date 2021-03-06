<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <%@ include file="../jsp/common/resource.jsp" %>
    <%@ include file="../jsp/common/tags.jsp" %>
    <link href="${ctx}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css?v=${webVersion}" rel="stylesheet">
    <link href="${ctx}/static/css/style-responsive.css" rel="stylesheet">
    <title>shiro系统管理-登录</title>
    <script>
        <c:if test="${not empty param.kickout}">
        alert('您被踢出登录了。');
        </c:if>
    </script>
</head>
<body class="sign_body">
<div>
    <div class="sign_wrap">
        <form action="${ctx}/login" method="post" id="form" class="form-login">
            <h2 class="form-login-heading">https://gitee.com/896022/shiroAuth</h2>
            <div class="login-wrap">
                <div class="sign_input_wrap"><input type="text" name="username" class="form-control" id="username"
                                                    placeholder="用户名/手机号"/></div>
                <br>
                <div class="sign_input_wrap"><input type="password" name="password" class="form-control" id="password"
                                                    placeholder="输入密码"/></div>
                <label class="checkbox">
                    <span class="pull-right" style="color: red;">${error}</span>
                </label>
                <button class="btn btn-theme btn-block sign_a" href="index.html" type="submit"
                        onclick="document.getElementById('form').submit();"><i class="fa fa-lock"></i> 登录
                </button>

            </div>
        </form>
    </div>
    <div id="sign_footer">
        <span>https://gitee.com/896022/shiroAuth</span><span style="margin-left: 65px">Copyright 上海xxxxxxxx有限公司版权所有 All Rights Reserved. </span><span
            style="margin-left: 40px">备案信息  沪ICP备xxxxxxx号-1</span>
    </div>
</div>
</body>
</html>
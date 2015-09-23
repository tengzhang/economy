<%--
  User: zhangteng
  Date: 14-1-16 下午4:39
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>管理员登录页面</title>
    <meta name="description" content="User login page"/>
    <jsp:include page="common/head.jsp"/>
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h3>
                            <i class="icon-leaf green"></i>
                            <span class="red">自考学习服务中心平台</span>
                            <span class="white">后台管理</span>
                        </h3>
                        <h4 class="blue">教师登录入口</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <c:if test="${!empty msg}">
                                        <div class="alert alert-danger center">
                                                ${msg}
                                        </div>
                                    </c:if>

                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入您的信息
                                    </h4>

                                    <div class="space-6"></div>

                                    <form action="${website}/admin/login" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="username" type="text" class="form-control" placeholder="用户名"/>
                                                    <i class="icon-user"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="password" type="password" class="form-control"
                                                       placeholder="密码"/>
                                                    <i class="icon-lock"></i>
                                                </span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="icon-refresh"></i>
                                                    重置
                                                </button>

                                                <button type="submit"
                                                        class="width-65 pull-right btn btn-sm btn-primary">
                                                    登录
                                                    <i class="icon-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="http://economic.nenu.edu.cn/v3/" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            返回经济学院首页
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <!-- /widget-body -->
                        </div>
                        <!-- /login-box -->

                    </div>
                    <!-- /position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
</div>
<!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='${staticWebsite}js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>

</body>
</html>

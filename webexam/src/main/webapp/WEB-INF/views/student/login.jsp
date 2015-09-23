<%--
  User: zhangteng
  Date: 14-2-5 下午12:47
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>自考学习服务中心平台-考生登录</title>

    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="shortcut icon" href="${staticWebsite}avatars/favicon.ico">
    <!-- basic styles -->

    <link href="${staticWebsite}css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${staticWebsite}css/chosen.css" />
    <!-- ace styles -->

    <link rel="stylesheet" href="${staticWebsite}css/uncompressed/ace.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${staticWebsite}css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${staticWebsite}js/html5shiv.js"></script>
    <script src="${staticWebsite}js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">自考学习</span>
                            <span class="white">服务中心平台</span>
                        </h1>
                        <h4 class="blue">&copy; 东北师范大学经济学院</h4>
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
                                        考生登录
                                    </h4>

                                    <div class="space-6"></div>

                                    <form action="${website}/student/login" method="post">
                                        <fieldset>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-left">
                                                    <select name="majorCode" id="form-field-select-1" class="chosen-select">
                                                        <option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择专业</option>
                                                        <c:forEach var="major" items="${majorList}">
                                                            <option value="${major.code}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${major.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <i class="icon-book "></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-left">
                                                    <input name="examNo" type="text" class="form-control"
                                                           placeholder="考生准考证号"/>
                                                    <i class="icon-credit-card" style="line-height: 33px;"></i>
                                                </span>
                                            </label>

                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-left">
                                                    <input name="name" type="text" class="form-control" placeholder="考生姓名"/>
                                                    <i class="icon-user" style="line-height: 33px;"></i>
                                                </span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">

                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="http://economic.nenu.edu.cn/" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            返回学院首页
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
<script src="${staticWebsite}js/uncompressed/chosen.jquery.js"></script>
<!-- inline scripts related to this page -->

<script type="text/javascript">
    $(".chosen-select").chosen({
        cssClasses: ['col-sm-12', 'col-xs-12'],
        hasSearch: true
    });

    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#' + id).addClass('visible');
    }
</script>
</body>
</html>

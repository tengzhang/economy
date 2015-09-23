<%--
  User: zhangteng
  Date: 14-2-5 下午12:59
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自考学习服务中心平台-关于我们</title>

    <meta name="description" content="Common UI Features &amp; Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="shortcut icon" href="${staticWebsite}avatars/favicon.ico">
    <!-- basic styles -->

    <link href="${staticWebsite}css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="${staticWebsite}css/ace-fonts.css" />

    <!-- ace styles -->

    <link rel="stylesheet" href="${staticWebsite}css/uncompressed/ace.css" />

    <!-- Custom styles for this template -->
    <link href="${staticWebsite}css/sticky-footer.css" rel="stylesheet">

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${staticWebsite}css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${staticWebsite}js/html5shiv.js"></script>
    <script src="${staticWebsite}js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div id="wrap">

    <div class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="navbar-container" id="navbar-container">
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <i class="icon-leaf"></i>
                            自考学习服务中心平台
                        </small>
                    </a><!-- /.brand -->
                </div><!-- /.navbar-header -->

                <div class="navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">
                        <li class="light-blue">
                            <a href="studentIndex.html">
                                <i class="icon-home home-icon"></i>
                                考生首页
                            </a>
                        </li>

                        <li>
                            <a href="studentInfo.html">
                                <i class="icon-user user-icon"></i>
                                考生信息
                            </a>
                        </li>

                        <li>
                            <a href="studentLesson.html">
                                <i class="icon-desktop"></i>
                                网络课堂
                            </a>
                        </li>

                        <li>
                            <a href="studentTestChose.html">
                                <i class="icon-file"></i>
                                网络测试
                            </a>
                        </li>
                        <li>
                            <a href="${website}/student/logout">
                                <i class="icon-signout"></i>
                                退出平台
                            </a>
                        </li>
                    </ul><!-- /.ace-nav -->
                </div><!-- /.navbar-header -->
            </div><!-- /.container -->
        </div>
    </div>

    <div class="main-container" id="main-container">

        <div class="main-container-inner">
            <a class="menu-toggler" id="menu-toggler" href="#">
                <span class="menu-text"></span>
            </a>


            <div class="main-content">

                <div class="page-content">
                    <div class="container">
                        <h3 class="header smaller lighter green">关于我们</h3>
                        <div class="row">
                            <div class="col-sm-12">
                                <p>xxx</p>
                            </div>
                        </div>

                        <div class="space"></div>

                        <h3 class="header smaller lighter green">联系我们</h3>
                        <div class="row">
                            <div class="col-sm-12">
                                <p>xxx</p>
                            </div>
                        </div>
                    </div>



                </div><!-- /.page-content -->
            </div><!-- /.main-content -->

        </div><!-- /.main-container-inner -->

        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="icon-double-angle-up icon-only bigger-110"></i>
        </a>
    </div><!-- /.main-container -->

</div>

<div class="footer" id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    版权所有：东北师范大学经济学院  |  地址：吉林 长春 净月大街2555号
                </p>
                <p>邮编：130117  |  管理员邮箱：kajak2013@163.com </p>
            </div>
        </div><!--/row-->
    </div><!--/container-->
</div>
</body>
</html>

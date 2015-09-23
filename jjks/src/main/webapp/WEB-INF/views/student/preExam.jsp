<%--
  User: zhangteng
  Date: 14-2-5 下午12:55
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自学考试实践考核平台-考生测试前注意事项</title>

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
                    <a href="${website}/student" class="navbar-brand">
                        <small>
                            <i class="icon-leaf"></i>
                            自学考试实践考核平台
                        </small>
                    </a><!-- /.brand -->
                </div><!-- /.navbar-header -->

                <div class="navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">
                        <li>
                            <a href="${website}/student">
                                <i class="icon-home home-icon"></i>
                                首页
                            </a>
                        </li>

                        <li class="light-blue">
                            <a href="${website}/student/exam/choose">
                                <i class="icon-file"></i>
                                实践考试
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

            <div class="main-content">

                <div class="page-content">
                    <div class="container">
                        <div class="page-header">
                            <h1>
                                实践考试
                                <small>
                                    <i class="icon-double-angle-right"></i>
                                    测试前注意事项
                                </small>
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row">
                            <div class="col-md-offset-4">
                                <h2>请务必认真阅读以下注意事项</h2>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="widget-main padding-4">
                                    <div class="tab-content padding-8 overflow-visible">
                                        <div class="tab-pane active" id="task-tab">
                                            <h4 class="header smaller lighter blue">
                                                <i class="icon-list"></i>
                                                考试规则:
                                            </h4>

                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <ul class="list-unstyled spaced">
                                                        <li>
                                                            <i class="icon-bell bigger-110 purple"></i>
                                                            题数为50题，题型包括单选、多选、判断。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 red"></i>
                                                            每次进入考试，题目随机抽取。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 green"></i>
                                                            每题2分，答对得分，答错不得分（多选题少选、多选、错选都不得分），满分100分。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 red"></i>
                                                            答题时间为30分钟，从“开始答题后”，系统计时，可以提前交卷，也可以等到30分钟后系统自动提交试卷。
                                                        </li>
                                                    </ul>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="widget-main padding-4">
                                    <div class="tab-content padding-8 overflow-visible">
                                        <div class="tab-pane active" id="task-tab">
                                            <h4 class="header smaller lighter blue">
                                                <i class="icon-list"></i>
                                                注意事项
                                            </h4>

                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <ul class="list-unstyled spaced">
                                                        <li>
                                                            <i class="icon-bell bigger-110 purple"></i>
                                                            点击“开始答题”按钮，即开始计时，30分钟后自动提交试卷。
                                                        </li>

                                                        <li>
                                                            <i class="icon-bell bigger-110 green"></i>
                                                            开始答题后，<span class="red bigger-130">不要</span>刷新页面，刷新页面视为重新开始答题，之前回答过的题目将清空。
                                                        </li>

                                                        <li>
                                                            <i class="icon-bell bigger-110 red"></i>
                                                            尽量保证自己的电脑不要卡，一些与考试无关的应用程序先暂时关闭。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 blue"></i>
                                                            尽量保证答题时的网速正常，这样既可以节约你的时间，也能保证你的答题质量。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 red"></i>
                                                            为了方便答题，请将电脑分辨率调至<span class="red bigger-130">1366*768</span>以上。
                                                        </li>
                                                        <li>
                                                            <i class="icon-bell bigger-110 blue"></i>
                                                            在考试过程中，如果遇到问题，请尽快与老师取得联系。
                                                        </li>
                                                    </ul>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <p class="pull-right">
                                    <a href="${website}/student/exam/${majorCode}/${subjectCode}" class="btn btn-primary">
                                        <i class="icon-hand-right"></i>
                                        开始答题
                                    </a>
                                </p>
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
            <p>
                版权所有：东北师范大学经济学院  |  地址：吉林 长春 净月大街2555号
            </p>
            <p>邮编：130117  |  管理员邮箱：bianming66@163.com </p>
        </div><!--/row-->
    </div><!--/container-->
</div>
</body>
</html>

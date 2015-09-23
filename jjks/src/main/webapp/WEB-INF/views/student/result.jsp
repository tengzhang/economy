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
    <title>自学考试实践考核平台-考生测试完毕</title>

    <meta name="description" content="overview &amp; stats" />
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

    <link rel="stylesheet" href="${staticWebsite}css/ace-test.css" />

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

<body class="breadcrumbs-fixed">
<div class="navbar navbar-default navbar-fixed-top" id="navbar">
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <div class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    自学考试实践考核平台-测试完毕
                </small>
            </div>
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li>
                    <a href="${website}/student/index">
                        <i class="icon-home home-icon"></i>
                        首页
                    </a>
                </li>

                <li>
                    <a href="${website}/student/logout" class="exitExam">
                        <i class="glyphicon glyphicon-log-out"></i>
                        退出平台
                    </a>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <div class="main-container-inner">

        <div class="sidebar sidebar-fixed" id="sidebar">
            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-home"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-user"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-desktop"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-file"></i>
                    </button>
                </div>

            </div><!-- #sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li>
                    <a>
                        <span class="menu-text"> 专业： </span>
                        <span class="menu-text"> ${webExam.majorName} </span>
                    </a>
                    <a>
                        <span class="menu-text"> 科目： </span>
                        <span class="menu-text" id="subjectName"> ${webExam.subjectName} </span>
                    </a>
                    <a>
                        <span class="menu-text"> 测试时长： </span>
                        <span class="menu-text"> ${webExam.examTime}分钟 </span>
                    </a>
                    <a>
                        <span class="menu-text"> 准考证号： </span>
                        <span class="menu-text"> ${student.examNo} </span>
                    </a>
                    <a style="height: 75px;">
                        <span class="menu-text"> 身份证号： </span>
                        <span class="menu-text"> ${student.idNo} </span>
                    </a>
                    <a>
                        <span class="menu-text"> 考生姓名： </span>
                        <span class="menu-text"> ${student.name} </span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->
        </div>

        <div class="main-content">
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        试卷已经提交！
                    </h1>
                </div><!-- /.page-header -->

                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->

                            <h4>考生成绩请在5月中旬到吉林省高等教育自学考试信息网查询。
                            </h4>

                            <div class="space"></div>

                            <div class="widget-box">
                                <div class="widget-header widget-header-flat widget-header-small">
                                    <h5>
                                        <i class="icon-comment"></i>
                                        注意
                                    </h5>
                                </div>

                                <div class="widget-body">
                                    <div class="widget-main">
                                        <div class="container">
                                            <%--<p>你总共有2科测试，目前已考完1科。</p>--%>
                                            <div class="space-8"></div>
                                            <p>如果你还想继续剩余科目的考试，请点击
                                                <a href="${website}/student/exam/choose" class="btn btn-primary">
                                                    <i class="icon-arrow-right"></i>
                                                    测试下一科目
                                                </a>
                                                。
                                            </p>
                                            <p>如果你所有科目测试完毕或者以后再进入该平台继续测试，请点击
                                                <a href="${website}/student" class="btn btn-default">
                                                    <i class="icon-arrow-left"></i>
                                                    返回到考生首页
                                                </a>
                                                或直接退出本平台。
                                            </p>
                                        </div>
                                    </div><!-- /widget-main -->
                                </div><!-- /widget-body -->
                            </div>
                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div>

            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->

</div><!-- /.main-container -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    $(function($){
        if($('#subjectName').width()>104){
            $('#subjectName').parent().height(75);
        }
    });
</script>
</body>
</html>

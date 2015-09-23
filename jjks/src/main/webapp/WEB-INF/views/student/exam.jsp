<%--
  User: zhangteng
  Date: 14-2-5 下午12:57
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>自学考试实践考核平台-考生正式测试</title>

    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="shortcut icon" href="favicon1.ico">
    <!-- basic styles -->

    <link href="${staticWebsite}css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="${staticWebsite}css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->
    <link href="${staticWebsite}css/jquery-ui-1.10.3.full.min.css" rel="stylesheet">

    <!-- fonts -->

    <!-- ace styles -->

    <link rel="stylesheet" href="${staticWebsite}css/ace-test.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${staticWebsite}css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->
    <style type="text/css">
        ol > li {
            padding: 5px;
        }

        ol > li:hover {
            background-color: #eee;
        }
    </style>
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
                    自学考试实践考核平台-正式考试
                </small>
            </div>
        </div>
        <!-- /.navbar-header -->

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
            </ul>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->
</div>

<div class="main-container" id="main-container">
<div class="main-container-inner">
<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text"></span>
</a>

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

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <!-- #sidebar-shortcuts -->

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

        <li class="center">
            <div class="space-2"></div>
            <button type="button" class="btn btn-block btn-primary submitExam">
                <i class="icon-ok"></i>
                提交试卷
            </button>
        </li>
    </ul>
    <!-- /.nav-list -->
</div>

<div class="main-content">

    <div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
        <div class="row" style="padding-left: 12px;">
            <div class="col-xs-12 col-lg-6">
                <label class="col-xs-12 col-lg-3 align-center">做题进度：</label>

                <div class="col-xs-12 col-lg-8">
                    <div class="progress progress-small progress-striped active" data-percent="0%"
                         style="margin-bottom: 0px; margin-top: 15px;">
                        <div id="progress-percent" class="progress-bar progress-bar-primary" style="width: 0%;"></div>
                    </div>
                </div>
                <label id="progress-number" class="col-xs-12 col-lg-1 align-center">0/50</label>
            </div>

            <div class="col-xs-12 col-lg-6">
                <label class="col-xs-12 col-lg-3 align-center">时间进度：</label>
                <label id="countdownTime" class="col-xs-12 col-lg-9 orange">
                    ${webExam.examTime}:00
                </label>
            </div>
        </div>
    </div>

    <div class="page-content">
        <div class="page-header">
            <h1>
                ${webExam.subjectName}
            </h1>
        </div>
        <!-- /.page-header -->

        <div style="padding-left: 5%">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form action="${website}/student/result/${webExam.majorCode}/${webExam.subjectCode}" method="post">
                        <h5>
                            总共50道题，分别为单选题、多选题和判断题。每题2分，答对得分，答错不得分（多选题多选、少选、错选都不得分），满分100分。
                        </h5>
                        <ol>

                            <!-- 循环开始 -->
                            <c:forEach var="problem" items="${problemList}" varStatus="status">
                                <li>
                                    <input name="ids[${status.count-1}]" value="${problem.id}" type="hidden"/>
                                    <input name="_answers[${status.count-1}]" type="hidden"/>

                                    <p>
                                    <c:if test="${problem.type == 1}">
                                    	(单选)
                                    </c:if>
                                    <c:if test="${problem.type == 2}">
                                    	(多选)
                                    </c:if>
                                    <c:if test="${problem.type == 3}">
                                    	(判断)
                                    </c:if>
                                    	${problem.title}
                                    </p>

                                    <c:if test="${problem.type != 2}">
                                        <c:set var="type" value="radio"/>
                                    </c:if>
                                    <c:if test="${problem.type == 2}">
                                        <c:set var="type" value="checkbox"/>
                                    </c:if>

                                    <c:if test="${!empty problem.chooseA}">
                                        <div class="${type}">
                                            <label>
                                                <input name="answers[${status.count-1}]" value="A" pNo="${status.count}" pType="${problem.type}"
                                                       type="${type}" class="ace">
                                                    <span class="lbl">
                                                        <label>A.</label>
                                                        <label>${problem.chooseA}</label>
                                                    </span>
                                            </label>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty problem.chooseB}">
                                        <div class="${type}">
                                            <label>
                                                <input name="answers[${status.count-1}]" value="B" pNo="${status.count}" pType="${problem.type}"
                                                       type="${type}" class="ace">
                    <span class="lbl">
                        <label>B.</label>
                        <label>${problem.chooseB}</label>
                    </span>
                                            </label>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty problem.chooseC}">
                                        <div class="${type}">
                                            <label>
                                                <input name="answers[${status.count-1}]" value="C" pNo="${status.count}" pType="${problem.type}"
                                                       type="${type}" class="ace">
                    <span class="lbl">
                        <label>C.</label>
                        <label>${problem.chooseC}</label>
                    </span>
                                            </label>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty problem.chooseD}">
                                        <div class="${type}">
                                            <label>
                                                <input name="answers[${status.count-1}]" value="D" pNo="${status.count}" pType="${problem.type}"
                                                       type="${type}" class="ace">
                    <span class="lbl">
                        <label>D.</label>
                        <label>${problem.chooseD}</label>
                    </span>
                                            </label>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty problem.chooseE}">
                                        <div class="${type}">
                                            <label>
                                                <input name="answers[${status.count-1}]" value="E" pNo="${status.count}" pType="${problem.type}"
                                                       type="${type}" class="ace">
                    <span class="lbl">
                        <label>E.</label>
                        <label>${problem.chooseE}</label>
                    </span>
                                            </label>
                                        </div>
                                    </c:if>
                                </li>
                            </c:forEach>
                            <!-- 循环结束 -->
                        </ol>

                        <button type="button" class="btn btn-primary pull-right submitExam">
                            <i class="icon-ok"></i>
                            提交试卷
                        </button>

                        <button id="reset-btn" type="reset" class="btn btn-warning pull-right">
                            <i class="icon-undo"></i>
                            重新填写
                        </button>
                    </form>

                    <!-- PAGE CONTENT ENDS -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>

    </div>
    <!-- /.page-content -->
</div>
<!-- /.main-content -->
</div>
<!-- /.main-container-inner -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
</div>
<!-- /.main-container -->

<div class="hide" id="dialog-message">
    <div class="space-4"></div>
    <p id="tip">
        确认提交试卷吗？
    </p>
</div>

<div class="hide" id="dialog-message-exit">
    <div class="space-4"></div>
    <p id="tipExit">
        确认退出考试平台吗？
    </p>
</div>
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
<script type="text/javascript" src="${staticWebsite}js/bootstrap.min.js"></script>
<script src="${staticWebsite}js/jquery-ui-1.10.3.full.min.js"></script>
<script type="text/javascript" src="${staticWebsite}js/student.exam.js"></script>
<script type="text/javascript">
    $(function ($) {
        startExam('${webExam.examTime}');
    });
</script>
<script type="text/javascript">
    $(function ($) {
        if ($('#subjectName').width() > 104) {
            $('#subjectName').parent().height(75);
        }
    });
</script>
</body>
</html>

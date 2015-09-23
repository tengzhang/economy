<%--
  User: zhangteng
  Date: 14-2-5 下午12:53
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自学考试实践考核平台-考生选择科目</title>

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
                <a href="${website}/student/index" class="navbar-brand">
                    <small>
                        <i class="icon-leaf"></i>
                        自学考试实践考核平台
                    </small>
                </a><!-- /.brand -->
            </div><!-- /.navbar-header -->

            <div class="navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li>
                        <a href="${website}/student/index">
                            <i class="icon-home home-icon"></i>
                            首页
                        </a>
                    </li>
                    <li class="light-blue">
                        <a href="${website}/student/exam/choose">
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

        <div class="main-content">

            <div class="page-content">
                <div class="container">
                    <div class="page-header">
                        <h1>
                            实践考试
                            <small>
                                <i class="icon-double-angle-right"></i>
                                考生选择课程
                            </small>
                        </h1>
                    </div><!-- /.page-header -->

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="widget-main no-padding">
                                <div class="dialogs">
                                    <div class="itemdiv dialogdiv">
                                        <div class="user">
                                            <img src="${staticWebsite}avatars/avatar1.png" alt="Alexa's Avatar">
                                        </div>

                                        <div class="body">
                                            <div class="name">
                                                <a href="#">你好，${student.name}</a>
                                            </div>
                                            <div class="text">
                                                欢迎进入自学考试实践考核平台。
                                            </div>
                                        </div>
                                    </div>

                                    <div class="itemdiv dialogdiv">
                                        <div class="user">
                                            <img src="${staticWebsite}avatars/avatar.png" alt="John's Avatar">
                                        </div>

                                        <div class="body">
                                            <div class="name">
                                                <a href="#">注意</a>
                                            </div>
                                            <div class="text">
                                                请认真核对右边的信息，确认后方可进入测试。
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8" style="border-left:1px dotted #ccc; padding-left:25px;">
                            <div class="widget-box">
                                <div class="widget-header widget-header-flat widget-header">
                                    <h5>
                                        <i class="icon-user"></i>
                                        考生个人信息
                                    </h5>
                                </div>

                                <div class="widget-body">
                                    <div class="widget-main">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-3">
                                                <label>考生姓名：</label>
                                                ${student.name}
                                            </div>
                                            <div class="col-xs-12 col-sm-4">
                                                <label>准考证号：</label>
                                                ${student.examNo}
                                            </div>
                                            <div class="col-xs-12 col-sm-5">
                                                <label>身份证号：</label>
                                                ${student.idNo}
                                            </div>
                                        </div>
                                    </div><!-- /widget-main -->
                                </div><!-- /widget-body -->
                            </div>

                            <hr>

                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="sample-table-1">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>专业名称</th>
                                        <th>课程名称</th>
                                        <th class="hidden-480">测试时长</th>
                                        <th>测试时间</th>
                                        <th></th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:if test="${empty examList}">
                                        <tr>
                                            <td colspan="6">
                                                <div class="alert alert-danger center">
                                                    暂无考试！
                                                </div>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <c:forEach var="exam" items="${examList}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${exam.majorName}</td>
                                            <td>${exam.subjectName}</td>
                                            <td class="hidden-480">${exam.examTime}分钟</td>
                                            <td>
                                                <fmt:formatDate value="${exam.startTime}" pattern="yyyy-MM-dd HH:mm" /> ~<br/>
                                                <fmt:formatDate value="${exam.endTime}" pattern="yyyy-MM-dd HH:mm" />
                                            </td>
                                            <td>
                                                <div class="btn-group">
                                                    <c:if test="${isExamed[status.count-1]==0}">
                                                        <a href="${website}/student/exam/pre/${exam.majorCode}/${exam.subjectCode}" class="btn btn-sm btn-primary">
                                                            <i class="icon-ok bigger-120"></i> 进入测试
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${isExamed[status.count-1] == 1}">
                                                        考试完成
                                                    </c:if>
                                                </div>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>



            </div><!-- /.page-content -->
        </div><!-- /.main-content -->

    </div><!-- /.main-container-inner -->

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

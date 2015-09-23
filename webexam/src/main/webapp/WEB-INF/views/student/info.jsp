<%--
  User: zhangteng
  Date: 14-2-5 下午12:50
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自考学习服务中心平台-考生个人信息</title>

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

    <script src="${staticWebsite}js/ace-extra.min.js"></script>

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
                            自考学习服务中心平台
                        </small>
                    </a><!-- /.brand -->
                </div><!-- /.navbar-header -->

                <div class="navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">
                        <li>
                            <a href="${website}/student/index">
                                <i class="icon-home home-icon"></i>
                                考生首页
                            </a>
                        </li>

                        <li class="light-blue">
                            <a href="${website}/student/info">
                                <i class="icon-user user-icon"></i>
                                考生信息
                            </a>
                        </li>

                        <li>
                            <a href="${lessonUrl}">
                                <i class="icon-desktop"></i>
                                网络课堂
                            </a>
                        </li>

                        <li>
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
                                考生信息
                                <small>
                                    <i class="icon-double-angle-right"></i>
                                    考生个人信息及课程信息
                                </small>
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row">
                            <div class="col-sm-12">
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
                                                    ${studentDto.student.name}
                                                </div>
                                                <div class="col-xs-12 col-sm-4">
                                                    <label>准考证号：</label>
                                                    ${studentDto.student.examNo}
                                                </div>
                                                <div class="col-xs-12 col-sm-5">
                                                    <label>身份证号：</label>
                                                    ${studentDto.student.idNo}
                                                </div>
                                            </div>
                                            <div class="space-4"></div>
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-3">
                                                    <label>专业：</label>
                                                    ${studentDto.student.majorName}
                                                </div>
                                                <div class="col-xs-12 col-sm-4">
                                                    <label>学校/机构：</label>
                                                    ${studentDto.student.schoolName}
                                                </div>
                                            </div>
                                        </div><!-- /widget-main -->
                                    </div><!-- /widget-body -->
                                </div>

                                <hr>
                                <div class="widget-header widget-header-flat widget-header">
                                    <h5>
                                        <i class="icon-tasks"></i>
                                        课程信息
                                    </h5>
                                </div>
                                <!-- <h5><i class="icon-tasks"></i> 课程信息</h5> -->
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="sample-table-1">
                                        <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th class="hidden-480">课程代码</th>
                                            <th>课程名称</th>
                                            <th>是否缴费</th>
                                            <th class="hidden-480">缴费时间</th>
                                            <th>成绩</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <c:forEach var="subject" items="${studentDto.subjectList}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td class="hidden-480">${subject.subjectCode}</td>
                                            <td>${subject.subjectName}</td>
                                            <td>
                                                <c:if test="${subject.isPay == 1}">
                                                    是
                                                </c:if>
                                                <c:if test="${subject.isPay == 0}">
                                                    否
                                                </c:if>
                                            </td>
                                            <td class="hidden-480">${subject.payTime}</td>
                                            <td>
                                                <c:if test="${subject.isShowScore == 1}">
                                                    ${subject.score}
                                                </c:if>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <p><strong><span class="red bigger-130">备注：</span></strong>以上通过经济学院自考学习服务中心取得的综合评价成绩，根据考生的缴费时间，为考生保留三年，如成绩超过三年或三年内想更新成绩，考生可重新进行缴费并通过网络学习和中心考试取得新的综合评价成绩。</p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12">
                                <a href="${website}/student/" class="btn btn-primary pull-right"><i class="icon-arrow-left"></i> 返回考生首页</a>
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

<%--
  User: zhangteng
  Date: 14-2-17 下午8:44
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自学考试实践考核平台-404</title>

    <meta name="description" content="Common UI Features &amp; Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="shortcut icon" href="favicon1.ico">
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
                        <li>
                            <a href="${website}/student/exam/choose">
                                <i class="icon-file"></i>
                                实践考试
                            </a>
                        </li>

                        <c:if test="${!empty stuSessionUid}">
                            <li>
                                <a href="${website}/student/logout">
                                    <i class="icon-signout"></i>
                                    退出平台
                                </a>
                            </li>
                        </c:if>
                    </ul><!-- /.ace-nav -->
                </div><!-- /.navbar-header -->
            </div><!-- /.container -->
        </div>
    </div>

    <div class="main-container" id="main-container">

        <div class="main-container-inner">

            <div class="main-content">

                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->

                            <div class="error-container">
                                <div class="well">
                                    <h1 class="grey lighter smaller">
												<span class="blue bigger-125">
													<i class="icon-sitemap"></i>
													404
												</span>
                                        页面找不到
                                    </h1>

                                    <hr>
                                    <h3 class="lighter smaller">我们很努力的找了，该页面没有找到</h3>

                                    <div>

                                        <div class="space"></div>
                                        <h4 class="smaller">您可以尝试以下几种方法来解决：</h4>

                                        <ul class="list-unstyled spaced inline bigger-110 margin-15">
                                            <li>
                                                <i class="icon-hand-right blue"></i>
                                                检查URL是否正确
                                            </li>
                                            <li>
                                                <i class="icon-hand-right blue"></i>
                                                联系管理员
                                            </li>
                                        </ul>
                                    </div>

                                    <hr>
                                    <div class="space"></div>

                                    <div class="center">
                                        <a class="btn btn-grey" href="${website}/student">
                                            <i class="icon-arrow-left"></i>
                                            返回首页
                                        </a>
                                    </div>
                                </div>
                            </div><!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
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
                <p>邮编：130117  |  管理员邮箱：bianming66@163.com </p>
            </div>
        </div><!--/row-->
    </div><!--/container-->
</div>
<!-- basic scripts -->

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

<script src="${staticWebsite}js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${staticWebsite}js/excanvas.min.js"></script>
<![endif]-->

<!-- ace scripts -->

<!-- inline scripts related to this page -->
</body>
</html>

<%--
  User: zhangteng
  Date: 14-2-5 下午12:45
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>自学考试实践考核平台-考生首页</title>

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
    <style type="text/css">
        .div-overlay {
            position: absolute;
            z-index: 14;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            background-color: #ffffff;
            text-align: center;
            filter: alpha(opacity=80);
            opacity: 0.8;
            -moz-opacity: 0.8;
        }
    </style>
    <!-- ace settings handler -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${staticWebsite}js/html5shiv.js"></script>
    <script src="${staticWebsite}js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- 判断浏览器版本是否低于IE9 -->
<!--[if lt IE 9]>
<div class="main-container">
    <div class="div-overlay">
        <div class="container">
            <div class="space"></div>
            <div class="space"></div>
            <div class="space"></div>
            <h1>
                <i class='icon-exclamation-sign'></i>&nbsp;你好！
            </h1>

            <div class="row">
                <h1 class="col-sm-12">你现在的浏览器<span class="red bigger-150">OUT</span>啦~~</h1>
                <h1 class="col-sm-12">为了更好的体验和进行测试，请<span class="red">升级</span>浏览器或者<span class="red">更换</span>下载下列浏览器</h1>
            </div>

            <div class="space"></div>
            <div class="space"></div>

            <hr/>

            <div class="row">
                <div class="col-md-offset-1 col-sm-2">
                    <a href="http://www.google.cn/intl/zh-CN/chrome/browser/" title="谷歌浏览器">
                        <img src="${staticWebsite}img/chrome.gif" alt="" style="width:100px;height:100px;">
                    </a>
                </div>

                <div class="col-sm-2">
                    <a href="http://www.firefox.com.cn/download/" title="火狐浏览器">
                        <img src="${staticWebsite}img/firefox.gif" alt="" style="width:100px;height:100px;">
                    </a>
                </div>

                <div class="col-sm-2">
                    <a href="http://support.apple.com/kb/DL1531?viewlocale=zh_CN" title="苹果safari浏览器">
                        <img src="${staticWebsite}img/safari.gif" alt="" style="width:100px;height:100px;">
                    </a>
                </div>

                <div class="col-sm-2">
                    <a href="http://www.opera.com/zh-cn/computer" title="欧朋浏览器">
                        <img src="${staticWebsite}img/opera.gif" alt="" style="width:100px;height:100px;">
                    </a>
                </div>
                <div class="col-sm-2">
                    <a href="http://www.maxthon.cn/" title="遨游浏览器">
                        <img src="${staticWebsite}img/maxthon.gif" alt="" style="width:100px;height:100px;">
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<![endif]-->
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
                        <li class="light-blue">
                            <a href="${website}/student/index">
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
                        <c:if test="${empty stuSessionUid}">
                            <li>
                                <a href="${website}/student/login">
                                    <i class="icon-signin"></i>
                                    学生登陆
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
                    <div class="container">
                        <div class="page-header">
                            <h1>
                                首页
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row">
                            <div class="col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-header widget-header-flat widget-header">
                                        <h5>
                                            <i class="icon-file"></i>
                                            实践考试
                                        </h5>
                                    </div>

                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="space-2"></div>
                                            进入参加考试。
                                            <div class="space-4"></div>
                                            <div class="hr hr8 hr-double"></div>
                                            <div class="space-8"></div>
                                            <div class="clearfix">
                                                <a href="${website}/student/exam/choose" title="" class="btn btn-primary btn-sm pull-right"><i class="icon-hand-right"></i> 点击进入</a>
                                            </div>
                                        </div><!-- /widget-main -->
                                    </div><!-- /widget-body -->
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
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<!--[if lt IE 9]>
<script type="text/javascript">
    $('#navbar').removeClass('navbar');
</script>
<![endif]-->
</html>

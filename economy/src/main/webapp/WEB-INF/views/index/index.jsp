<%--
  User: zhangteng
  Date: 2014/5/1 21:16
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <title>经济学院其他办学</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS Global Compulsory-->
    <link rel="stylesheet" href="${staticWebsite}index/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${staticWebsite}index/css/style.css">
    <link rel="stylesheet" href="${staticWebsite}index/css/headers/header2.css">
    <link rel="stylesheet" href="${staticWebsite}index/plugins/bootstrap/css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="${staticWebsite}index/css/responsive.css">
    <link rel="shortcut icon" href="${staticWebsite}index/img/faicon1.ico">
    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="${staticWebsite}index/plugins/font-awesome/css/font-awesome.css">

    <!-- CSS Page Style -->

    <!-- CSS Theme -->
    <link rel="stylesheet" href="${staticWebsite}index/css/themes/blue.css" id="style_color">
    <link rel="stylesheet" href="${staticWebsite}index/css/themes/headers/header2-blue.css" id="style_color-header-2">

    <!-- page css -->
    <link rel="stylesheet" href="${staticWebsite}index/css/pages/index.css">
    <style type="text/css">
    </style>
</head>

<body>

<!--=== Top ===-->
<div class="top-v1">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <ul class="list-unstyled top-v1-contacts">
                    <li>
                        <a href="mailto:info@htmlstream.com"><i class="icon-envelope"></i>&nbsp;院长信箱：liulz626@nenu.edu.cn</a>
                    </li>
                    <li>
                        <a href="http://economic.nenu.edu.cn/"><i class="icon-dashboard"></i>&nbsp;学院主页</a>
                    </li>
                </ul>
            </div><!--/top-v1-contacts-->

            <div class="col-md-6">
                <ul class="list-unstyled top-v1-data">
                    <li><a href="#"><i class="icon-home"></i></a></li>
                    <li><a href="#"><i class="icon-globe"></i></a></li>
                    <li><a href="#"><i class="icon-user"></i></a></li>
                </ul>
            </div><!--/top-v1-data-->
        </div>
    </div>
</div><!--/top-v1-->
<!--=== End Top ===-->

<!--=== Header ===-->
<div class="header margin-bottom-10">
    <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${website}">
                    <img id="logo-header" src="${staticWebsite}index/img/logo3.png" alt="Logo">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown active">
                        <a href="${website}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">
                            <i class="icon-home"></i>&nbsp;首页
                        </a>
                    </li>
                    <%-- 循环开始 --%>
                    <c:forEach var="indexModule" begin="0" end="5" items="${indexModuleList}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">
                                ${indexModule.name}
                                <i class="icon-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${website}/index/majors/${indexModule.id}" target="_blank">专业设置</a></li>
                                <li><a href="${website}/index/brochures/${indexModule.id}" target="_blank">招生简章</a></li>
                                <li><a href="${website}/index/subjects/${indexModule.id}" target="_blank">课程设置</a></li>
                                <li><a href="${website}/index/cooperations/${indexModule.id}" target="_blank">助学合作单位</a></li>
                                <li><a href="${website}/index/certificates/${indexModule.id}" target="_blank">证书样例</a></li>
                                <li><a href="${website}/index/questions/${indexModule.id}" target="_blank">常见问题解答</a></li>
                                <li><a href="${website}/index/contacts/${indexModule.id}" target="_blank">联系我们</a></li>
                                <li><a href="${website}/index/commonfiles/${indexModule.id}" target="_blank">常用文件下载</a></li>
                            </ul>
                        </li>
                    </c:forEach>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">
                            其他
                            <i class="icon-angle-down"></i>
                        </a>
                        <c:if test="${fn:length(indexModuleList) > 6}">
                            <ul class="dropdown-menu">
                            <c:forEach var="indexModule" begin="6" items="${indexModuleList}">
                                <li><a href="${website}/index/majors/${indexModule.id}" target="_blank">${indexModule.name}</a></li>
                            </c:forEach>
                            </ul>
                        </c:if>
                    </li>
                    <%-- 循环结束 --%>
                    <li class="hidden-sm"><a class="search"><i class="icon-search search-btn"></i></a></li>
                </ul>
                <div class="search-open">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="查询...">
                        <span class="input-group-btn">
                            <button class="btn-u" type="button">搜索</button>
                        </span>
                    </div><!-- /input-group -->
                </div>
            </div><!-- /navbar-collapse -->
        </div>
    </div>
</div><!--/header-->
<!--=== End Header ===-->

<!--=== Content Part ===-->
<div class="container">
<div class="row magazine-page">
    <!-- Begin Content -->
    <div class="col-md-5">
        <!--Magazine Slider-->
        <div id="myCarousel" class="carousel slide carousel-v1 margin-bottom-10">
            <div class="carousel-inner">
                <%-- 循环开始 --%>
                <c:forEach var="indexImg" items="${indexImgList}" varStatus="status">
                    <div class="item ${status.count==1 ? 'active' : ''}">
                        <img src="${staticWebsite}${indexImg.imgPath}" alt="">
                        <div class="carousel-caption">
                            <p>${indexImg.description}</p>
                        </div>
                    </div>
                </c:forEach>
                <%-- 循环结束 --%>
            </div>

            <div class="carousel-arrow">
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <i class="icon-angle-left"></i>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <i class="icon-angle-right"></i>
                </a>
            </div>
        </div>
        <!--End Magazine Slider-->

        <!-- <hr> -->
    </div>
    <!-- End Content -->

    <!-- Begin Sidebar -->
    <div class="col-md-7">
        <!-- Magazine Posts -->
        <div class="row">
            <div class="info col-md-12 col-sm-12">
                <div class="tag-box tag-box-v3" style="">
                    <div class="headline clearfix">
                        <h2><i class="icon-bell-alt color-blue"></i>&nbsp;通知公告</h2>
                        <a class="pull-right" href="${website}/index/notices">更多...</a>
                    </div>
                    <ul class="list-unstyled">
                        <%-- 循环开始 --%>
                        <c:forEach var="notice" items="${noticeList}" varStatus="status">
                            <li class="clearfix headline" style="${status.count==1 ? 'margin-top: 15px;' : ''}">
                                <a href="${website}/index/notice/${notice.id}" target="_blank">[${notice.indexModuleName}]&nbsp;${notice.title}</a>
                                <span class="time pull-right">[<fmt:formatDate value="${notice.publicTime}" pattern="yyyy-MM-dd" />]</span>
                            </li>
                        </c:forEach>
                        <c:forEach begin="1" end="${7 - fn:length(noticeList)}">
                            <li class="clearfix headline"><a href=""></a><span class="time pull-right"></span></li>
                        </c:forEach>
                        <%-- 循环结束 --%>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End Magazine Posts -->
    </div>
    <!-- End Sidebar -->
</div>

<hr style="margin-top: 0px;margin-bottom: 10px;">

<div class="row servive-block">
    <div class="col-md-6">
        <a href="${jjksUrl}">
            <div class="servive-block-in servive-block-colored servive-block-orange">
                <h4><i class="icon-desktop"></i>自考实践课考试平台</h4>
            </div>
        </a>
    </div>
    <div class="col-md-6">
        <a href="${zxksUrl}">
            <div class="servive-block-in servive-block-colored servive-block-sea">
                <h4> <i class="icon-pencil "></i>自考学习服务中心平台</h4>
            </div>
        </a>
    </div>
</div>

<%-- 循环开始 --%>
<c:forEach items="${indexModuleList}" begin="0" step="2" varStatus="status">
    <c:set var="iter" value="${(status.count-1)*2}" />
    <div class="row">
        <div class="col-md-6 service-alternative">
            <div class="service tag-box tag-box-v3">
                <i class="${indexModuleList[iter].iconClass} icon-round icon-color-blue service-icon"></i>
                <div class="desc">
                    <div class="headline"><h4>${indexModuleList[iter].name}</h4></div>
                    <div class="row">
                        <div class="col-md-6">
                            <ul class="list-unstyled">
                                <li><a href="${website}/index/majors/${indexModuleList[iter].id}" target="_blank">专业设置</a></li>
                                <li><a href="${website}/index/subjects/${indexModuleList[iter].id}" target="_blank">课程设置</a></li>
                                <li><a href="${website}/index/certificates/${indexModuleList[iter].id}" target="_blank">证书样例</a></li>
                                <li><a href="${website}/index/contacts/${indexModuleList[iter].id}" target="_blank">联系我们</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6">
                            <ul class="list-unstyled">
                                <li><a href="${website}/index/brochures/${indexModuleList[iter].id}" target="_blank">招生简章</a></li>
                                <li><a href="${website}/index/cooperations/${indexModuleList[iter].id}" target="_blank">助学合作单位</a></li>
                                <li><a href="${website}/index/questions/${indexModuleList[iter].id}" target="_blank">常见问题解答</a></li>
                                <li><a href="${website}/index/commonfiles/${indexModuleList[iter].id}" target="_blank">常用文件下载</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${(iter+1) != fn:length(indexModuleList)}">
            <div class="col-md-6 service-alternative">
                <div class="service tag-box tag-box-v3">
                    <i class="${indexModuleList[iter+1].iconClass} icon-round icon-color-blue service-icon"></i>
                    <div class="desc">
                        <div class="headline"><h4>${indexModuleList[iter+1].name}</h4></div>
                        <div class="row">
                            <div class="col-md-6">
                                <ul class="list-unstyled">
                                    <li><a href="${website}/index/majors/${indexModuleList[iter+1].id}" target="_blank">专业设置</a></li>
                                    <li><a href="${website}/index/subjects/${indexModuleList[iter+1].id}" target="_blank">课程设置</a></li>
                                    <li><a href="${website}/index/certificates/${indexModuleList[iter+1].id}" target="_blank">证书样例</a></li>
                                    <li><a href="${website}/index/contacts/${indexModuleList[iter+1].id}" target="_blank">联系我们</a></li>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <ul class="list-unstyled">
                                    <li><a href="${website}/index/brochures/${indexModuleList[iter+1].id}" target="_blank">招生简章</a></li>
                                    <li><a href="${website}/index/cooperations/${indexModuleList[iter+1].id}" target="_blank">助学合作单位</a></li>
                                    <li><a href="${website}/index/questions/${indexModuleList[iter+1].id}" target="_blank">常见问题解答</a></li>
                                    <li><a href="${website}/index/commonfiles/${indexModuleList[iter+1].id}" target="_blank">常用文件下载</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</c:forEach>
<%-- 循环结束 --%>
</div><!--/container-->
<!-- End Content Part -->

<!--=== Footer ===-->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="posts">
                    <div class="headline"><h2>友情链接</h2></div>
                    <a href="http://www.jlste.com.cn/">吉林省高等教育自学考试信息网</a>
                    <a href="http://www.jlxw.cn/">吉林省学位考试网</a>
                    <a href="http://yjsy.nenu.edu.cn/">东北师范大学研究生院</a>
                </div>
            </div>

            <div class="col-md-4">
                <!-- Monthly Newsletter -->
                <div class="headline"><h2>联系我们</h2></div>
                <div class="row">
                    <div class="col-md-6"><i class="icon-envelope"></i> bianming66@163.com</div>
                    <div class="col-md-6"><i class="icon-phone"></i> 0431-83536021</div>
                </div>
            </div>
        </div>
    </div><!--/row-->
</div><!--/container-->
</div><!--/footer-->
<!--=== End Footer ===-->


<!--=== Copyright ===-->
<div class="copyright">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="copyright-space">
                    版权所有：东北师范大学经济学院  |  地址：吉林 长春 净月大街2555号  |  邮编：130117  |  管理员邮箱：bianming66@163.com
                </p>
            </div>
        </div><!--/row-->
    </div><!--/container-->
</div><!--/copyright-->
<!--=== End Copyright ===-->

<!-- JS Global Compulsory -->
<script type="text/javascript" src="${staticWebsite}index/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/hover-dropdown.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/back-to-top.js"></script>
<!-- JS Implementing Plugins -->
<!-- <script type="text/javascript" src="${staticWebsite}index/plugins/flexslider/jquery.flexslider-min.js"></script> -->
<!-- JS Page Level -->
<script type="text/javascript" src="${staticWebsite}index/js/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        $('#topcontrol').children('img').attr('src', '${staticWebsite}index/img/up.png');
    });
</script>
<!--[if lt IE 9]>
<script src="${staticWebsite}index/plugins/respond.js"></script>
<![endif]-->

</body>
</html> 
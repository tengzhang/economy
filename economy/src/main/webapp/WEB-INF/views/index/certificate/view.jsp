<%--
  User: zhangteng
  Date: 2014/5/2 11:12
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <title>证书样例</title>
    <jsp:include page="../common/head.jsp" />
    <link rel="stylesheet" href="${staticWebsite}index/plugins/fancybox/source/jquery.fancybox.css">
</head>

<body>

<!--=== Top ===-->
<jsp:include page="../common/top.jsp" />
<!--=== End Top ===-->

<!--=== Header ===-->
<jsp:include page="../common/header.jsp" />
<!--=== End Header ===-->

<!--=== Breadcrumbs ===-->
<div class="breadcrumbs margin-bottom-40">
    <div class="container">
        <h1 class="pull-left">${indexModule.name}</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="${website}">首页</a></li>
            <li>${indexModule.name}</li>
            <li class="active">证书样例</li>
        </ul>
    </div>
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">
    <div class="row blog-page">
        <!-- Left Sidebar -->
        <jsp:include page="../common/leftSideBar.jsp" />
        <!-- End Left Sidebar -->

        <!-- Right Sidebar -->
        <div class="col-md-9 md-margin-bottom-40">
            <div class="tag-box tag-box-v3">
                <div class="headline clearfix">
                    <h2><i class="icon-comment color-blue"></i>&nbsp;证书样例</h2>

                </div>

                <div class="margin-bottom-20 clearfix"></div>

                <center><h2>证书样例</h2></center>

                <div class="margin-bottom-20 clearfix"></div>

                <div class="row">
                    <%-- 循环开始 --%>
                    <c:forEach var="certificate" items="${certificateList}">
                        <div class="col-md-6">
                            <div class="thumbnail">
                                <a href="${staticWebsite}${certificate.imgPath}" title="${certificate.name}" data-rel="fancybox-button" class="fancybox-button zoomer">
                                <span class="overlay-zoom">
                                    <img alt="" src="${staticWebsite}${certificate.imgPath}" class="img-responsive">
                                    <div class="zoom-icon"></div>
                                </span>
                                </a>
                                <div class="caption">
                                    <center><h4><a href="#" class="hover-effect">${certificate.name}</a></h4></center>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <%-- 循环结束 --%>
                </div>
                <div class="margin-bottom-30 clearfix"></div>
            </div>

        </div>
        <!-- End Right Sidebar -->
    </div><!--/row-->
</div><!--/container-->
<!--=== End Content Part ===-->

<!--=== Footer ===-->
<jsp:include page="../common/footer.jsp" />
<!--=== End Footer ===-->

<!--=== Copyright ===-->
<jsp:include page="../common/copyright.jsp" />
<!--=== End Copyright ===-->

<!-- JS Global Compulsory -->
<jsp:include page="../common/script.jsp" />
<script type="text/javascript" src="${staticWebsite}index/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        App.initFancybox();
    });
</script>
</body>
</html>
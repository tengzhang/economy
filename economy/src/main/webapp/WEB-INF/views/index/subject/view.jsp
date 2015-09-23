<%--
  User: zhangteng
  Date: 2014/5/2 11:10
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
    <title>课程设置-详细内容</title>
    <jsp:include page="../common/head.jsp" />
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
            <li class="active">课程设置</li>
        </ul>
    </div>
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">
    <div class="row blog-page">
        <!-- Left Sidebar -->

        <!-- End Left Sidebar -->

        <!-- Right Sidebar -->
        <div class="col-md-12 md-margin-bottom-40">
            <div class="tag-box tag-box-v3">
                <div class="headline clearfix">
                    <h2><i class="icon-comment color-blue"></i>&nbsp;${indexModule.name}课程设置</h2>
                </div>

                <div class="margin-bottom-20 clearfix"></div>

                <!-- 具体内容 -->
                <center><h2>${subject.title}</h2></center>

                <div class="margin-bottom-20 clearfix"></div>

                <center>
                    <ul class="list-unstyled list-inline blog-info">
                        <li><i class="icon-calendar color-orange"></i> <fmt:formatDate value="${subject.publicTime}" pattern="yyyy-MM-dd" /> </li>
                    </ul>
                </center>


                <div class="margin-bottom-20 clearfix"></div>

                <p>${subject.content}</p>
                <!-- 具体内容完毕 -->
                <div class="margin-bottom-30 clearfix"></div>

                <c:if test="${subject.hasAttachment == 1}">
                    <div class="tag-box">
                        <h3>
                            <i class="icon-download color-blue"></i>
                            附件下载：
                        </h3>
                        <ul class="list-unstyled">
                        <%-- 循环开始 --%>
                            <c:forEach var="attachment" items="${attachmentList}">
                                <li>
                                    <i class="icon-file-alt color-blue"></i>&nbsp;
                                    <a href="${website}/admin/attachment/download/${attachment.id}">${attachment.name}</a>
                                </li>
                            </c:forEach>
                        <%-- 循环结束 --%>
                        </ul>
                    </div>
                </c:if>
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
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        $('#topcontrol').children('img').attr('src', '${staticWebsite}index/img/up.png');
    });
</script>
</body>
</html>
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
    <title>助学合作单位列表</title>
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
            <li class="active">助学合作单位</li>
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
                    <h2><i class="icon-comment color-blue"></i>&nbsp;助学合作单位</h2>
                </div>

                <div class="margin-bottom-20 clearfix"></div>

                <ul class="list-unstyled comment">
                    <%-- 循环开始 --%>
                    <c:forEach var="cooperation" items="${cooperationList}">
                        <li class="clearfix headline">
                            <i class="icon-circle color-orange"></i>&nbsp;
                            <a href="${website}/index/cooperation/${indexModule.id}/${cooperation.id}">&nbsp;${cooperation.title}</a>
                        </li>
                    </c:forEach>
                    <%-- 循环结束 --%>
                </ul>
                <div class="margin-bottom-30 clearfix"></div>
            </div>

            <!--Pagination-->
            <%--<div class="text-center">
                <ul class="pagination">
                    <li><a href="${website}/index/notices?pageNo=${page.prevPage}">«</a></li>
                    <c:forEach var="pageNo" items="${page.pageList}">
                        <li ${pageNo==page.currentPage ? 'class="active"' : ''}>
                            <a href="${website}/index/notices?pageNo=${pageNo}">${pageNo}</a>
                        </li>
                    </c:forEach>
                    <li><a href="${website}/index/notices?pageNo=${page.nextPage}">»</a></li>
                </ul>
            </div>--%>
            <!--End Pagination-->
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
    });
</script>
</body>
</html>
<%--
  User: zhangteng
  Date: 2014/5/3 17:09
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
    <title>500</title>
    <jsp:include page="common/head.jsp" />
    <link rel="stylesheet" href="${staticWebsite}index/css/pages/page_404_error.css">
</head>

<body>

<!--=== Top ===-->
<jsp:include page="common/top.jsp" />
<!--=== End Top ===-->

<!--=== Header ===-->
<jsp:include page="common/header.jsp" />
<!--=== End Header ===-->

<!--=== Breadcrumbs ===-->
<div class="breadcrumbs margin-bottom-40">
    <div class="container">
        <h1 class="pull-left">500 错误</h1>
    </div>
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">
    <!--Error Block-->
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="error-v1">
                <span class="error-v1-title">500</span>
                <p>系统异常</p>
                <p>稍后再试吧！！</p>
            </div>
        </div>
    </div>
    <!--End Error Block-->
</div>
<!--=== End Content Part ===-->

<!--=== Footer ===-->
<jsp:include page="common/footer.jsp" />
<!--=== End Footer ===-->

<!--=== Copyright ===-->
<jsp:include page="common/copyright.jsp" />
<!--=== End Copyright ===-->

<!-- JS Global Compulsory -->
<jsp:include page="common/script.jsp" />
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>
</body>
</html>
<%--
  User: zhangteng
  Date: 2014/5/2 11:45
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<script type="text/javascript" src="${staticWebsite}index/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/hover-dropdown.min.js"></script>
<script type="text/javascript" src="${staticWebsite}index/plugins/back-to-top.js"></script>
<!-- JS Page Level -->
<script type="text/javascript" src="${staticWebsite}index/js/app.js"></script>

<!--[if lt IE 9]>
<script src="${staticWebsite}index/plugins/respond.js"></script>
<![endif]-->

<script type="text/javascript">
    jQuery(document).ready(function() {
        $('#topcontrol').children('img').attr('src', '${staticWebsite}index/img/up.png');
    });
</script>
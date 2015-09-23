<%--
  User: zhangteng
  Date: 14-1-22 上午11:12
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

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

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${staticWebsite}js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${staticWebsite}js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${staticWebsite}js/excanvas.min.js"></script>
<![endif]-->

<!-- ace scripts -->
<script src="${staticWebsite}js/ace.min.js"></script>
<script src="${staticWebsite}js/uncompressed/ace-elements.js"></script>
<!-- page specific plugin scripts -->

<script src="${staticWebsite}js/jquery-ui-1.10.3.full.min.js"></script>

<script src="${staticWebsite}js/uncompressed/chosen.jquery.js"></script>
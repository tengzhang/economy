<%--
  User: zhangteng
  Date: 14-1-22 上午11:12
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}admin/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='${staticWebsite}admin/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${staticWebsite}admin/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${staticWebsite}admin/js/bootstrap.min.js"></script>

<!--[if lte IE 8]>
<script src="${staticWebsite}admin/js/excanvas.min.js"></script>
<![endif]-->

<!-- ace scripts -->
<script src="${staticWebsite}admin/js/uncompressed/ace.js"></script>
<script src="${staticWebsite}admin/js/uncompressed/ace-elements.js"></script>
<!-- page specific plugin scripts -->

<script src="${staticWebsite}admin/js/jquery-ui-1.10.3.full.min.js"></script>

<script src="${staticWebsite}admin/js/uncompressed/chosen.jquery.js"></script>
<script src="${staticWebsite}admin/js/uncompressed/bootbox.js"></script>
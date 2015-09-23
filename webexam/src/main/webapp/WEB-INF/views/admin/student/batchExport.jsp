<%--
  User: zhangteng
  Date: 14-2-1 下午12:32
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-批量导出考生</title>
    <jsp:include page="../common/head.jsp"/>
</head>

<body>
<jsp:include page="../common/header.jsp" />

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <jsp:include page="../common/menu.jsp" />
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${website}/admin">自考学习服务中心平台后台管理</a>
                    </li>
                    <li class="active">考生信息管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        考生信息管理
                        <small>
                            <i class="icon-double-angle-right"></i>
                            批量导出考生信息
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="sample-table-1">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>专业名称</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="major" items="${majorList}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${major.name}</td>
                                            <td>
                                                <div class="btn-group">
                                                    <a onclick="exportStudentInfo('${major.code}')" class="btn btn-sm btn-primary">
                                                        <i class="icon-signout bigger-120"></i> 导出考生
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                        <a href="${website}/admin/student/list" class="btn">
                            <i class="icon-arrow-left bigger-110"></i>
                            返回
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->
        <!-- 遮罩层 -->
        <div class="message-loading-overlay" style="display: none;">
            <i class="icon-spin icon-spinner orange2 bigger-160"></i>
        </div>
    </div>
    <!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->
<jsp:include page="../common/script.jsp" />
<script type="text/javascript">
    function exportStudentInfo(majorCode) {
        $('.message-loading-overlay').show();
        window.location.target = '_ablank';
        window.location.href = '${website}/admin/student/batch/export?majorCode=' + majorCode;
        $('.message-loading-overlay').hide();
    }
</script>
</body>
</html>

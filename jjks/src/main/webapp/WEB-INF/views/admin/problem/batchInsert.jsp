<%--
  User: zhangteng
  Date: 14-1-22 下午6:35
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-批量增加题目</title>
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
                        <a href="${website}/admin">自学考试实践考核平台后台管理</a>
                    </li>
                    <li class="active">考生信息管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        题目管理
                        <small>
                            <i class="icon-double-angle-right"></i>
                            批量添加题目
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <c:if test="${!empty msg}">
                        <c:choose>
                            <c:when test="${msgCode == 0}">
                                <div class="alert alert-success center">
                                    <strong>${msg}</strong>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">
                                    <strong>${msg}</strong>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <form action="${website}/admin/problem/batch/insert" method="POST" enctype="multipart/form-data" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="id-input-file-1"
                                       class="control-label col-xs-12 col-sm-3 no-padding-right">批量增加题目：</label>

                                <div class="col-xs-12 col-sm-9">
                                    <input name="problemFile" type="file" id="id-input-file-1"/>
                                </div>
                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="submitBtn" class="btn btn-info" type="button">
                                        <i class="icon-ok bigger-110"></i>
                                        保存
                                    </button>

                                    &nbsp; &nbsp; &nbsp;
                                    <a class="btn" href="${website}/admin/student/list">
                                        <i class="icon-arrow-left bigger-110"></i>
                                        返回
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->

    </div>
    <!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>

<!-- /.main-container -->

<!-- basic scripts -->
<jsp:include page="../common/script.jsp" />
<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function ($) {
        $('#id-input-file-1').ace_file_input({
            no_file: '请选择文件 ...',
            btn_choose: '浏览',
            btn_change: '重新添加',
            droppable: false,
            onchange: null,
            thumbnail: false //| true | large
            //whitelist:'gif|png|jpg|jpeg'
            //blacklist:'exe|php'
            //onchange:''
            //
        });
    });
    $('#submitBtn').on('click', function(){
        $('.main-container').append('<div class="message-loading-overlay"><i class="icon-spin icon-spinner orange2 bigger-160"></i></div>');
        $('form').submit();
    });
</script>
</body>
</html>

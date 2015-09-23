<%--
  User: zhangteng
  Date: 14-2-11 下午8:58
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-网络课堂管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>

<body>
<jsp:include page="../common/header.jsp"/>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <jsp:include page="../common/menu.jsp"/>
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${website}/admin">自学考试实践考核平台后台管理</a>
                    </li>
                    <li class="active">网络课堂管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        网络课堂管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <a href="${website}/admin/webLesson/insert" class="btn btn-sm btn-primary pull-right">
                                    <i class="icon-plus-sign"></i>
                                    增加课程
                                </a>
                            </div>
                        </div>

                        <div class="space-6"></div>

                        <div class="row">
                            <div class="col-xs-12">

                                <div class="table-responsive">
                                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th class="hidden-480">课程名称</th>
                                            <th>课程地址</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <c:if test="${empty webLessonList}">
                                            <tr>
                                                <td colspan="8">
                                                    <div class="alert alert-danger center">
                                                        暂无课程信息!
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <!-- 循环开始 -->
                                        <c:forEach var="webLesson" items="${webLessonList}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td class="hidden-480">${webLesson.lessonName}</td>
                                                <td>${webLesson.lessonUrl}</td>
                                                <td>
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                        <a data-trigger="ajax" data-target="#ajax_target"
                                                           href="${website}/admin/webLesson/update/${webLesson.id}"
                                                           class="green" title="编辑">
                                                            <i class="icon-pencil bigger-130"></i>
                                                        </a>
                                                        <a id="delete-control-${webLesson.id}" uuid="${webLesson.id}"
                                                           data-trigger="my-delete" class="red" title="删除" href="#">
                                                            <i class="icon-trash bigger-130"></i>
                                                        </a>
                                                        <a id="delete-confirm-${webLesson.id}"
                                                           href="${website}/admin/webLesson/del/${webLesson.id}"
                                                           class="btn btn-danger btn-xs" style="display:none;">确定 </a>
                                                        <a id="delete-cancel-${webLesson.id}" data-trigger="my-delete"
                                                           uuid="${webLesson.id}" class="btn btn-default btn-xs"
                                                           style="display:none;">取消</a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <!-- 循环结束 -->
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                        </div>
                        <!-- /row -->
                        <!-- PAGE CONTENT ENDS -->
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
<jsp:include page="../common/script.jsp"/>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    $(document).on('click', '[data-trigger="my-delete"]', function () {
        var $uuid = $(this).attr('uuid');
        $('[id="delete-control-' + $uuid + '"]').toggle();
        $('[id="delete-confirm-' + $uuid + '"]').toggle();
        $('[id="delete-cancel-' + $uuid + '"]').toggle();
    });
</script>
</body>
</html>

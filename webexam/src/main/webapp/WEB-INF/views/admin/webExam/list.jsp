<%--
  User: zhangteng
  Date: 14-2-2 下午9:52
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-网络测试管理</title>
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
                        <a href="${website}/admin">自考学习服务中心平台后台管理</a>
                    </li>
                    <li class="active">网络测试管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        网络测试管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-6 no-padding-left">
                                    <form action="${website}/admin/webExam/search" method="post" class="form-horizontal"
                                          role="form">
                                        <div class="input-group col-sm-6 no-padding-left">
                                            <input name="search" type="text" placeholder="请输入专业代码或科目代码"
                                                   class="form-control search-query">
                                        <span class="input-group-btn">
                                            <button class="btn btn-purple btn-sm" type="submit">
                                                搜索
                                                <i class="icon-search icon-on-right bigger-110"></i>
                                            </button>
                                        </span>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-6 no-padding-right">
                                    <a href="${website}/admin/webExam/insert" class="btn btn-sm btn-primary pull-right">
                                        <i class="icon-plus-sign"></i>
                                        增加测试
                                    </a>
                                </div>
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
                                            <th>测试科目代码</th>
                                            <th class="hidden-480">测试科目名称</th>
                                            <th>所属专业代码</th>
                                            <th>所属专业名称</th>
                                            <th class="hidden-480">开考时间</th>
                                            <th class="hidden-480">结束时间</th>
                                            <th class="hidden-480">测试时长</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <c:if test="${empty webExamList}">
                                            <tr>
                                                <td colspan="8">
                                                    <div class="alert alert-danger center">
                                                        暂无考试信息!
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <!-- 循环开始 -->
                                        <c:forEach var="webExam" items="${webExamList}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${webExam.subjectCode}</td>
                                                <td class="hidden-480">${webExam.subjectName}</td>
                                                <td>${webExam.majorCode}</td>
                                                <td>${webExam.majorName}</td>
                                                <td class="hidden-480"><fmt:formatDate value="${webExam.startTime}" pattern="yyyy-MM-dd HH:mm" /> </td>
                                                <td class="hidden-480"><fmt:formatDate value="${webExam.endTime}" pattern="yyyy-MM-dd HH:mm" /></td>
                                                <td class="hidden-480">${webExam.examTime}分钟</td>
                                                <td>
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                        <a data-trigger="ajax" data-target="#ajax_target"
                                                           href="${website}/admin/webExam/update/${webExam.id}"
                                                           class="green" title="编辑">
                                                            <i class="icon-pencil bigger-130"></i>
                                                        </a>
                                                        <a id="delete-control-${webExam.id}" uuid="${webExam.id}"
                                                           data-trigger="my-delete" class="red" title="删除" href="#">
                                                            <i class="icon-trash bigger-130"></i>
                                                        </a>
                                                        <a id="delete-confirm-${webExam.id}"
                                                           href="${website}/admin/webExam/del/${webExam.id}"
                                                           class="btn btn-danger btn-xs" style="display:none;">确定 </a>
                                                        <a id="delete-cancel-${webExam.id}" data-trigger="my-delete"
                                                           uuid="${webExam.id}" class="btn btn-default btn-xs"
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

                                <ul class="pagination pull-right">
                                    <li class="prev">
                                        <a href="${website}/admin/webExam/list?pageNo=${page.prevPage}">
                                            <i class="icon-double-angle-left"></i>
                                        </a>
                                    </li>
                                    <c:forEach var="pageNo" items="${page.pageList}">
                                        <c:choose>
                                            <c:when test="${pageNo == page.currentPage}">
                                                <li class="active">
                                                    <a href="${website}/admin/webExam/list?pageNo=${pageNo}">${pageNo}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                                    <a href="${website}/admin/webExam/list?pageNo=${pageNo}">${pageNo}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <li class="next">
                                        <a href="${website}/admin/webExam/list?pageNo=${page.nextPage}">
                                            <i class="icon-double-angle-right"></i>
                                        </a>
                                    </li>
                                </ul>
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

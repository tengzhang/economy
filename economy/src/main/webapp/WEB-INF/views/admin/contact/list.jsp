<%--
  User: zhangteng
  Date: 2014/4/30 17:21
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
    <title>后台管理-联系我们管理</title>

    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
                        <a href="${website}/admin">其他办学后台管理</a>
                    </li>
                    <li class="active">联系我们管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        联系我们管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-12 no-padding-right">
                                    <a href="${website}/admin/contact/insert" class="btn btn-sm btn-primary pull-right">
                                        <i class="icon-plus-sign"></i>
                                        增加联系我们
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
                                            <th>所属版块</th>
                                            <th>通信地址</th>
                                            <th>联系电话</th>
                                            <th>电子邮件</th>
                                            <th>联系人</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <c:if test="${empty contactList}">
                                            <tr>
                                                <td colspan="8">
                                                    <div class="alert alert-danger center">
                                                        暂无联系我们!
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <!-- 循环开始 -->
                                        <c:forEach var="contact" items="${contactList}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${contact.indexModuleName}</td>
                                                <td>${contact.address}</td>
                                                <td>${contact.phone}</td>
                                                <td>${contact.email}</td>
                                                <td>${contact.contactPeople}</td>
                                                <td>
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                        <a data-trigger="ajax" data-target="#ajax_target"
                                                           href="${website}/admin/contact/update/${contact.id}"
                                                           class="green" title="编辑">
                                                            <i class="icon-pencil bigger-130"></i>
                                                        </a>
                                                        <a id="delete-control-${contact.id}" uuid="${contact.id}"
                                                           data-trigger="my-delete" class="red" title="删除" href="#">
                                                            <i class="icon-trash bigger-130"></i>
                                                        </a>
                                                        <a id="delete-confirm-${contact.id}"
                                                           data-trigger="my-delete-confirm"
                                                           href="${website}/admin/contact/delete/${contact.id}"
                                                           class="btn btn-danger btn-xs" style="display:none;">确定 </a>
                                                        <a id="delete-cancel-${contact.id}" data-trigger="my-delete"
                                                           uuid="${contact.id}" class="btn btn-default btn-xs"
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
                                        <a href="${website}/admin/contact/list?pageNo=${page.prevPage}">
                                            <i class="icon-double-angle-left"></i>
                                        </a>
                                    </li>
                                    <c:forEach var="pageNo" items="${page.pageList}">
                                        <c:choose>
                                            <c:when test="${pageNo == page.currentPage}">
                                                <li class="active">
                                                    <a href="${website}/admin/contact/list?pageNo=${pageNo}">${pageNo}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                                    <a href="${website}/admin/contact/list?pageNo=${pageNo}">${pageNo}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <li class="next">
                                        <a href="${website}/admin/contact/list?pageNo=${page.nextPage}">
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

<div class="hide" id="dialog-message-exit">
    <div class="space-4"></div>
    <p id="tipExit">
    </p>
</div>

<!-- basic scripts -->
<jsp:include page="../common/script.jsp"/>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    $(function($) {
        $(".chosen-select").chosen({
            hasSearch: false,
            cssClasses: ['col-sm-6', 'col-xs-6']
        });
    });

    $(document).on('click', '[data-trigger="my-delete"]', function () {
        var $uuid = $(this).attr('uuid');
        $('[id="delete-control-' + $uuid + '"]').toggle();
        $('[id="delete-confirm-' + $uuid + '"]').toggle();
        $('[id="delete-cancel-' + $uuid + '"]').toggle();
    });
    $(document).on('click', '[data-trigger="my-delete-confirm"]', function() {
        var $url = $(this).attr('href');
        var $tr = $(this).closest('tr');
        $.ajax({
            url: $url,
            type: 'get',
            success: function() {
                $tr.remove();
            }
        });
        return false;
    });
</script>
</body>
</html>
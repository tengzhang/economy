<%--
  User: zhangteng
  Date: 2014/4/11 17:38
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
    <title>后台管理-课程管理</title>

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
                    <li class="active">课程管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        课程管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-6 no-padding-left">
                                    <form action="${website}/admin/subject" method="get" class="form-horizontal" role="form">
                                        <div class="input-group col-sm-12 no-padding-left">
                                            <select name="search" class="chosen-select col-sm-6" data-placeholder="请选择版块">
                                                <option>请选择</option>
                                                <c:forEach var="indexModule" items="${indexModuleList}">
                                                    <c:if test="${search == indexModule.id}">
                                                        <option value="${indexModule.id}" selected="selected">${indexModule.name}</option>
                                                    </c:if>
                                                    <c:if test="${search != indexModule.id}">
                                                        <option value="${indexModule.id}">${indexModule.name}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <span style="padding-left: 10px;">
                                                <button class="btn btn-purple btn-sm" type="submit">
                                                    查询
                                                    <i class="icon-search icon-on-right bigger-110"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-6 no-padding-right">
                                    <a href="${website}/admin/subject/insert" class="btn btn-sm btn-primary pull-right">
                                        <i class="icon-plus-sign"></i>
                                        增加课程
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
                                            <th>标题</th>
                                            <th>发布时间</th>
                                            <th>详细信息</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <c:if test="${empty articleList}">
                                            <tr>
                                                <td colspan="8">
                                                    <div class="alert alert-danger center">
                                                        暂无课程!
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <!-- 循环开始 -->
                                        <c:forEach var="article" items="${articleList}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${article.indexModuleName}</td>
                                                <td>${article.title}</td>
                                                <td><fmt:formatDate value="${article.publicTime}" pattern="yyyy-MM-dd" /> </td>
                                                <td class="hidden-480">
                                                    <a href="${website}/admin/subject/view/${article.id}">点击查看</a>
                                                </td>
                                                <td>
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                        <a data-trigger="ajax" data-target="#ajax_target"
                                                           href="${website}/admin/subject/update/${article.id}"
                                                           class="green" title="编辑">
                                                            <i class="icon-pencil bigger-130"></i>
                                                        </a>
                                                        <a id="delete-control-${article.id}" uuid="${article.id}"
                                                           data-trigger="my-delete" class="red" title="删除" href="#">
                                                            <i class="icon-trash bigger-130"></i>
                                                        </a>
                                                        <a id="delete-confirm-${article.id}"
                                                           data-trigger="my-delete-confirm"
                                                           href="${website}/admin/subject/delete/${article.id}"
                                                           class="btn btn-danger btn-xs" style="display:none;">确定 </a>
                                                        <a id="delete-cancel-${article.id}" data-trigger="my-delete"
                                                           uuid="${article.id}" class="btn btn-default btn-xs"
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
                                        <a href="${website}/admin/subject/list?pageNo=${page.prevPage}&search=${search}">
                                            <i class="icon-double-angle-left"></i>
                                        </a>
                                    </li>
                                    <c:forEach var="pageNo" items="${page.pageList}">
                                        <c:choose>
                                            <c:when test="${pageNo == page.currentPage}">
                                                <li class="active">
                                                    <a href="${website}/admin/subject/list?pageNo=${pageNo}&search=${search}">${pageNo}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                                    <a href="${website}/admin/subject/list?pageNo=${pageNo}&search=${search}">${pageNo}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <li class="next">
                                        <a href="${website}/admin/subject/list?pageNo=${page.nextPage}&search=${search}">
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

    $('table th input:checkbox').on('click' , function(){
        var that = this;
        $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

    });

    $('#batchDel').on('click', function() {
        var ids = '';
        $('table').find('tr > td:first-child input:checkbox').each(function() {
            if(this.checked) {
                ids += $(this).val() + ',';
            }
        });
        if(ids=='' || ids.length==0) {
            showDialog('请选择要删除的项', '请选择要删除的项!', 1);
            return ;
        }
        $.ajax({
            url: '${website}/admin/subject/batch/delete',
            type: 'post',
            data: {
                'ids': ids
            },
            success: function() {
                showDialog('删除成功', '删除成功!', 2);
            }
        });
    });

    function showDialog(title, tips, type) {
        $('#tipExit').html(tips);
        $( "#dialog-message-exit" ).removeClass('hide').dialog({
            modal: true,
            title_html: true,
            buttons: [
                {
                    text: "取消",
                    "class" : "btn btn-xs",
                    click: function() {
                        if(type == 1) {
                            $( this ).dialog( "close" );
                        } else {
                            window.location.href='${website}/admin/subject';
                        }
                    }
                },
                {
                    text: "确认",
                    "class" : "btn btn-primary btn-xs",
                    click: function() {
                        if(type == 1) {
                            $( this ).dialog( "close" );
                        } else {
                            window.location.href='${website}/admin/subject';
                        }
                    }
                }
            ]
        });
    }
</script>
</body>
</html>
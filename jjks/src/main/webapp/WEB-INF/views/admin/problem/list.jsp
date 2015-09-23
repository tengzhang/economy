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
    <meta charset="utf-8" />
    <title>后台管理-题目管理</title>
    <jsp:include page="../common/head.jsp" />
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
        <li class="active">基本信息管理</li>
    </ul><!-- .breadcrumb -->
</div>

<div class="page-content">
<div class="page-header">
    <h1>
        基本信息管理
        <small>
            <i class="icon-double-angle-right"></i>
            题目管理
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div class="row">
            <div class="col-xs-12">
                <a href="${website}/admin/problem/insert" class="btn btn-sm btn-primary pull-right">
                    <i class="icon-plus-sign"></i>
                    增加题目
                </a>
                <a href="${website}/admin/problem/batch/insert" class="btn btn-sm btn-inverse pull-right">
                    <i class="icon-plus-sign"></i><i class="icon-plus-sign"></i>
                    批量增加题目
                </a>
                <a href="${website}/admin/problem/batch/toExport" class="btn btn-sm btn-purple pull-right">
                    <i class="icon-signout"></i>
                    批量导出题目
                </a>
                <button id="batchDel" class="btn btn-sm btn-red pull-right">
                    <i class="icon-trash"></i>
                    批量删除
                </button>
            </div>
        </div>

        <div class="space-6"></div>

        <div class="row">
            <div class="col-xs-12">

                <div class="table-responsive">
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input class="ace" type="checkbox">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>序号</th>
                            <th>题目类型</th>
                            <th class="hidden-480">分值</th>
                            <th>所属专业</th>
                            <th>所属科目</th>
                            <th>题目内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody>
                        <!-- 循环开始 -->
                        <c:forEach var="problem" items="${problemList}" varStatus="status">
                        <tr>
                            <td class="center">
                                <label>
                                    <input class="ace" type="checkbox" value="${problem.id}">
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>${status.count}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${problem.type == 1}">
                                        单选
                                    </c:when>
                                    <c:when test="${problem.type == 2}">
                                        多选
                                    </c:when>
                                    <c:otherwise>
                                        判断
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="hidden-480">${problem.score}</td>
                            <td>${problem.majorName}</td>
                            <td>${problem.subjectName}</td>
                            <td><a href="${website}/admin/problem/view/${problem.id}">点击查看</a></td>
                            <td>
                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                    <a data-trigger="ajax" data-target="#ajax_target"
                                        href="${website}/admin/problem/update/${problem.id}"
                                        class="green" title="编辑">
                                        <i class="icon-pencil bigger-130"></i>
                                    </a>
                                    <a id="delete-control-${problem.id}" uuid="${problem.id}"
                                        data-trigger="my-delete" class="red" title="删除" href="#">
                                        <i class="icon-trash bigger-130"></i>
                                    </a>
                                    <a id="delete-confirm-${problem.id}"
                                        data-trigger="my-delete-confirm"
                                        href="${website}/admin/problem/del/${problem.id}"
                                        class="btn btn-danger btn-xs" style="display:none;">确定 </a>
                                    <a id="delete-cancel-${problem.id}" data-trigger="my-delete"
                                        uuid="${problem.id}" class="btn btn-default btn-xs"
                                        style="display:none;">取消</a>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        <!-- 循环结束 -->
                        </tbody>
                    </table>
                </div><!-- /.table-responsive -->

                <ul class="pagination pull-right">
                    <li class="prev">
                        <a href="${website}/admin/problem/list?pageNo=${page.prevPage}">
                            <i class="icon-double-angle-left"></i>
                        </a>
                    </li>
                    <c:forEach var="pageNo" items="${page.pageList}">
                        <c:choose>
                            <c:when test="${pageNo == page.currentPage}">
                                <li class="active">
                                    <a href="${website}/admin/problem/list?pageNo=${pageNo}">${pageNo}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${website}/admin/problem/list?pageNo=${pageNo}">${pageNo}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li class="next">
                        <a href="${website}/admin/problem/list?pageNo=${page.nextPage}">
                            <i class="icon-double-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div><!-- /row -->
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
</div><!-- /.page-content -->
</div><!-- /.main-content -->
</div><!-- /.main-container-inner -->

<div class="hide" id="dialog-message-exit">
    <div class="space-4"></div>
    <p id="tipExit">
        确认退出考试平台吗？
    </p>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->
<!-- basic scripts -->
<jsp:include page="../common/script.jsp" />
<!-- inline scripts related to this page -->
<script type="text/javascript">
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
        console.log(ids);
        if(ids=='' || ids.length==0) {
            showDialog('请选择要删除的题目', '请选择要删除的题目!', 1);
            return ;
        }
        $.ajax({
            url: '${website}/admin/problem/batch/del',
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
                            window.location.href='${website}/admin/problem';
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
                            window.location.href='${website}/admin/problem';
                        }
                    }
                }
            ]
        });
    }
</script>
</body>
</html>

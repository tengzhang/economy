<%--
  User: zhangteng
  Date: 2014/4/11 17:38
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-更新首页版块问题</title>
    <jsp:include page="../../common/head.jsp"/>
    <style type="text/css">
        .bootbox-body .col-xs-12.col-sm-2.center:hover{
            cursor: pointer;
            color: #428BCA;
        }
        .icon-selected{
            color: #1b6aaa;
        }
    </style>
</head>

<body>
<jsp:include page="../../common/header.jsp"/>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <jsp:include page="../../common/menu.jsp"/>
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${website}/admin">其他办学后台管理</a>
                    </li>
                    <li class="active">首页版块管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        首页版块管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/index/module/update" method="POST" class="form-horizontal"
                                      role="form">
                                    <input name="id" value="${indexModule.id}" type="hidden" />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            名称： </label>

                                        <div class="col-sm-9">
                                            <input name="name" value="${indexModule.name}" class="col-xs-10 col-sm-5" type="text" placeholder="请输入名称">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <input name="iconClass" value="${indexModule.iconClass}" type="hidden" />
                                        <label class="col-sm-3 control-label no-padding-right">
                                            图标： </label>

                                        <div class="col-sm-9">
                                            <i id="iconClass" class="${indexModule.iconClass} bigger-150 blue"></i>
                                            <button type="button" class="btn btn-primary" id="bootbox-options">点击更改图标</button>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            排列顺序： </label>

                                        <div class="col-sm-9">
                                            <input name="sortNo" value="${indexModule.sortNo}" class="col-xs-10 col-sm-5" type="text" />
                                        </div>
                                    </div>

                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-info" type="submit">
                                                <i class="icon-ok bigger-110"></i>
                                                保存
                                            </button>

                                            &nbsp; &nbsp; &nbsp;
                                            <button class="btn" type="reset">
                                                <i class="icon-undo bigger-110"></i>
                                                重置
                                            </button>
                                        </div>
                                    </div>
                                </form>
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
<jsp:include page="../../common/script.jsp"/>
<script type="text/javascript">
    jQuery(function($) {
        $("#bootbox-options").on(ace.click_event, function() {
            var $message = '<h3>点击选择以下图标</h3><hr/>' +
                            '<div class="row">' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-bullhorn bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-download-alt bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-comment bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-comment-alt bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-flag bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-laptop bigger-150"></i></div>' +
                            '</div>' +
                            '<div class="space"></div>' +
                            '<div class="row">' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-eye-open bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-coffee bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-desktop bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-home bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-heart bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-heart-empty bigger-150"></i></div>' +
                            '</div>' +
                            '<div class="space"></div>' +
                            '<div class="row">' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-headphones bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-exchange bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-globe bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-leaf bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-key bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-lightbulb bigger-150"></i></div>' +
                            '</div>' +
                            '<div class="space"></div>' +
                            '<div class="row">' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-asterisk bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-bell bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-bell-alt bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-bookmark bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-bookmark-empty bigger-150"></i></div>' +
                            '<div class="col-xs-12 col-sm-2 center"><i class="icon-check bigger-150"></i></div>' +
                            '</div>'
                    ;
            bootbox.dialog({
                message: $message,
                buttons:
                        [
                            {
                                "label" : "<i class='icon-ok'></i> 确定",
                                "className" : "btn-sm btn-primary",
                                callback: function() {
                                    var $iconClass = $('.icon-selected').attr('class').split(' ')[0];
                                    $('[name="iconClass"]').val($iconClass);
                                    $('#iconClass').attr('class', $iconClass + ' bigger-150 blue');
                                }
                            },
                            {
                                "label" : "<i class='icon-arrow-left'></i> 返回",
                                "className" : "btn-sm"
                            }
                        ]
            });

            $('.bootbox-body .center').on('click',function(){
                $('.bootbox-body .center').children('i').removeClass('icon-selected');
                $(this).children('i').addClass('icon-selected');
            });
        });
    });
</script>
</body>
</html>
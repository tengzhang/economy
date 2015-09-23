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
    <title>后台管理-首页图片管理</title>

    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <jsp:include page="../../common/head.jsp"/>
    <link rel="stylesheet" href="${staticWebsite}admin/css/colorbox.css" />
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
                    <li class="active">首页图片管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        首页图片管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-12 no-padding-right">
                                    <a href="${website}/admin/index/img/insert" class="btn btn-sm btn-primary pull-right">
                                        <i class="icon-plus-sign"></i>
                                        增加图片
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="space-6"></div>

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="row-fluid">
                                    <ul class="ace-thumbnails">
                                        <c:forEach var="indexImg" items="${indexImgList}">
                                            <li>
                                                <a href="${staticWebsite}${indexImg.imgPath}" title="${indexImg.description}" data-rel="colorbox">
                                                    <img alt="150x150" src="${staticWebsite}${indexImg.imgPath}" style="width: 150px; height: 150px;" />
                                                </a>

                                                <div class="tools tools-bottom">
                                                    <a href="${website}/admin/index/img/update/${indexImg.id}">
                                                        <i class="icon-pencil"></i>
                                                    </a>

                                                    <a href="${website}/admin/index/img/delete/${indexImg.id}">
                                                        <i class="icon-remove red"></i>
                                                    </a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
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
<script src="${staticWebsite}admin/js/uncompressed/jquery.colorbox.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($) {
        var colorbox_params = {
            reposition:true,
            scalePhotos:true,
            scrolling:false,
            previous:'<i class="icon-arrow-left"></i>',
            next:'<i class="icon-arrow-right"></i>',
            close:'&times;',
            current:'{current} of {total}',
            maxWidth:'100%',
            maxHeight:'100%',
            onOpen:function(){
                document.body.style.overflow = 'hidden';
            },
            onClosed:function(){
                document.body.style.overflow = 'auto';
            },
            onComplete:function(){
                $.colorbox.resize();
            }
        };

        $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
        $("#cboxLoadingGraphic").append("<i class='icon-spinner orange'></i>");
    });
</script>
</body>
</html>
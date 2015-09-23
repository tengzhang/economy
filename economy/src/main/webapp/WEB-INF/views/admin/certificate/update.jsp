<%--
  User: zhangteng
  Date: 2014/4/29 15:00
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
    <title>后台管理-更新证书</title>
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
                    <li class="active">证书管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        证书管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/certificate/update" method="POST" enctype="multipart/form-data" class="form-horizontal" role="form">
                                    <input name="id" value="${certificate.id}" type="hidden"/>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            所属版块： </label>

                                        <div class="col-sm-9">
                                            <select name="indexModuleId" class="chosen-select" data-placeholer="请选择">
                                                <c:forEach var="indexModule" items="${indexModuleList}">
                                                    <c:if test="${certificate.indexModuleId == indexModule.id}">
                                                        <option value="${indexModule.id}" selected="selected">${indexModule.name}</option>
                                                    </c:if>
                                                    <c:if test="${certificate.indexModuleId != indexModule.id}">
                                                        <option value="${indexModule.id}">${indexModule.name}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            证书名称： </label>

                                        <div class="col-sm-9">
                                            <input name="name" value="${certificate.name}" class="col-xs-10 col-sm-5" type="text" placeholder="请输入名称">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            选择图片： </label>

                                        <div class="col-sm-9">
                                            <input name="imgFile" type="file" />
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
<jsp:include page="../common/script.jsp"/>
<script type="text/javascript">
    jQuery(function($) {
        $(".chosen-select").chosen({
            hasSearch: false,
            cssClasses: ['col-sm-5', 'col-xs-10']
        });

        $('[name="imgFile"]').ace_file_input({
            no_file:'请选择文件 ...',
            btn_choose:'浏览',
            btn_change:'重新添加',
            droppable:false,
            onchange:null,
            thumbnail:false
        });
    });
</script>
</body>
</html>
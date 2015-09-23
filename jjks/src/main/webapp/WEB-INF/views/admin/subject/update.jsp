<%--
  User: zhangteng
  Date: 14-1-21 下午1:44
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>后台管理-修改科目</title>
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
                            科目管理
                        </small>
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/subject/update" method="post" class="form-horizontal" role="form">
                                    <input name="id" value="${subject.id}" type="hidden" />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 科目代码： </label>

                                        <div class="col-sm-9">
                                            <input name="code" value="${subject.code}" type="text" id="form-field-1" class="col-xs-10 col-sm-5" />
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 科目名称： </label>

                                        <div class="col-sm-9">
                                            <input name="name" value="${subject.name}" type="text" id="form-field-2" class="col-xs-10 col-sm-5" />
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-3"> 学分： </label>

                                        <div class="col-sm-9">
                                            <input name="credit" value="${subject.credit}" type="text" id="form-field-3" class="col-xs-10 col-sm-5" />
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
                        </div><!-- /row -->
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

</body>
</html>

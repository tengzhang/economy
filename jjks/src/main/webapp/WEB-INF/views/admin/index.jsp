<%--
  User: zhangteng
  Date: 14-1-16 下午4:39
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>后台管理首页</title>
    <jsp:include page="common/head.jsp" />
</head>

<body>
<jsp:include page="common/header.jsp" />

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <jsp:include page="common/menu.jsp" />

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">自考学习服务中心平台后台管理</a>
                    </li>
                    <li class="active">常用管理</li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        常用管理
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="space-6"></div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-3">
                                <a href="${website}/admin/problem" title="" class="btn btn-success">题目管理</a>
                            </div>
                            <div class="col-xs-12 col-sm-3">
                                <a href="${website}/admin/major/subject" title="" class="btn btn-primary">专业-科目管理</a>
                            </div>
                            <div class="col-xs-12 col-sm-3">
                                <a href="${website}/admin/student" title="" class="btn btn-warning">考生信息管理</a>
                            </div>
                            <div class="col-xs-12 col-sm-3">
                                <a href="${website}/admin/webExam" title="" class="btn btn-danger">网络测试管理</a>
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
<jsp:include page="common/script.jsp" />
</body>
</html>
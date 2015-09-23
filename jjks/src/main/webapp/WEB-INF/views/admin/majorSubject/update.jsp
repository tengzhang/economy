<%--
  User: zhangteng
  Date: 14-1-22 下午6:32
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>后台管理-修改专业科目</title>
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
                                <form id="form1" action="${website}/admin/major/subject/update" method="post" class="form-horizontal" role="form">
                                    <input name="id" value="${majorSubject.id}" type="hidden" />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 专业名称： </label>

                                        <div class="col-sm-9">
                                            <select name="majorId" id="form-field-1" class="width-80 chosen-select" style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="major" items="${majorList}">
                                                    <c:choose>
                                                        <c:when test="${majorSubject.majorId == major.id}">
                                                            <option value="${major.id}" selected="selected">${major.name}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${major.id}">${major.name}</option>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>
                                    <div id="sub-choose" class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right"> 科目名称： </label>

                                        <div class="col-sm-9">
                                            <select name="subjectId" class="width-80 chosen-select" style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="subject" items="${subjectList}">
                                                    <c:choose>
                                                        <c:when test="${majorSubject.subjectId == subject.id}">
                                                            <option value="${subject.id}" selected="selected">${subject.name}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${subject.id}">${subject.name}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
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

<!-- basic scripts -->
<jsp:include page="../common/script.jsp" />

<!-- 页面内部js -->
<script type="text/javascript">
    $(function($) {
        $(".chosen-select").chosen({
            cssClasses: ['col-sm-5', 'col-xs-10'],
            hasSearch: true
        });
    });
</script>
</body>
</html>

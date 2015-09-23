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
    <title>后台管理-查看题目详情</title>
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
                                <div class="space-4"></div>
                                <form class="form-horizontal" role="form">
                                    <p>${problem.title}</p>
                                    <c:if test="${problem.type != 2}">
                                        <c:if test="${!empty problem.chooseA}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" class="ace" name="form-field-radio">
                                                    <span class="lbl">A.${problem.chooseA}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseB}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" class="ace" name="form-field-radio">
                                                    <span class="lbl">B.${problem.chooseB}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseC}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" class="ace" name="form-field-radio">
                                                    <span class="lbl">C.${problem.chooseC}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseD}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" class="ace" name="form-field-radio">
                                                    <span class="lbl">D.${problem.chooseD}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseE}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" class="ace" name="form-field-radio">
                                                    <span class="lbl">E.${problem.chooseE}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${problem.type == 2}">
                                        <c:if test="${!empty problem.chooseA}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">A.${problem.chooseA}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseB}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">B.${problem.chooseB}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseC}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">C.${problem.chooseC}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseD}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">D.${problem.chooseD}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${!empty problem.chooseE}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">A.${problem.chooseE}</span>
                                                </label>
                                            </div>
                                        </c:if>
                                    </c:if>
                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <a href="${website}/admin/problem/update/${problem.id}" class="btn btn-info" type="button">
                                                <i class="icon-pencil bigger-110"></i>
                                                修改题目
                                            </a>

                                            &nbsp; &nbsp; &nbsp;
                                            <a href="${website}/admin/problem/list" class="btn">
                                                <i class="icon-arrow-left bigger-110"></i>
                                                返回
                                            </a>
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

<%--
  User: zhangteng
  Date: 14-1-31 下午5:32
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-增加考生</title>
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
                        <a href="${website}/admin">自学考试实践考核平台后台管理</a>
                    </li>
                    <li class="active">考生信息管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        考生信息管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/student/insert" method="post" class="form-horizontal"
                                      role="form">
                                    <div class="row">
                                        <!-- 第一列左列 -->
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">考生姓名:</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="name" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入考生姓名"/>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">身份证号:</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="idNo" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入考生身份证号"/>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">学校/机构：</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="schoolName" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入学校/机构"/>
                                                </div>
                                            </div>

                                        </div>
                                        <!-- 左列结束 -->

                                        <!-- 又是一列 右列-->
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">准考证号：</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="examNo" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入考生准考证号"/>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">专业：</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <select name="majorId" class="chosen-select col-sm-10 col-xs-10">
                                                        <option value="0">请选择</option>
                                                        <c:forEach var="major" items="${majorList}">
                                                            <option value="${major.id}"
                                                                    class="major1">${major.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- 右列结束 -->
                                    </div>

                                    <div class="hr hr-double"></div>
                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-info" type="submit" id="qq">
                                                <i class="icon-arrow-right bigger-110"></i>
                                                下一步
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

<!-- 页面内部js -->
<script type="text/javascript">
    $(function ($) {
        $(".chosen-select").chosen({
            cssClasses: ['col-sm-10', 'col-xs-10']
        });
    });
</script>
</body>
</html>

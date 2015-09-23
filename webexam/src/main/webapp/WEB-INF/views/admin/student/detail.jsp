<%--
  User: zhangteng
  Date: 14-1-31 下午5:33
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-查看考生详情</title>
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
                        <a href="${website}/admin">自考学习服务中心平台后台管理</a>
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
                                <div class="space-4"></div>
                                <form class="form-horizontal" role="form">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-3">
                                            <label>考生姓名：</label>
                                            ${studentDto.student.name}
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <label>准考证号：</label>
                                            ${studentDto.student.examNo}
                                        </div>
                                        <div class="col-xs-12 col-sm-5">
                                            <label>身份证号：</label>
                                            ${studentDto.student.idNo}
                                        </div>
                                    </div>
                                    <div class="space-4"></div>
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-3">
                                            <label>专业：</label>
                                            ${studentDto.student.majorName}
                                        </div>
                                        <div class="col-xs-12 col-sm-4">
                                            <label>学校/机构：</label>
                                            ${studentDto.student.schoolName}
                                        </div>
                                    </div>

                                    <div class="hr hr-double"></div>

                                    <div class="row">
                                        <div class="col-xs-12">
                                            <label class="control-label">课程信息：</label>

                                            <div class="space-4"></div>
                                            <div class="table-responsive">
                                                <table id="sample-table-1"
                                                       class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>序号</th>
                                                        <th class="hidden-480">科目代码</th>
                                                        <th>科目名称</th>
                                                        <th>是否缴费</th>
                                                        <th>缴费时间</th>
                                                        <th>成绩</th>
                                                    </tr>
                                                    </thead>

                                                    <tbody>
                                                    <!-- 循环开始 -->
                                                    <c:forEach var="subject" items="${studentDto.subjectList}"
                                                               varStatus="status">
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td class="hidden-480">${subject.subjectCode}</td>
                                                            <td>${subject.subjectName}</td>
                                                            <td>
                                                                <c:if test="${subject.isPay == 1}">
                                                                    是
                                                                </c:if>
                                                                <c:if test="${subject.isPay == 0}">
                                                                    否
                                                                </c:if>
                                                            </td>
                                                            <td>${subject.payTime}</td>
                                                            <td>
                                                                ${subject.score}
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    <!-- 循环结束 -->
                                                    </tbody>
                                                </table>
                                            </div>
                                            <!-- /.table-responsive -->
                                        </div>
                                    </div>

                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <a href="${website}/admin/student/update/${studentDto.student.id}" class="btn btn-info" type="button">
                                                <i class="icon-pencil bigger-110"></i>
                                                修改考生信息
                                            </a>

                                            &nbsp; &nbsp; &nbsp;
                                            <a href="${website}/admin/student/list" class="btn">
                                                <i class="icon-arrow-left bigger-110"></i>
                                                返回
                                            </a>
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
<jsp:include page="../common/script.jsp" />
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

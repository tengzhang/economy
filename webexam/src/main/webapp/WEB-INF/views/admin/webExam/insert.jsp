<%--
  User: zhangteng
  Date: 14-2-2 下午9:48
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-增加网络测试</title>
    <jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="${staticWebsite}css/uncompressed/bootstrap-datetimepicker.css">
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
                    <li class="active">网络测试管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        网络测试管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/webExam/insert" method="POST" class="form-horizontal"
                                      role="form">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                            测试专业名称： </label>

                                        <div class="col-sm-9">
                                            <select name="majorId" id="form-field-1" class="width-80 chosen-select"
                                                    style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="major" items="${majorList}">
                                                    <option value="${major.id}">${major.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                            测试科目名称： </label>

                                        <div class="col-sm-9">
                                            <select name="subjectId" id="form-field-2" class="width-80 chosen-select"
                                                    style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="subject" items="${subjectList}">
                                                    <option value="${subject.id}">${subject.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                            开考时间： </label>

                                        <div class="col-sm-9">
                                            <!-- <input id="form-field-2" class="col-xs-10 col-sm-5" type="text" placeholder="请输入测试开考时间"> -->
                                            <div class="input-group date form_datetime col-xs-10 col-sm-5 no-padding-left no-padding-right"
                                                 data-date="" data-date-format="yyyy-mm-dd HH:ii"
                                                 data-link-field="dtp_input1">
                                                <input class="form-control" size="16" type="text" value="" readonly>
                                                <span class="input-group-addon"><span
                                                        class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <input name="startTime" type="hidden" id="dtp_input1" value=""
                                                   placeholder="请选择测试开始时间"/>
                                        </div>

                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">
                                            结束时间： </label>

                                        <div class="col-sm-9">
                                            <!-- <input id="form-field-2" class="col-xs-10 col-sm-5" type="text" placeholder="请输入测试结束时间"> -->
                                            <div class="input-group date form_datetime col-xs-10 col-sm-5 no-padding-left no-padding-right"
                                                 data-date="" data-date-format="yyyy-mm-dd HH:ii"
                                                 data-link-field="dtp_input2">
                                                <input class="form-control" size="16" type="text" value="" readonly>
                                                <span class="input-group-addon"><span
                                                        class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <input name="endTime" type="hidden" id="dtp_input2" value=""
                                                   placeholder="请选择测试开始时间"/>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-3">
                                            测试时长： </label>

                                        <div class="col-sm-9">
                                            <input name="examTime" id="form-field-3" value="30"
                                                   class="col-xs-10 col-sm-5" type="text"
                                                   placeholder="请输入测试时长">
													<span class="help-inline col-xs-10 col-sm-2">
														<span class="middle">分钟</span>
													</span>
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
<script type="text/javascript" src="${staticWebsite}js/uncompressed/datetime/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
        src="${staticWebsite}js/uncompressed/datetime/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- 页面内部js -->
<script type="text/javascript">
    $(function ($) {
        $(".chosen-select").chosen({
            cssClasses: ['col-sm-5', 'col-xs-10']
        });
    });

    $('.form_datetime').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
</script>
</body>
</html>
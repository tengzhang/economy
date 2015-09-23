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
    <title>后台管理-增加题目</title>
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
                <a href="${website}/admin">自考学习服务中心平台后台管理</a>
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
                        <form action="${website}/admin/problem/insert" method="post" class="form-horizontal" role="form">
                            <div class="row">
                                <!-- 第一列左列 -->
                                <div class="col-xs-12 col-sm-6">
                                    <div class="form-group">
                                        <label for="type" class="control-label col-xs-12 col-sm-3 no-padding-right">题目类型:</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <select name="type" id="type" class="width-80 chosen-select" style="display: none;">
                                                <option>请选择</option>
                                                <option value="1">单选</option>
                                                <option value="2">多选</option>
                                                <option value="3">判断</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="title" class="control-label col-xs-12 col-sm-3 no-padding-right">题目题干:</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <textarea name="title" placeholder="请输入题目内容，选项除外" id="title" class="col-xs-12 col-sm-10"></textarea>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="chooseA" class="control-label col-xs-12 col-sm-3 no-padding-right">题目选项A：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="chooseA" id="chooseA" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该选项内容">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="chooseB" class="control-label col-xs-12 col-sm-3 no-padding-right">题目选项B：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="chooseB" id="chooseB" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该选项内容">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="chooseC" class="control-label col-xs-12 col-sm-3 no-padding-right">题目选项C：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="chooseC" id="chooseC" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该选项内容">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="chooseD" class="control-label col-xs-12 col-sm-3 no-padding-right">题目选项D：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="chooseD" id="chooseD" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该选项内容">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="chooseE" class="control-label col-xs-12 col-sm-3 no-padding-right">题目选项E：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="chooseE" id="chooseE" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该选项内容">
                                        </div>
                                    </div>
                                </div>
                                <!-- 左列结束 -->

                                <!-- 又是一列 右列-->
                                <div class="col-xs-12 col-sm-6">
                                    <div class="form-group">
                                        <label for="majorId" class="control-label col-xs-12 col-sm-3 no-padding-right">所属专业：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <select name="majorId" id="majorId" class="width-80 chosen-select" style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="major" items="${majorList}">
                                                    <option value="${major.id}">${major.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="subjectId" class="control-label col-xs-12 col-sm-3 no-padding-right">所属科目：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <select name="subjectId" id="subjectId" class="width-80 chosen-select" style="display: none;">
                                                <option>请选择</option>
                                                <c:forEach var="subject" items="${subjectList}">
                                                    <option value="${subject.id}">${subject.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="score" class="control-label col-xs-12 col-sm-3 no-padding-right">分值：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="score" id="score" value="2" class="col-xs-10 col-sm-10" type="text" placeholder="请输入该题的分值">
                                                <span class="help-inline col-xs-10 col-sm-2">
                                                    <span class="middle">分</span>
                                                </span>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label for="answer" class="control-label col-xs-12 col-sm-3 no-padding-right">正确答案：</label>
                                        <div class="col-xs-12 col-sm-9">
                                            <input name="answer" id="answer" class="col-xs-10 col-sm-10" type="text" placeholder="请输入答案" />
                                        </div>
                                    </div>
                                </div>
                                <!-- 右列结束 -->
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
            cssClasses: ['col-sm-10', 'col-xs-10']
        });
    });
</script>
</body>
</html>

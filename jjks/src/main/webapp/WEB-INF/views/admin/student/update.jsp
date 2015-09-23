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
    <title>后台管理-修改考生</title>
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
                                <form action="${website}/admin/student/update" method="post" class="form-horizontal"
                                      role="form">
                                    <input name="student.id" value="${studentDto.student.id}" type="hidden" />
                                    <div class="row">
                                        <!-- 第一列左列 -->
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">考生姓名:</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="student.name" value="${studentDto.student.name}" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入考生姓名"/>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">身份证号:</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="student.idNo" value="${studentDto.student.idNo}" class="col-xs-10 col-sm-10" type="text"
                                                           placeholder="请输入考生身份证号"/>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right">学校/机构：</label>

                                                <div class="col-xs-12 col-sm-9">
                                                    <input name="student.schoolName" value="${studentDto.student.schoolName}" class="col-xs-10 col-sm-10" type="text"
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
                                                    <input name="student.examNo" value="${studentDto.student.examNo}" class="col-xs-10 col-sm-10" type="text"
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
                                                            <c:choose>
                                                                <c:when test="${major.code == studentDto.student.majorCode}">
                                                                    <option value="${major.id}" selected="selected" class="major1">${major.name}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${major.id}"
                                                                            class="major1">${major.name}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- 右列结束 -->
                                    </div>

                                    <div class="hr "></div>

                                    <div class="row">
                                        <div class="col-xs-12">
                                            <label class="control-label">课程信息：</label>

                                            <div class="space-4"></div>
                                            <!-- 国际经济与管理的科目 -->
                                            <div class="table-responsive" id="subject1">
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th class="hidden-480">科目代码</th>
                                                        <th>科目名称</th>
                                                        <th>是否缴费</th>
                                                        <th>缴费时间</th>
                                                        <th>成绩</th>
                                                        <th>是否显示成绩</th>
                                                        <th></th>
                                                    </tr>
                                                    </thead>

                                                    <tbody>
                                                    <c:forEach var="subject" items="${studentDto.subjectList}" varStatus="status">
                                                        <tr>
                                                            <input name="subjectList[${status.count-1}].studentId" value="${subject.studentId}" type="hidden" />
                                                            <td class="hidden-480">
                                                                <input name="subjectList[${status.count-1}].subjectCode" value="${subject.subjectCode}" class="col-xs-10 col-sm-10" type="text" />
                                                            </td>
                                                            <td>
                                                                <input name="subjectList[${status.count-1}].subjectName" value="${subject.subjectName}" class="col-xs-10 col-sm-10" type="text" />
                                                            </td>
                                                            <td>
                                                                <select name="subjectList[${status.count-1}].isPay" class="width-80 chosen-select" >
                                                                    <c:choose>
                                                                        <c:when test="${subject.isPay == 1}">
                                                                            <option value="1" selected="selected">是</option>
                                                                            <option value="0">否</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="1">是</option>
                                                                            <option value="0" selected="selected">否</option>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </select>
                                                            </td>
                                                            <td>
                                                                <input name="subjectList[${status.count-1}].payTime" value="${subject.payTime}" class="col-xs-10 col-sm-10" type="text"
                                                                       placeholder="请输入缴费时间，如20140104">
                                                            </td>
                                                            <td>
                                                                <input name="subjectList[${status.count-1}].score" value="${subject.score}" class="col-xs-10 col-sm-10" type="text" placeholder="请输入成绩" />
                                                            </td>
                                                            <td>
                                                                <select name="subjectList[${status.count-1}].isShowScore" class="width-80 chosen-select" >
                                                                    <c:choose>
                                                                        <c:when test="${subject.isShowScore == 1}">
                                                                            <option value="1" selected="selected">是</option>
                                                                            <option value="0">否</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="1">是</option>
                                                                            <option value="0" selected="selected">否</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <div name="del-sub" class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                                                    <a class="btn btn-sm btn-danger canel">
                                                                        <i class="icon-trash bigger-120"></i>
                                                                    </a>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>

                                                <div class="align-right">
                                                    <button id="add-sub" class="btn btn-sm btn-danger" type="button" id="id-add-attachment">
                                                        <i class="icon-plus bigger-140"></i>
                                                        添加科目
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="hr hr-double"></div>
                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-info" type="submit" id="qq">
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

<!-- 页面内部js -->
<script type="text/javascript">
    $(function ($) {
        var subCount = ${subCount};

        $(".chosen-select").chosen({
            cssClasses: ['col-sm-10', 'col-xs-10']
        });

        $('[name="del-sub"]').on('click', function() {
            $(this).closest('tr').remove();
        });

        $('#add-sub').on('click', function(){
            var $tr = getHtmlStr(subCount);
            $('table').append($tr);
            $(".chosen-select").chosen({
                cssClasses: ['col-sm-10', 'col-xs-10']
            });
            subCount ++;
        });

        function getHtmlStr(num) {
            var html = '<tr>' +
                            '<input name="subjectList[' + num + '].studentId" value="${studentDto.student.id}" type="hidden" />' +
                            '<td class="hidden-480">' +
                                '<input name="subjectList[' + num + '].subjectCode" class="col-xs-10 col-sm-10" type="text" placeholder="请输入科目代码">' +
                            '</td>' +
                            '<td>' +
                                '<input name="subjectList[' + num + '].subjectName" class="col-xs-10 col-sm-10" type="text" placeholder="请输入科目名称">' +
                            '</td>' +
                            '<td>' +
                                '<select name="subjectList[' + num + '].isPay" class="width-80 chosen-select">' +
                                    '<option value="1">是</option>' +
                                    '<option value="0">否</option>' +
                                '</select>' +
                            '</td>' +
                            '<td>' +
                                '<input name="subjectList[' + num + '].payTime" class="col-xs-10 col-sm-10" type="text" placeholder="请输入缴费时间，如20140104">' +
                            '</td>' +
                            '<td>' +
                                '<input name="subjectList[' + num + '].score" class="col-xs-10 col-sm-10" type="text" placeholder="请输入成绩" />' +
                            '</td>' +
                            '<td>' +
                                '<select name="subjectList[' + num + '].isShowScore" class="width-80 chosen-select" >' +
                                    '<option value="1">是</option>' +
                                    '<option value="0" selected="selected">否</option>' +
                                '</select>' +
                            '</td>' +
                            '<td>' +
                                '<div name="del-sub" class="visible-md visible-lg hidden-sm hidden-xs btn-group">' +
                                    '<a class="btn btn-sm btn-danger canel">' +
                                        '<i class="icon-trash bigger-120"></i>' +
                                    '</a>' +
                                '</div>' +
                            '</td>' +
                        '</tr>';
            return html;
        }
    });

</script>
</body>
</html>

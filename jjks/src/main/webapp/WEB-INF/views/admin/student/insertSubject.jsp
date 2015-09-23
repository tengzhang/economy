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
                                <form action="${website}/admin/student/insertSubject" method="post" class="form-horizontal"
                                      role="form">
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
                                            <c:forEach var="studentSubject" items="${studentSubjectList}" varStatus="status">
                                                <tr>
                                                    <input name="studentSubjectList[${status.count-1}].studentId" value="${studentSubject.studentId}" type="hidden" />
                                                    <input name="studentSubjectList[${status.count-1}].subjectCode" value="${studentSubject.subjectCode}" type="hidden" />
                                                    <input name="studentSubjectList[${status.count-1}].subjectName" value="${studentSubject.subjectName}" type="hidden" />
                                                    <td class="hidden-480">${studentSubject.subjectCode}</td>
                                                    <td>${studentSubject.subjectName}</td>
                                                    <td>
                                                        <select name="studentSubjectList[${status.count-1}].isPay" class="width-80 chosen-select" />
                                                            <option value="1">是</option>
                                                            <option value="0">否</option>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <input name="studentSubjectList[${status.count-1}].payTime" class="col-xs-10 col-sm-10" type="text"
                                                               placeholder="请输入缴费时间，如20140104">
                                                    </td>
                                                    <td>
                                                        <input name="studentSubjectList[${status.count-1}].score" class="col-xs-10 col-sm-10" type="text" placeholder="请输入成绩" />
                                                    </td>
                                                    <td>
                                                        <select name="studentSubjectList[${status.count-1}].isShowScore" class="width-80 chosen-select" >
                                                            <option value="1">是</option>
                                                            <option value="0" selected="selected">否</option>
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
        $(".chosen-select").chosen({
            cssClasses: ['col-sm-10', 'col-xs-10']
        });

        $('[name="del-sub"]').on('click', function() {
           $(this).closest('tr').remove();
        });
    });
</script>
</body>
</html>

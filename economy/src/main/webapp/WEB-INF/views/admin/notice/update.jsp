<%--
  User: zhangteng
  Date: 2014/4/11 17:38
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理-更新通知</title>
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
                        <a href="${website}/admin">其他办学后台管理</a>
                    </li>
                    <li class="active">通知管理</li>
                </ul>
                <!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        通知管理
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="alert alert-info center">
                            <strong>通知正文请尽量使用微软雅黑字体。</strong>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${website}/admin/notice/update" method="POST" enctype="multipart/form-data" class="form-horizontal" role="form">
                                    <input name="article.id" value="${article.id}" type="hidden" />
                                    <input name="article.type" value="${article.type}" type="hidden" />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            所属版块： </label>

                                        <div class="col-sm-9">
                                            <select name="article.indexModuleId" class="chosen-select" data-placeholer="请选择">
                                                <c:forEach var="indexModule" items="${indexModuleList}">
                                                    <c:if test="${article.indexModuleId == indexModule.id}">
                                                        <option value="${indexModule.id}" selected="selected">${indexModule.name}</option>
                                                    </c:if>
                                                    <c:if test="${article.indexModuleId != indexModule.id}">
                                                        <option value="${indexModule.id}">${indexModule.name}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            标题： </label>

                                        <div class="col-sm-9">
                                            <input name="article.title" value="${article.title}" class="col-xs-10 col-sm-6" type="text" placeholder="请输入问题">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            内容： </label>

                                        <div class="col-sm-9">
                                            <input name="article.content" type="hidden" />
                                            <!-- 添加文字编辑 -->
                                            <div id="aceEditor" class="wysiwyg-editor">${article.content}</div>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">
                                            是否有附件： </label>

                                        <div class="col-sm-9">
                                            <select name="article.hasAttachment" class="chosen-select">
                                                <c:if test="${article.hasAttachment == 0}">
                                                    <option value="0" selected="selected">否</option>
                                                    <option value="1">是</option>
                                                </c:if>
                                                <c:if test="${article.hasAttachment == 1}">
                                                    <option value="0">否</option>
                                                    <option value="1" selected="selected">是</option>
                                                </c:if>
                                            </select>
                                        </div>
                                    </div>

                                    <input name="delAttachmentIds" type="hidden" />
                                    <c:if test="${article.hasAttachment == 1}">
                                        <div class="space-4"></div>

                                        <div id="showAttachments" class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">
                                                已添加附件列表： </label>

                                            <div class="col-sm-9">
                                                <ul>
                                                    <c:forEach var="attachment" items="${attachmentList}">
                                                        <div class="row">
                                                            <i class="icon-file-alt"></i>
                                                            ${attachment.name}
                                                            <span class="action-buttons">
                                                                <a name="removeAttachment" id="${attachment.id}" class="red" href="#">
                                                                    <i class="icon-trash red bigger-130 middle"></i>
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </c:forEach>
                                                </ul>

                                            </div>
                                        </div>
                                    </c:if>

                                    <div class="hr hr-18 dotted"></div>

                                    <div id="addAttachments" class="form-group no-margin-bottom hide">
                                        <label class="col-sm-2 col-xs-12 control-label no-padding-right">添加附件：</label>
                                        <div class="col-sm-10 col-xs-12">
                                            <div id="form-attachments">
                                                <div class="row file-input-container">
                                                    <div class="col-sm-7">
                                                        <div class="ace-file-input width-90 inline">
                                                            <button class="btn btn-sm btn-danger" type="button" id="id-add-attachment">
                                                                <i class="icon-paper-clip bigger-140"></i>
                                                                增加附件
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button id="btnSubmit" class="btn btn-info" type="btn">
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
<script src="${staticWebsite}admin/js/uncompressed/jquery.hotkeys.js"></script>
<script src="${staticWebsite}admin/js/uncompressed/bootstrap-wysiwyg.js"></script>
<script type="text/javascript">
    $(function($) {
        if($('[name="article.hasAttachment"]').val() == 1) {
            $('#addAttachments').removeClass('hide');
        }

        var attachmentNum = 0;
        $(".chosen-select").chosen({
            hasSearch: false,
            cssClasses: ['col-sm-6', 'col-xs-12']
        });

        // 绑定表单提交
        $('#btnSubmit').on('click', function() {
            var $content = $('#aceEditor').html();
            $('[name="article.content"]').val($content);

            $('form').submit();
        });

        // 绑定是否有附件的chang事件
        $('[name="article.hasAttachment"]').on('change', function() {
            var $val = $(this).val();
            if($val == 0) {
                $('#addAttachments').addClass('hide');
                $('#showAttachments').addClass('hide');
            } else {
                $('#addAttachments').removeClass('hide');
                $('#showAttachments').removeClass('hide');
            }
        });

        // 绑定移除附件按钮
        $('[name="removeAttachment"]').on('click', function() {
            var $delAttachmentIds = $('[name="delAttachmentIds"]'),
                $delId = $(this).attr('id');
            var val = $delAttachmentIds.val() + $delId  + ',';
            $delAttachmentIds.val(val);

            // 移除当前项
            $(this).parent().parent().remove();
            return false;
        });

        // ace的编辑器
        $('#aceEditor').ace_wysiwyg({
            toolbar: [
                {name:'font', title:'字体'},
                null,
                {name:'fontSize', title:'字体大小'},
                null,
                {name:'bold', className:'btn-info', title:'加粗(Ctrl+B)'},
                {name:'italic', className:'btn-info', title:'倾斜(Ctrl+I)'},
                {name:'underline', className:'btn-info', title:'下划线(Ctrl+U)'},
                null,
                {name:'insertunorderedlist', className:'btn-success', title:'无序列表'},
                {name:'insertorderedlist', className:'btn-success', title:'有序列表'},
                {name:'outdent', className:'btn-purple', title:'减少缩进(Shift+Tab)'},
                {name:'indent', className:'btn-purple', title:'增加缩进(Tab)'},
                null,
                {name:'justifyleft', className:'btn-primary', title:'左对齐(Ctrl+L)'},
                {name:'justifycenter', className:'btn-primary', title:'居中(Ctrl+E)'},
                {name:'justifyright', className:'btn-primary', title:'右对齐(Ctrl+R)'},
                {name:'justifyfull', className:'btn-inverse', title:'两端对齐(Ctrl+J)'},
                null,
                {name:'foreColor', title:'更改颜色'},
                null,
                {name:'undo', className:'btn-grey', title:'撤销'},
                {name:'redo', className:'btn-grey', title:'重做'}
            ]
        }).prev().addClass('wysiwyg-style2');

        // 绑定添加附件
        $('#id-add-attachment').on('click', function(){
            var fileHtml = '<input type="file" name="attachmentFileList[' + attachmentNum + ']" />';
            attachmentNum ++;
            var file = $(fileHtml).appendTo('#form-attachments');
            file.ace_file_input({
                no_file:'请选择文件 ...',
                btn_choose:'浏览',
                btn_change:'重新添加',
                droppable:false,
                onchange:null,
                thumbnail:false
            });
            file.closest('.ace-file-input').addClass('width-90 inline').wrap('<div class="row file-input-container"><div class="col-sm-7"></div></div>')
                    .parent(/*.span7*/).append('<div class="action-buttons pull-right col-xs-1">\
				<a href="#" data-action="delete" class="middle">\
				<i class="icon-trash red bigger-130 middle"></i>\
				</a>\
				</div>').find('a[data-action=delete]').on('click', function(e){
                        //the button that removes the newly inserted file input
                        e.preventDefault();
                        $(this).closest('.row').hide(300, function(){
                            $(this).remove();
                        });
                    });
        });
    });


</script>
</body>
</html>
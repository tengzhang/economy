<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  User: zhangteng
  Date: 2014/5/2 11:33
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<div class="header">
    <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${website}">
                    <img id="logo-header" src="${staticWebsite}index/img/logo3.png" alt="Logo">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="${website}">
                            <i class="icon-home"></i>&nbsp;首页
                        </a>
                    </li>
                    <%-- 循环开始 --%>
                    <c:forEach var="module" begin="0" end="5" items="${indexModuleList}">
                        <li class="dropdown${indexModule.id==module.id ? ' active' : ''}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">
                                ${module.name}
                                <i class="icon-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${website}/index/majors/${module.id}" target="_blank">专业设置</a></li>
                                <li><a href="${website}/index/subjects/${module.id}" target="_blank">课程设置</a></li>
                                <li><a href="${website}/index/brochures/${module.id}" target="_blank">招生简章</a></li>
                                <li><a href="${website}/index/certificates/${module.id}" target="_blank">证书样例</a></li>
                                <li><a href="${website}/index/cooperations/${module.id}" target="_blank">助学合作单位</a></li>
                                <li><a href="${website}/index/questions/${module.id}" target="_blank">常见问题解答</a></li>
                                <li><a href="${website}/index/commonfiles/${module.id}" target="_blank">常用文件下载</a></li>
                                <li><a href="${website}/index/contacts/${module.id}" target="_blank">联系我们</a></li>
                            </ul>
                        </li>
                    </c:forEach>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">
                            其它
                            <i class="icon-angle-down"></i>
                        </a>
                        <c:if test="${fn:length(indexModuleList) > 6}">
                            <ul class="dropdown-menu">
                                <c:forEach var="module" begin="6" items="${indexModuleList}">
                                    <li><a href="${website}/index/majors/${module.id}" target="_blank">${module.name}</a></li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </li>
                    <%-- 循环结束 --%>
                    <li class="hidden-sm"><a class="search"><i class="icon-search search-btn"></i></a></li>
                </ul>
                <div class="search-open">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="查询...">
                        <span class="input-group-btn">
                            <button class="btn-u" type="button">搜索</button>
                        </span>
                    </div><!-- /input-group -->
                </div>
            </div><!-- /navbar-collapse -->
        </div>
    </div>
</div><!--/header-->
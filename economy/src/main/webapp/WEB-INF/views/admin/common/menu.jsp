<%--
  User: zhangteng
  Date: 14-1-22 下午12:27
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar" id="sidebar">
    <jsp:include page="sidebar.jsp" />
    <ul class="nav nav-list">
        <c:choose>
            <c:when test="${indexModuleMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/index/module">
                <i class="icon-list"></i>
                <span class="menu-text"> 首页版块管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${indexImgMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/index/img">
                <i class="icon-picture"></i>
                <span class="menu-text"> 首页图片管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${noticeMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/notice" class="dropdown-toggle">
                <i class="icon-bell"></i>
                <span class="menu-text"> 通知管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${majorMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
        <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/major" class="dropdown-toggle">
                <i class="icon-th-large"></i>
                <span class="menu-text"> 专业管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${subjectMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
        <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/subject" class="dropdown-toggle">
                <i class="icon-th"></i>
                <span class="menu-text"> 课程管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${brochureMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/brochure" class="dropdown-toggle">
                <i class="icon-book"></i>
                <span class="menu-text"> 招生简章管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${questionMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/question" class="dropdown-toggle">
                <i class="icon-question"></i>
                <span class="menu-text"> 常见问题管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${certificateMenuActived == true}">
               <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/certificate" class="dropdown-toggle">
                <i class="icon-bookmark"></i>
                <span class="menu-text"> 证书管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${cooperationMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/cooperation" class="dropdown-toggle">
                <i class="icon-group"></i>
                <span class="menu-text"> 助学单位管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${contactMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
            <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/contact" class="dropdown-toggle">
                <i class="icon-phone"></i>
                <span class="menu-text"> 联系我们管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${commonFileMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/commonfile" class="dropdown-toggle">
                <i class="icon-file-text-alt"></i>
                <span class="menu-text"> 常用文件管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${buttonUrlMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/buttonurl" class="dropdown-toggle">
                <i class="icon-link"></i>
                <span class="menu-text"> 平台链接管理 </span>
            </a>
        </li>
    </ul><!-- /.nav-list -->
</div>
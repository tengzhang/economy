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
            <c:when test="${basicMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/major">
                <i class="icon-list"></i>
                <span class="menu-text"> 基本信息管理 </span>
            </a>

            <ul class="submenu">
                <c:choose>
                    <c:when test="${majorMenuActived == true}">
                    <li class="active">
                    </c:when>
                    <c:otherwise>
                    <li>
                    </c:otherwise>
                </c:choose>
                    <a href="${website}/admin/major">
                        <i class="icon-double-angle-right"></i>
                        专业管理
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
                    <a href="${website}/admin/subject">
                        <i class="icon-double-angle-right"></i>
                        科目管理
                    </a>
                </li>

                <c:choose>
                    <c:when test="${majorSubMenuActived == true}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="${website}/admin/major/subject">
                        <i class="icon-double-angle-right"></i>
                        专业—科目管理
                    </a>
                </li>

                <c:choose>
                    <c:when test="${problemMenuActived == true}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="${website}/admin/problem">
                        <i class="icon-double-angle-right"></i>
                        题目管理
                    </a>
                </li>
            </ul>
        </li>

        <c:choose>
            <c:when test="${sutdentMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/student">
                <i class="icon-user"></i>
                <span class="menu-text"> 考生信息管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${webExamMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/webExam" class="dropdown-toggle">
                <i class="icon-file-text-alt"></i>
                <span class="menu-text"> 网络测试管理 </span>
            </a>
        </li>

        <c:choose>
            <c:when test="${webLessonMenuActived == true}">
                <li class="active">
            </c:when>
            <c:otherwise>
                <li>
            </c:otherwise>
        </c:choose>
            <a href="${website}/admin/webLesson">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 网络课堂管理 </span>
            </a>
        </li>

    </ul><!-- /.nav-list -->
</div>
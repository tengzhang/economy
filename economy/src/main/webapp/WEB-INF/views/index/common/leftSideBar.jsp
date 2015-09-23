<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: zhangteng
  Date: 2014/5/2 11:43
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<div class="col-md-3">

    <!-- Blog Latest Tweets -->
    <div class="blog-twitter">
        <!-- Social Icons -->
        <%-- 循环开始 --%>
        <c:forEach var="module" items="${indexModuleList}">
            <div class="magazine-sb-social margin-bottom-10">

                <div class="blog-twitter-inner${module.id==indexModule.id ? ' active' : ''}">
                    <h4>${module.name}</h4>

                    <ul class="list-unstyled content${module.id==indexModule.id ? ' active' : ''}">
                        <li>
                            <blockquote${(module.id==indexModule.id && majorActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/majors/${module.id}"${(module.id==indexModule.id && majorActive==true) ? ' class="active"' : ''}>
                                    专业设置
                                </a>
                            </blockquote>
                        </li>
                        <li>
                            <blockquote${(module.id==indexModule.id && subjectActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/subjects/${module.id}"${(module.id==indexModule.id && subjectActive==true) ? ' class="active"' : ''}>
                                    课程设置
                                </a>
                            </blockquote>
                        </li>
                        <li>
                            <blockquote${(module.id==indexModule.id && brochureActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/brochures/${module.id}"${(module.id==indexModule.id && brochureActive==true) ? ' class="active"' : ''}>
                                    招生简章
                                </a>
                            </blockquote>
                        </li>
                        <li>
                            <blockquote${(module.id==indexModule.id && certificateActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/certificates/${module.id}"${(module.id==indexModule.id && certificateActive==true) ? ' class="active"' : ''}>
                                    证书样例
                                </a>
                            </blockquote>
                        </li>
                        <li>
                            <blockquote${(module.id==indexModule.id && cooperationActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/cooperations/${module.id}"${(module.id==indexModule.id && cooperationActive==true) ? ' class="active"' : ''}>
                                    助学合作单位
                                </a>
                            </blockquote>
                        </li>

                        <li>
                            <blockquote${(module.id==indexModule.id && questionActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/questions/${module.id}"${(module.id==indexModule.id && questionActive==true) ? ' class="active"' : ''}>
                                    常见问题解答
                                </a>
                            </blockquote>
                        </li>

                        <li>
                            <blockquote${(module.id==indexModule.id && commonFileActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/commonfiles/${module.id}"${(module.id==indexModule.id && commonFileActive==true) ? ' class="active"' : ''}>
                                    常用文件下载
                                </a>
                            </blockquote>
                        </li>
                        <li>
                            <blockquote${(module.id==indexModule.id && contactActive==true) ? ' class="active"' : ''}>
                                <a href="${website}/index/contacts/${module.id}"${(module.id==indexModule.id && contactActive==true) ? ' class="active"' : ''}>
                                    联系我们
                                </a>
                            </blockquote>
                        </li>
                    </ul>
                </div>

            </div>
        </c:forEach>
        <%-- 循环结束 --%>
    </div>
    <!-- End Blog Latest Tweets -->
</div>
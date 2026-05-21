<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ include file="../include.jsp" %>

<div class="layout subject-page">

    <div class="main">
        <h2>科目管理</h2>

        <div class="subject-create-link">
            <a href="<%= request.getContextPath() %>/subject/SubjectCreate.action">新規登録</a>
        </div>

        <c:choose>
            <c:when test="${not empty subjectList}">
                <table class="subject-table">
                    <tr>
                        <th>科目コード</th>
                        <th>科目名</th>
                        <th></th>
                        <th></th>
                    </tr>

                    <c:forEach var="subject" items="${subjectList}">
                        <tr>
                            <td>${subject.cd}</td>
                            <td>${subject.name}</td>
                            <td>
                                <a href="<%= request.getContextPath() %>/subject/SubjectUpdateFrom.action?cd=${subject.cd}">変更</a>
                            </td>
                            <td>
                                <a href="<%= request.getContextPath() %>/subject/SubjectDeleteFrom.action?cd=${subject.cd}">削除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>

            <c:otherwise>
                <table class="subject-table">
                    <tr>
                        <th>科目コード</th>
                        <th>科目名</th>
                        <th></th>
                        <th></th>
                    </tr>
                </table>
                <p class="subject-empty-message">科目情報が存在しませんでした</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="/footer.jsp" %>
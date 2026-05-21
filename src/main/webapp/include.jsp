<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点管理システム</title>
</head>
<body>

<div class="headerbox">
<h1>得点管理システム</h1>
<c:if test="${not empty teacher}">
<div class="right">${teacher.name}様　<a href="http://localhost:8080/scoremanager/auth/logout.jsp">ログアウト</a></div>
</c:if></div>

<article>
<c:if test="${not empty teacher}">
<div class="side">
<nav class="nav-menu">
        <ul>
            <li><a href="http://localhost:8080/scoremanager/menu.jsp">メニュー</a></li>

            <li><a href="http://localhost:8080/scoremanager/student/StudentList.action">学生管理</a></li>

            <li class="label">成績管理</li>
            <li>　<a href="#">成績登録</a></li>
            <li>　<a href="http://localhost:8080/scoremanager/test/TestList.action">成績参照</a></li>
            <li><a href="http://localhost:8080/scoremanager/subject/SubjectList.action">科目管理</a></li>
        </ul>
    </nav>
</div>
</c:if>
 <div class="content">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ include file="../include.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科目管理</title>
</head>
<body>

<h2>科目情報変更</h2>

<form action="SubjectUpdate.action" method="post">

<label>科目コード</label><br>
<input type="text" name="cd" value="${subject.cd}" class="textbox"><br>

<label>科目名</label><br>
<input type="text" name="name" value="${subject.name}" class="textbox"><br><br>

<br><br>
<button type="submit">変更</button>

</form>

<a href="http://localhost:8080/scoremanager/subject/SubjectList.action">戻る</a>

</body>
</html>
<%@ include file="../footer.jsp" %>
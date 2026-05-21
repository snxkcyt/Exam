<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ include file="../include.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>科目情報登録</h2>
<form action="SubjectCreateExecute.action" method="get">
<label>科目コード</label><br>
<input type="text" name="cd" value="${cd}" maxlength="10" placeholder="科目コードを入力してください" class="textbox">
<br>
<label>科目名</label><br>
<input type="text" name="name" value="${name}" maxlength="30" placeholder="科目名を入力してください" class="textbox"> 

<br>
<br>
<button name="submit">登録して終了</button>
</form>

<br><a href="http://localhost:8080/scoremanager/subject/SubjectList.action">戻る</a>
</body>
</html>

<%@ include file="../footer.jsp" %>
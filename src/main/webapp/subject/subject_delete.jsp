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

<form action="SubjectDelete.action" method="post">
<h2>科目情報削除</h2>
<p>「${subject_name}(${subject_cd})」を削除してもよろしいですか</p>
<button name="submit">削除</button>
<br>
<a href="#">戻る</a>（科目管理一覧へ）
</body>
</html>
<%@ include file="../footer.jsp" %>
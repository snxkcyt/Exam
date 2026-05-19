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

<h2>学生情報</h2>

<form action="StudentCreate.action" method="post">
<label>入学年度</label><br>
<select name="ent_year" value="${ent_year}" class="textbox">
<option value="">---</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
</select>
<br>
<label>学生番号</label><br>
<input type="text" name="no" value="${no}" maxlength="10" placeholder="学生番号を入力してください" class="textbox">
<br>
<label>氏名</label><br>
<input type="text" name="name" value="${name}" maxlength="30" placeholder="氏名を入力してください" class="textbox"> 
<br>
<label>クラス</label><br>
<select name="class_num" class="textbox">
<c:forEach var="num" items="${classNumList}">
	<option value="${num}">${num}</option>
</c:forEach>
</select>
<br>
<label>在学中</label>
<input type="checkbox" name="is_attend" value="${is_attend}">
<br><br>
<button name="submit">登録して終了</button>
</form>

<br><a href="StudentList.action">戻る</a>
</body>
</html>

<%@ include file="../footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ include file="../include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理</title>
</head>
<body>

<h2>学生情報</h2>

<form action="StudentUpdate.action" method="post">
<label>入学年度</label><br>
<p>　${student.entYear}</p>
<input type="hidden" name="ent_year" value="${student.entYear}"> 

<label>学生番号</label>
<p>　${student.no}</p>
<input type="hidden" name="no" value="${student.no}">

<label>氏名</label><br>
<input type="text" name="name" value="${student.name}" maxlength="30" placeholder="氏名を入力してください" class="textbox">
<br>
<label>クラス</label><br>
<select name="class_num" class="textbox">
<c:forEach var="num" items="${classNumList}">
<option value="${num}"
<c:if test="${num == student.classNum}">selected</c:if>>
${num}
</option>
</c:forEach>
</select>
<br>
<label>在学中</label>
<input type="checkbox" name="is_attend"
<c:if test="${student.attend}">checked</c:if>
<br><br><br>
<button name="submit">変更</button>
<br>
<a href="StudentList.action">戻る</a>

</body>
</html>
<%@ include file="../footer.jsp" %>
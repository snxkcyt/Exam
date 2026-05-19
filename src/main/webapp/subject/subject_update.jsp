<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
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
<p>　${cd}(ここに科目コード)</p><br>

<label>科目名</label><br>
<input type="text" name="name" value="${name}" placeholder="科目名を入力してください"  class="textbox"><br><br>

<button name="submit">変更</button><br><br>

<a href="#">戻る</a>

</body>
</html>
<%@ include file="../footer.jsp" %>
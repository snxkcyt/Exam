<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>科目情報変更</h2>
<label>科目コード</label><br>
<input type="text" name="cd" value="${cd}">（初期値　科目コード）<br>

<label>科目名</label><br>
<input type="text" name="name" value="${name}" placeholder="科目名を入力してください">（初期値　科目名）<br><br>

<button>変更</button><br><br>

<a href="#">戻る</a>

</body>
</html>
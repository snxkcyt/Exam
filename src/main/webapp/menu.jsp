<%@page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP Samples</title>
</head>
<body>
<h2>メニュー</h2>
<article>
<div class="stu">
<br><a href="http://localhost:8080/scoremanager/student/StudentList.action">学生管理</a><br>
</div>

<div class="test">
成績管理<br>
<a href="#">成績登録</a><br>
<a href="http://localhost:8080/scoremanager/test/TestList.action">成績参照</a>
</div>

<div class="sub">
<br><a href="#">科目管理</a><br>
</div>

</script>
</body>
</html>
</article>
<%@ include file="footer.jsp" %>
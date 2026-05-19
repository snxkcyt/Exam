<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head><title>学生一覧</title></head>
<body>
<h2>学生管理</h2>
<div class="right">
<a href="StudentCreateForm.action">新規登録</a>
</div>

<form method="get" class="box2">

<div class="box_flex">
	<div class="SearchBox">
	<label>入学年度</label><br>
	<select name="f1"  class="textbox2">
		<option value="">---</option>
		<option value="2023">2023</option>
		<option value="2024">2024</option>
		<option value="2025">2025</option>
	</select>
	</div>
	
	<div class="SearchBox">
	<label>クラス</label><br>
	<select name="f2"  class="textbox2">
		<option value="0">---</option>
			<c:forEach var="num" items="${classnum}">
				<option value="${num}">${num}</option>
			</c:forEach>
	</select>
	</div>

	<label class="checkbox"><input type="checkbox" name="f3">
	在学中</label>
	<button>絞込み</button>
	<div>${errors.get("f1")}</div>

</div>
</form>

<c:choose>
    <c:when test="${list.size()>0 }">
        <div>検索結果：${list.size() }件</div>
            <table>
                <tr>
                    <th>入学年度</th>
                    <th>学生番号</th>
                    <th>氏名</th>
                    <th>クラス</th>
                    <th class="attend">在学中</th>
                    <th></th>
                </tr>
                <c:forEach var="s" items="${list}">
                    <tr>
                        <td>${s.entYear}</td>
                        <td>${s.no}</td>
                        <td>${s.name}</td>
                        <td>${s.classNum}</td>
                        <td class="attend">
                        <c:choose>
                            <c:when test="${s.attend}">
                                ◯
                            </c:when>
                            <c:otherwise>
                                ×
                            </c:otherwise>
                        </c:choose>
                        </td>
                        <td><a href="StudentUpdateFrom.action?no=${s.no}">変更</a></td>
                    </tr>
                </c:forEach>
            </table>
    </c:when>
    <c:otherwise>
        <div>学生情報が存在しませんでした。</div>
    </c:otherwise>
</c:choose>
</table>

<br>
<a href="http://localhost:8080/scoremanager/menu.jsp">メニューへ</a>

</body>
</html>
<%@ include file="../footer.jsp" %>
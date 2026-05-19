<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
		<link rel="stylesheet" type="text/css" href="style.css">
<%@include file="../include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点管理システム</title>
</head>
<body>
<h2 class="title">成績一覧（科目）</h2>

<div class="search-box">
	<form action="TestListSubjectExecute.action" method="get">
		
		<div class="section-header">科目情報</div>
		
		<div class="row">
			<label>入学年度</label>
			<select name="f1">
				<option value="0">--------</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
			</select>
			<label >クラス</label>
			<select name="f2">
				<option value="0">--------</option>
				<c:forEach var="num" items="${classnum}">
					<option value="${num }">${num}</option>
				</c:forEach>
			</select>
			
			<label>科目</label>
				<select name="f3">
				<option value="0">--------</option>
				<c:forEach var="num" items="${subjectnum}">
					<option value="${num.cd}">${num.name}</option>
				</c:forEach>
			</select>			
			<button>検索</button>
		</div>
		
		<div class="error">${errors.get("search")}</div>
	</form>
	<form action="TestListStudentExecute.action" method="get">
		<div class="section-header">学生情報</div>
		<div class="row">
			<label>学生番号</label>
			<input type="text" name="studentNo">
			<button>検索</button>
		</div>
	</form>
</div>

<c:if test="${list != null }">
<c:choose>
	<c:when test="${list.size()>0 }">
		<div>科目：${subjectName}</div>
			<table class="result-table">
	
				<tr>
					<th>入学年度</th>
					<th>クラス</th>
					<th>学生番号</th>
					<th>氏名</th>
					<th>1回</th>
					<th>2回</th>
					<th></th>
				</tr>
				<c:forEach var="s" items="${list}">
				<%--DEBUG: ${s.studentNo} / ${s.points}
				DEBUG GET 1: ${s.points[1]}
				DEBUG GET '1': ${s.points['1']}--%>
				
					<tr>
						<td>${s.entYear }</td>
						<td>${s.classNum }</td>
						<td>${s.studentNo }</td>
						<td>${s.studentName }</td>
						<td>
							<c:set var="p1" value="-" />
						    <c:forEach var="e" items="${s.points}">
						        <c:if test="${e.key == 1}">
						            <c:set var="p1" value="${e.value}" />
						        </c:if>
						    </c:forEach>
						    ${p1}
						</td>
						<td>
						    <c:set var="p2" value="-" />
						    <c:forEach var="e" items="${s.points}">
						        <c:if test="${e.key == 2}">
						            <c:set var="p2" value="${e.value}" />
						        </c:if>
						    </c:forEach>
						    ${p2}
						</td>


					</tr>
				</c:forEach>
			</table>
	</c:when>
	<c:otherwise>
		<div>学生情報が存在しませんでした。</div>
	</c:otherwise>
</c:choose>
</c:if>

<%@ include file="../footer.jsp" %>
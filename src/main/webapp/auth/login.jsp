<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../include.jsp" %>

<form action="LoginExecute.action" method="post">

<div class="login">
<h2 class="loginh2">ログイン</h2>

<div class="loginbox">
	<p>ID<br><input type="text" name="id" class="textbox"></p>
	<p>パスワード<br><input type="password" name="password" class="textbox"></p>
	<center><p><button type="submit">ログイン</button></p></center>
	</div>
</form>

<center>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
</center>
</div>
<%@include file="../footer.jsp" %>

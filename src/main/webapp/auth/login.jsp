<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="LoginExecute.action" method="post">
<p>ログイン名<input type="text" name="id"></p>
<p>パスワード<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<%@include file="../footer.html" %>

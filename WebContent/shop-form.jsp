<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>新宿飲食店</title>

</head>
<body>
	<header>
			<h2>
				新宿で行った飲食店
			</h2>
				<a href="<%=request.getContextPath()%>/list"
					class="nav-link">TOP</a>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="get">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="get">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			編集画面
            		</c:if>
						<c:if test="${user == null}">
            			新規追加
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset>
					<label>店名</label> <input type="text"
						value="<c:out value='${user.name}' />"
						name="name" required="required">
				</fieldset>

				<fieldset>
					<label>URL</label> <input type="text"
						value="<c:out value='${user.url}' />"
						name="url">
				</fieldset>

				<fieldset>
					<label>コメント</label> <input type="text"
						value="<c:out value='${user.comment}' />"
						name="comment">
				</fieldset>

				<button type="submit" class="btn btn-success">決定</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
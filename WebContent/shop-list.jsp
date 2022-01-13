<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>新宿飲食店</title>
<style type="text/css">
table{
  width: 95%;
  margin-left: auto;
  margin-right: auto;
  border-collapse:separate;
  border-spacing: 0;
}

table th{
  text-align: center;
  color:white;
  background: linear-gradient(#82bc90,#228835);
  border-left: 1px solid #3c9058;
  border-top: 1px solid #3c9058;
  border-bottom: 1px solid #3c9058;
  box-shadow: 0px 1px 1px rgba(255,255,255,0.3) inset;
  padding: 15px 0;
}

table td{
  text-align: center;
  border-left: 1px solid #73c769;
  border-bottom: 1px solid #73c769;
  border-top:none;
  box-shadow: 0px -3px 5px 1px #eee inset;
  padding: 15px 0;
}

.btn--green,
a.btn--green {
  color: #fff;
  background-color: #335239;
  text-decoration: none;
}
.btn--green:hover,
a.btn--green:hover {
  color: #fff;
  background: #82bc90;
}

a.btn--radius {
   border-radius: 50vh;
}

a.btn--orange {
  color: #fff;
  background-color: #eb6100;
  border-bottom: 5px solid #b84c00;
  text-decoration: none;

}
a.btn--orange:hover {
  margin-top: 3px;
  color: #fff;
  background: #f56500;
  border-bottom: 2px solid #b84c00;
}
a.btn--shadow {
  -webkit-box-shadow: 0 3px 5px rgba(0, 0, 0, .3);
  box-shadow: 0 3px 5px rgba(0, 0, 0, .3);
}

a.btn--yellow {
  color: #000;
  background-color: #fff100;
  border-bottom: 5px solid #ccc100;
  text-decoration: none;
}

a.btn--yellow:hover {
  margin-top: 3px;
  color: #000;
  background: # fff20a;
  border-bottom: 2px solid #ccc100;
}
</style>
</head>
<body>

	<header>
	<p>
   <c:out value="${loginUser.name}" />さん、ログイン中
   </p>
	</header>
	<br>
	<div>

		<div>
			<h1>新宿で行った飲食店</h1>
			<hr>
			<h2>
			    <a href="<%=request.getContextPath()%>/new" class="btn btn--orange btn--cubic btn--shadow">&nbsp;&nbsp;新規追加&nbsp;&nbsp;</a><br>
			    <p>
		        <a href="<%=request.getContextPath()%>/random" class="btn btn--yellow btn--cubic">&nbsp;&nbsp;ランダム&nbsp;&nbsp;</a>
		        </p>
		   </h2>
			<br>
			<table>
				<thead>
					<tr>
						<th width="2%">No.</th>
						<th width="33%">店名</th>
						<th width="23%">食べログURL</th>
						<th width="30%">コメント</th>
						<th width="12%">編集・削除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listShop}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><a href="${user.url}">${user.url}</a></td>
							<td><c:out value="${user.comment}" /></td>
							<td>
							<a href="edit?id=<c:out value='${user.id}' />"
							class="btn btn--green btn--radius">&nbsp;編集&nbsp;</a>
								&nbsp;&nbsp;&nbsp;
							<a href="delete?id=<c:out value='${user.id}' />"
							class="btn btn--green btn--radius">&nbsp;削除&nbsp;</a></td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
<footer>
   <p>
   <a href="/Jisyuseisaku/Logout">ログアウト</a>
   </p>
</footer>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./write" method="get">
		<table border="1" width="500px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>
	<br/>
	
	<c:forEach items="${ gbList }" var="listVo">
		<table border="1"  width="500px">
				<tr>
					<td>${ listVo.no }</td>
					<td>${ listVo.name }</td>
					<td>${ listVo.regDate }</td>
					<td><a href="./deleteForm?no=${ listVo.no }">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4>${ listVo.content }</td>
				</tr>
			</table>
		    <br/>
	</c:forEach>
	
</body>
</html>